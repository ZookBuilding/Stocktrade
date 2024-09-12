package controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;


public class MenuUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUI frame = new MenuUI("123");
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
	public MenuUI(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("自選群組");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpservationGroupUI o=new OpservationGroupUI(username);
				o.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 10, 85, 23);
		contentPane.add(btnNewButton);
		
		JButton btn_transactionDetail = new JButton("交易紀錄");
		btn_transactionDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransactionDetailUI T=new TransactionDetailUI(username);
				T.setVisible(true);
				dispose();
			}
		});
		btn_transactionDetail.setBounds(10, 43, 85, 23);
		contentPane.add(btn_transactionDetail);
		
		JButton btnNewButton_2 = new JButton("股票交易");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockBuyUI s=new StockBuyUI(username);
				s.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(105, 10, 85, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("登出");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l=new LoginUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(105, 43, 85, 23);
		contentPane.add(btnNewButton_3);
	}

}
