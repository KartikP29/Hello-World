package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	
	public static Connection connection=null;
	public static Connection connect() throws SQLException, ClassNotFoundException{
		
		if(connection==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytestdb?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
			System.out.println("connected");
		}
		
	return connection;
	}

}
