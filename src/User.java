import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable {

    private HashMap<String, String> credentials; //Store username and password

    private String name;
    private String address; //Used for delvery purposes

    //Payment information
    private String cardHolderName;
    private String cardNumber;
    private String cvc;
    private String expirationDate;
    private String billingAddress;

    //CONSTRUCTOR
    public User(String username, String password){

        this.credentials = new HashMap<>();
        this.credentials.put(username, password);
        this.address = address;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expirationDate = expirationDate;
        this.billingAddress = billingAddress;

    }
    //GETTERS AND SETTERS

    public HashMap<String, String> getCredentials(){
        return credentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
