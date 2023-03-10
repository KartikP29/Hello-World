package dao;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;


	public class UserDAO {
		private Connection con;
		private String query;
		private PreparedStatement pst;
		private ResultSet rs;
		public UserDAO(Connection con) {
			this.con = con;
		}
		public User userLogin(String email, String password) throws GeneralSecurityException {
			User user=null;
		try {
			query="select * from users where email=? and password=?";
			pst=this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2,MD5(password));
			rs=pst.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
		}
		public String MD5(String s) throws GeneralSecurityException {
			MessageDigest m=MessageDigest.getInstance("MD5");
			m.update(s.getBytes(),0,s.length());
			return new BigInteger(1,m.digest()).toString(16);
			}
	}
