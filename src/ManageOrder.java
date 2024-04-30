import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageOrder {
    private List<User> users; // List to store user objects
    private String fileName; // File name to store order data
    private static final String FILE_PATH = "data" + File.separator + "orders.dat";

    public ManageOrder() {
        this.users = new ArrayList<>();
        this.fileName = FILE_PATH;
        this.loadOrders(); // Load orders from file when ManageOrder is instantiated
    }

    // Add a user to the list
    public void addOrder(User user) {
        users.add(user);
        saveOrders(); // Save orders to file after adding a new user
    }

    // Load orders from file
    public void loadOrders() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            users = (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Order file not found. Creating a new one.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading orders: " + e.getMessage());
        }
    }

    // Save to files
    public void saveOrders() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(users);
            System.out.println("Orders successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving orders: " + e.getMessage());
        }
    }

    // Get all users
    public List<User> getUsers() {
        return users;
    }

    // Remove a user
    public void removeUser(User user) {
        users.remove(user);
        saveOrders(); // Save orders to file after removing a user
    }

}
