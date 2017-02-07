import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class order {

	private JFrame frame;
	private JTextField textcompany;
	private JTextField textmedicine;
	private JTextField textmg;
	private JTextField textsalt;
	private JTextField textprice;
	private JTextField textquantity;
	private JTextField textFrom;
	private JTextField textto;
	private JTextField textdate;
	private JTextField textname;

	Connection con1=null;
	private JTextField texttype;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					order window = new order();
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
	public order() {
		con1=billconnect.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Order");
		frame.setBounds(100, 100, 775, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCompany.setBounds(17, 101, 68, 23);
		frame.getContentPane().add(lblCompany);
		
		textcompany = new JTextField();
		textcompany.setColumns(10);
		textcompany.setBounds(95, 104, 110, 20);
		frame.getContentPane().add(textcompany);
		
		JLabel lblmedicine = new JLabel("Medicine");
		lblmedicine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblmedicine.setBounds(17, 144, 60, 23);
		frame.getContentPane().add(lblmedicine);
		
		textmedicine = new JTextField();
		textmedicine.setColumns(10);
		textmedicine.setBounds(95, 147, 110, 20);
		frame.getContentPane().add(textmedicine);
		
		textmg = new JTextField();
		textmg.setColumns(10);
		textmg.setBounds(95, 184, 110, 20);
		frame.getContentPane().add(textmg);
		
		textsalt = new JTextField();
		textsalt.setColumns(10);
		textsalt.setBounds(455, 58, 110, 20);
		frame.getContentPane().add(textsalt);
		
		textprice = new JTextField();
		textprice.setColumns(10);
		textprice.setBounds(455, 104, 110, 20);
		frame.getContentPane().add(textprice);
		
		textquantity = new JTextField();
		textquantity.setColumns(10);
		textquantity.setBounds(455, 147, 110, 20);
		frame.getContentPane().add(textquantity);
		
		JLabel lblMg = new JLabel("mg");
		lblMg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMg.setBounds(17, 181, 60, 23);
		frame.getContentPane().add(lblMg);
		
		JLabel lblSalt = new JLabel("Salt");
		lblSalt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalt.setBounds(389, 55, 60, 23);
		frame.getContentPane().add(lblSalt);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(385, 101, 60, 23);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(389, 144, 60, 23);
		frame.getContentPane().add(lblQuantity);
		
		JCheckBox chckbxPurchaseOrder = new JCheckBox("Purchase order");
		chckbxPurchaseOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxPurchaseOrder.setBounds(392, 202, 124, 23);
		frame.getContentPane().add(chckbxPurchaseOrder);
		
		JCheckBox chckbxSalesOrder = new JCheckBox("Sales order");
		chckbxSalesOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxSalesOrder.setBounds(519, 202, 97, 23);
		frame.getContentPane().add(chckbxSalesOrder);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrom.setBounds(17, 11, 46, 25);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTo.setBounds(389, 17, 46, 25);
		frame.getContentPane().add(lblTo);
		
		textFrom = new JTextField();
		textFrom.setColumns(10);
		textFrom.setBounds(95, 15, 110, 20);
		frame.getContentPane().add(textFrom);
		
		textto = new JTextField();
		textto.setColumns(10);
		textto.setBounds(451, 18, 110, 20);
		frame.getContentPane().add(textto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 300, 730, 225);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblType.setBounds(328, 202, 68, 18);
		frame.getContentPane().add(lblType);
		
		
		
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(592, 17, 38, 25);
		frame.getContentPane().add(lblDate);
		
		JFormattedTextField textdate = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		textdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textdate.setColumns(10);
		textdate.setBounds(640, 18, 80, 23);
		frame.getContentPane().add(textdate);
		textdate.setValue(new java.util.Date());
		
		textname = new JTextField();
		textname.setColumns(10);
		textname.setBounds(95, 58, 110, 20);
		frame.getContentPane().add(textname);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(17, 53, 46, 25);
		frame.getContentPane().add(lblName);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Type;
				  if(chckbxPurchaseOrder.isSelected())
					  Type = "Purchase Order";
				  else
					  Type="Sales Order";
				  
				 
				  texttype.setText(Type);
				
				  try{
					  
					  
					  String query="insert into orderr  values(?,?,?,?,?,?,?,?,?);";
					  PreparedStatement pst2=con1.prepareStatement(query);
					  
					  pst2.setString(1,textname.getText());
					  pst2.setString(2,texttype.getText());
					  pst2.setString(3,textmedicine.getText());
					  pst2.setString(4,textcompany.getText());
					  pst2.setInt(5,Integer.parseInt(textquantity.getText()));
					  pst2.setInt(6,Integer.parseInt(textprice.getText()));
					  pst2.setString(7,textdate.getText());
					  pst2.setString(8,textsalt.getText());
					  pst2.setInt(9,Integer.parseInt(textmg.getText()));
					  
					  pst2.execute();
					  JOptionPane.showMessageDialog(null,"Data saved");
					  pst2.close();
					  
					    
					  
					  
					  
					
				  }
				  catch(SQLException e)
				  {
					  e.printStackTrace();
				  }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(455, 251, 110, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(592, 251, 110, 38);
		frame.getContentPane().add(btnCancel);
		
		texttype = new JTextField();
		texttype.setBounds(622, 204, 110, 25);
		frame.getContentPane().add(texttype);
		texttype.setColumns(10);
	}
}
