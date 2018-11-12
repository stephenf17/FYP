
public class Main {

    //Setting up database connection and allowing the client frame to be visible
    
    public static void main(String[] args) {
        
                
        login login = new login();
        login.setVisible(true);
        
        DBConnect connect = new DBConnect();
        connect.getData();
        
        new ClientFrame().setVisible(true);
    }
    
}
