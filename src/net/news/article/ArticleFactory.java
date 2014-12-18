package net.news.article;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.news.db.Database;

@WebServlet("/article/factory")

public class ArticleFactory extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int caid = 0;	//기본값, 전체 불러오기
		Database db = new Database();
		ArrayList<Article> articleList = new ArrayList<Article>();
		try {
			articleList = db.loadArticle(caid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nextJSP = "/";
		req.setAttribute("article", articleList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req,resp);
	}
	


	//기사를 불러온다. 인자는 카테고리
	//리턴은 resertset;
	
	//resertset을 탐색하면서 코맨트가 있는지 확인
	//없으면 바로 링크드 리스트에 넣고
	//있으면 댓글을 불러온다.
	
	//댓글은 댓들 펙토리에 문의
	
	//일단 기사를 여기에서 링크드 리스트로 만들어...
	//코멘트도 링크드리스트로 만들어
	
}
