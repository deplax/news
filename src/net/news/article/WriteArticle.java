package net.news.article;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.news.db.Database;
import net.news.user.SignInServlet;

@WebServlet("/article/write")

public class WriteArticle extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute(SignInServlet.SESSION_USER_ID);
		int caid = Integer.parseInt(req.getParameter("category"));
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		//aid uid caid title contents lasttime comment
		Article article = new Article(email, caid, title, contents);
		Database db = new Database();
		try {
			db.writeArticle(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(title);
		System.out.println(caid);
		System.out.println(contents);
		
		//DB에 저장해야지
		
		
		resp.sendRedirect("/article/factory");
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		System.out.println("in");
//		String nextJSP = "/signIn.jsp";
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//		dispatcher.forward(req,resp);
//		return;
//	}
}