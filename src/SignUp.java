/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SignUp {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;

    private JFrame frame;
    private HashMap<String,String> loginInfo;

    public SignUp(HashMap<String,String> loginInfo){
        this.loginInfo = loginInfo;

        frame = new JFrame("User Sign-Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,150));

        JPanel panel = new JPanel(new GridLayout(3,2));
        frame.add(panel);

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);

        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password: ");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        signUpButton = new JButton("Sign Up");
        panel.add(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();

            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    private void signUp(){
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        //VALIDATION CHECKS

        //STORE SIGNUP INFO IN HASHMAPS
        loginInfo.put(username,password);

        //PROVIDE FEEDBACK TO USER
        JOptionPane.showMessageDialog(frame,"Sign up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void printLoginInfo(){
        System.out.println("Login Info: ");
        for(String username: loginInfo.keySet()) {
            String password = loginInfo.get(username);
            System.out.println("Username: " + username + ", Password: " + password);
        }
        }


    public static void main(String[] args){
        HashMap<String,String> loginInfo = new HashMap<>();
        SwingUtilities.invokeLater(() -> new SignUp(loginInfo));

    }


}
/*


 */