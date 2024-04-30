import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class StaffPage extends JFrame implements ActionListener {
    private ManageOrder manageOrder;
    private JButton quitButton;
    private JLabel totalPriceLabel;

    public StaffPage(ManageOrder manageOrder) {
        this.manageOrder = manageOrder;
        setTitle("Staff Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // for order list
        JPanel ordersPanel = new JPanel();
        ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));

        // loads the users from file
        List<User> users = manageOrder.getUsers();

        // Initialize total price
        double totalPrice = 0.0;

        // add users to screen
        for (User user : users) {
            JPanel userPanel = new JPanel(new BorderLayout());
            userPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // label for users name
            JLabel nameLabel = new JLabel("User: " + user.getName());
            userPanel.add(nameLabel, BorderLayout.NORTH);

            // order details text area
            JTextArea orderTextArea = new JTextArea();
            orderTextArea.setEditable(false);

            Order order = user.getOrder();
            for (Map.Entry<MenuItem, Integer> entry : order.getItems().entrySet()) {
                MenuItem item = entry.getKey();
                int quantity = entry.getValue();
                orderTextArea.append(item.getName() + " - Quantity: " + quantity + "\n");
            }
            JScrollPane scrollPane = new JScrollPane(orderTextArea);
            userPanel.add(scrollPane, BorderLayout.CENTER);

            // Total amount label for each order
            double userTotal = order.calculateTotalPrice();
            JLabel totalLabel = new JLabel("Total: $" + formatDecimal(userTotal));
            userPanel.add(totalLabel, BorderLayout.SOUTH);

            // delete button for orders
            JButton deleteButton = new JButton("Complete Order");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    manageOrder.removeUser(user);
                    ordersPanel.remove(userPanel); // remove panel from display
                    updateTotalPrice(); // update total price
                    revalidate(); // refresh layout
                    repaint(); // repaint the frame
                }
            });
            userPanel.add(deleteButton, BorderLayout.EAST);

            // add user panel to orders panel
            ordersPanel.add(userPanel);

            // update total price
            totalPrice += userTotal;
        }

        // Show total price of all orders
        totalPriceLabel = new JLabel("Total Price of All Orders: $" + formatDecimal(totalPrice));
        totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(totalPriceLabel, BorderLayout.NORTH);

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

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    // function updates the total price label
    private void updateTotalPrice() {
        double totalPrice = 0.0;
        for (User user : manageOrder.getUsers()) {
            totalPrice += user.getOrder().calculateTotalPrice();
        }
        totalPriceLabel.setText("Total Price of All Orders: $" + formatDecimal(totalPrice));
    }

    // function formats decimals
    private String formatDecimal(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(value);
    }
}
