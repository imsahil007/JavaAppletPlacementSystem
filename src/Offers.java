import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Offers extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	JFrame f;
	
	JButton reset;
	Offers(String qualification){

		String col[] = {"Sno.","Organization Name","Post","Salary Offered","Vacancies"};
		String data[][] = new String [20][4];
		int k = 0;
		reset = new JButton("Reset");
		reset.setBounds(580,450,100,30);
		add(reset);
		reset.addActionListener(this);
		try {
				FileInputStream fin = new FileInputStream("employer.txt");
				try {
					@SuppressWarnings("resource")
					ObjectInputStream input = new ObjectInputStream(fin);
					Object obj = null;
					
				    Employer emp = null;
				  
				    while ((obj = input.readObject()) != null) 
					{
						int i =0;
						emp =(Employer) obj;
						if(emp.getQualification().equals(qualification)) {
						data[k][i++] = emp.getName();
						data[k][i++] = emp.getJob();
						data[k][i++] = emp.getSalary();
						data[k][i++] = emp.getVacancy();
						k++;
						}
					}
		
				} 
				catch (Exception e1) {
	    // System.out.println(e.printStackTrace());
				}
			
				fin.close();
				
		}
		catch(Exception e2) {}
	
		
		String str = col[0];
		
		for(int i=1; i <5; i++)
		{
			col[i]=String.format("%" + 25 + "s", col[i]); 
			str += col[i];
		}
		JLabel l1=new JLabel(str);	
		l1.setForeground(Color.BLUE);
		l1.setBounds(20,20,700,10);
		add(l1);
		str="";
		for(int i=0; i < k; i++)
		{
			str+= Integer.toString(i+1);
			str+="   ";
			for(int j = 0; j <4;j++) {
				
				str +=  String.format("%" + 25 + "s", data[i][j]);
			}
			str += "\n";
		}
		
		JTextArea l2=new JTextArea(str);	

		l2.setBounds(20,45,550,450);
		add(l2);

		setSize(700, 550);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == reset)
		{
			 this.dispose();
			  new Main();
			
		}
	}

}
