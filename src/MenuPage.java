import javax.swing.*;
import java.awt.*;

public class MenuPage extends JFrame {

    public MenuPage(User user, ManageUser manageUser) {

        setTitle("Menu Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // buttons for editing account, go to cart, quit to log in page
        JButton editAccountButton = new JButton("Edit Account");
        JButton viewCartButton = new JButton("View Cart");
        JButton quitButton = new JButton("Quit");

        // Create a panel for the buttons in the top corners
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING)); // Left-align buttons
        buttonPanel.add(editAccountButton);
        buttonPanel.add(viewCartButton);

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
}
