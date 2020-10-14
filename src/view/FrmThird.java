package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.BloodData;
import model.Donor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmThird extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtPhone;
	private JTextField txtGender;
	private JTextField txtQuantity;


	@SuppressWarnings("unused")
	private Donor don;
	
	public FrmThird(String s, BloodData b) {
		this.setTitle("Donor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(30, 12, 40, 15);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(208, 10, 156, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(30, 81, 52, 15);
		contentPane.add(lblGender);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(208, 41, 156, 19);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(30, 117, 27, 15);
		contentPane.add(lblAge);
		
		txtGender = new JTextField();
		txtGender.setBounds(208, 81, 156, 19);
		contentPane.add(txtGender);
		txtGender.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone No.");
		lblPhone.setBounds(30, 46, 73, 15);
		contentPane.add(lblPhone);
		
		txtAge = new JTextField();
		txtAge.setBounds(208, 115, 156, 19);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity(pack of 350ml)");
		lblQuantity.setBounds(30, 148, 166, 15);
		contentPane.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(208, 146, 156, 19);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblBlood = new JLabel("Blood Group");
		lblBlood.setBounds(30, 183, 87, 15);
		contentPane.add(lblBlood);
		
		JRadioButton rdbtnA = new JRadioButton("A+");
		rdbtnA.setBackground(Color.WHITE);
		rdbtnA.setBounds(184, 179, 44, 23);
		contentPane.add(rdbtnA);
		
		JRadioButton rdbtnA_ = new JRadioButton("A-");
		rdbtnA_.setBackground(Color.WHITE);
		rdbtnA_.setBounds(274, 179, 39, 23);
		contentPane.add(rdbtnA_);
		
		JRadioButton rdbtnB = new JRadioButton("B+");
		rdbtnB.setBackground(Color.WHITE);
		rdbtnB.setBounds(184, 262, 44, 23);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnB_ = new JRadioButton("B-");
		rdbtnB_.setBackground(Color.WHITE);
		rdbtnB_.setBounds(274, 262, 39, 23);
		contentPane.add(rdbtnB_);
		
		JRadioButton rdbtnAB = new JRadioButton("AB+");
		rdbtnAB.setBackground(Color.WHITE);
		rdbtnAB.setBounds(184, 233, 53, 23);
		contentPane.add(rdbtnAB);
		
		JRadioButton rdbtnAB_ = new JRadioButton("AB-");
		rdbtnAB_.setBackground(Color.WHITE);
		rdbtnAB_.setBounds(274, 233, 48, 23);
		contentPane.add(rdbtnAB_);
		
		JRadioButton rdbtnO = new JRadioButton("O+");
		rdbtnO.setBackground(Color.WHITE);
		rdbtnO.setBounds(184, 206, 46, 23);
		contentPane.add(rdbtnO);
		
		JRadioButton rdbtnO_ = new JRadioButton("O-");
		rdbtnO_.setBackground(Color.WHITE);
		rdbtnO_.setBounds(274, 206, 41, 23);
		contentPane.add(rdbtnO_);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String gender = txtGender.getText();
				String age_str = txtAge.getText();
				String phone = txtPhone.getText();
				String quantity_str = txtQuantity.getText();
				
				if(Integer.valueOf(age_str) < 18) {
					JOptionPane.showMessageDialog(null, "You're too young to donate blood!", "Sorry", JOptionPane.INFORMATION_MESSAGE);				
					return;
				}
				
				if(txtName.getText().isEmpty() || txtAge.getText().isEmpty() || txtPhone.getText().isEmpty() || txtGender.getText().isEmpty() || txtQuantity.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter complete data", "Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if(rdbtnA_.isSelected()) {
						don = new Donor(name, gender, age_str, phone, quantity_str, rdbtnA_.getText());
						b.add(rdbtnA_.getText(), Integer.valueOf(quantity_str));
					}
					else if(rdbtnAB_.isSelected()) {
						don = new Donor(name, gender, age_str, phone, quantity_str, rdbtnAB_.getText());
						b.add(rdbtnAB_.getText(), Integer.valueOf(quantity_str));
					}
					else if(rdbtnAB.isSelected()) {
						don = new Donor(name, gender, age_str, phone, quantity_str, rdbtnAB.getText());
						b.add(rdbtnAB.getText(), Integer.valueOf(quantity_str));
					}
					else if(rdbtnA.isSelected()) {
						don = new Donor(name, gender, age_str, phone, quantity_str, rdbtnA.getText());
						b.add(rdbtnA.getText(), Integer.valueOf(quantity_str));
					}
					else if(rdbtnB.isSelected()) {
						don = new Donor(name, gender, age_str, phone, quantity_str, rdbtnB.getText());
						b.add(rdbtnB.getText(), Integer.valueOf(quantity_str));
					}
					else if(rdbtnB_.isSelected()) {
						don = new Donor(name, gender, age_str, phone, quantity_str, rdbtnB_.getText());
						b.add(rdbtnB_.getText(), Integer.valueOf(quantity_str));
					}
					else if(rdbtnO.isSelected()) {
						don = new Donor(name, gender, age_str, phone, quantity_str, rdbtnO.getText());
						b.add(rdbtnO.getText(), Integer.valueOf(quantity_str));
					}
					else if(rdbtnO_.isSelected()) {
						don = new Donor(name, gender, age_str, phone, quantity_str, rdbtnO_.getText());
						b.add(rdbtnO_.getText(), Integer.valueOf(quantity_str));
					}
					else {
						JOptionPane.showMessageDialog(null, "Select any one option", "Warning", JOptionPane.INFORMATION_MESSAGE);						
					}
				}
				txtName.setText(null);
				txtAge.setText(null);
				txtPhone.setText(null);
				txtGender.setText(null);
				txtQuantity.setText(null);
				rdbtnA_.setSelected(false);
				rdbtnAB_.setSelected(false);
				rdbtnAB.setSelected(false);
				rdbtnA.setSelected(false);
				rdbtnB.setSelected(false);
				rdbtnB_.setSelected(false);
				rdbtnO.setSelected(false);
				rdbtnO_.setSelected(false);
			
			}
		});
		btnSubmit.setBounds(145, 293, 83, 25);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtAge.setText(null);
				txtPhone.setText(null);
				txtGender.setText(null);
				txtQuantity.setText(null);
				rdbtnA_.setSelected(false);
				rdbtnAB_.setSelected(false);
				rdbtnAB.setSelected(false);
				rdbtnA.setSelected(false);
				rdbtnB.setSelected(false);
				rdbtnB_.setSelected(false);
				rdbtnO.setSelected(false);
				rdbtnO_.setSelected(false);
			}
		});
		btnReset.setBounds(238, 293, 75, 25);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(325, 293, 59, 25);
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("< Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBounds(42, 293, 91, 25);
		contentPane.add(btnBack);
	}
}
