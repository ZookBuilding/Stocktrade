package controller;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dao.impl.OptionalDaoImpl;
import model.Optional;
import service.RealTimeQuote;


public class OpservationGroupUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_stock;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private OptionalDaoImpl o=new OptionalDaoImpl();
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		try {
			OpservationGroupUI frame = new OpservationGroupUI("123");
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
			

	}

	/**
	 * Create the frame.
	 */
	public OpservationGroupUI(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		
		txt_stock = new JTextField();
		txt_stock.setBounds(22, 40, 96, 21);
		contentPane.add(txt_stock);
		txt_stock.setColumns(10);
		textArea = new JTextArea();
		textArea.setBounds(22, 85, 401, 170);
		contentPane.add(textArea);
		textArea.setText(o.queryOptionalString(username));
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String stockid=txt_stock.getText();
				Optional op=null;
				try {				
					op = RealTimeQuote.update(stockid);
					op.setUsername(username);
					System.out.print(op.getUsername());
					System.out.print(op.getStockid());
					System.out.print(op.getStockname());
					System.out.print(op.getStockprice());
					
					op.setStockid(stockid);
					o.addOptional(op);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(o.queryOptionalString(username));
				
				
				
				
			}
		});
		btnNewButton.setBounds(128, 26, 60, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("自選群組");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(62, 10, 94, 19);
		contentPane.add(lblNewLabel);
		
		
		
		btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUI m=new MenuUI(username);
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(460, 232, 85, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("更新");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				o.updateOprionalList(o.queryOptional(username));
				textArea.setText(o.queryOptionalString(username));
				
			}
		});
		btnNewButton_2.setBounds(324, 52, 85, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("-");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String stockid=txt_stock.getText();
				Optional op=null;
				try {				
					op = RealTimeQuote.update(stockid);
					op.setUsername(username);
					System.out.print(op.getUsername());
					System.out.print(op.getStockid());
					System.out.print(op.getStockname());
					System.out.print(op.getStockprice());					
					op.setStockid(stockid);
					o.daleteOPtional(username, stockid);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(o.queryOptionalString(username));
				
				
			}
		});
		btnNewButton_3.setBounds(128, 54, 60, 21);
		contentPane.add(btnNewButton_3);
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setText("使用網路爬蟲更新股價，在自選群組下方框可輸入股票代碼，更新按鈕按下會刷新股價資訊");
		textArea_1.setEnabled(false);
		textArea_1.setEditable(false);
		textArea_1.setBounds(444, 50, 96, 129);
		contentPane.add(textArea_1);
	}
}
