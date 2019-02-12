import javax.swing.*;
import java.util.*;

public class Student {
private int id;
private String firstName;
private String lastName;
private String address;
private double avarage;
private boolean finde;
private ArrayList<Student> st;
public Student(int id ,String firstName ,String lastName ,String address,double avarage){
	this.id=id;
	this.firstName=firstName;
	this.lastName=lastName;
	this.address=address;
	this.avarage=avarage;
	this.finde=false;
	st = new ArrayList<Student>();
	
}
public void set_id(int id)
{
	this.id=id;
}
public void set_firstName(String firstName )
{
	this.firstName=firstName;
}
public void set_lastName(String lastName )
{
	this.lastName=lastName;
}

public void set_address(String address )
{
	this.address=address;
}
public void set_avarage(double avarage )
{
	this.avarage=avarage;
}
public int get_id(){
	return this.id;
}

public String  get_firstName(){
	return this.firstName;
}
public String  get_lastName(){
	return this.lastName;
}
public String  get_address(){
	return this.address;
}
public double  get_avarage(){
	return this.avarage;
}
public void founde(){
	if(this.finde)  JOptionPane.showMessageDialog(null,"This id has been not found,you can't finde and delete  it");
	else
		this.finde=true;
}
public boolean isFinde()
{
return this.finde;
}
public int size() {
	return st.size();
}

}
