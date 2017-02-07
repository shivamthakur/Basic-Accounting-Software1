import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JScrollPane;

public class amount {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					amount window = new amount();
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
	public amount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 797, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxPayable = new JCheckBox("Payable");
		chckbxPayable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxPayable.setBounds(17, 25, 97, 23);
		frame.getContentPane().add(chckbxPayable);
		
		JCheckBox chckbxReceivable = new JCheckBox("Receivable");
		chckbxReceivable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxReceivable.setBounds(150, 27, 97, 23);
		frame.getContentPane().add(chckbxReceivable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 131, 738, 274);
		frame.getContentPane().add(scrollPane);
	}

}
