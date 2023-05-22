import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainActivity extends JPanel {
    public MainActivity(LingoApp lingoApp) {
        setBackground(Color.BLACK);
        // Set the layout manager for the MainActivity panel
        setLayout(new BorderLayout());

        // Create the logo label
        ImageIcon logoIcon = new ImageIcon("Lingo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create the buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setBackground(Color.BLACK);

        // Create the Classroom button
        JButton classroomButton = new JButton("Learn French");
        classroomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Classroom button click
                lingoApp.getClassroomPage().setVisible(true);
                lingoApp.getHomePage().setVisible(false);
            }
        });
        buttonsPanel.add(classroomButton);

        // Create the Testroom button
        JButton testroomButton = new JButton("Take a Quiz");
        testroomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Testroom button click
                lingoApp.getTestPage().setVisible(true);
                lingoApp.getHomePage().setVisible(false);
            }
        });
        buttonsPanel.add(testroomButton);

        // Add the logo and buttons panel to the MainActivity panel
        add(logoLabel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
