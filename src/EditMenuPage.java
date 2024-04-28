import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenuPage extends JFrame implements ActionListener {
    public EditMenuPage() {
        setTitle("Edit Menu Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose this frame without exiting the application
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel for adding new item button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addItemButton = new JButton("Add New Item");
        addItemButton.addActionListener(this);
        buttonPanel.add(addItemButton);
        add(buttonPanel, BorderLayout.NORTH);

        // Panel for listing items (scrollable)
        JPanel itemListPanel = new JPanel();
        itemListPanel.setLayout(new BoxLayout(itemListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(itemListPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Example: Add components to itemListPanel to display list of items with edit/delete buttons

        // Button to submit changes and return to StaffPage
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        submitPanel.add(submitButton);
        add(submitPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add New Item")) {
            // Open a new page to add a new item
            // Example: AddNewItemPage addNewItemPage = new AddNewItemPage();
        } else if (e.getActionCommand().equals("Submit")) {
            // Return to StaffPage
            dispose(); // Close this EditMenuPage
            // Example: Implement logic to return to StaffPage
        }
    }


}

