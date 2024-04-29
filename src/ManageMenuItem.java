import java.util.ArrayList;
import java.util.List;

public class ManageMenuItem {

    private static List<MenuItem> menuItems;


    //Menu ITems hardcoded into app
    public ManageMenuItem() {

        this.menuItems = new ArrayList<MenuItem>();

        MenuItem pepperoniPizza = new MenuItem("Pepperoni Pizza", "Classic pepperoni", 10.99, "pizza" );
        MenuItem coke2L = new MenuItem("2L Coca-Cola", "Refreshing Coca-Cola in a 2-liter bottle", 2.99, "drink");
        MenuItem sprite2L = new MenuItem("2L Sprite", "Crisp Sprite in a 2-liter bottle", 2.99, "drink");
        MenuItem beefPizza = new MenuItem("Beef Pizza", "Savory beef pizza with tomato sauce and cheese", 12.99, "pizza");
        MenuItem meatLoversPizza = new MenuItem("Meat Lovers Pizza", "Hearty pizza loaded with assorted meats and cheese", 14.99, "pizza");
        MenuItem stuffedCrustPepperoni = new MenuItem("Stuffed Crust Pepperoni", "Pepperoni pizza with a delicious stuffed crust", 13.99, "pizza");
        MenuItem ranchSauce = new MenuItem("Ranch Sauce", "Creamy ranch sauce for dipping", 1.99, "side");
        MenuItem marinaraSauce = new MenuItem("Marinara Sauce", "Classic marinara sauce for dipping", 1.99, "side");

        menuItems.add(pepperoniPizza);
        menuItems.add(coke2L);
        menuItems.add(sprite2L);
        menuItems.add(beefPizza);
        menuItems.add(meatLoversPizza);
        menuItems.add(stuffedCrustPepperoni);
        menuItems.add(ranchSauce);
        menuItems.add(marinaraSauce);

    }

    //Need function to list all available users
    //Used for debugging purposes
    public void listMenuItems() {
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getName());
        }
    }

 public static List<MenuItem> getMenuItems(){
    return menuItems;
 }
}
