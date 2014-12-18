package net.news.article;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.news.db.Database;

@WebServlet("/article/delete")
public class DeleteArticle extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int aid = Integer.parseInt(req.getParameter("aid"));
		Database db = new Database();
		try {
			db.deleteArticle(aid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(aid);
		resp.sendRedirect("/article/factory");
	}
}
