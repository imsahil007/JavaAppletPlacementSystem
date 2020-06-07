import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import javax.swing.*;



public class SignUpEmployer  extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int x=0,y=100;
	JLabel l1, l2,l3,l4,l5,l6,l7;
	JTextField id,name,job,vacancy;
//	JPasswordField pswd;
	JTextField pswd;
	JRadioButton elect,civil,soft,it;
	JComboBox salary;
	JButton submit,reset;
	ButtonGroup bg;
	String qualification="";
	
	SignUpEmployer(){
				
		l1 = new JLabel("Username");
		l1.setBounds(100,150,100,25);	
		id = new JTextField();
		id.setBounds(220,150,100,25);
	

		l2= new JLabel("Password");
		l2.setBounds(100,200,100,25);
		pswd = new JPasswordField();
		pswd.setBounds(220,200,100,25);
		
		l3 = new JLabel("Organization Name");
		l3.setBounds(100,250,100,25);	
		name = new JTextField();
		name.setBounds(220,250,100,25);
		
		l4 = new JLabel("Job-Post");
		l4.setBounds(100,300,100,25);	
		job = new JTextField();
		job.setBounds(220,300,100,25);
		
		l5 = new JLabel("Vacancy");
		l5.setBounds(400,150,100,25);	
		vacancy = new JTextField();
		vacancy.setBounds(520,150,100,25);
		
		l6 = new JLabel("Qualification Needed");
		l6.setBounds(400,200,125,25);	
		elect=new JRadioButton("Electrical Engineer");  
		civil=new JRadioButton("Civil Engineer");   
		soft=new JRadioButton("Software Engineer");   
		it=new JRadioButton("IT Engineer");
		elect.setBounds(450,230,200,25);
		civil.setBounds(450,260,200,25);
		soft.setBounds(450,290,200,25);
		it.setBounds(450,320,200,25);
		bg=new ButtonGroup();    
		bg.add(elect);
		bg.add(civil); 
		bg.add(soft);
		bg.add(it); 
		
		l7 = new JLabel("Salary Offered:");
		l7.setBounds(100,350,125,25);	
		String s[] = { "25000","30000" ,"35000","40000+"}; 
		salary= new JComboBox(s);
		salary.setBounds(220,350,100,25);
		
//		salary.getSelectedItem()

		submit = new JButton("SUBMIT");
		submit.setBounds(450,380,200,25);
		submit.addActionListener(this);
		reset = new JButton("Reset");
		reset.setBounds(670,380,100,25);
		add(reset);
		reset.addActionListener(this);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(id);
		add(pswd);
		add(name);
		add(job);
		add(vacancy);
		add(elect);
		add(civil); 
		add(soft);
		add(it); 
		add(salary);
		add(submit);
		
		setSize(800, 500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == submit)
		{	
			
			if(elect.isSelected())
				qualification = "Electrical Engineer";
			else if(civil.isSelected())
				qualification ="Civil Engineer"; 
			else if(soft.isSelected())
				qualification = "Software Engineer";
			else 
				qualification = "IT Engineer";
			Employer emp = new Employer(id.getText().toString(),pswd.getText().toString(),name.getText().toString(),job.getText().toString(),
					vacancy.getText().toString(),salary.getSelectedItem().toString(),qualification);
		
			try {
					String path = "employer.txt";
				  	File file = new File(path);
			        boolean append = file.exists(); // if file exists then append, otherwise create new
			        try {
			            FileOutputStream fout = new FileOutputStream(file, append);
			            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
			            oout.writeObject(emp);
			            fout.close();
			        } catch (FileNotFoundException e1) {
			            e1.printStackTrace();
			        
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
			}
			finally {
				
			}
			  this.dispose();
			  new Main();
		}
		else if(e.getSource() == reset)
		{
			 this.dispose();
			  new Main();
			
		}
		
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
	

}
