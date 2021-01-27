import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class Jee {

	private JFrame frmJointEntranceExamination;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jee window = new Jee();
					window.frmJointEntranceExamination.setVisible(true);
					String dburl = "jdbc:mysql://localhost:3306/jeedb";
					String username = "root";
					String password = "Srijan@2000";
					
					Connection conn = null;
					PreparedStatement state = null;
					ResultSet result;
					
					String query = "select * from student";
					try{
			            
			            Class.forName("com.mysql.cj.jdbc.Driver"); 
			            // Getting database access to MySql Server
			            conn = DriverManager.getConnection(dburl, username, password);
			            
			            // Prepared statement to execute SQL Query
			            state = conn.prepareStatement(query);
			            
			            result = state.executeQuery(query);
			            
			            while(result.next()){
			                int count =  result.getInt(1);
			                System.out.print("\nTotal records are : " + count + "\n");
			            }
			            
			        }
				
			        catch(Exception e){
			            System.out.print("\nError in connectrion : " + e);
				} 
			}
					catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Jee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJointEntranceExamination = new JFrame();
		frmJointEntranceExamination.getContentPane().setBackground(new Color(51, 204, 255));
		frmJointEntranceExamination.setTitle("JOINT ENTRANCE EXAMINATION");
		frmJointEntranceExamination.setBounds(100, 100, 660, 346);
		frmJointEntranceExamination.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJointEntranceExamination.getContentPane().setLayout(null);
		
		JLabel lblJointEntranceExamination = new JLabel("JOINT ENTRANCE EXAMINATION");
		lblJointEntranceExamination.setForeground(Color.RED);
		lblJointEntranceExamination.setFont(new Font("CG Omega", Font.BOLD, 32));
		lblJointEntranceExamination.setBounds(83, 21, 512, 46);
		frmJointEntranceExamination.getContentPane().add(lblJointEntranceExamination);
		
		JButton btnRegister = new JButton("REGISTER");
		
		btnRegister.setBackground(new Color(255, 182, 193));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationForm reg=new RegistrationForm() ;
				frmJointEntranceExamination.setVisible(false);
				reg.main(null);
				
				
			}
		});
		btnRegister.setFont(new Font("DialogInput", Font.PLAIN, 30));
		btnRegister.setBounds(67, 197, 190, 40);
		frmJointEntranceExamination.getContentPane().add(btnRegister);
		
		JButton btnCheckResult = new JButton("CHECK RESULT");
		btnCheckResult.setBackground(new Color(255, 182, 193));
		btnCheckResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckResult rslt=new CheckResult();
				frmJointEntranceExamination.setVisible(false);
				rslt.main(null);
			}
		});
		btnCheckResult.setFont(new Font("DialogInput", Font.PLAIN, 30));
		btnCheckResult.setBounds(338, 197, 255, 40);
		frmJointEntranceExamination.getContentPane().add(btnCheckResult);
		
		JLabel lblHdshfjhdf = new JLabel("JEE MAIN will be conducted by NTA from 2019 onwards. This examination was being conducted by CBSE till 2018.");
		lblHdshfjhdf.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblHdshfjhdf.setBounds(23, 78, 611, 22);
		frmJointEntranceExamination.getContentPane().add(lblHdshfjhdf);
		
		JLabel lblNewLabel = new JLabel("JEE Main is applicable for admission to NIT, IIT and CFTI participating through Central Seat allocation Board");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(33, 114, 611, 22);
		frmJointEntranceExamination.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("subject to the condition that the candidate should have secured atleast 75% marks in 12th class examination.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(22, 147, 612, 22);
		frmJointEntranceExamination.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SHOW FULL RESULT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FullResult f=new FullResult();
				f.main(null);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman MT Extra Bold", Font.PLAIN, 30));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(139, 259, 375, 37);
		frmJointEntranceExamination.getContentPane().add(btnNewButton);
	}
}
