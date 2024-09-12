package controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.impl.TransactionDaoImpl;
import model.Optional;
import model.Transaction;
import service.RealTimeQuote;



public class StockBuyUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_stockId;
	private static TransactionDaoImpl T=new TransactionDaoImpl();
	private Optional O=null;
	private Double price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockBuyUI frame = new StockBuyUI("123");
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
	public StockBuyUI(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_stockId = new JTextField();
		txt_stockId.setBounds(61, 41, 96, 21);
		contentPane.add(txt_stockId);
		txt_stockId.setColumns(10);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(61, 102, 214, 44);
		contentPane.add(textArea);
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					O=RealTimeQuote.update(txt_stockId.getText());
					textArea.setText("股票代號\t股票名稱\t股票價格\n"
							+ O.getStockid()+"\t"+O.getStockname()+"\t"+O.getStockprice());
					price=O.getStockprice();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(190, 40, 85, 23);
		contentPane.add(btnNewButton);
		

		
		JSpinner sp_stocknumber = new JSpinner();
		sp_stocknumber.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		sp_stocknumber.setBounds(61, 191, 96, 22);
		contentPane.add(sp_stocknumber);
		
		JButton btnNewButton_1 = new JButton("買");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				String stockid=txt_stockId.getText();
				Integer number=(int)sp_stocknumber.getValue();
				System.out.print(username);
				System.out.print("\n");
				System.out.print(time);
				System.out.print("\n");
				System.out.print(stockid);
				System.out.print("\n");
				System.out.print(price);
				System.out.print("\n");
				System.out.print(number);
				
				Transaction data=new Transaction(username,time,stockid,price,number);							
				T.addTransaction(data);
			}
		});
		btnNewButton_1.setBounds(167, 174, 85, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("賣");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				String stockid=txt_stockId.getText();
				Integer number=(int)sp_stocknumber.getValue();
				number=-number;
				System.out.print(username);
				System.out.print("\n");
				System.out.print(time);
				System.out.print("\n");
				System.out.print(stockid);
				System.out.print("\n");
				System.out.print(price);
				System.out.print("\n");
				System.out.print(number);
				
				Transaction data=new Transaction(username,time,stockid,price,number);							
				T.addTransaction(data);
			}
		});
		btnNewButton_2.setBounds(167, 203, 85, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("返回");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUI m=new MenuUI(username);
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(376, 232, 85, 23);
		contentPane.add(btnNewButton_3);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("使用網路爬蟲同步當前股價，輸入股票代碼查詢後，再選擇要買賣的數量");
		textArea_1.setLineWrap(true);
		textArea_1.setEnabled(false);
		textArea_1.setEditable(false);
		textArea_1.setBounds(318, 41, 143, 103);
		contentPane.add(textArea_1);
	}
}
