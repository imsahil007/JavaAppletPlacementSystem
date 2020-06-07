import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Main extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	JFrame f;
	int x=0,y=100;
	JButton loginButton, signupButton;
	JRadioButton applicant, employer;
	JTextField user,passwd;

	Main(){

		JLabel l2 = new JLabel("Username");
		l2.setBounds(100,150,100,25);	
		l2.setFont(new Font("Serif", Font.BOLD, 16));
		user = new JTextField();
		user.setBounds(220,150,100,25);
	

		JLabel l3 = new JLabel("Password");
		l3.setBounds(100,200,100,25);
		l3.setFont(new Font("Serif", Font.BOLD, 16));
		passwd = new JPasswordField();
		passwd.setBounds(220,200,100,25);
		
		applicant=new JRadioButton("Applicant");    
		employer=new JRadioButton("Employer");    
		applicant.setBounds(100,250,100,25);    
		employer.setBounds(220,250,100,25);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(applicant);
		bg.add(employer); 
		
		loginButton = new JButton("Login");
		loginButton.setBounds(150,300,100,30);
		loginButton.addActionListener(this);
		signupButton = new JButton("SignUp");
		signupButton.setBounds(125,350,150,30);
		signupButton.addActionListener(this);
//		add(l1,BorderLayout.CENTER);
		add(l2);
		add(user);
		add(l3);
		add(passwd);
		add(loginButton);
		add(signupButton);
		add(applicant);
		add(employer);   
		


		setSize(450, 500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Font font = new Font("Times New Roman", Font.BOLD+Font.PLAIN,20);
		g2.setFont(font);
		g2.setColor(Color.BLUE);
		g2.drawString("Welcome to Placement Automation System!",x,y);
		try	{
			  Thread.sleep(100);
		} 
		catch(Exception ex) {}
		x+=10;
		if(x+100>this.getWidth()) 
		{	x=0;
		}
		repaint();
	}
	


	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(loginButton == e.getSource()) {
			if(employer.isSelected())
			{
				try {
					FileInputStream fin = new FileInputStream("employer.txt");
					try {
						@SuppressWarnings("resource")
						ObjectInputStream input = new ObjectInputStream(fin);
						Object obj = input.readObject();
					    Employer emp;
					    while (obj != null) 
						{
							
							emp =(Employer) obj;
							if(emp.getId().equals(user.getText()))
							{
//								JOptionPane.showMessageDialog(this,emp.getPswd().toString(),"Error!",JOptionPane.WARNING_MESSAGE);    

								if(emp.getPswd().equals(passwd.getText().toString()))
								{
									Applicant a;
									new Candidates(emp.getQualification());
									this.dispose();
								}
								
							}
		
					
							
							
							obj = input.readObject();
							if(obj == null)
							{
								JOptionPane.showMessageDialog(this," Invalid details.","Error!",JOptionPane.WARNING_MESSAGE); 
							}
						}
			
					} 
					catch (Exception e1) {
		    // System.out.println(e.printStackTrace());
					}
			}
			catch(Exception e2) {}
    
		}

		else if(applicant.isSelected())
		{
			try {
				FileInputStream fin = new FileInputStream("applicant.txt");
				try {
					@SuppressWarnings("resource")
					ObjectInputStream input = new ObjectInputStream(fin);
					Object obj = input.readObject();
				    Applicant emp;
				    while (obj != null) 
					{
				    	  
						
						emp =(Applicant) obj;
						if(emp.getId().equals(user.getText()))
						{
							

							if(emp.getPswd().equals(passwd.getText().toString()))
							{
								new Offers(emp.getQualification());
								this.dispose();
							}
							
						}
	
				
						
						
						obj = input.readObject();
						if(obj == null)
						{
							JOptionPane.showMessageDialog(this," Invalid details.","Error!",JOptionPane.WARNING_MESSAGE); 
						}
					}
		
				} 
				catch (Exception e1) {
	    // System.out.println(e.printStackTrace());
				}
		}
		catch(Exception e2) {}
			   
	}
		
			
		}
		else if(signupButton == e.getSource())
		{
			if(employer.isSelected())
				new SignUpEmployer();
			else if(applicant.isSelected())
				new SignUp();
			this.dispose();
		}
		
		}

}