import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Result {

	private JFrame frame;
	static int z;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	JLabel l8;
	JLabel l9;
	JLabel l4;
	JLabel l10;
	private int categoryrankST (int n) {
        String dbURL = "jdbc:mysql://localhost:3306/jeedb";
        String username ="root";
        String password = "Srijan@2000";
        
        Connection conn = null;
        Statement state = null;
        ResultSet result;
        String query = "select student.rollno,marks.maths,marks.total,marks.phy,marks.chem from student inner join marks on student.rollno = marks.rollno where category ='ST' order by total desc,maths desc,phy desc,chem desc";
        int i=0;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            
            // Prepared statement to execute SQL Query
            state = conn.prepareStatement(query);
            
            result = state.executeQuery(query);
            //System.out.print(result);
            int roll1;
            while(result.next()){
            i++;
                    roll1=result.getInt("rollno");
                    if(roll1==n)
                        break;     
            }
        }
            catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
        }
        return i;
    }
	
	
	private int categoryrankSC (int n) {
        String dbURL = "jdbc:mysql://localhost:3306/jeedb";
        String username ="root";
        String password = "Srijan@2000";
        
        Connection conn = null;
        Statement state = null;
        ResultSet result;
        String query = "select student.rollno,marks.maths,marks.total,marks.phy,marks.chem from student inner join marks on student.rollno = marks.rollno where category ='SC' order by total desc,maths desc,phy desc,chem desc";
        int i=0;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            
            // Prepared statement to execute SQL Query
            state = conn.prepareStatement(query);
            
            result = state.executeQuery(query);
            //System.out.print(result);
            int roll1;
            while(result.next()){
            i++;
                    roll1=result.getInt("rollno");
                    if(roll1==n)
                        break;     
            }
        }
            catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
        }
        return i;
    }
	private int categoryrankOBC (int n) {
        String dbURL = "jdbc:mysql://localhost:3306/jeedb";
        String username ="root";
        String password = "Srijan@2000";
        
        Connection conn = null;
        Statement state = null;
        ResultSet result;
        String query = "select student.rollno,marks.maths,marks.total,marks.phy,marks.chem from student inner join marks on student.rollno = marks.rollno where category ='OBC' order by total desc,maths desc,phy desc,chem desc";
        int i=0;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            
            // Prepared statement to execute SQL Query
            state = conn.prepareStatement(query);
            
            result = state.executeQuery(query);
            //System.out.print(result);
            int roll1;
            while(result.next()){
            i++;
                    roll1=result.getInt("rollno");
                    if(roll1==n)
                        break;     
            }
        }
            catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
        }
        return i;
    }
	private int categoryrankPWD (int n) {
        String dbURL = "jdbc:mysql://localhost:3306/jeedb";
        String username ="root";
        String password = "Srijan@2000";
        
        Connection conn = null;
        Statement state = null;
        ResultSet result;
        String query = "select student.rollno,marks.maths,marks.total,marks.phy,marks.chem from student inner join marks on student.rollno = marks.rollno where category ='PWD' order by total desc,maths desc,phy desc,chem desc";
        int i=0;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            
            // Prepared statement to execute SQL Query
            state = conn.prepareStatement(query);
            
            result = state.executeQuery(query);
            //System.out.print(result);
            int roll1;
            while(result.next()){
            i++;
                    roll1=result.getInt("rollno");
                    if(roll1==n)
                        break;     
            }
        }
            catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
        }
        return i;
    }
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String s) {
		z= Integer.parseInt(s);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result window = new Result();
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
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().setBackground(new Color(204, 255, 255));
		frame.setBounds(100, 100, 873, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setFont(new Font("DialogInput", Font.PLAIN, 30));
		lblName.setBounds(69, 127, 115, 34);
		frame.getContentPane().add(lblName);
		
		JLabel lblRollNo = new JLabel("ROLL NO. :");
		lblRollNo.setFont(new Font("DialogInput", Font.PLAIN, 30));
		lblRollNo.setBounds(69, 190, 186, 34);
		frame.getContentPane().add(lblRollNo);
		
		JLabel lblCategory = new JLabel("CATEGORY :");
		lblCategory.setFont(new Font("DialogInput", Font.PLAIN, 30));
		lblCategory.setBounds(69, 314, 186, 34);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblResultPortal = new JLabel("RESULT PORTAL");
		lblResultPortal.setForeground(new Color(255, 51, 51));
		lblResultPortal.setFont(new Font("Berling Antiqua", Font.BOLD, 32));
		lblResultPortal.setBounds(296, 49, 273, 34);
		frame.getContentPane().add(lblResultPortal);
		
		JLabel lblGender_1 = new JLabel("GENDER :");
		lblGender_1.setFont(new Font("DialogInput", Font.PLAIN, 30));
		lblGender_1.setBounds(69, 248, 147, 34);
		frame.getContentPane().add(lblGender_1);
		
		 l1 = new JLabel("");
		 l1.setForeground(new Color(51, 51, 204));
		 l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		l1.setBounds(278, 127, 147, 34);
		frame.getContentPane().add(l1);
		
		l2 = new JLabel("");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l2.setForeground(new Color(255, 69, 0));
		l2.setBounds(278, 190, 147, 34);
		frame.getContentPane().add(l2);
		
		 l3 = new JLabel("");
		 l3.setForeground(new Color(255, 69, 0));
		 l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l3.setBounds(278, 248, 147, 34);
		frame.getContentPane().add(l3);
		
		 l4 = new JLabel("");
		 l4.setForeground(new Color(255, 69, 0));
		 l4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l4.setBounds(278, 314, 147, 34);
		frame.getContentPane().add(l4);
		
		JLabel lblPhysics = new JLabel("PHYSICS");
		lblPhysics.setFont(new Font("DialogInput", Font.PLAIN, 30));
		lblPhysics.setBounds(492, 127, 147, 34);
		frame.getContentPane().add(lblPhysics);
		
		JLabel lblChemistry = new JLabel("CHEMISTRY");
		lblChemistry.setFont(new Font("DialogInput", Font.PLAIN, 30));
		lblChemistry.setBounds(492, 190, 177, 34);
		frame.getContentPane().add(lblChemistry);
		
		JLabel lblMaths = new JLabel("MATHS");
		lblMaths.setFont(new Font("DialogInput", Font.PLAIN, 30));
		lblMaths.setBounds(492, 248, 147, 34);
		frame.getContentPane().add(lblMaths);
		
		JLabel lblTotal = new JLabel("TOTAL :");
		lblTotal.setFont(new Font("DialogInput", Font.BOLD, 30));
		lblTotal.setBounds(502, 334, 137, 34);
		frame.getContentPane().add(lblTotal);
		
		 l5 = new JLabel("");
		l5.setBounds(713, 127, 96, 34);
		frame.getContentPane().add(l5);
		
		 l6 = new JLabel("");
		l6.setBounds(713, 190, 96, 34);
		frame.getContentPane().add(l6);
		
		 l7 = new JLabel("");
		l7.setBounds(713, 248, 96, 34);
		frame.getContentPane().add(l7);
		
		 l8 = new JLabel("");
		 l8.setForeground(new Color(0, 128, 0));
		 l8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l8.setBounds(667, 341, 96, 27);
		frame.getContentPane().add(l8);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(109, 572, 1, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(265, 153, -10, 321);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(47, 79, 79));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBounds(457, 127, 1, 267);
		frame.getContentPane().add(separator_2);
		
		JLabel lblAir = new JLabel("A.I.R  -");
		lblAir.setFont(new Font("DialogInput", Font.PLAIN, 30));
		lblAir.setBounds(229, 476, 147, 34);
		frame.getContentPane().add(lblAir);
		
		 l9 = new JLabel("");
		 l9.setForeground(new Color(255, 0, 102));
		 l9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		l9.setBounds(473, 477, 96, 34);
		frame.getContentPane().add(l9);
		
		 l10 = new JLabel("NOT APPLICABLE");
		 l10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l10.setBounds(473, 522, 178, 34);
		frame.getContentPane().add(l10);
	}
	public Result() {
		initialize();
		String roll=" ",gen=" ",ct=" ";
        String name=" ";
        int p=0,c=0,m=0,tm=0;
           String dbURL = "jdbc:mysql://localhost:3306/jeedb";
            String username ="root";
            String password = "Srijan@2000";
        String query="select * from student where rollno="+z;
        String q = "select * from marks where rollno = "+z;
        Connection conn = null;
        Statement state = null;
        Statement state1 = null;
       // Statement state2 = null;
        
        try{            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            // Prepared statement to execute SQL Query
          
            state = conn.prepareStatement(query); 
            
                ResultSet res;
                res= state.executeQuery(query);
             
                while(res.next()){
             
                 name=  res.getString("name");
                 
                 ct=  res.getString("category");
                 gen = res.getString("gender");
                 
                }
                roll = Integer.toString(z);
               
                state = conn.prepareStatement(q);
                ResultSet rs;
                rs = state.executeQuery(q);
                
                while(rs.next()){
             
                    m= rs.getInt("maths");
                    p = rs.getInt("phy");
                    c = rs.getInt("chem");
                    tm = rs.getInt("total");
                }
                
                l1.setText(name);
                l2.setText(roll);
                l3.setText(gen);
                String rn="JEE19M" ;
                rn+=Integer.toString(z);

                l4.setText(ct);
                l5.setText(Integer.toString(p));
                l6.setText(Integer.toString(c));
                l7.setText(Integer.toString(m));
                l8.setText(Integer.toString(tm));
        }
        catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
    }
        
        
        int i=0;
       int j=0;
        String query1="select * from marks order by total desc,maths desc,phy desc ,chem desc";
       try {
            int roll1;
            	state1 = conn.prepareStatement(query1);
                ResultSet rest;
                rest= state1.executeQuery(query1);   
                
                while(rest.next()){
                	
                    i++;
                 
                    roll1=rest.getInt("rollno");
                    if(roll1==z)
                        break;
                }
                l9.setText(Integer.toString(i));
                switch (ct) {
                case "OBC":
                    j = categoryrankOBC(z);
                    break;
                case "SC":
                    j = categoryrankSC(z);
                    break;
                case "ST":
                    j = categoryrankST(z);
                    break;
                case "GENERAL":
                    String s = "NOT APPLICABLE";
                    j = Integer.parseInt(s);
                    break;
                case "PWD":
                    j = categoryrankPWD(z);
                    break;
            }
                l10.setText(Integer.toString(j)); 
       }
       catch(Exception exception)
       {
    	   
       }
                
                JButton btnHome = new JButton("HOME");
                btnHome.setIcon(new ImageIcon(Result.class.getResource("/")));
                btnHome.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		Jee j=new Jee();
                		j.main(null);
                		frame.setVisible(false);
                	}
                });
                btnHome.setForeground(Color.RED);
                btnHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
                btnHome.setBounds(661, 581, 89, 44);
                frame.getContentPane().add(btnHome);
                
                JButton btnNewButton = new JButton("BACK");
                btnNewButton.setForeground(Color.RED);
                btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		CheckResult c=new CheckResult();
                		c.main(null);
                		frame.setVisible(false);
                	}
                });
                btnNewButton.setBounds(38, 581, 89, 44);
                frame.getContentPane().add(btnNewButton);
                
                JLabel lblNewLabel = new JLabel("CONGRATULATIONS!!!  YOU HAVE QUALIFIED...");
                lblNewLabel.setForeground(new Color(153, 51, 255));
                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
                lblNewLabel.setBounds(215, 420, 411, 27);
                frame.getContentPane().add(lblNewLabel);
                
                JSeparator separator = new JSeparator();
                separator.setBackground(Color.GREEN);
                separator.setBounds(178, 96, 473, 2);
                frame.getContentPane().add(separator);
                
                JLabel cat = new JLabel("CATEGORY RANK -");
                cat.setFont(new Font("Yu Gothic UI", Font.PLAIN, 26));
                cat.setBounds(175, 521, 237, 34);
                frame.getContentPane().add(cat);
	
       

	/**
	 * Initialize the contents of the frame.
	 */
	

	}
}
