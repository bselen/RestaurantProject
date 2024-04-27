import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// this menu is not connected to the main program

public class Menu implements ActionListener {
    JFrame frame = new JFrame("Menu");
    JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
    JLabel cheesePizza = new JLabel("Cheese Pizza: $7");
    JLabel pepperoniPizza = new JLabel("Pepperoni Pizza: $10");
    JLabel sausagePizza = new JLabel("Sausage Pizza: $10");
    JButton cheesePizzaButton = new JButton("Order");
    JButton pepperoniPizzaButton = new JButton("Order");
    JButton sausagePizzaButton = new JButton("Order");
    JLabel baconPizza = new JLabel("Bacon Pizza: $10");
    JButton baconPizzaButton = new JButton("Order");
    JLabel pineapplePizza = new JLabel("Pineapple Pizza: $10");
    JButton pineapplePizzaButton = new JButton("Order");
    JLabel mushroomPizza = new JLabel("Mushroom Pizza: $10");
    JButton mushroomPizzaButton = new JButton("Order");
    JButton submitButton = new JButton("Submit");
    List<String> pizzasSelected = new ArrayList<>();
    double total = 0;



    public Menu() {
        // Increase font size for JLabels
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        cheesePizza.setFont(labelFont);
        pepperoniPizza.setFont(labelFont);
        sausagePizza.setFont(labelFont);
        baconPizza.setFont(labelFont);
        pineapplePizza.setFont(labelFont);
        mushroomPizza.setFont(labelFont);

        panel.add(cheesePizza);
        panel.add(cheesePizzaButton);
        panel.add(pepperoniPizza);
        panel.add(pepperoniPizzaButton);
        panel.add(sausagePizza);
        panel.add(sausagePizzaButton);
        panel.add(baconPizza);
        panel.add(baconPizzaButton);
        panel.add(pineapplePizza);
        panel.add(pineapplePizzaButton);
        panel.add(mushroomPizza);
        panel.add(mushroomPizzaButton);
        panel.add(new JLabel());
        panel.add(submitButton);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
        cheesePizzaButton.addActionListener(this);
        pepperoniPizzaButton.addActionListener(this);
        sausagePizzaButton.addActionListener(this);
        baconPizzaButton.addActionListener(this);
        pineapplePizzaButton.addActionListener(this);
        mushroomPizzaButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cheesePizzaButton) {
            System.out.println("cheesePizzaButton pressed");
            pizzasSelected.add("Cheese Pizza - $7");
            total += 7;
        }
        if(e.getSource() == pepperoniPizzaButton) {
            System.out.println("pepperoniPizzaButton pressed");
            pizzasSelected.add("Pepperoni Pizza - $10");
            total += 10;
        }
        if(e.getSource() == sausagePizzaButton) {
            System.out.println("sausagePizzaButton pressed");
            pizzasSelected.add("Sausage Pizza - $10");
            total += 10;
        }
        if(e.getSource() == baconPizzaButton) {
            System.out.println("baconPizzaButton pressed");
            pizzasSelected.add("Bacon Pizza - $10");
            total += 10;
        }
        if(e.getSource() == pineapplePizzaButton) {
            System.out.println("pineapplePizzaButton pressed");
            pizzasSelected.add("Pineapple Pizza - $10");
            total += 10;
        }
        if(e.getSource() == mushroomPizzaButton) {
            System.out.println("mushroomPizzaButton pressed");
            pizzasSelected.add("Mushroom Pizza - $10");
            total += 10;
        }
        if(e.getSource() == submitButton) {
            System.out.println("submitButton pressed");
            System.out.println(pizzasSelected);
            System.out.println(total);
            frame.dispose();
        }

    }
    public List<String> getPizzasSelected() {
        return pizzasSelected;
    }

    public double menuGetTotal() {
        return total;
    }
}
