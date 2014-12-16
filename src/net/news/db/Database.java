package net.news.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;

	public Connection getConnection() {
		String url = "jdbc:mysql://192.168.42.183:3306/news";
		String id = "deplax";
		String pw = "secret";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			System.out.println("[DB Connection Failed] : " + e.getMessage());
			return null;
		}
	}
	
	public void TestConnection(){
		conn = getConnection();
		System.out.println(conn);
	}
}
