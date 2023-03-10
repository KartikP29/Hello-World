package dao;

import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.UserDAO;
import com.mysql.cj.protocol.Resultset;

import connection.Conn;
import model.User;

public class RegisterDAO {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private int rs;
	public RegisterDAO(Connection con) {
		this.con = con;
	}
	public int registerUser(User user) throws ClassNotFoundException, GeneralSecurityException {
		String INSERT_USERS_SQL = "INSERT INTO users" +" (name, email, password) VALUES " +" (?, ?, ?);";
        int result = 0;
		try {
			pst = this.con.prepareStatement(INSERT_USERS_SQL);
			//pst.setInt(1, 1);
		    UserDAO ud=new UserDAO(con);
			String ps=ud.MD5(user.getPassword());
			pst.setString(1 ,user.getName());
			pst.setString(2,user.getEmail());
			pst.setString(3,ps);

			System.out.println(pst);
			// Step 3: Execute the query or update query
			result = pst.executeUpdate();

		} catch (SQLException e) {
			
			System.out.println("Username Already Exists");
			
			e.printStackTrace();
		}
		return result;
	}
			
		}
	


	

