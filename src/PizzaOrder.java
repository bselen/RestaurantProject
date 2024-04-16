import javax.swing.*;
import java.awt.event.ActionEvent; // Represents an event such as button click or menu selection
import java.awt.event.ActionListener; //ActionListener is to handle events triggered by user actions, such as button clicks.



public class PizzaOrder extends JFrame implements ActionListener {
    JLabel textHeader, Description;
    JCheckBox pepperoni, cheese, bacon;
    JButton b;

    PizzaOrder() {
        //TITLE
        textHeader = new JLabel("MENU");
        textHeader.setBounds(50, 50, 500, 30);

        //DECLARE CHECKBOXES
        pepperoni = new JCheckBox("Pepperoni Pizza @ 15");
        cheese = new JCheckBox("Cheese Pizza @ 12");
        bacon = new JCheckBox("Bacon Pizza @ 13");

        //SET BOUNDS  position and size of the GUI components
        pepperoni.setBounds(100,100,200,20);
        cheese.setBounds(200,200,200,20);
        bacon.setBounds(200,200,200,20);


        //DESCRIPTION
        Description = new JLabel();
        Description.setBounds(20,50,500,30);

        //BUTTON
        b = new JButton("ORDER");
        b.setBounds(100, 400, 150, 50);
        //Event Listener "CLICK"
        b.addActionListener(this);

        //ADD COMPONENTS TO FRAME
        add(pepperoni);
        add(cheese);
        add(bacon);
        add(Description);
        add(b);
        add(textHeader);

        //SIZING
        setSize(500, 600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

        @Override
    public void actionPerformed(ActionEvent e){
        float amount = 0;
        String msg = "";
        if(pepperoni.isSelected()){
            amount += 15;
            msg += "pepperoni: 15\n"; // cost of the pizza \n means newline
        }
        if(cheese.isSelected()){
            amount += 12;
            msg += "cheese: 12\n"; //if cheese checkbox is checked return true and add 12 to the cost
        }
        if(bacon.isSelected()){
            amount += 13;
            msg += "bacon: 13\n";

        }


//LINE SEPARATOR
msg +="-----------------------";

       //DIALOG BOX
       JOptionPane.showMessageDialog(this, "RECEIPT\n\n"+msg+"Total = "+amount+"\n\nCONTACT: @gmail.com" ); //prints the receipt
            //parentComponent determines the position of the dialog box





    }
    //CALLING THE METHDD
    public  static void main(String[] args) {

    }


}
