package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.LinkedList;

public class BloodData {
	File file = new File("blood.txt");
	
	public String[] group = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
	int[] data = new int[8];	

	public Scanner input = null;
	public FileWriter out = null;

	
	public BloodData() {
		try {
			int i=0;
			input = new Scanner(file);
			while(input.hasNextInt()) {
				data[i++] = input.nextInt();
			} 
		}
		catch (IOException e) {
			System.out.println("Error");
		}
	}
	
	public int get_data_at(int x) {
		return data[x];
	}
	
	public void add(String s, int x) {
		if(file.length() == 0) {
			new Exception("File is empty");
		}
		else {
			for(int i=0 ; i<8 ; i++) {
				if(s.equals(group[i])) {
					int y = Integer.valueOf(data[i]);
					data[i] = y + x;
					print();
					break;
				}
			}
		}
	}

	public void remove(String s, int x) throws Exception {
		if(file.length() == 0) {
			new Exception("File is empty");
		}
		else {
			for(int i=0 ; i<8 ; i++) {
				if(s.equals(group[i])) {
					int y = Integer.valueOf(data[i]);
					if(y-x > 0) {
						data[i] = y - x;
						print();
					}
					else {
						JOptionPane.showMessageDialog(null, "Request is waiting!", "Wait", JOptionPane.INFORMATION_MESSAGE);	
						Exception e = new Exception("");
					}
					break;
				}
			}
		}
	}
	
	private void print() {
		try {
			out = new FileWriter(file);
			for(int i=0 ; i<8 ; i++) {
				out.write(data[i] + "\n");
			}
			out.flush();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
