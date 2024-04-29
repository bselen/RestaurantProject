import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ManageOrder {
    private Map<User, Order> userOrders;
    private String fileName; // File name to store order data
    private static final String FILE_PATH = "data" + File.separator + "orders.dat";

    public ManageOrder() {
        this.userOrders = new HashMap<>();
        this.fileName = FILE_PATH;
        this.loadOrders(); // Load orders from file when ManageOrder is instantiated
    }

    // Add an order for a user
    public void addOrder(User user) {
        userOrders.put(user, user.getOrder());
        saveOrders(); // Save orders to file after adding a new order
    }

    // Load orders from file
    public void loadOrders() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            userOrders = (Map<User, Order>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Order file not found. Creating a new one.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading orders: " + e.getMessage());
        }
    }

    // Save orders to file
    public void saveOrders() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(userOrders);
            System.out.println("Orders successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving orders: " + e.getMessage());
        }
    }

    // Get all user orders
    public Map<User, Order> getUserOrders() {
        return userOrders;
    }

    // Remove an order for a user
    public void removeOrder(User user) {
        userOrders.remove(user);
        saveOrders(); // Save orders to file after removing an order
    }
}