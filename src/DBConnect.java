
import java.sql.*;


public class DBConnect {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    //YouTube tutorial - https://www.youtube.com/watch?v=BCqW5XwtJxY&t=74s
    //Raeding data from database
    
    public DBConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            st = con.createStatement();
            
        }catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
    }
    
    public void getData() {
        try{
            
            String query = "select * from clients";
            rs = st.executeQuery(query);
            System.out.println("Records from database");
            while(rs.next()){
                String name = rs.getString("name");
                String sector = rs.getString("sector");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String website = rs.getString("website");
                String vatnumber = rs.getString("vatnumber");
                System.out.println("Name: "+name+"   "+"Sector: "+sector+"   "+"Telephone: "+telephone+"   "+"Email: "+email+"   "+"Address: "+address+"   "+"Website: "+website+"   "+"Vat Number: "+vatnumber);
                        
        }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
