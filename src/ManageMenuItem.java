import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManageMenuItem {

    private List<User> menuItems;
    private String fileName; // File name to store user data
    private HashMap<String, String> loginInfo;
    public ManageMenuItem(String fileName) {
        this.fileName = "data" + File.separator + fileName; //Stores
        this.users = new ArrayList<>();
        this.loadUsers(); // Load users from file when UserManager is instantiated
    }

    // add a new user
    public void addMenuItem(MenuItem menuItem) {
        menuItem.add(menuItem);
        saveMenuItem(); // Save menuItem to file after adding a new user
    }



    // Load users from file
    public void loadMenuItem() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            users = (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("User file not found. Creating a new one.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }


    public void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(users);
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
    public void loadLoginInfo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data" + File.separator + "loginInfo.dat"))) {
            loginInfo = (HashMap<String, String>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Login info file not found.");
            loginInfo = new HashMap<>(); // Initialize an empty HashMap
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading login info: " + e.getMessage());
        }
    }

    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getCredentials().containsKey(username) && user.getCredentials().get(username).equals(password)) {
                return true;
            }
        }
        return false;

    }

    //Need function to list all available users
    public void listUsers(){
        for (User user : users) {
            System.out.println(user);
        }
    }
}
