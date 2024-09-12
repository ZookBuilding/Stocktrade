package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.OptionalDao;
import model.Optional;
import service.RealTimeQuote;

public class OptionalDaoImpl implements OptionalDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void addOptional(Optional data) {
		Connection conn = DbConnection.getDb();
		String sql = "insert into optional(username, stockid, stockname, stockprice) values (?,?,?,?);";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data.getUsername());
			ps.setString(2, data.getStockid());
			ps.setString(3, data.getStockname());
			ps.setDouble(4, data.getStockprice());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Optional> queryOptional(String username) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from optional where username = ?";
		List<Optional> da = new ArrayList<Optional>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Optional d = new Optional(username);
				d.setUsername(rs.getString("username"));
				d.setStockid(rs.getString("stockid"));
				d.setStockname(rs.getString("stockname"));
				d.setStockprice(rs.getDouble("stockprice"));
				
				da.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return da;
	}
	public String queryOptionalString(String username) {
		String show = "";
		List<Optional> da = queryOptional(username);
		if(da.size()>0) {
			for(Optional i:da) {
				show+=(i.getStockid()+"\t"+i.getStockname()+"\t"+i.getStockprice()+"\n");
			}
		}
		return show;
	}
	public void updateOprionalList(List<Optional> o) {
		if(o.size()>0) {
			for(Optional i:o) {
				updateOptional(i.getStockid());
			}
		}
	}

	@Override
	public void updateOptional(String stockid){
		Connection conn = DbConnection.getDb();
		String sql = "update Optional set stockprice=?"
				+ "where stockid = ?";
		Optional o=null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			try {
				o = RealTimeQuote.update(stockid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.setDouble(1, o.getStockprice());
			ps.setString(2, stockid);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void daleteOPtional(String username,String stockid) {
		Connection conn = DbConnection.getDb();
		String sql = "delete from optional where stockid= ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stockid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
