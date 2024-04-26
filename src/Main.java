public class Main{
    public static void main(String[] args){
        IDandPasswords idandPasswords = new IDandPasswords();

        //Load up the ManageUser class to be able to handle user info.
        //Loads saved user info from the save file.
        ManageUser manageUser = new ManageUser("userList.dat");
        manageUser.loadUsers();


        //INSTANCE
        //Open up the login page
        LoginPage loginPage = new LoginPage(manageUser);
        Menu menu = new Menu();

    }
}