package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Donor{
	String name;
	String age;
//	int weight;
	String bloodgroup;
	String Phonenumber;
	String Gender;
	int quantity;
	
	File x = new File("donor.txt");
	FileWriter fw = null;
	LinkedList<Donor> don = new LinkedList<>();
	LinkedList<Donor> donqueue = new LinkedList<>();
	
	public Donor(String name, String gender2, String age_str, String phone, String quantity_str, String bloodgrp) {
		//System.out.println("Donor data received!!!");
		this.name = name;
		this.Gender = gender2;
		this.age = age_str;
		this.Phonenumber = phone;
		this.bloodgroup = bloodgrp;
		this.quantity = Integer.valueOf(quantity_str);
		
		don.insertNode(this);
		for(int i=0 ; i<don.size() ; i++)
			donqueue.insertNode(don.dataAtNodeIndex(i));
		
		System.out.println(donqueue.displayList());
		try {
			fw = new FileWriter(x, true);
			fw.append(donqueue.displayList());
			fw.flush();
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

	public int getQuantity() {
		return quantity;
	}

	public String toString() {
		String y;
		y= "Name: "+this.getName()+"\tAge: "+this.getAge() + "\tBloodGroup: "+this.getBloodgroup()+"\tNumber: "+this.getPhonenumber()+"\tGender:"+this.getGender() + "\tQuantity: " +this.getQuantity() + "\n";
		return y;
	}
}