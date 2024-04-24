public class Main{
    public static void main(String[] args){
        IDandPasswords idandPasswords = new IDandPasswords();


        ManageUser manageUser = new ManageUser("userList.dat");
        manageUser.loadUsers();


        //INSTANCE
        LoginPage loginPage = new LoginPage(manageUser);



    }
}