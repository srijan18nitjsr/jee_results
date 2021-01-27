import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CheckResult {

	private JFrame frmCheckResult;
	private JTextField roll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckResult window = new CheckResult();
					window.frmCheckResult.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckResult() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCheckResult = new JFrame();
		frmCheckResult.getContentPane().setBackground(new Color(255, 255, 204));
		frmCheckResult.setTitle("CHECK RESULT");
		frmCheckResult.setBounds(100, 100, 546, 366);
		frmCheckResult.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckResult.getContentPane().setLayout(null);
		
		JLabel lblCheckYourResult = new JLabel("CHECK YOUR RESULT");
		lblCheckYourResult.setForeground(new Color(102, 0, 255));
		lblCheckYourResult.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 32));
		lblCheckYourResult.setBounds(78, 37, 365, 30);
		frmCheckResult.getContentPane().add(lblCheckYourResult);
		
		JLabel lblRollNumber = new JLabel("ENTER YOUR JEE  ROLL NUMBER");
		lblRollNumber.setForeground(new Color(204, 0, 153));
		lblRollNumber.setFont(new Font("DialogInput", Font.PLAIN, 25));
		lblRollNumber.setBounds(48, 115, 428, 30);
		frmCheckResult.getContentPane().add(lblRollNumber);
		
		roll = new JTextField();
		roll.setBounds(227, 178, 88, 30);
		frmCheckResult.getContentPane().add(roll);
		roll.setColumns(10);
		
		JButton btnGetResult = new JButton("VIEW RESULT\r\n");
		btnGetResult.setEnabled(false);
		btnGetResult.setIcon(new ImageIcon(CheckResult.class.getResource("/")));
		btnGetResult.setForeground(new Color(139, 69, 19));
		btnGetResult.setBackground(new Color(153, 255, 255));
		btnGetResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = roll.getText();
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
			
		        catch(Exception e1){
		            System.out.print("\nError in connectrion : " + e1);
			} 
				Result r=new Result();
				frmCheckResult.setVisible(false);
				r.main(s);
				
				}
		});
		btnGetResult.setFont(new Font("DialogInput", Font.PLAIN, 30));
		btnGetResult.setBounds(144, 245, 254, 43);
		frmCheckResult.getContentPane().add(btnGetResult);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  String dbURL = "jdbc:mysql://localhost:3306/jeedb";
			        String username ="root";
			        String password = "Srijan@2000";
			       int i=0;
			        
			        Connection conn = null;
			        Statement state = null;
			        ResultSet result , res,rest;
			        int id=Integer.parseInt(roll.getText()),m,p,c,count=0;
			        
			        
			        String query = "select rollno from student where rollno="+id;
			        
			        try{
			            
			            Class.forName("com.mysql.cj.jdbc.Driver"); 
			            // Getting database access to MySql Server
			            conn = DriverManager.getConnection(dbURL, username, password);
			            
			            // Prepared statement to execute SQL Query
			            state = conn.prepareStatement(query);
			            
			            result = state.executeQuery(query);
			                while(result.next()){
			                    i++;
			                    count =  result.getInt("rollno");
			                    System.out.print("\nTotal records are : " + count + "\n");
			                }
			                if(i==0)
			                    JOptionPane.showMessageDialog(null,"Not Registered","Error", JOptionPane.ERROR_MESSAGE);
			                else
			                {
			                	btnGetResult.setEnabled(true);
			                }
			                
			        }
			        catch(Exception e){
			            System.out.print("\nError in connectrion : " + e);
			        }
			    }                                     
				
			
		});
		btnNewButton.setBounds(354, 178, 76, 30);
		frmCheckResult.getContentPane().add(btnNewButton);
		
		JLabel lbljee = new JLabel("2019JEE");
		lbljee.setForeground(Color.GREEN);
		lbljee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbljee.setBounds(144, 178, 73, 30);
		frmCheckResult.getContentPane().add(lbljee);
	}
}
