import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class viewCart extends JFrame {
    private JPanel cartPanel;

    public viewCart(List<String> pizzasSelected, double total) {
        setTitle("Cart");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        // Create a panel to hold the cart contents
        cartPanel = new JPanel(new GridLayout(pizzasSelected.size() + 1, 1));

        // Add each pizza to the cart panel
        for (String pizza : pizzasSelected) {
            JLabel pizzaLabel = new JLabel(pizza);
            cartPanel.add(pizzaLabel);
        }

        // Create a label to display the total
        JLabel totalLabel = new JLabel("Total: $" + total);
        cartPanel.add(totalLabel);

        // Create a panel for the clear button
        JPanel clearPanel = new JPanel();
        clearPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center-align button
        JButton clearButton = new JButton("Clear Cart");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCart();
            }
        });
        clearPanel.add(clearButton);

        // Add the cart panel and clear panel to the frame
        add(cartPanel, BorderLayout.CENTER);
        add(clearPanel, BorderLayout.SOUTH);
    }

    // Method to clear the cart
    private void clearCart() {
        cartPanel.removeAll(); // Remove all components
        Menu.getPizzasSelected().clear(); // Clear the list of selected pizzas
        Menu.total = 0; // Reset the total
        dispose(); // Close the cart frame
    }
}