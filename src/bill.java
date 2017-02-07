import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.JFrame;

public class bill {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtDate;
	private JTextField txtMedicine;
	private JTextField txtSalt;
	private JTextField txtCompany;
	private JTextField txtPrice;
	private JTable table;

Connection con2=null;
Connection conm=null;
private JTextField txtQuantity;
private JTextField txtPres;
private JTextField txtType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill window = new bill();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void refreshTable()
	{
		try{
			String query="select * from bills ";
				PreparedStatement pst1=con2.prepareStatement(query);
			  ResultSet rs=pst1.executeQuery();
			   table.setModel(DbUtils.resultSetToTableModel(rs));
			    pst1.close();
		   }
		   catch(Exception e)
		   {
			 e.printStackTrace();
		   }
	}

	/**
	 * Create the application.
	 */
	public bill() {
		con2=billconnect.dbConnector();
		conm=stockconnect.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame( "Billing");
		frame.setBounds(100, 100, 794, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(108, 21, 127, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(53, 19, 69, 20);
		frame.getContentPane().add(lblName);
		
		JFormattedTextField txtDate = new JFormattedTextField( new SimpleDateFormat("dd/MM/yyyy"));
		txtDate.setBounds(636, 21, 86, 20);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		txtDate.setValue(new java.util.Date());
		
		
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(525, 24, 101, 17);
		frame.getContentPane().add(lblDate);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(682, 493, 89, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(583, 493, 89, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(10, 493, 89, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblType = new JLabel("Type ");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblType.setBounds(53, 76, 44, 20);
		frame.getContentPane().add(lblType);
		
		JRadioButton rdbtnStock = new JRadioButton("Stock");
		rdbtnStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnStock.setBounds(105, 77, 69, 23);
		frame.getContentPane().add(rdbtnStock);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOther.setBounds(176, 75, 61, 23);
		frame.getContentPane().add(rdbtnOther);
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMedicine.setBounds(53, 146, 69, 20);
		frame.getContentPane().add(lblMedicine);
		
		JLabel lblSalt = new JLabel("Salt");
		lblSalt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalt.setBounds(77, 200, 30, 23);
		frame.getContentPane().add(lblSalt);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCompany.setBounds(373, 151, 69, 23);
		frame.getContentPane().add(lblCompany);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(398, 201, 44, 20);
		frame.getContentPane().add(lblPrice);
		
		txtMedicine = new JTextField();
		txtMedicine.setBounds(122, 148, 113, 20);
		frame.getContentPane().add(txtMedicine);
		txtMedicine.setColumns(10);
		
		txtSalt = new JTextField();
		txtSalt.setBounds(122, 198, 113, 20);
		frame.getContentPane().add(txtSalt);
		txtSalt.setColumns(10);
		
		txtCompany = new JTextField();
		txtCompany.setBounds(452, 154, 113, 20);
		frame.getContentPane().add(txtCompany);
		txtCompany.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(452, 203, 113, 20);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 290, 659, 165);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(53, 252, 69, 20);
		frame.getContentPane().add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(122, 254, 113, 20);
		frame.getContentPane().add(txtQuantity);
		
		JLabel lblPriscription = new JLabel("Priscription");
		lblPriscription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPriscription.setBounds(373, 252, 79, 20);
		frame.getContentPane().add(lblPriscription);
		
		txtPres = new JTextField();
		txtPres.setColumns(10);
		txtPres.setBounds(452, 254, 113, 20);
		frame.getContentPane().add(txtPres);
		
		txtType = new JTextField();
		txtType.setBounds(325, 78, 86, 20);
		frame.getContentPane().add(txtType);
		txtType.setColumns(10);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Type;
				  if(rdbtnStock.isSelected())
					  Type = "Stock";
				  else
					  Type="Other";
				  
				 
				  txtType.setText(Type);
				String med="";
				int qty=0;
				  try{
					  String query="insert into bill(Name,Date,Type,Medicine,Company,Salt,Price,Quantity,Priscription) values(?,?,?,?,?,?,?,?,?)";
					  PreparedStatement pst1=con2.prepareStatement(query);
					  pst1.setString(1,txtName.getText());
					  pst1.setString(2, txtDate.getText());
					  
					  
					  pst1.setString(3,txtType.getText());
					  med=txtMedicine.getText();
					  pst1.setString(4,txtMedicine.getText());
					  pst1.setString(5,txtCompany.getText());
				      pst1.setString(6,txtSalt.getText());
				      
				      pst1.setInt(7,Integer.parseInt(txtPrice.getText()));
				      pst1.setInt(8,Integer.parseInt(txtQuantity.getText()));
				      qty=Integer.parseInt(txtQuantity.getText());
				      pst1.setString(9,txtPres.getText());
				      				      
				      pst1.execute();
					  JOptionPane.showMessageDialog(null,"Data Saved");
					    pst1.close();
					    
					
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
				  finally
				  {
					  if(rdbtnStock.isSelected())
					  {
						  String query ="update company_stock set Qunatity=((select Qunatity from company_stock where Medicine = '"+med+"')-"+qty+") where Medicine='"+med+"';";
						  //String query ="update company_stock set Qunatity='0' where Medicine='"+med+"';";
						  //String query="update company_stock set Qunatity=(select Qunatity from company_stock)-(select Quantity from bill) where (select Qunatity from company_stock)=(select Quantity from bill);";
						  PreparedStatement pst3;
						try {
							pst3 = conm.prepareStatement(query);
						  //pst3.setString(1,med);
						  //pst3.setInt(2, qty);

							pst3.execute();
									JOptionPane.showMessageDialog(null,"Data updated");
							  pst3.close();  
								try
								{
								String query2 ="delete from company_stock where Qunatity = ?;";
								
								PreparedStatement pst4;
								pst4=conm.prepareStatement(query2);
								pst4.setInt(1, 0);
								//pst4.setInt(2, 0);
								pst4.execute();
								pst4.close();
								
								}
								catch(SQLException e) 
								{
									
								}

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  
						  
					  }
					  else{
						  JOptionPane.showMessageDialog(null,"thank you");
					  }
				  }
				 
			}
		});
		
	}

}
