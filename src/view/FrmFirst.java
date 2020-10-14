package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.BloodData;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmFirst extends JFrame {

	private static final long serialVersionUID = 1L;
	public BloodData blood_data = new BloodData();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFirst frame = new FrmFirst();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmFirst() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBloodBankManaf = new JLabel("Blood Bank Management");
		lblBloodBankManaf.setFont(new Font("Khmer OS System", Font.BOLD, 17));
		lblBloodBankManaf.setBounds(22, 12, 230, 28);
		panel.add(lblBloodBankManaf);
		
		JButton btnDonateBlood = new JButton("Donate Blood");
		btnDonateBlood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmThird("Enter information of Donor", blood_data).setVisible(true);
			}
		});
		btnDonateBlood.setBounds(22, 64, 157, 40);
		panel.add(btnDonateBlood);
		
		JButton btnNeedBlood = new JButton("Need Blood");
		btnNeedBlood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Need bloooooodddd!!!!");
				new FrmSecond("Enter information of Patient", blood_data).setVisible(true);	
			}
		});
		btnNeedBlood.setBounds(22, 116, 157, 40);
		panel.add(btnNeedBlood);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(22, 224, 157, 40);
		panel.add(btnExit);
		
		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new ImageIcon("/home/tirth/eclipse-workspace/prjBloodBankDonation/src/view/download.png"));
		lblImage.setBounds(236, 28, 224, 248);
		panel.add(lblImage);
		
		JButton btnBankStatus = new JButton("Bank Status");
		btnBankStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmFourth("Bank Status").setVisible(true);
			}
		});
		btnBankStatus.setBounds(22, 168, 157, 40);
		panel.add(btnBankStatus);
	}
}
