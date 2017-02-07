import java.sql.*;
import javax.swing.*;
public class loginconnect {
	Connection con=null;
	 public static Connection dbConnector()
	 {
	   try{
		   Class.forName("org.sqlite.JDBC");
		   Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Shivam Thakur\\workspace\\EmployeeData.sqlite");
		   JOptionPane.showMessageDialog(null,"connection successfull");
		   return con;
	   }
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null,e);
		   return null;
	   }
	 }

}
