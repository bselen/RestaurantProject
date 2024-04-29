import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartPage {
    private JFrame frame;
    private JPanel cartPanel;
    private JButton backButton;
    private JButton submitButton;

    private User user;
    private Order order;
    private ManageUser manageUser;

    public CartPage(User user, ManageUser manageUser) {
        this.user = user;
        this.manageUser = manageUser;
        this.order = user.getOrder();
        this.cartPanel = new JPanel();

        displayCartItems();

        // Initialize frame
        frame = new JFrame("Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Initialize cart panel
        cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        // Initialize buttons
        backButton = new JButton("Back to Menu");
        submitButton = new JButton("Submit Order");

        // Add action listeners to buttons
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuPage(user, manageUser);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Submit the order
                JOptionPane.showMessageDialog(frame, "Order submitted successfully!");
            }
        });

        // Display user's cart items
        displayCartItems();

        // Add components to frame
        frame.add(cartPanel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.WEST);
        frame.add(submitButton, BorderLayout.EAST);

        // Display frame
        frame.setVisible(true);
    }

    private void displayCartItems() {

        // Iterate over cart items and display them
        for (MenuItem item : order.getItems().keySet()) {
            int quantity = order.getItems().get(item);

            JLabel itemLabel = new JLabel(item.getName() + " - Quantity: " + quantity);
            cartPanel.add(itemLabel);
        }
    }



}
