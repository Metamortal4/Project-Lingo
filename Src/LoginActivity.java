import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoginActivity extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;
    private LingoApp lingoApp;

    public LoginActivity(LingoApp lingoAppMaster) {
        this.lingoApp = lingoAppMaster;
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Create the logo label
        ImageIcon logoIcon = new ImageIcon("Lingo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        add(logoLabel, BorderLayout.NORTH);

        // Create the login form panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.setBackground(Color.BLACK);

        // Username label and text field
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.WHITE);
        usernameField = new JTextField();
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.WHITE);
        passwordField = new JPasswordField();
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Error label for displaying login validation message
        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);
        formPanel.add(errorLabel);

        // Create the buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.BLACK);
        
        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Login button click
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (validateLogin(username, password)) {
                    errorLabel.setText("");
                    lingoApp.showHomePage();
                } else {
                    errorLabel.setText("Invalid Login Information");
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });

        //Adds action listener to passwordField
        passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick();
            }
        });
        
        // Sign Up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Sign Up button click
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (!username.isEmpty() && !password.isEmpty()) {
                    if (addAccount(username, password)) {
                        errorLabel.setText("");
                        usernameField.setText("");
                        passwordField.setText("");
                    } else {
                        errorLabel.setText("Error: Failed to add account");
                    }
                }
            }
        });

        buttonsPanel.add(loginButton);
        buttonsPanel.add(signUpButton);

        // Add the form panel and buttons panel to the Login panel
        add(formPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private boolean validateLogin(String username, String password) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("accounts.txt"));
            for (String line : lines) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean addAccount(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt", true))) {
            writer.write(username + ":" + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
