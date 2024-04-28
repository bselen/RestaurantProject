import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageMenuItem {

    private List<MenuItem> menuItems;
    private String fileName; // File name to store user data

    public ManageMenuItem(String fileName) {
        this.fileName = "menuItems" + File.separator + fileName; //Stores
        this.menuItems = new ArrayList<>();
        this.loadMenuItem(); // Load users from file when UserManager is instantiated
    }

    // add a new user
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
        saveMenuItem(); // Save menuItem to file after adding a new user
    }



    // Load users from file
    public void loadMenuItem() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            menuItems = (List<MenuItem>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("User file not found. Creating a new one.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }


    public void saveMenuItem() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(menuItems);
            System.out.println("Users successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // save users to file
        /*
        public void saveUsers() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(users);
            } catch (IOException e) {
                System.err.println("Error saving users: " + e.getMessage());
            }
        }
        */


    //Need function to list all available users
    public void listMenuItems(){
        for (MenuItem menuItem  : menuItems) {
            System.out.println(menuItem);
        }
    }
}
