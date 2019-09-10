package kr.co.itcen.bookmall.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");	
			String url = "jdbc:mysql://192.168.1.69:3306/bookmall?characterEncoding=utf8";

			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver: "+e);
		}
		
		return connection;
	}
}
