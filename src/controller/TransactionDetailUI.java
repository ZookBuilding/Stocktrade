package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.TransactionDaoImpl;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class TransactionDetailUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TransactionDaoImpl T=new TransactionDaoImpl();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionDetailUI frame = new TransactionDetailUI("123");
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
	public TransactionDetailUI(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_return = new JButton("返回");
		btn_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUI m=new MenuUI(username);
				m.setVisible(true);
				dispose();
			}
		});
		btn_return.setBounds(229, 236, 85, 23);
		contentPane.add(btn_return);
		
		textArea = new JTextArea();
		textArea.setBounds(45, 23, 393, 203);
		contentPane.add(textArea);
		textArea.setText(
				"日期\t\t股票代碼\t股票價格\t股票數量\n" +T.queryStockDetail(username)
			);
		
		
	}

}
