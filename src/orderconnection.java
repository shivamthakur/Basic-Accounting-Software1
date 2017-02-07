import java.sql.*;
import javax.swing.*;
public class orderconnection {
	Connection con1=null;
	  public static Connection dbConnector()
	  {
		  try{
			   Class.forName("org.sqlite.JDBC");
			   Connection con1=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Shivam Thakur\\Accounts\\Companystock.sqlite");
			   
			   return con1;
		     }
		   catch(Exception e)
		   {
			   JOptionPane.showMessageDialog(null,e);
			   return null;
	       }
	  }
}
