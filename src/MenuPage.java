import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage implements ActionListener {
    JFrame frame = new JFrame()  ;
    JButton editAccountButton = new JButton("Edit Account");
    JButton   viewCartButton = new JButton("View Cart");
    JButton quitButton = new JButton("Quit");
    JLabel displayUsername;

    private ManageUser manageUser;
    private boolean isGuest;
    private User user;

    public MenuPage(User user, ManageUser manageUser) {

        this.user = user;
        this.manageUser = manageUser;

        displayUsername = new JLabel("Welcome: " + user.getName(), SwingConstants.CENTER);

        // Create a panel for the buttons in the top corners
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(editAccountButton, BorderLayout.WEST);
        buttonPanel.add(viewCartButton, BorderLayout.EAST);

        // Create a panel for the username label between the buttons
        JPanel usernamePanel = new JPanel(new BorderLayout());
        usernamePanel.add(displayUsername, BorderLayout.CENTER);

        // Combine button panel and username panel vertically
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(buttonPanel, BorderLayout.NORTH);
        topPanel.add(usernamePanel, BorderLayout.CENTER);

        // Create a panel for the quit button in the bottom left corner
        JPanel quitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        quitPanel.add(quitButton);

        // Set bounds and properties of buttons
        editAccountButton.setFocusable(false);
        editAccountButton.addActionListener(this);

        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        viewCartButton.setFocusable(false);
        viewCartButton.addActionListener(this);

        // Add components to frame using BorderLayout
        frame.add(topPanel, BorderLayout.NORTH); // Add topPanel instead of buttonPanel
        frame.add(quitPanel, BorderLayout.SOUTH);

        // FRAME SETUP
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 320);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == editAccountButton) {
            frame.dispose();

            new AccountInfoPage(user, false, manageUser);
        }
    }
}
