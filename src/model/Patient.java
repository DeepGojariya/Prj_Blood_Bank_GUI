package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Patient{
	String name;
	String age;
	String bloodgroup;
	String Phonenumber;
	String Gender;
	int priority;
	int quantity;
	
	File x = new File("patient.txt");
	File y = new File("wait.txt");
	FileWriter fw = null;
	
	LinkedList<Patient> pat = new LinkedList<>();
	//LinkedList<Patient> patqueue = new LinkedList<>();
	LinkedList<Patient> wait=new LinkedList<>();
			
	public Patient(String name2, String gender2, String age_str, String phone, String quantity_str, String priority, String bloodgrp) {
		//System.out.println("Patient data received!!!");
		this.name = name2;
		this.Gender = gender2;
		this.age = age_str;
		this.Phonenumber = phone;
		this.quantity = Integer.valueOf(quantity_str);
		this.priority = Integer.valueOf(priority);
		this.bloodgroup = bloodgrp;
		
		pat.insertNode(this);
		
		for(int i=0;i<pat.size()-1;i++) {
			Patient data=pat.dataAtNodeIndex(i);
			Patient l;
			for(int y=i+1;y<pat.size();y++) {
				if(pat.dataAtNodeIndex(i).priority<pat.dataAtNodeIndex(y).priority) {
					l=pat.dataAtNodeIndex(y);
					pat.insertNodeAtIndex(i, l);
					pat.deleteNodeAtIndex(i+1);
					pat.insertNodeAtIndex(y, data);
					pat.deleteNodeAtIndex(y+1);
				}
			}
		}
		
//		for (int j=pat.size() ; j>0 ; j--)
//			patqueue.insertNode(pat.dataAtNodeIndex(j));
		
		System.out.println(pat.displayList());
		try {
			fw = new FileWriter(x);
			fw.write(pat.displayList());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void Call() {
		wait.insertNode(pat.dataAtNodeIndex(0));
		pat.deleteNode();
		for(int i=0;i<wait.size()-1;i++) {
			Patient data=wait.dataAtNodeIndex(i);
			Patient l=null;
			for(int y=i+1;y<wait.size();y++) {
				if(wait.dataAtNodeIndex(i).priority<wait.dataAtNodeIndex(y).priority) {
					l=wait.dataAtNodeIndex(y);
					wait.insertNodeAtIndex(i, l);
					wait.deleteNodeAtIndex(i+1);
					wait.insertNodeAtIndex(y, data);
					wait.deleteNodeAtIndex(y+1);
				}
			}
		}
		try {
			fw = new FileWriter(y);
			System.out.println(wait.displayList());
			fw.write("adcs");
			fw.write(wait.displayList());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			fw = new FileWriter(x);
			fw.write(pat.displayList());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public String getPhonenumber() {
		return Phonenumber;
	}

	public String getGender() {
		return Gender;
	}

	public int getPriority() {
		return priority;
	}

	public int getQuantity() {
		return quantity;
	}

	public String toString() {
		String y;
		y = "Name: "+this.getName()+"\tAge: "+this.getAge() + " \tBloodGroup: "+this.getBloodgroup()+"\tNumber: "+this.getPhonenumber()+"\tGender:"+this.getGender()+ "\tQuantity:"+this.getQuantity() + "\tEmer:"+this.getPriority() + "\n";
		return y;
	}
}
