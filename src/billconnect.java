import java.sql.*;
import javax.swing.*;
public class billconnect {
	Connection con2=null;
	  public static Connection dbConnector()
	  {
		  try{
			   Class.forName("org.sqlite.JDBC");
			   Connection con2=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Shivam Thakur\\Accounts\\Companystock.sqlite");
			   
			   return con2;
		     }
		   catch(Exception e)
		   {
			   JOptionPane.showMessageDialog(null,e);
			   return null;
	       }
	  }
}
