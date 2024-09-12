package controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Member;
import service.impl.MemberServiceImpl;
import javax.swing.JTextArea;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_password;
	private static MemberServiceImpl msi = new MemberServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbl_error = new JLabel("");
		lbl_error.setBounds(84, 148, 253, 15);
		contentPane.add(lbl_error);
		
		JButton btn_login = new JButton("登入");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=txt_username.getText();
				String Password=txt_password.getText();
				if(Username.equals("")||Password.equals("")) {
					lbl_error.setText("請輸入帳號密碼");
				}else {
					Member data = msi.queryByUN(Username);
					if(data == null) {
						lbl_error.setText("請先註冊");
					}else {
						if(Password.equals(data.getPassword())){
							MenuUI u=new MenuUI(Username);
							u.setVisible(true);
							dispose();
						}
						else {
							lbl_error.setText("密碼錯誤");
						}
					}
				}
				
			}
		});
		btn_login.setBounds(84, 172, 85, 23);
		contentPane.add(btn_login);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=txt_username.getText();
				String Password=txt_password.getText();
				if(Username.equals("")||Password.equals("")) {
					lbl_error.setText("請輸入帳號密碼");
				}else {
					Member data = msi.queryByUN(Username);
					if(data == null) {
						msi.addMB(Username,Password);
					}else {						
						lbl_error.setText("此帳號已被註冊過 !");						
					}
				}
			}
		});
		btnNewButton_1.setBounds(252, 172, 85, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setBounds(123, 52, 46, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(123, 88, 46, 15);
		contentPane.add(lblNewLabel_1);
		
		txt_username = new JTextField();
		txt_username.setBounds(241, 49, 96, 21);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setBounds(241, 85, 96, 21);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("輸入帳號密碼，第一次使用請先註冊，輸入帳號密碼點選註冊，即註冊完成");
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(386, 46, 112, 155);
		contentPane.add(textArea);
		

	}
}
