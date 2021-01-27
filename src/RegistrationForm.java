import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class RegistrationForm {
	String Category="", date="",Name="",Num="",g="" ; 
	int id1 ;

	private JFrame frmJeeRegistrationForm;
	private JTextField name;
	private JTextField fone;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm window = new RegistrationForm();
					window.frmJeeRegistrationForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrationForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJeeRegistrationForm =  new JFrame();
		frmJeeRegistrationForm.getContentPane().setBackground(new Color(255, 153, 204));
		frmJeeRegistrationForm.getContentPane().setFont(new Font("DialogInput", Font.PLAIN, 30));
		frmJeeRegistrationForm.setTitle("JEE REGISTRATION FORM\r\n");
		frmJeeRegistrationForm.setBounds(100, 100, 633, 647);
		frmJeeRegistrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJeeRegistrationForm.getContentPane().setLayout(null);
		
		JLabel lblJeeRegistrationForm = new JLabel("JEE REGISTRATION FORM");
		lblJeeRegistrationForm.setForeground(new Color(0, 0, 205));
		lblJeeRegistrationForm.setFont(new Font("DialogInput", Font.BOLD, 32));
		lblJeeRegistrationForm.setBounds(102, 27, 412, 40);
		frmJeeRegistrationForm.getContentPane().add(lblJeeRegistrationForm);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("DV1-TTGanesh", Font.PLAIN, 30));
		lblName.setBounds(32, 124, 115, 31);
		frmJeeRegistrationForm.getContentPane().add(lblName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("DV1-TTGanesh", Font.PLAIN, 30));
		lblDob.setBounds(32, 204, 86, 31);
		frmJeeRegistrationForm.getContentPane().add(lblDob);
		
		JLabel lblMobileNo = new JLabel("MOBILE NO.");
		lblMobileNo.setFont(new Font("DV1-TTGanesh", Font.PLAIN, 30));
		lblMobileNo.setBounds(32, 279, 190, 31);
		frmJeeRegistrationForm.getContentPane().add(lblMobileNo);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("DV1-TTGanesh", Font.PLAIN, 30));
		lblGender.setBounds(32, 337, 142, 31);
		frmJeeRegistrationForm.getContentPane().add(lblGender);
		
		JLabel lblCategory = new JLabel("CATEGORY");
		lblCategory.setFont(new Font("DV1-TTGanesh", Font.PLAIN, 30));
		lblCategory.setBounds(32, 409, 180, 31);
		frmJeeRegistrationForm.getContentPane().add(lblCategory);
		
		name = new JTextField();
		
		name.setBounds(285, 130, 260, 32);
		frmJeeRegistrationForm.getContentPane().add(name);
		name.setColumns(10);
		
		fone = new JTextField();
		fone.setBounds(285, 279, 260, 32);
		frmJeeRegistrationForm.getContentPane().add(fone);
		fone.setColumns(10);
		
		JRadioButton rm = new JRadioButton("MALE");
		rm.setForeground(Color.BLACK);
		rm.setBackground(new Color(238, 232, 170));
		buttonGroup.add(rm);
		rm.setFont(new Font("DialogInput", Font.PLAIN, 18));
		rm.setBounds(242, 346, 81, 21);
		frmJeeRegistrationForm.getContentPane().add(rm);
		
		JRadioButton rf = new JRadioButton("FEMALE");
		rf.setBackground(new Color(255, 255, 102));
		buttonGroup.add(rf);
		rf.setFont(new Font("DialogInput", Font.PLAIN, 18));
		rf.setBounds(326, 346, 115, 21);
		frmJeeRegistrationForm.getContentPane().add(rf);
		
		JRadioButton ro = new JRadioButton("OTHERS");
		ro.setBackground(new Color(238, 232, 170));
		buttonGroup.add(ro);
		ro.setFont(new Font("DialogInput", Font.PLAIN, 18));
		ro.setBounds(446, 346, 109, 21);
		frmJeeRegistrationForm.getContentPane().add(ro);
		
		JComboBox category1 = new JComboBox();
		//	Category = category.getSelectedItem().toString();
			category1.setFont(new Font("DialogInput", Font.PLAIN, 24));
			category1.setModel(new DefaultComboBoxModel(new String[] {"PELESE SELECT", "GENERAL", "SC", "ST", "OBC", "PWD"}));
			category1.setBounds(285, 409, 260, 31);
			frmJeeRegistrationForm.getContentPane().add(category1);
			
			JDateChooser dob1 = new JDateChooser();
			//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	       // date = dateFormat.format(dob.getDate());
			dob1.setBounds(285, 204, 260, 31);
			frmJeeRegistrationForm.getContentPane().add(dob1);
			
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setHorizontalAlignment(SwingConstants.LEFT);
		btnSubmit.setIcon(new ImageIcon(RegistrationForm.class.getResource("/submit.png")));
		btnSubmit.setBackground(Color.PINK);
	
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c=0 ;
				Name=name.getText();
				if(!Pattern.matches("^[A-Z]{1}[a-z]*([ ][A-Z]{1}[a-z]*)*",Name ) )
				{
					JOptionPane.showMessageDialog(null, "Enter the valid name");
					c++ ;
				}
				
			    Num=fone.getText();
				if(!Pattern.matches("[6,7,8,9]{1}[0-9]{9}",Num ) )
				{
					JOptionPane.showMessageDialog(null, "Enter the valid Phone Number");
					c++ ;
				}
				Category = category1.getSelectedItem().toString();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			        date = dateFormat.format(dob1.getDate());
			        String studate[]=date.split("-");
			        int year_stu=Integer.parseInt(studate[0]);
			        int yearr=2019;
			        int a=yearr-year_stu;
			        if(a>21||a<17) {
			        	JOptionPane.showMessageDialog(null, "You are not elligible for registration");
			        	c++;
			        }
			        		
			    if(rm.isSelected())
			    	g="MALE";
			    else if(rf.isSelected())
			    	g="FEMALE";
			    else if(ro.isSelected())
			    	g="OTHERS";
				
			
				
				String dburl = "jdbc:mysql://localhost:3306/jeedb";
				String username = "root";
				String password = "Srijan@2000";
				
				Connection conn = null;
				PreparedStatement state = null;
				ResultSet result;
				
				String query = "insert into student (name,mobile_no,gender,category,dob) values(?,?,?,?,?)";
				try{
		            
		            Class.forName("com.mysql.cj.jdbc.Driver"); 
		            // Getting database access to MySql Server
		            conn = DriverManager.getConnection(dburl, username, password);
		            
		      if(c==0) {      // Prepared statement to execute SQL Query
		            state = conn.prepareStatement(query);
		            PreparedStatement ps = conn.prepareStatement(query);
		            ps.setString(1,Name);
		            ps.setString(2, Num);
		            ps.setString(3, g);
		            ps.setString(4, Category);
		            ps.setString(5, date);
		            ps.executeUpdate();
		            String q = "select * from student where mobile_no="+Num;
		            state = conn.prepareStatement(q);
		             
		             result = state.executeQuery(q);
		              id1=0;
		             while(result.next()){
		                 id1 =  result.getInt("rollno");
		             }
		             String show="2019JEE";
		             show+=Integer.toString(id1);
		            //JOptionPane.showMessageDialog(this,"Your Rollno and User id is\n"+show,"REGISTERED", JOptionPane.INFORMATION_MESSAGE);
		            //result = state.executeQuery(query);
		            
		            
		           JOptionPane.showMessageDialog(null,"Your Rollno and User id is\n"+show,"REGISTERED", JOptionPane.INFORMATION_MESSAGE );
		      }
		        }
			
		        catch(Exception e1){
		            System.out.print("\nError in connectrion : " + e1);
			} 
				name.setText("");
				
				fone.setText("");
				
			}
		});
		btnSubmit.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnSubmit.setBounds(10, 492, 260, 85);
		frmJeeRegistrationForm.getContentPane().add(btnSubmit);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setHorizontalAlignment(SwingConstants.LEFT);
		btnNext.setIcon(new ImageIcon(RegistrationForm.class.getResource("/next.jpg")));
		btnNext.setBackground(Color.PINK);
		btnNext.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterMarks marks=new EnterMarks();
				frmJeeRegistrationForm.setVisible(false);
				marks.main(Integer.toString(id1));
				
			}
		});
		btnNext.setBounds(354, 496, 201, 77);
		frmJeeRegistrationForm.getContentPane().add(btnNext);
		
		JLabel lblNewLabel = new JLabel("(The first letter of the name should be capital)");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(15, 153, 260, 21);
		frmJeeRegistrationForm.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GREEN);
		separator.setBounds(54, 68, 510, 2);
		frmJeeRegistrationForm.getContentPane().add(separator);
		
		
	}
}
