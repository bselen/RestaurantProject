import javax.swing.*;
import  java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGUI {
    private JRadioButton pepperoniRadioButton;
    private JRadioButton fiveCheeseRadioButton;
    private JRadioButton margaritaRadioButton;
    private JRadioButton supremeRadioButton;
    private JCheckBox medium1299CheckBox;
    private JCheckBox large1599CheckBox;
    private JCheckBox medium1099CheckBox;
    private JCheckBox large1399CheckBox;
    private JCheckBox medium1199CheckBox;
    private JCheckBox large1499CheckBox;
    private JCheckBox medium1399CheckBox;
    private JCheckBox large1699CheckBox;
    private JButton submitButton;

    public MenuGUI() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //HANDLE SUBMIT BUTTON CLICK
                String selectedItem = "";
                if (pepperoniRadioButton.isSelected()) {
                    selectedItem = "Pepperoni";

                } else if (fiveCheeseRadioButton.isSelected()) {
                    selectedItem = "Five Cheese";

                } else if (margaritaRadioButton.isSelected()) {
                    selectedItem = "Margarita";
                } else if (supremeRadioButton.isSelected()) {
                    selectedItem = "Supreme";

                }

                String selectedSize = "";
                if (medium1299CheckBox.isSelected()) {
                    selectedSize = "Medium $12.99";
                } else if (large1399CheckBox.isSelected()) {
                    selectedSize = "Large $13.99";

                } else if (medium1099CheckBox.isSelected()) {
                    selectedSize = "Medium $10.99";

                } else if (large1599CheckBox.isSelected()) {
                    selectedSize = "Large $15.99";

                } else if (medium1399CheckBox.isSelected()) {
                    selectedSize = "Medium $12.99";

                } else if (large1499CheckBox.isSelected()) {
                    selectedSize = "Large $14.99";

                } else if (medium1199CheckBox.isSelected()) {
                    selectedSize = "Medium 1199";

                }

                System.out.println("Selected Item: " + selectedItem);
                System.out.println("Selected Size" + selectedSize);
            }
        });
    }

        public static void main(String[] args){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MenuGUI();
                }
            });
        }
    }


