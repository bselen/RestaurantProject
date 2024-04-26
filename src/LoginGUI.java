import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginGUI {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton guestButton;
    private JButton resetButton;
    private JButton loginButton;
    private JButton signUpButton;

    private JFrame frame;
    private HashMap<String, String> loginInfo = new HashMap<>();

    //CONSTRUCTOR
    public LoginGUI() {
        IDandPasswords iDandPasswords = new IDandPasswords();
        loginInfo = iDandPasswords.getLoginInfo();


        frame = new JFrame("User Login Page");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 250));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = textField1.getText();
                String password = String.valueOf(passwordField1.getPassword());
                //CHECK IF USER ID EXISTS
                if (loginInfo.containsKey(userID)) {
                    //CHECK IF PASSWORD MATCHES
                    if (loginInfo.get(userID).equals(password)) {
                        //LOGIN SUCCESSFUL
                        JOptionPane.showMessageDialog(frame, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        //PASSWORD DOESN'T MATCH
                        JOptionPane.showMessageDialog(frame, "Invalid Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    //USER ID DOESN'T MATCH
                    JOptionPane.showMessageDialog(frame, "ID doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                passwordField1.setText("");
            }
        });


        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();

            }
        });
    }

    private void signUp() {
        String userID = textField1.getText();
        String password = String.valueOf(passwordField1.getPassword());
        if (loginInfo.containsKey(userID)) {
            JOptionPane.showMessageDialog(frame, "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            loginInfo.put(userID, password);
            JOptionPane.showMessageDialog(frame, "Sign up successful", "Success", JOptionPane.INFORMATION_MESSAGE);


            printLoginInfo(loginInfo);
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI();

            }
        });
    }
    public void printLoginInfo(HashMap<String,String> loginInfo){
        System.out.println("Login Info: ");
        for(String username: loginInfo.keySet()) {
            String password = loginInfo.get(username);
            System.out.println("Username: " + username + ", Password: " + password);
        }
    }
}






   /* public void actionPerformed(ActionEvent e) {
        //ALLOWS US TO RESET LOGIN INFO
        if(e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }


        else if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            //CHECK IF USER ID EXISTS
            if (logininfo.containsKey(userID)) {
                //CHECK IF PASSWORD MATCHES
                if (logininfo.get(userID).equals(password)){
                    //LOGIN SUCCESSFUL
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");

                }
                else{
                    //PASSWORD DOESN'T MATCH
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Invalid password");
                }

            }
            else {
                //USER ID DOESN'T MATCH
                messageLabel.setForeground(Color.red);
                messageLabel.setText("ID doesn't exist");
            }

        }
        else if(e.getSource() == signupButton){
            //Get user ID and password
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword()); //retrieve the password and converts to a string and stores within a string

            if(logininfo.containsKey(userID)) {
                messageLabel.setForeground(Color.CYAN);
                messageLabel.setText("Login successful");
            }
            else{
                logininfo.put(userID,password);
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Sign up successful! You can now login ");



            }
        }
    }

    */

