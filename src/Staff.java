import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Staff implements Serializable {
    private HashMap<String, String> credentials;
    private static final String FILE_PATH = "data" + File.separator + "staffUser.dat";

    //On startup load up staff information to a Staff object
    public Staff() {
        loadStaff();
        System.out.println(credentials);
    }
    //Initial staff account
    public Staff(String username, String password) {
        this.credentials = new HashMap<>();
        this.credentials.put(username, password);
        saveStaff();
    }
    //Load Staff information on start up
    public void loadStaff() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            credentials = (HashMap<String, String>) ois.readObject();
            for (Map.Entry<String, String> entry : credentials.entrySet()) {
                System.out.println("Username: " + entry.getKey() + ", Password: " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Staff file not found. Creating a new one.");
            credentials = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading staff information: " + e.getMessage());

        }
    }
    //Save information to file
    public void saveStaff(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(credentials);
            System.out.println("Staff information successfully saved to " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error saving staff information: " + e.getMessage());
        }
    }
    //Authenticate Staff information for log in
    public boolean authenticate(String username, String password){
        System.out.println("Authenticating user " + username + " with password " + password);
        if (credentials.containsKey(username) && credentials.get(username).equals(password))
            return true;
        else
            return false;
    }

    /*

     */
   // USed to create an initial staff account since only one will be used.

    public static void main(String args[]) {
        Staff staff = new Staff("Staff7576","Staff4Pizza6000");
    }




}
