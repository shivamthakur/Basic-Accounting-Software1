import java.sql.*;
import javax.swing.*;
public class stockconnect {
	Connection conm=null;
	 public static Connection dbConnector()
	 {
	   try{
		   Class.forName("org.sqlite.JDBC");
		   /*
		    * 
		    * pass variables here for the folder name of the company
		    */
		   Connection conm=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Shivam Thakur\\Accounts\\Companystock.sqlite");
		   
		   return conm;
	   }
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null,e);
		   return null;
	   }
	 }
}
