import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
public class addcompany {

	private JFrame frame;
	private JTextField txtCompany;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addcompany window = new addcompany();
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
	public addcompany() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void createDirectory(String name){
		String c = "E:\\Data\\";
		c = c.concat(name);
		File files = new File(c);
        if (!files.exists()) {
            if (files.mkdirs()) {
            	JOptionPane.showMessageDialog(null,"Directory Created");
            	
            	mainframe af = new mainframe();
            	af.main(null);
            	frame.dispose();
            } else {
            	JOptionPane.showMessageDialog(null,"Cannot Create directory");
            }
        }
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		/*
		 * Add company name labels and text fields
		 */
		txtCompany = new JTextField();
		txtCompany.setBounds(202, 319, 171, 20);
		frame.getContentPane().add(txtCompany);
		txtCompany.setColumns(10);
		txtCompany.setVisible(false);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setBounds(110, 322, 82, 14);
		frame.getContentPane().add(lblCompanyName);
		lblCompanyName.setVisible(false);
		/*
		 * Label company name and text fields End here
		 */
		
		
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBounds(39, 251, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					lblCompanyName.setVisible(true);
					txtCompany.setVisible(true);
					String name = txtCompany.getText();
					createDirectory(name);
					
					
				   }
				   catch(Exception e)
				   {
					 e.printStackTrace();
				   }
			}
		});
		btnAdd.setBounds(202, 251, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(371, 251, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(39, 29, 119, 20);
		frame.getContentPane().add(comboBox);
		
		table = new JTable();
		table.setBounds(38, 67, 422, 159);
		frame.getContentPane().add(table);
		
		
	}
}
