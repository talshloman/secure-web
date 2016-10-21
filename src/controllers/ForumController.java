package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AntiXss;
import model.Comments;

public class ForumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForumController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null){
			response.sendRedirect("error.jsp");
		}
		String itemID = request.getParameter("itemID");
		if(AntiXss.isUsername(itemID) == false)
		{
			response.sendRedirect("error.jsp");
		}
		Comments getJsonString = new Comments();
		String json = getJsonString.getData(itemID);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
