package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.BloodData;
import model.Patient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmSecond extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtPhone;
	private JTextField txtGender;
	private JTextField txtQuantity;


	public Patient pat;
	private JTextField txtTime;
	
	public FrmSecond(String s, BloodData b) {
		this.setTitle("Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 395);
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
		
		JLabel lblQuantity = new JLabel("Quantity (pack of 350ml)");
		lblQuantity.setBounds(30, 148, 166, 15);
		contentPane.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(208, 146, 156, 19);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtTime = new JTextField();
		txtTime.setBounds(208, 182, 156, 19);
		contentPane.add(txtTime);
		txtTime.setColumns(10);
		
		JLabel lblTime = new JLabel("Emergency (out of 5)");
		lblTime.setBounds(30, 184, 166, 15);
		contentPane.add(lblTime);
		
		JLabel lblBloodGrp = new JLabel("Blood Group");
		lblBloodGrp.setBounds(30, 224, 87, 15);
		contentPane.add(lblBloodGrp);
		
		JRadioButton rdbtnA = new JRadioButton("A+");
		rdbtnA.setBackground(Color.WHITE);
		rdbtnA.setBounds(184, 220, 44, 23);
		contentPane.add(rdbtnA);
		
		JRadioButton rdbtnA_ = new JRadioButton("A-");
		rdbtnA_.setBackground(Color.WHITE);
		rdbtnA_.setBounds(274, 220, 39, 23);
		contentPane.add(rdbtnA_);
		
		JRadioButton rdbtnB = new JRadioButton("B+");
		rdbtnB.setBackground(Color.WHITE);
		rdbtnB.setBounds(184, 301, 44, 23);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnB_ = new JRadioButton("B-");
		rdbtnB_.setBackground(Color.WHITE);
		rdbtnB_.setBounds(274, 301, 39, 23);
		contentPane.add(rdbtnB_);
		
		JRadioButton rdbtnAB = new JRadioButton("AB+");
		rdbtnAB.setBackground(Color.WHITE);
		rdbtnAB.setBounds(184, 274, 53, 23);
		contentPane.add(rdbtnAB);
		
		JRadioButton rdbtnAB_ = new JRadioButton("AB-");
		rdbtnAB_.setBackground(Color.WHITE);
		rdbtnAB_.setBounds(274, 274, 48, 23);
		contentPane.add(rdbtnAB_);
		
		JRadioButton rdbtnO = new JRadioButton("O+");
		rdbtnO.setBackground(Color.WHITE);
		rdbtnO.setBounds(183, 247, 46, 23);
		contentPane.add(rdbtnO);
		
		JRadioButton rdbtnO_ = new JRadioButton("O-");
		rdbtnO_.setBackground(Color.WHITE);
		rdbtnO_.setBounds(274, 247, 41, 23);
		contentPane.add(rdbtnO_);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String gender = txtGender.getText();
				String age_str = txtAge.getText();
				String phone = txtPhone.getText();
				String time = txtTime.getText();
				String quantity_str = txtQuantity.getText();
								
				if(txtName.getText().isEmpty() || txtTime.getText().isEmpty() || txtAge.getText().isEmpty() || txtPhone.getText().isEmpty() || txtGender.getText().isEmpty() || txtQuantity.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter complete data", "Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					try{
						if(rdbtnA_.isSelected()) {
							pat = new Patient(name, gender, age_str, phone, quantity_str, time, rdbtnA_.getText());
							b.remove(rdbtnA_.getText(), Integer.valueOf(quantity_str));
						}
						else if(rdbtnAB_.isSelected()) {
							pat = new Patient(name, gender, age_str, phone, quantity_str, time, rdbtnAB_.getText());
							b.remove(rdbtnAB_.getText(), Integer.valueOf(quantity_str));
						}
						else if(rdbtnAB.isSelected()) {
							pat = new Patient(name, gender, age_str, phone, quantity_str, time,  rdbtnAB.getText());
							b.remove(rdbtnAB.getText(), Integer.valueOf(quantity_str));
						}
						else if(rdbtnA.isSelected()) {
							pat = new Patient(name, gender, age_str, phone, quantity_str, time,  rdbtnA.getText());
							b.remove(rdbtnA.getText(), Integer.valueOf(quantity_str));
						}
						else if(rdbtnB.isSelected()) {
							pat = new Patient(name, gender, age_str, phone, quantity_str, time, rdbtnB.getText());
							b.remove(rdbtnB.getText(), Integer.valueOf(quantity_str));
						}
						else if(rdbtnB_.isSelected()) {
							pat = new Patient(name, gender, age_str, phone, quantity_str, time, rdbtnB_.getText());
							b.remove(rdbtnB_.getText(), Integer.valueOf(quantity_str));
						}
						else if(rdbtnO.isSelected()) {
							pat = new Patient(name, gender, age_str, phone, quantity_str, time, rdbtnO.getText());
							b.remove(rdbtnO.getText(), Integer.valueOf(quantity_str));
						}
						else if(rdbtnO_.isSelected()) {
							pat = new Patient(name, gender, age_str, phone, quantity_str, time, rdbtnO_.getText());
							b.remove(rdbtnO_.getText(), Integer.valueOf(quantity_str));
						}
						else {
							JOptionPane.showMessageDialog(null, "Select any one option", "Warning", JOptionPane.INFORMATION_MESSAGE);						
						}
					}
					catch (Exception ex) {
						pat.Call();	
						System.out.println(ex);
					}
				}
				txtName.setText(null);
				txtAge.setText(null);
				txtPhone.setText(null);
				txtGender.setText(null);
				txtQuantity.setText(null);
				txtTime.setText(null);;
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
		btnSubmit.setBounds(139, 332, 83, 25);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtAge.setText(null);
				txtPhone.setText(null);
				txtGender.setText(null);
				txtQuantity.setText(null);
				txtTime.setText(null);;
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
		btnReset.setBounds(234, 332, 75, 25);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(321, 332, 59, 25);
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("< Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBounds(42, 332, 87, 25);
		contentPane.add(btnBack);
		
		}
}
