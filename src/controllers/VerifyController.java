package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AntiXss;
import model.Authenticator;

@WebServlet("/VerifyServlet")
public class VerifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public VerifyController() {
		super();
	}
	
	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * Function that handles the POST request that comes from verify.jsp.
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	*/
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		if(AntiXss.isUsername(request.getParameter("username")) == false){
			response.sendRedirect("error.jsp");
		}
		if(AntiXss.isCodeZip(request.getParameter("code")) == false){
			response.sendRedirect("error.jsp");
		}
		String username = request.getParameter("username");
		int code = Integer.parseInt(request.getParameter("code"));
		RequestDispatcher rd = null;
		Authenticator authenticator = new Authenticator();
		String result = authenticator.verification(username, code);
		
		if (result.equals("success")) 
		{
			rd = request.getRequestDispatcher("VerficationConfirm.html");
		} 
		else
		{
			rd = request.getRequestDispatcher("error.jsp");	
		}
		
		rd.forward(request, response);
	}
 
}