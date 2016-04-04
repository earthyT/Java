import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.JOptionPane;

public class RegForm extends Frame implements ActionListener
{
	Label title,l1,l2,l3,l4,l5,l6;
	TextField t1,t2,t3,t4,t5;
	Button b;
	String message;
	CheckboxGroup cg;
	Checkbox c1,c2;
	Frame f;
	Panel p1,p2,p3,p4;
	
	RegForm()
	{
		f = new Frame("Registration Form");
		
		title = new Label("Sign up now!", Label.CENTER);
		l1 = new Label("Name:" , Label.LEFT);
		l2 = new Label("Email id:" , Label.LEFT);
		l3 = new Label("Password:" , Label.LEFT);
		l4 = new Label("Re-enter password:" , Label.LEFT);
		l5 = new Label("Gender:" , Label.LEFT);
		l6 = new Label("Age:" , Label.LEFT);

		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		t3.setEchoChar('*');
		t4 = new TextField();
		t4.setEchoChar('*');
		t5 = new TextField();

		b = new Button("Sign up!");
		b.addActionListener(this);
		
		cg = new CheckboxGroup();
	
		c1 = new Checkbox("Male",false,cg);
		c2 = new Checkbox("Female",false,cg);

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();

		p1.setLayout(new FlowLayout());
		p1.add(title);

		p2.setLayout(new GridLayout(6,2));
		p2.add(l1);
		p2.add(t1);
		p2.add(l2);
		p2.add(t2);
		p2.add(l3);
		p2.add(t3);
		p2.add(l4);
		p2.add(t4);
		p2.add(l6);
		p2.add(t5);

		p3.setLayout(new BorderLayout());
		p3.add(b,BorderLayout.CENTER);

		p4.setLayout(new GridLayout(1,3));
		p4.add(l5);
		p4.add(c1);
		p4.add(c2);

		f.setLayout(new GridLayout(4,1));
		f.add(p1);
		f.add(p2);
		f.add(p4);
		f.add(p3);
		f.setSize(350,600);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent windowEvent){ System.exit(0);}}); 
		f.setBackground(Color.black);
		f.setForeground(Color.green);   

		
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Sign up!"))
		{
			String x= t3.getText();
			int xlen = x.length();
			if(xlen < 7)
			{
				JOptionPane.showMessageDialog(null,"Password should contain atleast 7 characters","Error",JOptionPane.WARNING_MESSAGE);	
			}		
			if((t1.getText().equals(""))||(t2.getText().equals(""))||(t3.getText().equals(""))||(t4.getText().equals(""))||(t5.getText().equals("")))
			{
				JOptionPane.showMessageDialog(null,"All fields are required!","Error",JOptionPane.WARNING_MESSAGE);
			}
			if( ( (t3.getText()).compareTo(t4.getText()) )  != 0)
			{
				JOptionPane.showMessageDialog(null,"Passwords don't match!","Error",JOptionPane.WARNING_MESSAGE);
			}
			if((c1.getState())==false && (c2.getState())==false)
			{
				JOptionPane.showMessageDialog(null,"Please select 			gender","Error",JOptionPane.WARNING_MESSAGE);			
			}
			String id = t2.getText();
			int len = id.length();
			int i = 0;
			while(i <= len-1)
			{
				if(id.charAt(i)=='@') 
				break;
				else
				i++;
				if((i==len-4))
				{
					JOptionPane.showMessageDialog(null,"Invalid email id!","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		}		
	}

	

	
	public static void main(String args[])
	{
		new RegForm();
	}
}	
		
		







	