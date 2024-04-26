import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            // while loop to loop the action event until acceptable information is entered for variables.
            boolean noEmptyFields = false;
            while (!noEmptyFields) {
                // to submit to user object
                String name = nameField.getText();
                String address = addressField.getText();
                String cardHolderName = cardHolderField.getText();
                String cardNumber = cardNumberField.getText();
                String cvc = cvcField.getText();
                String expirationDate = expirationField.getText();

                // checking for empty variables
                if (name.isEmpty() || address.isEmpty() || cardHolderName.isEmpty() || cardNumber.isEmpty() || cvc.isEmpty() || expirationDate.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all the blank fields and resubmit");
                    break;
                }

                // Checking if name variable contains only alphabet characters (space included)

                // Regular expression to match only alphabet characters
                String regex = "^[a-zA-Z\\s]+$";

                Pattern pattern = Pattern.compile(regex);

                // Matching the input string against the pattern
                Matcher matcher = pattern.matcher(name);

                // Checking if the string contains only alphabet characters
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(frame, "Name contains non-alphabet characters. Please resubmit.");
                    break;
                }
                // Checking if cardholder name contains only alphabet characters (space included).
                matcher = pattern.matcher(cardHolderName);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(frame, "Cardholder name contains non-alphabet characters. Please resubmit.");
                    break;
                }
                // Checking if credit card number contains only numbers and allows hyphens
                String regexCC = "^[0-9\\-]+$";
                Pattern patternCC = Pattern.compile(regexCC);
                matcher = patternCC.matcher(cardNumber);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(frame, "Card number contains invalid characters. Please resubmit.");
                    break;
                }
                // Checking that cvc has only numbers
                String regexCVC = "^[0-9]{3,4}$";
                Pattern patternCVC = Pattern.compile(regexCVC);
                matcher = patternCVC.matcher(cvc);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(frame, "CVC contains invalid characters or is not 3-4 digits. Please resubmit.");
                    break;
                }
                else {
                    // terminates the loop
                    noEmptyFields = true;
                    //Add user info to user object for storage
                    user.setName(name);
                    user.setAddress(address);
                    user.setCardHolderName(cardHolderName);
                    user.setCardNumber(cardNumber);
                    user.setCvc(cvc);
                    user.setExpirationDate(expirationDate);

                    //If guest then dont add to userList file go to menu page
                    if (!isGuest) {
                        frame.dispose();
                        new MenuPage(user, manageUser);
                    } else {
                        frame.dispose();
                        manageUser.addUser(user); //I think change this to update field rather than save user
                        new MenuPage(user, manageUser);
                    }
                }
                // Perform validation of text
            }
        }
    }
}
