public class Main{
    public static void main(String[] args){
        IDandPasswords idandPasswords = new IDandPasswords();


        //INSTANCE
        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());



    }
}