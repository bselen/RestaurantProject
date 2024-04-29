import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage implements ActionListener {
    JFrame frame = new JFrame();
    JPanel menuPanel = new JPanel(); // Panel to hold menu items
    JButton editAccountButton = new JButton("Edit Account");
    JButton viewCartButton = new JButton("View Cart");
    JButton quitButton = new JButton("Quit");
    JLabel displayUsername;

    private ManageUser manageUser;
    private boolean isGuest;
    private User user;
    private ManageMenuItem manageMenuItem = new ManageMenuItem();

    public MenuPage(User user, ManageUser manageUser) {
        this.user = user;
        this.manageUser = manageUser;

        displayUsername = new JLabel("Welcome: " + user.getName(), SwingConstants.CENTER);

        // Create a panel for the username label between the buttons
        JPanel usernamePanel = new JPanel(new BorderLayout());
        usernamePanel.add(displayUsername, BorderLayout.CENTER);

        // Set bounds and properties of buttons
        editAccountButton.setFocusable(false);
        editAccountButton.addActionListener(this);

        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        viewCartButton.setFocusable(false);
        viewCartButton.addActionListener(this);

        // Add buttons to a panel at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(editAccountButton);
        buttonPanel.add(viewCartButton);
        buttonPanel.add(quitButton);

        // Add components to frame using BorderLayout
        frame.add(usernamePanel, BorderLayout.NORTH);
        frame.add(menuPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set up menu panel
        menuPanel.setLayout(new GridLayout(manageMenuItem.getMenuItems().size(), 1)); // Adjust layout based on number of menu items

        // Add menu item buttons to menu panel
        for (MenuItem menuItem : manageMenuItem.getMenuItems()) {
            JButton menuItemButton = new JButton(menuItem.getName() + " - $" + menuItem.getPrice());
            menuItemButton.addActionListener(this);
            menuPanel.add(menuItemButton);
        }

        // FRAME SETUP
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Center the frame on screen
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editAccountButton) {
            frame.dispose();
            new AccountInfoPage(user, false, manageUser);
        } else if (e.getSource() == quitButton) {
            System.exit(0);
        } else if (e.getSource() == viewCartButton) {
            frame.dispose();
            new CartPage(user, manageUser);

        } else {
            for (MenuItem menuItem : manageMenuItem.getMenuItems()) {
                if (e.getActionCommand().equals(menuItem.getName() + " - $" + menuItem.getPrice())) {
                    // Check if the item already exists in the order
                    boolean itemExists = false;
                    for (MenuItem existingItem : user.getOrder().getItems().keySet()) {
                        if (existingItem.getName().equals(menuItem.getName())) {
                            // If it exists, increment the quantity
                            user.getOrder().addItem(menuItem, user.getOrder().getItems().get(existingItem) + 1);
                            JOptionPane.showMessageDialog(null, menuItem.getName() + " added to cart.");
                            itemExists = true;
                            break;
                        }
                    }
                    // If the item does not exist, add it with quantity 1
                    if (!itemExists) {
                        user.getOrder().addItem(menuItem, 1);
                        JOptionPane.showMessageDialog(null, menuItem.getName() + " added to cart.");
                    }
                    return;
                }
            }
        }
    }
}