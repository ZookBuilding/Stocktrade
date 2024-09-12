package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.TransactionDao;
import model.Transaction;

public class TransactionDaoImpl implements TransactionDao{
	public static void main(String[] args) {
	}
	

	@Override
	public void addTransaction(Transaction data) {
		Connection conn = DbConnection.getDb();
		String sql = "insert into transaction(username,date, stockid, stockprice, stocknumber) values (?,?,?,?,?);";
		
		try {			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data.getUsername());
			ps.setString(2, data.getDate());
			ps.setString(3, data.getStockid());
			ps.setDouble(4, data.getStockprice());
			ps.setInt(5, data.getStocknumber());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Transaction> queryByUsername(String username) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from transaction where username = ?";
		List<Transaction> da = new ArrayList<Transaction>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction d = new Transaction(username);
				d.setUsername(username);
				d.setDate(rs.getString("date"));
				d.setStockid(rs.getString("stockid"));
				d.setStockprice(rs.getDouble("stockprice"));
				d.setStocknumber(rs.getInt("stocknumber"));				
				da.add(d);
				System.out.print(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return da;
	}
	public String queryStockDetail(String username) {
		String show = "";
		List<Transaction> da = queryByUsername(username);
		if(da.size()>0) {
			for(Transaction i:da) {
				show+=(i.getDate()+"\t"+i.getStockid()+"\t"+i.getStockprice()+"\t"+i.getStocknumber()+"\n");
			}
		}
		return show;
	}

	

}
