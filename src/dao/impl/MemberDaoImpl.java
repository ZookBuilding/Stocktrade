package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDaoImpl a=new MemberDaoImpl();
		a.addMember("abc","123");

	}

	@Override
	public void addMember(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String sql="insert into member(username, password) values (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Member queryUsername(String username) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String sql = "select * from member where username = ?";
		Member da = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				da = new Member();
				da.setUsername(rs.getString("username"));
				da.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return da;
	}

}
