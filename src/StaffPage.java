import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffPage extends JFrame implements ActionListener {
    public StaffPage(Staff staff) {
        setTitle("Staff Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));

        // Buttons for navigating to orders page and edit menu page
        JButton ordersButton = new JButton("Orders Page");
        ordersButton.addActionListener(this);
        JButton editMenuButton = new JButton("Edit Menu Page");
        editMenuButton.addActionListener(this);
        JButton editAccountButton = new JButton("Edit Staff Password");
        editAccountButton.addActionListener(this);

        // Add buttons to the JFrame
        add(ordersButton);
        add(editMenuButton);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Orders Page")) {

            //Take to orders page
        } else if (e.getActionCommand().equals("Edit Menu Page")) {

           //Take to edit menu page
        } else if (e.getActionCommand().equals("Edit Staff Password")) {
            //Take to change Staff account info.
        }
    }
}
