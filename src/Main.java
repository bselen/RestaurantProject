public class Main{
    public static void main(String[] args){
        IDandPasswords idandPasswords = new IDandPasswords();

        //Inital startup loading information (Staff and User data)
        ManageUser manageUser = new ManageUser("userList.dat");
        manageUser.loadUsers();
        Staff staff = new Staff();

        //INSTANCE
        //Open up the login page
        LoginPage loginPage = new LoginPage(manageUser, staff);

    }
}