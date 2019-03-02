//YouTube Tutorial - https://www.youtube.com/watch?v=uuhEb0k3vVE

package JavaDB_001;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Work extends JFrame implements ActionListener{
    JLabel JL_Name,JL_Sector,JL_Telephone,JL_Email,JL_Address,JL_Website,JL_Vat,JL_Compliance;
    JTextField JT_Name,JT_Sector,JT_Telephone,JT_Email,JT_Address,JT_Website,JT_Vat,JT_Compliance;
    JButton btn_search, btn_back;

      public Work(){
          super("Search");
          JL_Name = new JLabel("Enter Company Name:");
          JL_Name.setBounds(20, 20, 200, 20);
          JT_Name = new JTextField(20);
          JT_Name.setBounds(160, 20, 150, 27);
          btn_search = new JButton("Search");
          btn_search.setBounds(320, 20, 80, 27);
          btn_search.addActionListener(this);
          btn_back = new JButton("Back");
          btn_back.setBounds(180, 280, 80, 27);
          btn_back.addActionListener(this);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setSize(500,500);
          
          JL_Sector = new JLabel("Sector: ");
          JL_Sector.setBounds(20, 50, 100, 20);
          JT_Sector = new JTextField(20);
          JT_Sector.setBounds(160, 50, 150, 27);
          JT_Sector.setEditable(false);
          JL_Telephone = new JLabel("Telephone: ");
          JL_Telephone.setBounds(20, 80, 100, 20);
          JT_Telephone = new JTextField(20);
          JT_Telephone.setBounds(160, 80, 150, 27);
          JT_Telephone.setEditable(false);
          JL_Email = new JLabel("Email: ");
          JL_Email.setBounds(20, 110, 100, 20);
          JT_Email = new JTextField(20);
          JT_Email.setBounds(160, 110, 150, 27);
          JT_Email.setEditable(false);
          JL_Address = new JLabel("Address: ");
          JL_Address.setBounds(20, 140, 100, 20);
          JT_Address = new JTextField(20);
          JT_Address.setBounds(160, 140, 150, 27);
          JT_Address.setEditable(false);
          JL_Website = new JLabel("Website: ");
          JL_Website.setBounds(20, 170, 100, 20);
          JT_Website = new JTextField(20);
          JT_Website.setBounds(160, 170, 150, 27);
          JT_Website.setEditable(false);
          JL_Vat = new JLabel("Vat No.: ");
          JL_Vat.setBounds(20, 200, 100, 20);
          JT_Vat = new JTextField(20);
          JT_Vat.setBounds(160, 200, 150, 27);
          JT_Vat.setEditable(false);
          JL_Compliance = new JLabel ("Compliance:");
          JL_Compliance.setBounds(20, 230, 100, 20);
          JT_Compliance = new JTextField(20);
          JT_Compliance.setBounds(160, 230, 150, 27);
          JT_Compliance.setEditable(false);
          setLayout(null);

          add(btn_search);
          add(btn_back);
          add(JL_Name);
          add(JL_Sector);
          add(JT_Telephone);
          add(JL_Email);
          add(JL_Address);
          add(JL_Website);
          add(JL_Vat);
          add(JL_Compliance);
          add(JT_Name);
          add(JT_Sector);
          add(JL_Telephone);
          add(JT_Email);
          add(JT_Address);
          add(JT_Website);
          add(JT_Vat);
          add(JT_Compliance);

    }
          
    @Override
    public void actionPerformed(ActionEvent e) { 
    Function f = new Function();
    ResultSet rs = null;
    String sector = "sector";
    String telephone = "telephone";
    String email = "email";
    String address = "address";
    String website = "website";
    String vat = "vat";
    JT_Compliance.setText("Achieved");
    
    rs = f.find(JT_Name.getText());
    try{
      if(rs.next()){
          JT_Sector.setText(rs.getString("sector"));
            JT_Telephone.setText(rs.getString("telephone"));
              JT_Email.setText(rs.getString("email"));
                JT_Address.setText(rs.getString("address"));
                  JT_Website.setText(rs.getString("website"));
                    JT_Vat.setText(rs.getString("vatnumber"));
      }  else{
          JOptionPane.showMessageDialog(null, "No data for this company");
          JT_Name.setText("");
          JT_Sector.setText("");
          JT_Telephone.setText("");
          JT_Email.setText("");
          JT_Address.setText("");
          JT_Website.setText("");
          JT_Vat.setText("");
      }
    }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
            }

    }


   public class Function{
       Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
       public ResultSet find(String s){
           try{
           con = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
           ps = con.prepareStatement("select * from clients where name = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
       
   }

    
 public static void main(String[] args){
  new Work();
 }
 
}