package net.news.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.news.db.Database;

@WebServlet("/users/signUp")
public class SignUpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String email = req.getParameter("email");
		String emailVerify = req.getParameter("emailVerify");
		String password = req.getParameter("password");
		String passwordVerify = req.getParameter("passwordVerify");
		String name = req.getParameter("name");
		
		
		User user = new User(email, password, name);
		Database db = new Database();
		
		//여기에서 일치여부 확인.
		
		try {
			db.signUp(user);
		} catch (SQLException e) {
			//아이디가 같을 경우에 대한 처리 필요
			e.printStackTrace();
		}
		
		resp.sendRedirect("/article/factory");

		PrintWriter writer = resp.getWriter();
		writer.println(email);
		writer.println(emailVerify);
		writer.println(password);
		writer.println(passwordVerify);
		writer.println(name);

	}

	public boolean checkMatchInfo(String a, String b) {
		if (a == b)
			return true;
		return false;
	}

}
