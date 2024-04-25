import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

    public class Menu {

        public static void main(String[] args) {
            menu();
            printMenu();
        }

        public static void menu() {
            try (FileWriter pzMenu = new FileWriter("Menu.txt")) {
                pzMenu.write("\n\t\tAll our classic pizzas come on your choice of hand-tossed, original pan,\n\t\t or thin-crispy crust with our signature blend of robust tomato sauce.\n\n");
                pzMenu.write("\n\t\t\t\t\tSmall(10in) \tMedium(14in) \tLarge(18in) \tX-Large(22in)\n");
                pzMenu.write("CLASSICS:\n");
                pzMenu.write("\nFive Cheese\t\t\t - \t");
                pzMenu.write("   $7.99\t");
                pzMenu.write("   $9.99\t");
                pzMenu.write("   $12.99\t");
                pzMenu.write("   $16.99\n");
                pzMenu.write("\n\tFresh mozzarella, provolone, asiago, muenster\n\t and parmesan cheese. Cheese lovers rejoice!\n");

                pzMenu.write("\nMargarita\t\t\t - \t");
                pzMenu.write("   $8.99\t");
                pzMenu.write("   $10.99\t");
                pzMenu.write("   $13.99\t");
                pzMenu.write("   $17.99\n");
                pzMenu.write("\n\tFresh mozzarella, tomatoes, basil and tyme.\n\t       It's a classic for a reason.\n");

                pzMenu.write("\nPepperoni\t\t\t - \t");
                pzMenu.write("   $8.99\t");
                pzMenu.write("   $11.99\t");
                pzMenu.write("   $15.99\t");
                pzMenu.write("   $20.99\n");
                pzMenu.write("\n\tCovered in fresh mozzarella and pepperoni.\n\t\t      Enough said.\n");

                pzMenu.write("\nSupreme\t\t\t\t - \t");
                pzMenu.write("   $11.99\t");
                pzMenu.write("   $15.99\t");
                pzMenu.write("   $20.99\t");
                pzMenu.write("   $26.99\n");
                pzMenu.write("\n\t Pepperoni, ham, beef, seasoned pork, Italian sausage,\n\tonions, mushrooms, green bell peppers and black olives.\n\t\t\t    Now that's a mouthful.\n");

                pzMenu.write("\nMeat Lovers\t\t\t - \t");
                pzMenu.write("   $11.99\t");
                pzMenu.write("   $15.99\t");
                pzMenu.write("   $20.99\t");
                pzMenu.write("   $26.99\n");
                pzMenu.write("\n\t  Old-world pepperoni, Italian sausage, ham,\n\tapplewood smoked bacon, seasoned pork and beef.\n\t\t     Grandpa's favorite!\n");

                pzMenu.write("\nSPECIALTIES:\n");
                pzMenu.write("\nBlanco Spinach\t\t\t - \t");
                pzMenu.write("   $9.99\t");
                pzMenu.write("   $12.99\t");
                pzMenu.write("   $16.99\t");
                pzMenu.write("   $21.99\n");
                pzMenu.write("\n\tCreamy Alfredo sauce, fresh spinach, feta, Parmesan-Asiago,\n\t\tprovolone and real fresh mozzarella cheese.\n");

                pzMenu.write("\nChicken x Bacon Ranch\t\t - \t");
                pzMenu.write("   $10.99\t");
                pzMenu.write("   $13.99\t");
                pzMenu.write("   $17.99\t");
                pzMenu.write("   $22.99\n");
                pzMenu.write("\n\tHomestyle ranch, rotisserie grilled chicken \n\t    breast and applewood smoked bacon.\n\t\tIs your mouth watering yet?\n");

                pzMenu.write("\nHawaiian\t\t\t - \t");
                pzMenu.write("   $10.99\t");
                pzMenu.write("   $13.99\t");
                pzMenu.write("   $17.99\t");
                pzMenu.write("   $22.99\n");
                pzMenu.write("\n\tClassic marinara sauce, slow-roasted ham, smoked \n\tbacon and tropical pineapple. Pineapple on pizza?\n\t\t     Let's fight about it!\n");

                pzMenu.write("\nBuffalo or Barbeque Chicken\t - \t");
                pzMenu.write("   $9.99\t");
                pzMenu.write("   $12.99\t");
                pzMenu.write("   $16.99\t");
                pzMenu.write("   $21.99\n");
                pzMenu.write("\n\tYour choice of tangy barbeque or spicy buffalo sauce, sharp\n\tcheddar cheese, grilled chicken and applewood smoked bacon.\n\t\t\t    Try it half/half!\n");


                pzMenu.write("\nMeatball Marinara\t\t - \t");
                pzMenu.write("   $9.99\t");
                pzMenu.write("   $12.99\t");
                pzMenu.write("   $16.99\t");
                pzMenu.write("   $21.99\n");
                pzMenu.write("\n\t100% American beef meatballs and creamy ricotta\n\t    cheese on a bed of fresh mozzarella and\n\t       mouth watering homestyle marinara.\n");

                pzMenu.write("\n\nCREATE YOUR OWN:\t\t - \t");
                pzMenu.write("   $8.99\t");
                pzMenu.write("   $11.99\t");
                pzMenu.write("   $15.99\t");
                pzMenu.write("   $20.99\n");
                pzMenu.write("\n\tChoose your favorite toppings and create your own masterpiece!\n");

                pzMenu.write("\nCRUST:(Included)\n");
                pzMenu.write("\tHand-Tossed \t\t : \t Original Pan \t\t : \t Thin-Crispy\n");

                pzMenu.write("\nSAUCE:(Included)\n");
                pzMenu.write("\tRobust Tomato \t\t : \t Hearty Marinara \t : \t Creamy Alfredo\n\tHomestyle Ranch \t : \t Spicy Buffalo \t\t : \t Tangy Barbeque\n");

                pzMenu.write("\nTOPPINGS:($1 Per Additional Topping, Fresh Mozzarella Included)\n");
                pzMenu.write("\n> Meats: Old World Pepperoni - Italian Sausage - Applewood Smoke Bacon - Slow Roasted Ham\n");
                pzMenu.write("         100% All-American Beef - Rotisserie Grilled Chicken - Seasoned Pork - Meatballs\n");

                pzMenu.write("\n> Veggies: Bell Peppers - Mushrooms - Onions - Black Olives - Jalapeños - Fresh Spinach\n");
                pzMenu.write("           Fresh Tomatoes - Artichoke - Green Olives - Pepperoncini - Basil - Pineapple\n");

                pzMenu.write("\n> Cheese: Extra Fresh Mozzarella - Feta - Cheddar - Parmesan - Asiago\n");
                pzMenu.write("          Provolone - Gouda - Havarti - Muenster - Ricotta\n");

            } catch (IOException e) {
                System.err.println("Error writing to Menu.txt: " + e.getMessage());
            }
        }

        public static void printMenu() {
            try (BufferedReader reader = new BufferedReader(new FileReader("Menu.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading from Menu.txt: " + e.getMessage());
            }
        }
    }