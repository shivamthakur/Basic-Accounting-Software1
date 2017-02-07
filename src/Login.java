import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login {
	private JFrame frame;
	private JTextField textField;
	private JButton btnCancel;
	private JLabel lblP;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection con=null;
	public Login() {
		initialize();
		con=loginconnect.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(141, 75, 252, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try{
					String query="select * from Employee where username=? and password=? ";
					 PreparedStatement pst=con.prepareStatement(query);
					 pst.setString(1,textField.getText());
					 pst.setString(2,passwordField.getText());
					 
					 ResultSet rs=pst.executeQuery();
					 int count=0;
					 while(rs.next()){
						 count++;
						 
					 }
					 if(count==1)
					 {
						 JOptionPane.showMessageDialog(null, "Username and password is correct");
						 
						 addcompany ac = new addcompany();
						 ac.main(null);
						 
						frame.dispose();
					 }
					 else if(count>1)
					 {
						 JOptionPane.showMessageDialog(null, "Duplicate Username and password ");
						 frame.dispose();
					 }
					 else{
						 JOptionPane.showMessageDialog(null, " Username and password is incorrect ");
						 frame.dispose();
					 }
					 rs.close();
					 pst.close();
				   }
				   catch(Exception e)
				   {
					   JOptionPane.showMessageDialog(null,e);
				   }
			}
		});
		btnLogin.setForeground(SystemColor.textHighlight);
		btnLogin.setBackground(SystemColor.menu);
		btnLogin.setBounds(141, 168, 116, 33);
		frame.getContentPane().add(btnLogin);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"bye");
                frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setForeground(SystemColor.textHighlight);
		btnCancel.setBackground(SystemColor.menu);
		btnCancel.setBounds(285, 168, 108, 34);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(62, 75, 73, 23);
		frame.getContentPane().add(lblNewLabel);
		
		lblP = new JLabel("Password:");
		lblP.setForeground(Color.GRAY);
		lblP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblP.setBounds(62, 109, 69, 23);
		frame.getContentPane().add(lblP);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordField.setBounds(141, 109, 252, 23);
		frame.getContentPane().add(passwordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.GRAY);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(205, 39, 132, 25);
		frame.getContentPane().add(lblLogin);
	}
	}


