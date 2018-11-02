
public class Main {


    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        connect.getData();
        
        new ClientFrame().setVisible(true);
    }
    
}
