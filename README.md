![alt text](https://github.com/Metamortal4/Project-Lingo/blob/main/LingoLogo.png?raw=true)

# Programming with JAVA - Group Assignment (Language Learning Platform)


## Group Members:



* CAYTON YOOKOW NHYIRA BARNES - 10211100383
* ANNABEL APINI AYABA ALU - 10211100374
* PAUL HIRO HACKMAN - 10211100353
* KELVIN AKUTTEH - 10211100344


## Project Description / Application Concept

People learn to speak a language in order to make communication with other people significantly easier. As human beings living in a society, communication is key to our continuous survival. Sometimes after we have already learnt to speak one language we may encounter situations that require us to learn another language. For example, a person migrating from one nation to another may need to learn the language of the nation they are migrating to. Or someone who works internationally would have to communicate with foreigners in order to effectively do his/her job.

The point is, this is an existing problem and an environment for learning to speak a new language is a reasonable solution. It also provides us with a good enough challenge to solve and show off our skills as programmers. Hence we have decided to build a language learning platform (concept) that solves a real life problem and also puts our JAVA coding skills to test.


## 


## Project Lingo: Overview

Project Lingo is a Language Learning Platform/Mini Applet built using the Java Swing GUI Library. It consists of five(5) classes; LingoApp, MainActivity, LoginActivity, Classroom and Testroom. The classes are each explained in detail later in this document, however here is an overview of them.

 
   **LingoApp:**
   This is the main class that serves as the entry point of your application. It creates an instance of the JFrame window and sets up the initial settings for the app's window, such as title, size, and layout.

 
   **MainActivity:**
   This class extends JPanel and represents the homepage of your app. It contains the logo of the app at the top-center position and two buttons that navigate to the Classroom and Testroom classes. The class is responsible for handling user interactions on the homepage.

 
   **LoginActivity:**
    LoginActivity is a JPanel class that displays the login page of your app. It includes a logo at the top-center position, along with a label and text fields for username and password input. It also provides login and sign-up buttons for user authentication. The class validates login information and handles corresponding actions based on user interactions.

 
   **Classroom:**
   Classroom extends JPanel and represents the screen where French and English word pairs are displayed. It consists of a large text label for French words, a smaller label for English words, and two buttons at the bottom to load the next and previous word sets. It also includes a home button at the top for navigating back to the homepage. Classroom class manages the display of word pairs and handles user interactions for loading word sets.


   **Testroom:**
    Testroom is a JPanel class similar to Classroom but designed for testing language skills. It selects random word pairs from the French and English word lists. It displays the French word and provides an input field for users to enter the corresponding English translation. It also includes a button to load the next word, a button to end the test, and a home button for navigation. Testroom class evaluates user input, tracks the score, and manages the test process.

The general Idea of the Application Structure is displayed in the following image.

![alt text](https://github.com/Metamortal4/Project-Lingo/blob/main/Blueprint.png?raw=true)


The application starts from the LingoApp class which serves as our application scene and control manager. It creates the JFrame window for the application and swaps out the JPanel classes using a CardLayout object. 

From there we go to the LoginActivity which is the user's login page. It is a JPanel class that holds the elements of the login page as well as the action listeners and the methods to be executed when the actions are performed. The elements are one(1) ImageIcon for displaying the Project Lingo logo, two(2) JLabels that show where to input which information, one(1) JTextField for entering the username, one(1) JPasswordField for entering the password, two(2) JButtons for logging in and signing up.

After successfully logging in, the user is taken to the MainActivity which is the home page of the application. This is the simplest page in the app as it consists mainly of 3 elements; one(1) ImageIcon for the Project Lingo Logo and two(2) JButtons one which takes the user to the Classroom and the other to the Testroom.

Here the program branches off to either the Classroom or to the Testroom so let's go with the Classroom first. 

In the Classroom there are two(2) JLabels for showing the French words and the English words, four(4) JButtons; one(1) Next button, one(1) Previous button, one(1) Home button and one(1) Take Quiz button. The Next and Previous buttons are for changing the words in the JLabels, the Home button takes you back to the MainActivity and the Take Quiz button takes you to the Testroom class.

In the Testroom there are three(3) JButtons: one(1) Next button, one(1) End button and one(1) Practice button, one(1) JLabel to display the French words and one(1) JInputField for entering the answer. The Next button skips to the next word, the End button ends the quiz and the Practice button goes back to the Classroom.

That brings us to the end of the Project Overview. From here on we get into the details of the program application and take a look at the source code explaining it thoroughly and going into the utmost of details.




## Project Lingo Source Code Explanation

Project Lingo starts from the LingoApp class as a result we would begin our journey into the nightmare that is the source code for the program application in the LingoApp.java file. From there we will continue on into the LoginActivity.java file, explaining each code fragment as well as going into detail about our decisions citing reasons for specific code choices. We will continue from there just like before and go into the MainActivity.java file to the Classroom.java file and finally into the Testroom.java file.


### Project Lingo: LingoApp.java

Let us begin with the first ten(10) lines of the source code.


```
import javax.swing.JFrame;
import java.awt.CardLayout;

public class LingoApp {
    private JFrame lingoAppWindow;
    private MainActivity homePage;
    private LoginActivity loginPage;
    private Classroom classroomPage;
    private Testroom testPage;
```


The first two(2) lines import JFrame and CardLayout from Java Swing and Java AWT Libraries respectively. This is done because they are essential to developing the program application. Java Swing (javax.swing.*) is part of Java Foundation Classes. It is used to create window-based applications which makes it suitable for developing lightweight desktop applications. It is built on top of an abstract windowing toolkit (AWT) API purely written in Java programming language. Java AWT (java.awt.*) is Java's original platform-dependent windowing, graphics, and user-interface widget toolkit, preceding Swing. It is part of the Java Foundation Classes (JFC) — the standard API for providing a graphical user interface (GUI) for a Java program. In simple terms, if you want to build a graphical user interface desktop application in Java you will have to use one of the two if not both.

The next thing we do is create the LingoApp class and declare all our global variables which are actually objects of JFrame for the window of our application, and our JPanel classes which are our pages/cards.


```
public LingoApp() {
        lingoAppWindow = new JFrame();
        lingoAppWindow.setTitle("Project LINGO");
        lingoAppWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lingoAppWindow.setSize(750, 500);
        lingoAppWindow.setLocationRelativeTo(null);
        lingoAppWindow.setLayout(new CardLayout());

        homePage = new MainActivity(this);
        loginPage = new LoginActivity(this);
        classroomPage = new Classroom(this);
        testPage = new Testroom(this);

        lingoAppWindow.add(homePage, "Home");
        lingoAppWindow.add(loginPage, "Login");
        lingoAppWindow.add(classroomPage, "Classroom");
        lingoAppWindow.add(testPage, "Testroom");
    }
```


Above is our LingoApp constructor. Here we initialize our lingoAppWindow JFrame by setting the title and size as well as the layout and relative screen position. After that we define our JPanel objects using the constructors of their individual classes and passing this LingoApp class into them as an argument. Following that we then add our now defined objects to the lingoAppWindow.


```
    public void showHomePage() {
        CardLayout cardLayout = (CardLayout) lingoAppWindow.getContentPane().getLayout();
        cardLayout.show(lingoAppWindow.getContentPane(), "Home");
    }

    public void showLoginPage() {
        CardLayout cardLayout = (CardLayout) lingoAppWindow.getContentPane().getLayout();
        cardLayout.show(lingoAppWindow.getContentPane(), "Login");
    }

    public void showClassroomPage() {
        CardLayout cardLayout = (CardLayout) lingoAppWindow.getContentPane().getLayout();
        cardLayout.show(lingoAppWindow.getContentPane(), "Classroom");
    }

    public void showTestPage() {
        CardLayout cardLayout = (CardLayout) lingoAppWindow.getContentPane().getLayout();
        cardLayout.show(lingoAppWindow.getContentPane(), "Testroom");
    }
```


Now we define methods that will show our cards/pages on our window when called. How does it work? Well we first create a CardLayout object which will help us to show the JPanel card/page we want using the show() method of the CardLayout class by passing in the window content pane and the name of the card to show.


```
    public MainActivity getHomePage() {
        return homePage;
    }

    public LoginActivity getLoginPage() {
        return loginPage;
    }

    public Classroom getClassroomPage() {
        return classroomPage;
    }

    public Testroom getTestPage() {
        return testPage;
    }
```


Here we create accessor methods for our private variables with the exception of the lingoAppWindow JFrame. These are created in order to allow access to the variables data without risking access to the variable itself.


```
    public void startApp() {
        showLoginPage(); // Start with the login page
        lingoAppWindow.setVisible(true);
    }

    public static void main(String[] args) {
        LingoApp lingoApp = new LingoApp();
        lingoApp.startApp();
    }
}
```


Finally we have the startApp() method which we use to load the login page and display the window. Now that all the set-up is complete we move into our main method and create an object of this class and start the app using the startApp() method.

When the user runs this the window would open and we should have the login page displayed. So let’s look at the login page code in LoginActivity.java.


### Project Lingo: LoginActivity.java

Just like before we will import our essentials and then declare our global variables.


```
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
```


This time we are importing a whole lot more than the last time. We know what Java Swing is and what Java AWT is but what about the rest and this time there is something else from AWT being imported. 

So first things first, we have imported everything from the Java Swing Library. Since we would now be building our login page, instead of importing all the classes we may need one by one we are importing them whole.

Secondly, we have imported ActionEvent and ActionListener from the Event class of the Java AWT Library. What this does is allows us to check for input from the user, not in the way we normally do but we are checking for keyboard and mouse input. This makes it so we know if the user clicked a button on screen or pressed the enter key while in a text field.

We are already familiar with the Java IO Library, however just to freshen our memories; The Java I/O package provides a set of input streams and a set of output streams used to read and write data to files or other input and output sources. The BufferedWriter writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters, arrays, and strings. TheFileWriter is used to write character-oriented data to a file. And IOException is used to check for IO related errors.

Java NIO (New IO) is an alternative to Java IO. The Files class and Paths class allow for easy navigation through file systems and directories using strings of the paths/urls.

And finally Java Util List gives us access to the List Data Structure.

Once that is all over we declare our global variables which in this case are a JTextField object, a JPasswordField object, a JLabel object and a LingoApp object which we will use later on in the code. Notice that this class extends from JPanel which is why we can use it for our page/card.


```
    public LoginActivity(LingoApp lingoAppMaster) {
        this.lingoApp = lingoAppMaster;
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Create the logo label
        ImageIcon logoIcon = new ImageIcon("Lingo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        add(logoLabel, BorderLayout.NORTH);
```


Now we move into the LoginActivity constructor. First we define our LingoApp object lingoApp as the argument passed into this method when an instance of this class is created anywhere (We saw this in the LingoApp.java code where we passed that class as an argument into the LoginActivity() constructor).  We set the Layout of this page/card to be BorderLayout (It is a layout structure that arranges the components along the border and in the center) and then we set the background color of the JPanel to black (just because I like it black #NoLightMode).

Next we create an ImageIcon object for the Project Lingo Logo and pass that object into a JLabel and have it panned to the center of the top of the screen (the North of the BorderLayout).


```
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
```


Now we create a JPanel for holding all the elements of our login form and we give it a GridLayout with three rows and two columns. We set the background of the JPanel to black so that it doesn’t destroy the aesthetic we are going for.

We create a JLabel that would be used to display where the username should be entered and set the color of the text to white. We also define our JTextField usernameField that we declared as a global variable then we add the label first and then the text field. We do it in this order because we are using a GridLayout and we don’t want the text field to be on the left and the label on the right. 

We do the same thing for the password label and password field (we use a password field instead of a regular text field so that the user’s password isn’t shown as they are typing it).

After that we create one label for our error message which we will use to inform the user of a failed login request and we make it red then add it to the JPanel.


```
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
```


Again we create another JPanel but this time for our buttons and we again set the background color as black. 

We first make our login button and then we add an ActionListener that listens for a click event on the button. When the click happens we collect the information in the text field and the password field and validate them. If they are valid we move on to MainActivity else we display our error message and clear the two fields.

We also add an ActionListener to the password field and make it execute a login button click if the enter key is pressed when in the field.

We also create a signup button and made it so that when it is clicked it would get the username and password and save them as “loginable” accounts and add an error message for the scenario that the login failed.

After that we add the buttons to the button JPanel. We also add the form panel to this class's JPanel in the center and then add the button panel at the bottom.


```
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
```


This is the method which validates login credentials. How does it work? Well it first tries to read each line from the file “accounts.txt” into a list of strings. It then goes line by line splitting the string into storedUsername and storedPassword variables. From here it compares the username and password passed into it as an argument with the current stored credentials. And it will repeat it until the list is exhausted or it finds a match. However if it fails to find the “accounts.txt” file it would catch the exception and handle the error.


```
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
```


This method is executed when someone clicks on the signup button. It takes the username and password passed into it and writes them into the “accounts.txt” file in the form “username:password”. 

This is the end of the LoginActivity.java file. As planned we will move on to the next Java class in the program, which is the MainActivity.java file, the simplest of them all.


### Project Lingo: MainActivity.java


```
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
```


This class is so simple we can look at it as a whole. Everything that goes on here has been seen in the past two classes. It is also the smallest class with 48 lines of code as compared to the LingoApp.java’s 75 lines of code and LoginActivity.java’s 137 lines of code.

The code starts with us importing the packages we would be using here. We have met these packages already so I will not be going over them again. 

This class also extends from JPanel and thus makes it eligible to be a card/page in the program application. The class has no methods other than its constructor. The constructor starts by setting the background color as black and setting the JPanel layout to BorderLayout then it goes on defining an ImageIcon and JLabel for the Project Lingo Logo. We then create a JPanel for the buttons and this time we use a FlowLayout (this arranges the elements in line usually from left to right.) We set the background to black (as usual). 

We then create two buttons, one of which when clicked will take us to Classroom.java and the other which will take us to Testroom.java. 

Surprise!! We are done with the MainActivity.java now we move on to the next class which is Classroom.java.


### Project Lingo: Classroom.java


```
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
```


Just like before we import Java Swing and Java AWT for the GUI. We also import ActionEvent and ActionListener from AWT for button clicks. We import BufferedReader, FileReader and IOException from Java IO to access data in files. And finally we import ArrayList and List from Java Util so we can use those Data Structures. 

We create our Classroom class and extend it from JPanel before declaring our global variables. This time we will need a list of strings for our French and English words, we will also need an indexing variable to keep track of where we are in these lists.


```
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
```


The Classroom constructor starts by setting the layout to BorderLayout and setting the background color to black. Following that we create a JLabel for the French and English words. We set their fonts to Liberation Sans, set the font style to bold for the French and plain for the English words and also set the size to 42 and 18 for the French and English words respectively. We set their colors to white and we create a JPanel and add them to this JPanel. We also set the background color to black.


```
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
```


We continue by creating a new JPanel for the list navigation buttons. We set the background color of the panel to black. We create the Previous button and make it reduce the currentIndex by one(1) when it is clicked, thus going back in the wordlists and changing the labels appropriately. We create the Next button and make it increase the currentIndex by one(1) when it is clicked, thus going forward in the wordlists and changing the labels appropriately.

We then add these buttons to the panel.


```
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
```


We create a Home button and a Take Quiz button which take you to the MainActivity.java and the Testroom.java respectively. We create a new JPanel topRightPanel and set its background color to black. We then add the Home button and the Take Quiz button.


```
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
```


We add the topRightPanel placing it at the top, we place the central panel in the center after adding it and we place the navigation buttons panel at the bottom. We call a method to load the wordlists then we set the current index to 0 and call another method to update the labels.


```
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
```


This method creates two ArrayLists then it reads the file “frenchWords.txt” and using a similar technique to that of the username and password validation method, splits the lines of the text file into the two ArrayLists.


```
    private void updateWordLabels(JLabel frenchWordLabel, JLabel englishWordLabel) {
        if (!frenchWords.isEmpty() && !englishWords.isEmpty()) {
            frenchWordLabel.setText(frenchWords.get(currentIndex));
            englishWordLabel.setText(englishWords.get(currentIndex));
        }
    }
}
```


The final method of the Classroom class takes the two labels for the French and English words and sets the text of those labels to the string from the currentIndex of the two wordlists.




### Project Lingo: Testroom.java


```
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
```


Just like before we import Java Swing and Java AWT for the GUI. We also import ActionEvent and ActionListener from AWT for button clicks. We import BufferedReader, FileReader and IOException from Java IO to access data in files. And finally we import ArrayList, Collections and List from Java Util so we can use those Data Structures and the Algorithms they come with. 

We create our Testroom class and extend it from JPanel before declaring our global variables. This time we will need a list of strings for our French and English words, we will also need an indexing variable to keep track of where we are in these lists and a score variable to keep track of the user’s score.


```
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
```


Again we set the background to black and the layout to BorderLayout. We create a label to display the French words. We also create an input field where the user can type in their answers and we add a score label to display the user’s score. We create a center panel and add all these elements to it.


```
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
```


We create an End button that will be used to end the quiz whenever the user likes. We also create a next button that allows the user to submit their answer and go to the next question. If the user is correct their score will go up by one(1) and if not they gain nothing. We also add a button called Practice that takes the user back to the Classroom.java file. 

_#  I decided not to add a button that would take the user to MainActivity.java cause there’s NO WAY HOME # _

From there we create a new panel to hold all our buttons and add them to that JPanel.


```
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
```


We add the center and bottom panels to the Testroom JPanel, then we call a method to load the wordlists randomly from the file ‘frenchWords.txt”, then we set the currentIndex and the score to 0 and update the French word label. Finally we add an ActionListener to the input field allowing the user to press the enter key instead of going to click on next.


```
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
```


This method works similarly to the loadWordsFromFile() method in the Classroom.java file as in it reads the lines of the file “frenchWords.txt” and splits them into the two ArrayLists frenchWords and englishWords. However this time before it splits into the two ArrayLists the lines List is shuffled and truncated so that the order in which the words appear is not the same as the practice and neither is the length of words to test on.


```
    private void updateWordLabels(JLabel frenchWordLabel, JLabel englishWordLabel) {
        if (!frenchWords.isEmpty() && !englishWords.isEmpty()) {
            frenchWordLabel.setText(frenchWords.get(currentIndex));
            englishWordLabel.setText(englishWords.get(currentIndex));
        }
    }
}
```


Just like in the Classroom.java file this method keeps the labels up to date with the currentIndex of the ArrayList.


## 


## Compiling The Code

Place the additional files (Lingo.png, frenchWords.txt, accounts.txt) in the same directory as your Java source files.

Open the command prompt or terminal and navigate to the directory where your Java source files and the additional files are located.

Compile your Java source files as before using the javac command:


```
javac LingoApp.java
```


Create a manifest file (manifest.txt) that specifies the main class to be executed. Open a text editor and add the following line:


```
Main-Class: LingoApp
```


Save the file in the same directory where your compiled .class files and additional files are located.


```
jar cfm LingoApp.jar manifest.txt *.class Lingo.png frenchWords.txt accounts.txt
```


This will execute your Java application, and it will have access to the included additional files.


```
java -jar LingoApp.jar
```


Or you can navigate to the LingoApp.jar and double click on it like a normal human being. Your choice.

This is the end of the Documentation. Have fun Using our App. By the time you are done reading this you would know that there is no malicious code in our app. It is not a VIRUS. Thank you for taking the time to read all this. Have a blessed day. 🙂
