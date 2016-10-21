package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AntiXss;
import model.Comments;
import model.User;

public class NewMassageController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public NewMassageController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
 
		String itemNum = request.getParameter("item");
		String massage = request.getParameter("massage");
		RequestDispatcher rd = null;
		HttpSession session = null;
 
		session = request.getSession(false);
		if(session == null){
			response.sendRedirect("error.jsp");
		}
		if(AntiXss.isUsername(itemNum) == false)
		{
			response.sendRedirect("error.jsp");
		}
		if(AntiXss.isAdress(massage) == false)
		{
			response.sendRedirect("error.jsp");
		}
		User user = (User) session.getAttribute("users");
		String text = user.getName()+": "+massage;
		Comments uploadText = new Comments();
		String result = uploadText.uploadMassage(text,itemNum); 
		
		if (result.equals("success")) 
		{
			rd = request.getRequestDispatcher("Item.jsp");
		}
		else
		{
			rd = request.getRequestDispatcher("error.jsp");
		}
		
		rd.forward(request, response);
	}
}
