import javax.swing.*;

public class Main{
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Menu Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MenuGUI menuGUI = new MenuGUI();
            frame.add(menuGUI);

            frame.pack();
            frame.setVisible(true);
        });

        //IDandPasswords idandPasswords = new IDandPasswords();

        //Inital startup loading information (Staff and User data)
       // ManageUser manageUser = new ManageUser("userList.dat");
        //manageUser.loadUsers();
       // Staff staff = new Staff();

        //INSTANCE
        //Open up the login page
       // LoginPage loginPage = new LoginPage(manageUser, staff);

       // MenuGUI menuGUI = new MenuGUI();

    }
}