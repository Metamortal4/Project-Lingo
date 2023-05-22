import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Classroom extends JPanel {
    private List<String> frenchWords;
    private List<String> englishWords;
    private int currentIndex;

    public Classroom(LingoApp lingoApp) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Create the French word label
        JLabel frenchWordLabel = new JLabel();
        frenchWordLabel.setFont(new Font("Liberation Sans", Font.BOLD, 42));
        frenchWordLabel.setForeground(Color.WHITE);
        frenchWordLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create the English word label
        JLabel englishWordLabel = new JLabel();
        englishWordLabel.setFont(new Font("Liberation Sans", Font.PLAIN, 18));
        englishWordLabel.setForeground(Color.WHITE);
        englishWordLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create a panel for centering the labels
        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.setBackground(Color.BLACK);
        centerPanel.add(frenchWordLabel);
        centerPanel.add(englishWordLabel);

        // Create the buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.BLACK);

        // Create the previous button
        JButton previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex--;
                if (currentIndex < 0) {
                    currentIndex = 0;
                }
                updateWordLabels(frenchWordLabel, englishWordLabel);
            }
        });
        buttonsPanel.add(previousButton);

        // Create the next button
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex++;
                if (currentIndex >= frenchWords.size()) {
                    currentIndex = frenchWords.size() - 1;
                }
                updateWordLabels(frenchWordLabel, englishWordLabel);
            }
        });
        buttonsPanel.add(nextButton);

        // Create the home button
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lingoApp.showHomePage();
            }
        });

        // Create the quiz button
        JButton quizButton = new JButton("Take Quiz");
        quizButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lingoApp.showTestPage();
            }
        });
        
        // Create a panel for the top-right corner buttons
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.setBackground(Color.BLACK);
        topRightPanel.add(homeButton);
        topRightPanel.add(quizButton);

        // Add the top-right corner panel to the Classroom panel
        add(topRightPanel, BorderLayout.NORTH);

        // Add the center panel and buttons panel to the Classroom panel
        add(centerPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Load the words from the file
        loadWordsFromFile();

        // Set the initial index to 0
        currentIndex = 0;

        // Update the word labels with the initial words
        updateWordLabels(frenchWordLabel, englishWordLabel);
    }

    private void loadWordsFromFile() {
        frenchWords = new ArrayList<>();
        englishWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("frenchWords.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    frenchWords.add(parts[0]);
                    englishWords.add(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateWordLabels(JLabel frenchWordLabel, JLabel englishWordLabel) {
        if (!frenchWords.isEmpty() && !englishWords.isEmpty()) {
            frenchWordLabel.setText(frenchWords.get(currentIndex));
            englishWordLabel.setText(englishWords.get(currentIndex));
        }
    }
}