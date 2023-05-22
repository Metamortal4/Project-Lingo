import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Testroom extends JPanel {
    private List<String> frenchWords;
    private List<String> englishWords;
    private int currentIndex;
    private int score;

    public Testroom(LingoApp lingoApp) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Create the French word label
        JLabel frenchWordLabel = new JLabel();
        frenchWordLabel.setFont(new Font("Liberation Sans", Font.BOLD, 24));
        frenchWordLabel.setForeground(Color.WHITE);
        frenchWordLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create the input field for user input
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Liberation Sans", Font.PLAIN, 18));

        // Create the score label
        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Liberation Sans", Font.PLAIN, 18));
        scoreLabel.setForeground(Color.WHITE);

        // Create a panel for centering the labels and input field
        JPanel centerPanel = new JPanel(new GridLayout(3, 1));
        centerPanel.setBackground(Color.BLACK);
        centerPanel.add(frenchWordLabel);
        centerPanel.add(inputField);
        centerPanel.add(scoreLabel);

        // Create the end button
        JButton endButton = new JButton("End");
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(inputField);
                remove(endButton);
                scoreLabel.setText("Final Score: " + score);
                revalidate();
                repaint();
            }
        });

        // Create the next button
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText().trim().toLowerCase();
                String expectedEnglishWord = englishWords.get(currentIndex).trim().toLowerCase();
                if (userInput.equals(expectedEnglishWord)) {
                    score++;
                }
                scoreLabel.setText("Score: " + score);
                inputField.setText("");
                currentIndex++;
                if (currentIndex < frenchWords.size()) {
                    updateWordLabel(frenchWordLabel);
                } else {
                    remove(inputField);
                    remove(nextButton);
                    remove(endButton);
                    scoreLabel.setText("Final Score: " + score);
                    revalidate();
                    repaint();
                }
            }
        });

        // Create the practice button
        JButton practiceButton = new JButton("Practice");
        practiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lingoApp.showClassroomPage();
            }
        });

        // Create a panel for the bottom buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.add(nextButton);
        bottomPanel.add(endButton);
        bottomPanel.add(practiceButton);

        // Add the center panel and bottom panel to the Testroom panel
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Load the words from the file and select 15 random lines
        loadRandomWordsFromFile();

        // Set the initial index to 0
        currentIndex = 0;
        score = 0;

        // Update the word label with the initial word
        updateWordLabel(frenchWordLabel);

        // Add ActionListener to the input field
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextButton.doClick();
            }
        });
    }

    private void loadRandomWordsFromFile() {
        frenchWords = new ArrayList<>();
        englishWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("frenchWords.txt"))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            Collections.shuffle(lines);
            int numLines = Math.min(15, lines.size());
            for (int i = 0; i < numLines; i++) {
                String[] parts = lines.get(i).split(":");
                if (parts.length == 2) {
                    frenchWords.add(parts[0]);
                    englishWords.add(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateWordLabel(JLabel frenchWordLabel) {
        if (!frenchWords.isEmpty()) {
            frenchWordLabel.setText(frenchWords.get(currentIndex));
        }
    }
}