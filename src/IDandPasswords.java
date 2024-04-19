import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> logininfo = new HashMap<String, String>();

    IDandPasswords(){
        logininfo.put("Emily", "12apple");
        logininfo.put("Adam","gators$234");
        logininfo.put("Alex","pizzA11");

    }

  //GETTER
    protected HashMap getLoginInfo(){
        return logininfo;

    }
}
