import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MenuPage extends JFrame implements ActionListener {
    // buttons for editing account, go to cart, quit to log in page
    JButton editAccountButton = new JButton("Edit Account");
    JButton viewCartButton = new JButton("View Cart");
    JButton viewMenuButton = new JButton("View Menu");
    JButton quitButton = new JButton("Quit");
    public MenuPage(User user, ManageUser manageUser) {

        setTitle("Menu Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());


        // Create a panel for the buttons in the top corners
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING)); // Left-align buttons
        buttonPanel.add(editAccountButton);
        buttonPanel.add(viewCartButton);
        buttonPanel.add(viewMenuButton);

        editAccountButton.addActionListener(this);
        viewCartButton.addActionListener(this);
        viewMenuButton.addActionListener(this);
        quitButton.addActionListener(this);

        // Create a panel for the quit button in the bottom left corner
        JPanel quitPanel = new JPanel();
        quitPanel.setLayout(new FlowLayout(FlowLayout.LEADING)); // Left-align button
        quitPanel.add(quitButton);

        // Add panels to the JFrame
        add(buttonPanel, BorderLayout.NORTH);
        add(quitPanel, BorderLayout.SOUTH);

        // Display the JFrame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewMenuButton)
        {
            Menu menu = new Menu();
        }
        if (e.getSource() == viewCartButton) {
            // Create and display a new JFrame to show the cart contents
            JFrame cartFrame = new JFrame("Cart");
            cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cartFrame.setSize(500, 500);
            cartFrame.setLocationRelativeTo(this);

            // Get the list of selected pizzas from Menu
            List<String> pizzasSelected = Menu.getPizzasSelected();
            double total = Menu.menuGetTotal();
            // Create a JTextArea to display the list of selected pizzas
            JTextArea cartTextArea = new JTextArea(10, 20);
            cartTextArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(cartTextArea);

            // Add the list of pizzas to the JTextArea
            for (String pizza : pizzasSelected) {
                cartTextArea.append(pizza + "\n");
            }

            // Add the JTextArea to the cartFrame
            cartFrame.add(scrollPane);
            cartTextArea.append("Total: " + total);
            // Make the cartFrame visible
            cartFrame.setVisible(true);
        }
    }
}
