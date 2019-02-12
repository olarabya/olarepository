import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;

public class StudentList extends JFrame implements ActionListener {
	//private ArrayList<Student> list;
	//private Font font; 
	ArrayList<Student>st = new ArrayList<Student>();
	private FlowLayout layout;
	private Container container;
	private JButton clear;
	private JButton add;
	private JButton Finde;
	private JButton Save;
	private JButton Delete;
	private JButton Edit;
	private JLabel l1,l2,l3,l4,l5;
	private JPanel p1,p2,p3,p4,p5,p6;
	private JTextField t1,t2,t3,t4,t5;	 
	public StudentList() {
		
	super("HW2_Students");
	st = new ArrayList<Student>();
	layout=new FlowLayout();
		container=getContentPane();
		setLayout(layout);
		l1=new JLabel("ID ");
		l2=new JLabel("FirstName");
		l3=new JLabel("LastName");
		l4=new JLabel("Address");
		l5=new JLabel("Avarage");
		clear=new JButton("Clear");
		clear.addActionListener(this);
		add=new JButton("Add");
		add.addActionListener(this);
		Finde=new JButton("Finde");
		Finde.addActionListener(this);
		Save=new JButton("Save");
		Save.addActionListener(this);
		 Delete=new JButton(" Delete");
			Delete.addActionListener(this);
			Edit=new JButton(" Edit");
			Edit.addActionListener(this);
			
		t1=new JTextField(31);
		t2=new JTextField(30);
		t3=new JTextField(30);
		t4=new JTextField(30);
		t5=new JTextField(30);
		p1=new JPanel();
		p2 = new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p1.add(clear);
		p1.add(add);
		p1.add(Finde);
		p1.add(Save);
		p1.add(Delete);
		p1.add(Edit);
		add(p1);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		
		add(l3);add(t3);
		add(l4);add( t4);
		add(l5);add(t5);
		
		setSize(430,230);
		setResizable(false);
		
		
	}
	
	public void actionPerformed(ActionEvent event) {
		int number;
		if(event.getSource()==add) {
			//number=Integer.parseInt(t1.getText());
			
				System.out.println("add");
				
				String fname="";
				String lname="";
				String addrs="";
				double avg=0.0;
				
				if(t1.getText().matches("[0-9]+") &&  !t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty())
				{
					
					fname=t2.getText();
					
						lname=t3.getText();
					if(!t4.getText().isEmpty())
						addrs=t4.getText();
					if(!t5.getText().isEmpty())
						avg=new Double(t5.getText());
					Student std=new Student(Integer.parseInt( t1.getText()), fname,lname,addrs,avg);
					
				addStudent(std );
				}
				else
				{
					if(!t1.getText().matches("[0-9]+"))
					JOptionPane.showMessageDialog(null, "the student  id must be integer  ");
					
					if(t2.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Enter the first name ");
					if(t3.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Enter the last name ");
				}
				
		}
		
		if(event.getSource()==Finde) {
			//number=Integer.parseInt(t1.getText());
			
				System.out.println("finde");
				//Student std=new Student(Integer.parseInt( t1.getText()), t2.getText(),t3.getText(),t4.getText(),Double.parseDouble(t5.getText()));
				search(Integer.parseInt( t1.getText()));
			
				}
		if(event.getSource()==Delete) {
			//number=Integer.parseInt(t1.getText());
			
				//System.out.println("finde");
				//Student std=new Student(Integer.parseInt( t1.getText()), t2.getText(),t3.getText(),t4.getText(),Double.parseDouble(t5.getText()));
			if(search(Integer.parseInt( t1.getText()))!=null)
			{deletestudent(Integer.parseInt( t1.getText()));
				
			
				JOptionPane.showMessageDialog(null, "the student  remove frome the list ");
				}
			else
			{
				
				JOptionPane.showMessageDialog(null, "the student  can't remove frome the list not founded ");
			}
		}
		
		if(event.getSource()==clear) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		}
		if(event.getSource()==Edit) {
			edit(Integer.parseInt( t1.getText()));
		}
		
		if(event.getSource()==Save) {
			
		}
		if(event.getSource()==Save) {
			save(Integer.parseInt( t1.getText()));
		}
		
		
		
			
		}
		
	
	public void addStudent(Student s) {
		if (!st.contains(s)){
			
			st.add(s);
			JOptionPane.showMessageDialog(null, "the student added in the list");
			System.out.println(st.get(st.size()-1).get_firstName()+st.get(st.size()-1).get_lastName()+st.size());
		}
		else {
		JOptionPane.showMessageDialog(null, "the student you cant added in the list");
		}
		
		
	}
	public void remove(Student s){
		st.remove(s);
	}
	public void deletestudent(int id){
		Student sdt=search(id);
		st.remove(sdt);
	}
	public Student getStudent(int i){
		return st.get(i);
	}
	public int indexOf(Student s){
		return st.indexOf(s);
	}
	public boolean contains(Student s) {
		return st.contains(s);
	}
	
	public   Student search(int id) {
		
		for(int i=0; i<st.size(); i++) {
			
			if(st.get(i).get_id()==id)
			{
				JOptionPane.showMessageDialog(null, "student  found in the list");
				return st.get(i);
			}
			
			
			
			
		}
		
		JOptionPane.showMessageDialog(null, "student not found in the list");
		return null;
		
	}
	public void edit (int id) {
		Student sdt=search(id);
		if(sdt!=null)
		{
			
		
			JOptionPane.showMessageDialog(null, "the student  Edit frome the list ");
			
			t2.setText(sdt.get_firstName());
			t3.setText(sdt.get_lastName());
			t4.setText(sdt.get_address());
			t5.setText(new Double(sdt.get_avarage()).toString());
			}
		else
		{
			
			JOptionPane.showMessageDialog(null, "the student  can't Edit  not founded ");
		}
	}
	
	
	public void save (int id) {
		Student sdt=search(id);
		if(sdt!=null)
		{
			
		
			
			sdt.set_firstName(t2.getText());

			sdt.set_lastName(t3.getText());
			sdt.set_address(t4.getText());
			sdt.set_avarage(new Double(t5.getText()));
			
			JOptionPane.showMessageDialog(null, "the student  saved successfully ");
			
			
			
			}
		else
		{
			
			JOptionPane.showMessageDialog(null, "the student  can't Save  not founded ");
		}
	}
}
  
				  