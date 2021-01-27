import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class EnterMarks {

	private JFrame frmMarksEntry;
	private JTextField pm;
	private JTextField cm;
	private JTextField mm;
	static int r ;

	/**
	 * Launch the application.
	 */
	public static void main(String string) {
		r = Integer.parseInt(string);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterMarks window = new EnterMarks();
					window.frmMarksEntry.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnterMarks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarksEntry = new JFrame();
		frmMarksEntry.getContentPane().setBackground(Color.YELLOW);
		frmMarksEntry.setTitle("MARKS ENTRY");
		frmMarksEntry.setBounds(100, 100, 595, 418);
		frmMarksEntry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarksEntry.getContentPane().setLayout(null);
		
		JLabel lblEnterYourMarks = new JLabel(" ENTER  CANDIDATE MARKS");
		lblEnterYourMarks.setForeground(new Color(0, 0, 128));
		lblEnterYourMarks.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		lblEnterYourMarks.setBounds(41, 37, 497, 37);
		frmMarksEntry.getContentPane().add(lblEnterYourMarks);
		
		JLabel lblPhysics = new JLabel("PHYSICS");
		lblPhysics.setForeground(new Color(107, 142, 35));
		lblPhysics.setFont(new Font("DV1-TTGanesh", Font.PLAIN, 30));
		lblPhysics.setBounds(82, 138, 141, 30);
		frmMarksEntry.getContentPane().add(lblPhysics);
		
		JLabel lblChemistry = new JLabel("CHEMISTRY");
		lblChemistry.setForeground(new Color(107, 142, 35));
		lblChemistry.setFont(new Font("DV1-TTGanesh", Font.PLAIN, 30));
		lblChemistry.setBounds(82, 194, 204, 37);
		frmMarksEntry.getContentPane().add(lblChemistry);
		
		JLabel lblMaths = new JLabel("MATHS");
		lblMaths.setForeground(new Color(107, 142, 35));
		lblMaths.setFont(new Font("DV1-TTGanesh", Font.PLAIN, 30));
		lblMaths.setBounds(82, 258, 163, 23);
		frmMarksEntry.getContentPane().add(lblMaths);
		
		pm = new JTextField();
		pm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		pm.setBounds(353, 138, 141, 32);
		frmMarksEntry.getContentPane().add(pm);
		pm.setColumns(10);
		
		cm = new JTextField();
		cm.setBounds(353, 194, 141, 35);
		frmMarksEntry.getContentPane().add(cm);
		cm.setColumns(10);
		
		mm = new JTextField();
		mm.setBounds(353, 258, 141, 28);
		frmMarksEntry.getContentPane().add(mm);
		mm.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setIcon(new ImageIcon(EnterMarks.class.getResource("/submit.png")));
		btnSubmit.setBackground(new Color(255, 255, 0));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
				String dburl = "jdbc:mysql://localhost:3306/jeedb";
				String username = "root";
				String password = "Srijan@2000";
				
				
				int Phy= Integer.parseInt(pm.getText());
				int Chem= Integer.parseInt(cm.getText());
				int Maths= Integer.parseInt(mm.getText());
				int t= (Phy+Chem)+Maths ;
				if(Phy>120||Chem>120||Maths>120||Phy<-30||Chem<-30||Maths<-30)
					JOptionPane.showMessageDialog(null, "Enter valid marks");
				
				else {
				Connection conn = null;
				PreparedStatement state = null;
				ResultSet result;
				
				String query = "insert into marks(rollno,phy,chem,maths,total) values(?,?,?,?,?)";
				try{
		            
		            Class.forName("com.mysql.cj.jdbc.Driver"); 
		            // Getting database access to MySql Server
		            conn = DriverManager.getConnection(dburl, username, password);
		            PreparedStatement ps = conn.prepareStatement(query);
		            ps.setInt(1, r);
		            ps.setInt(2, Phy);
		            ps.setInt(3, Chem);
		            ps.setInt(4, Maths);
		            ps.setInt(5, t);
		            ps.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Your marks are entered successfully");
		            
		            
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
				
				Jee j=new Jee();
				frmMarksEntry.setVisible(false);
				j.main(null);
				}
				
			}
		});
		btnSubmit.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnSubmit.setBounds(194, 310, 183, 47);
		frmMarksEntry.getContentPane().add(btnSubmit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 93, 497, 2);
		frmMarksEntry.getContentPane().add(separator);
	}
}
