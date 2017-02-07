import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class mainframe {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe window = new mainframe();
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
	public mainframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Accounting Software");
		frame.setBounds(100, 100, 792, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStockEntry = new JButton("Stock Entry");
		btnStockEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stocktable st=new stocktable();
				st.main(null);
			}
		});
		btnStockEntry.setBounds(41, 182, 89, 23);
		frame.getContentPane().add(btnStockEntry);
		
		JButton btnBilling = new JButton("Billing");
		btnBilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bill bl=new bill();
				bl.main(null);
			}
		});
		btnBilling.setBounds(196, 182, 89, 23);
		frame.getContentPane().add(btnBilling);
		
		JButton btnNewButton = new JButton("Purchase order");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				order or=new order();
				or.main(null);
			}
		});
		btnNewButton.setBounds(387, 182, 114, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSalesOrder = new JButton("Sales order");
		btnSalesOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order or=new order();
				or.main(null);
			}
		});
		btnSalesOrder.setBounds(595, 182, 89, 23);
		frame.getContentPane().add(btnSalesOrder);
		
		JButton btnAcReceivable = new JButton("A/C receivable");
		btnAcReceivable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Temporary Unavailable");
			}
		});
		btnAcReceivable.setBounds(41, 262, 103, 23);
		frame.getContentPane().add(btnAcReceivable);
		
		JButton btnAcPayable = new JButton("A/C payable");
		btnAcPayable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Temporary Unavailable");
			}
		});
		btnAcPayable.setBounds(209, 262, 114, 23);
		frame.getContentPane().add(btnAcPayable);
		
		JButton btnDailyStatement = new JButton("Daily statement");
		btnDailyStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Temporary Unavailable");
			}
		});
		btnDailyStatement.setBounds(412, 262, 114, 23);
		frame.getContentPane().add(btnDailyStatement);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogout.setBounds(677, 11, 89, 23);
		frame.getContentPane().add(btnLogout);
	}
}
