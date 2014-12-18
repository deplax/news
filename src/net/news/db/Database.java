package net.news.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.news.article.Article;
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

	public void writeArticle(Article article) throws SQLException {
		String sql = "insert into article(uid, caid, title, contents, lasttime, comment) values(?, ?, ?, ?, now(), 0)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getUid());
			pstmt.setInt(2, article.getCaid());
			pstmt.setString(3, article.getTitle());
			pstmt.setString(4, article.getContents());

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

	public ArrayList<Article> loadArticle(int caid) throws SQLException {
		
		String sql; 
		if (caid == 0)
			sql = "select * from article where 1=? or 1=1";
		else
			sql = "select * from article where caid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Article> articleList = new ArrayList<Article>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, caid);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Article tempArticle = new Article(rs.getInt("aid"),
						rs.getString("uid"), rs.getInt("caid"),
						rs.getString("title"), rs.getString("contents"),
						rs.getString("lasttime"), rs.getInt("comment"));
				articleList.add(tempArticle);
			}
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

			return articleList;
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
	public void deleteArticle(int aid) throws SQLException {
		String sql = "delete from article where aid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);

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

	public void TestConnection() {
		conn = getConnection();
		System.out.println(conn);
	}

}
