package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.BloodData;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class FrmFourth extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private BloodData blood = new BloodData();
	
	private JPanel contentPane;
	
	public FrmFourth(String s) {
		setTitle("Availability");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 231, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblA = new JLabel("A+ve");
		lblA.setBounds(29, 30, 70, 15);
		panel.add(lblA);
		
		JLabel lblA_ = new JLabel("A-ve");
		lblA_.setBounds(29, 57, 70, 15);
		panel.add(lblA_);
		
		JLabel lblB = new JLabel("B+ve");
		lblB.setBounds(29, 84, 70, 15);
		panel.add(lblB);
		
		JLabel lblB_ = new JLabel("B-ve");
		lblB_.setBounds(29, 111, 70, 15);
		panel.add(lblB_);
		
		JLabel lblAB = new JLabel("AB+ve");
		lblAB.setBounds(29, 143, 70, 15);
		panel.add(lblAB);
		
		JLabel lblAB_ = new JLabel("AB-ve");
		lblAB_.setBounds(29, 174, 70, 15);
		panel.add(lblAB_);
		
		JLabel lblO = new JLabel("O+ve");
		lblO.setBounds(29, 201, 70, 15);
		panel.add(lblO);
		
		JLabel lblO_ = new JLabel("O-ve");
		lblO_.setBounds(29, 228, 70, 15);
		panel.add(lblO_);
				
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(18, 279, 81, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(116, 279, 75, 25);
		panel.add(btnNewButton_1);
		
		JTextPane textPane_a = new JTextPane();
		textPane_a.setText("0");
		textPane_a.setBounds(106, 24, 62, 21);
		panel.add(textPane_a);
		
		JTextPane textPane_a1 = new JTextPane();
		textPane_a1.setText("0");
		textPane_a1.setBounds(106, 51, 62, 21);
		panel.add(textPane_a1);
		
		JTextPane textPane_b = new JTextPane();
		textPane_b.setText("0");
		textPane_b.setBounds(106, 78, 62, 21);
		panel.add(textPane_b);
		
		JTextPane textPane_b1 = new JTextPane();
		textPane_b1.setText("0");
		textPane_b1.setBounds(106, 108, 62, 21);
		panel.add(textPane_b1);
		
		JTextPane textPane_ab = new JTextPane();
		textPane_ab.setText("0");
		textPane_ab.setBounds(106, 139, 62, 21);
		panel.add(textPane_ab);
		
		JTextPane textPane_ab1 = new JTextPane();
		textPane_ab1.setText("0");
		textPane_ab1.setBounds(106, 168, 62, 21);
		panel.add(textPane_ab1);
		
		JTextPane textPane_o = new JTextPane();
		textPane_o.setText("0");
		textPane_o.setBounds(106, 195, 62, 21);
		panel.add(textPane_o);
		
		JTextPane textPane_o1 = new JTextPane();
		textPane_o1.setText("0");
		textPane_o1.setBounds(106, 222, 62, 21);
		panel.add(textPane_o1);
		
		textPane_a.setText(String.valueOf(blood.get_data_at(0)));
		textPane_a1.setText(String.valueOf(blood.get_data_at(1)));
		textPane_b.setText(String.valueOf(blood.get_data_at(2)));
		textPane_b1.setText(String.valueOf(blood.get_data_at(3)));
		textPane_ab.setText(String.valueOf(blood.get_data_at(4)));
		textPane_ab1.setText(String.valueOf(blood.get_data_at(5)));
		textPane_o.setText(String.valueOf(blood.get_data_at(6)));
		textPane_o1.setText(String.valueOf(blood.get_data_at(7)));
		
	}
}
