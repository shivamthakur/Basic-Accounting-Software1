import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.Font;

public class stocktable {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stocktable window = new stocktable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conm=null;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JButton btnDelete;
	private JLabel lblQuantity;
	private JTextField txtQuantity;

	public void refreshTable()
	{
		try{
			String query="select* from company_stock ";
				PreparedStatement pst=conm.prepareStatement(query);
			  ResultSet rs=pst.executeQuery();
			   table.setModel(DbUtils.resultSetToTableModel(rs));
			    pst.close();
		   }
		   catch(Exception e)
		   {
			 e.printStackTrace();
		   }
	}

	/**
	 * Create the application.
	 */
	public stocktable() {
		conm=stockconnect.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Stock Entry");
		frame.setBounds(100, 100, 791, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLoad = new JButton("Exit");
		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
			}
		});
		btnLoad.setBounds(676, 163, 89, 23);
		frame.getContentPane().add(btnLoad);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 240, 755, 243);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblAgency = new JLabel("Agency");
		lblAgency.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAgency.setBounds(10, 21, 61, 19);
		frame.getContentPane().add(lblAgency);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCompanyName.setBounds(10, 76, 117, 19);
		frame.getContentPane().add(lblCompanyName);
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMedicine.setBounds(10, 139, 89, 23);
		frame.getContentPane().add(lblMedicine);
		
		JLabel lblSalt = new JLabel("Salt");
		lblSalt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalt.setBounds(329, 21, 61, 19);
		frame.getContentPane().add(lblSalt);
		
		JLabel lblMg = new JLabel("mg");
		lblMg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMg.setBounds(329, 74, 61, 23);
		frame.getContentPane().add(lblMg);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(329, 142, 61, 17);
		frame.getContentPane().add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(137, 22, 116, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 77, 116, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 142, 116, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(428, 22, 106, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(428, 77, 106, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(428, 142, 106, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(10, 188, 89, 23);
		frame.getContentPane().add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(137, 191, 116, 20);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		
		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 String query="insert into company_stock(Agency,Company,Medicine,Salt,mg,Price,Qunatity) values (?,?,?,?,?,?,?)";
				try{
					 
						PreparedStatement pst=conm.prepareStatement(query);
						pst.setString(1,textField.getText());
						pst.setString(2,textField_1.getText());
						pst.setString(3,textField_2.getText());
						pst.setString(4,textField_3.getText());
						pst.setString(5,textField_4.getText());
						pst.setString(6,textField_5.getText());
						pst.setString(7,txtQuantity.getText());
                        
						pst.execute();
					  JOptionPane.showMessageDialog(null,"Data Saved");
					    pst.close();
				   }
				   catch(Exception e)
				   {
					 e.printStackTrace();
				   }
				refreshTable();
			}
		});
		btnNewButton.setBounds(554, 163, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="Update company_stock set Agency='"+textField.getText()+"' ,Company='"+textField_1.getText()+"' ,Medicine='"+textField_2.getText()+"',Salt='"+textField_3.getText()+"',mg='"+textField_4.getText()+"',Price='"+textField_5.getText()+"' where Agency='"+textField.getText()+"'";
					PreparedStatement pst=conm.prepareStatement(query);
					
                    
					pst.execute();
				  JOptionPane.showMessageDialog(null,"Data Updated");
				    pst.close();
			   }
			   catch(Exception e)
			   {
				 e.printStackTrace();
			   }
				refreshTable();
			}
		});
		btnUpdate.setBounds(554, 129, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="delete from company_stock where Agency='"+textField.getText()+"' ";
					PreparedStatement pst=conm.prepareStatement(query);
					
                    
					pst.execute();
				  JOptionPane.showMessageDialog(null,"Data Deleted");
				    pst.close();
			   }
			   catch(Exception ex)
			   {
				 ex.printStackTrace();
			   }
				refreshTable();
			}
		});
		btnDelete.setBounds(676, 129, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		
		
		refreshTable();
	}

}
