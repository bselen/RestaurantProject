import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        LoginGUI loginGUI = new LoginGUI();


        IDandPasswords iDandPasswords = new IDandPasswords();

        HashMap<String, String> loginInfo = iDandPasswords.getLoginInfo();
        loginGUI.printLoginInfo(loginInfo);
    }
}

      //  SignUp signUp = new SignUp(iDandPasswords.getLoginInfo());

      //  signUp.printLoginInfo();




        //INSTANCE
       // LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());






