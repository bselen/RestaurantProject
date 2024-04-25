import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener { //indicates that our class can respond to action events triggered by GUI

    //INSTANCE VARIABLES
    JFrame frame = new JFrame()  ;
    JButton loginButton = new JButton("Login");
    JButton   resetButton = new JButton("Reset");
    JButton signupButton = new JButton("Sign Up");
    JButton guestButton = new JButton("Guest");






    //SIGN
 /*

    JLabel signUpLabel = new JLabel("Sign Up");
    JPasswordField newUserPasswordField = new JPasswordField();
    JTextField newUserIDField = new JTextField();
    JButton signUpButton = new JButton("Sign Up");

JLabel signUpIDLabel = new JLabel("User ID");
JLabel signUpPasswordLabel = new JLabel("Password: ");
JLabel signUpMessage = new JLabel("");
*/






    //LOGIN
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User ID");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("");

    private ManageUser manageUser; //Changed it from IDandPasswords. We might not need that class anymore
    private HashMap<String, String> loginInfo;

    //CONSTRUCTOR LOGIN
    public LoginPage(ManageUser manageUser){
        this.loginInfo = loginInfo;
        this.manageUser = manageUser; //To interact with user data

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(100,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25 ));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        signupButton.setBounds(50,200,100,25);
        signupButton.setFocusable(false);
        signupButton.addActionListener(this);

        loginButton.setBounds(175,200,100,25);
        loginButton.setFocusable(false); //When component has focus, any input  will be directed to that component.
        loginButton.addActionListener(this);

        resetButton.setBounds(300,200,100,25);
        resetButton.setFocusable(false); //When component has focus,any input  will be directed to that component.
        resetButton.addActionListener(this);

        guestButton.setBounds(225,250, 100, 25);
        guestButton.setFocusable(false);
        guestButton.addActionListener(this);

/*
     signUpLabel.setBounds(50,50,75,25);
     newUserIDField.setBounds(125,100,200,25);
     newUserPasswordField.setBounds(125,150,200,25);
     signUpButton.setBounds(125,200,100,25);

     signUpIDLabel.setBounds(175,100,75,25);
     signUpPasswordLabel.setBounds(50,150,75,25);



     signUpButton.addActionListener(this);

 */

     //LOGIN

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(signupButton);
        frame.add(guestButton);


    /* //SIGN UP
        frame.add(signUpLabel);
        frame.add(newUserPasswordField);
        frame.add(newUserIDField);
        frame.add(signUpButton);

     */

     //FRAME SETUP
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,320);
        frame.setLayout(null);
        frame.setVisible(true);


     //SIGNUP FRAME SETUP
      //  frame.setSize(420,480);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //ALLOWS US TO RESET LOGIN INFO
        if(e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setText(""); // To clear message label
        }
        else if (e.getSource() == loginButton) {
                String username = userIDField.getText();
                String password = String.valueOf(userPasswordField.getPassword());

                try{
                    if (manageUser.authenticate(username,password)) { // add authenticate later
                        messageLabel.setForeground(Color.GREEN);
                        messageLabel.setText("Login Successful");

                        //Add to go to Menu page
                    }
                    else {
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("Login Failed: Incorrect username or password");
                    }

                }
                catch (Exception ex) {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Error");
                }
            /*
            //CHECK IF USER ID EXISTS
            if (logininfo.containsKey(userID)) {
                //CHECK IF PASSWORD MATCHES
                if (logininfo.get(userID).equals(password)){
                    //LOGIN SUCCESSFUL
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");
                    frame.dispose();
                    new MenuPage();
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
            */
        }
        //Changed this to work with the user and manageUser class NEED TO FIX GIVES ERROR INSTEAD
        //OF ADDING TO FILE
        else if (e.getSource() == signupButton) {
            String username = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (manageUser.authenticate(username,password)) {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Username is already in use");
            }
            else {
                //Create new user and add to file
                User newUser = new User(username, password);
                manageUser.addUser(newUser);

                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Login Successful");

                frame.dispose(); //close login page
                new AccountInfoPage(newUser,false, manageUser);
            }
        }

        /*
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
             */

        else if (e.getSource() == guestButton) {
            //String guestUsername = generateRandomUsername(); implement later idk what class
            //Should be in the format of GuestXXXX were the X are random digits.
            String guestUsername = "GuestXXXX";
            String password = "";

            User user = new User(guestUsername, password);
            frame.dispose();
            new AccountInfoPage(user,true, manageUser);
        }
         }
    }

