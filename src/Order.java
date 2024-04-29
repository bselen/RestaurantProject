import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {
    private Map<MenuItem, Integer> items; // map to store items and their quantities

    public Order() {
        items = new HashMap<>();
    }

    // function to add an item to the order
    public void addItem(MenuItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    // function to remove an item from the order
    public void removeItem(MenuItem item, int quantity) {
        if (items.containsKey(item)) {
            int currentQuantity = items.get(item);
            if (currentQuantity <= quantity) {
                items.remove(item);
            } else {
                items.put(item, currentQuantity - quantity);
            }
        }
    }

    // function to calculate the total price of the order
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }
        return total;
    }

    public Map<MenuItem, Integer> getItems() {
        return items;
    }

}
