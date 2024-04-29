import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class StaffPage extends JFrame implements ActionListener {
    private ManageOrder manageOrder;
    private JButton quitButton;

    public StaffPage(ManageOrder manageOrder) {
        this.manageOrder = manageOrder;
        setTitle("Staff Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel to hold orders
        JPanel ordersPanel = new JPanel();
        ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));

        // Add orders to the orders panel
        Map<User, Order> userOrders = manageOrder.getUserOrders();
        for (User user : userOrders.keySet()) {
            Order order = userOrders.get(user);
            JPanel orderPanel = new JPanel(new BorderLayout());
            orderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel nameLabel = new JLabel("User: " + user.getName());
            orderPanel.add(nameLabel, BorderLayout.NORTH);

            // List items in the order
            JTextArea itemsTextArea = new JTextArea();
            itemsTextArea.setEditable(false);
            for (Map.Entry<MenuItem, Integer> entry : order.getItems().entrySet()) {
                MenuItem item = entry.getKey();
                int quantity = entry.getValue();
                itemsTextArea.append(item.getName() + " - Quantity: " + quantity + "\n");

                // Add delete button for each item
                JButton deleteButton = new JButton("Delete");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        order.removeItem(item, quantity); // Remove item from order
                        manageOrder.saveOrders(); // Save updated orders to file
                        orderPanel.remove(deleteButton); // Remove the delete button
                        orderPanel.revalidate();
                        orderPanel.repaint();
                    }
                });
                orderPanel.add(deleteButton, BorderLayout.SOUTH);
            }
            JScrollPane scrollPane = new JScrollPane(itemsTextArea);
            orderPanel.add(scrollPane, BorderLayout.CENTER);

            ordersPanel.add(orderPanel);
        }

        // Quit button
        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageOrder.saveOrders(); // Save orders to file
                System.exit(0); // Close application
            }
        });

        // Add components to the frame
        JScrollPane scrollPane = new JScrollPane(ordersPanel);
        add(scrollPane, BorderLayout.CENTER);
        add(quitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // No action required for now
    }
}
