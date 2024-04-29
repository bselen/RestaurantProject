import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartPage {
    private JFrame frame;
    private JPanel cartPanel;
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

        // Initialize submit button
        submitButton = new JButton("Submit Order");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Submit the order
                ManageOrder manageOrder = new ManageOrder();
                manageOrder.addOrder(user);

                JOptionPane.showMessageDialog(frame, "Order submitted successfully!");
            }
        });

        // Display user's cart items
        displayCartItems();

        // Add components to frame
        frame.add(cartPanel, BorderLayout.CENTER);
        frame.add(submitButton, BorderLayout.SOUTH);

        // Display frame
        frame.setVisible(true);
    }

    private void displayCartItems() {
        // Clear previous items
        cartPanel.removeAll();

        // Iterate over cart items and display them
        for (MenuItem item : order.getItems().keySet()) {
            int quantity = order.getItems().get(item);

            JPanel itemPanel = new JPanel(new BorderLayout());
            JLabel itemLabel = new JLabel(item.getName() + " - Quantity: " + quantity);
            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the item from the cart
                    order.removeItem(item, 1); // Remove one quantity of the item
                    displayCartItems(); // Update cart display
                }
            });

            itemPanel.add(itemLabel, BorderLayout.WEST);
            itemPanel.add(removeButton, BorderLayout.EAST);
            cartPanel.add(itemPanel);
        }

        // Refresh panel
        cartPanel.revalidate();
        cartPanel.repaint();
    }
}