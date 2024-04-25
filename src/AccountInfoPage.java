import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountInfoPage implements ActionListener {

    // INSTANCE VARIABLES
    JFrame frame = new JFrame("Account Information");
    JLabel nameLabel = new JLabel("Name:");
    JTextField nameField = new JTextField();
    JLabel addressLabel = new JLabel("Address:");
    JTextField addressField = new JTextField();
    JLabel cardHolderLabel = new JLabel("Card Holder Name:");
    JTextField cardHolderField = new JTextField();
    JLabel cardNumberLabel = new JLabel("Card Number:");
    JTextField cardNumberField = new JTextField();
    JLabel cvcLabel = new JLabel("CVC:");
    JTextField cvcField = new JTextField();
    JLabel expirationLabel = new JLabel("Expiration Date:");
    JTextField expirationField = new JTextField();
    JButton submitButton = new JButton("Submit");

    private ManageUser manageUser;
    private boolean isGuest;
    private User user;

    // CONSTRUCTOR
    public AccountInfoPage(User user, boolean isGuest, ManageUser manageUser) {

        this.isGuest = isGuest;
        this.manageUser = manageUser;
        this.user = user;

        // Set up the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(8, 2));

        // Add components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(addressLabel);
        frame.add(addressField);
        frame.add(cardHolderLabel);
        frame.add(cardHolderField);
        frame.add(cardNumberLabel);
        frame.add(cardNumberField);
        frame.add(cvcLabel);
        frame.add(cvcField);
        frame.add(expirationLabel);
        frame.add(expirationField);
        frame.add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(this);

        // Make the frame visible
        frame.setVisible(true);
    }

    // ActionListener implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click events
        if (e.getSource() == submitButton) {

            // to submit to user object
            String name = nameField.getText();
            String address = addressField.getText();
            String cardHolderName = cardHolderField.getText();
            String cardNumber = cardNumberField.getText();
            String cvc = cvcField.getText();
            String expirationDate = expirationField.getText();


            //Add user info to user object for storage
            user.setName(name);
            user.setAddress(address);
            user.setCardHolderName(cardHolderName);
            user.setCardNumber(cardNumber);
            user.setCvc(cvc);
            user.setExpirationDate(expirationDate);

            //If guest then dont add to userList file go to menu page
            if (!isGuest){
                frame.dispose();
                new MenuPage(user, manageUser);
            }
            else {
                frame.dispose();
                manageUser.addUser(user); //I think change this to update field rather than save user
                new MenuPage(user, manageUser);
            }
            // Perform validation of text

        }
    }


}
