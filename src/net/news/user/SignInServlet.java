package net.news.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/signIn")
public class SignInServlet extends HttpServlet {
	public static final String SESSION_USER_ID = "email";

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter(SESSION_USER_ID);
		String password = request.getParameter("password");

		try {
			User.login(email, password);
			HttpSession session = request.getSession();
			session.setAttribute(SESSION_USER_ID, email);
			response.sendRedirect("/");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

//	private void forwardJSP(HttpServletRequest request,
//			HttpServletResponse response, String errorMessage)
//			throws ServletException, IOException {
//		request.setAttribute("errorMessage", errorMessage);
//		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
//		rd.forward(request, response);
//	}
}
