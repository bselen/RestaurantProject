import javax.swing.*;
import java.awt.*;

public class LoginGUI {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton guestButton;
    private JButton resetButton;
    private JButton loginButton;
    private JButton signUpButton;

    private JFrame frame;
    public LoginGUI(){
        frame = new JFrame("User Login Page");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,250));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
