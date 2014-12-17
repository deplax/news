package net.news.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.news.user.User;

public class Database {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;

	public Connection getConnection() {
		String url = "jdbc:mysql://192.168.198.129:3306/news";
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

	public void signUp(User user) throws SQLException {
		String sql = "insert into user values(?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());

			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		}
	}

	public User findByUserId(String email) throws SQLException {
		String sql = "select * from user where uid = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			return new User(rs.getString("uid"), rs.getString("password"),
					rs.getString("name"));
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		}

	}

	public void TestConnection() {
		conn = getConnection();
		System.out.println(conn);
	}

}
