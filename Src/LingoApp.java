import javax.swing.JFrame;
import java.awt.CardLayout;

public class LingoApp {
    private JFrame lingoAppWindow;
    private MainActivity homePage;
    private LoginActivity loginPage;
    private Classroom classroomPage;
    private Testroom testPage;

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

    public void startApp() {
        showLoginPage(); // Start with the login page
        lingoAppWindow.setVisible(true);
    }

    public static void main(String[] args) {
        LingoApp lingoApp = new LingoApp();
        lingoApp.startApp();
    }
}