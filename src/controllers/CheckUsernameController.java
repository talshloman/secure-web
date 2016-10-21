package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AntiXss;
import model.Authenticator;

public class CheckUsernameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException
	{
		RequestDispatcher rd = null;
		  String  username = request.getParameter("username");
		  if(AntiXss.isUsername(username))
		  {
			  Authenticator authenticator = new Authenticator();
			  String result = authenticator.checkUsername(username);
			  response.setContentType("text/html");
			  PrintWriter out = response.getWriter();
	          if(result.contentEquals("User already exists")){
	        	  out.println(result);
	          }else{
	        	  out.println(result);
	          }
		  }
		  else{
				rd = request.getRequestDispatcher("error.jsp");
		    	rd.forward(request, response);
		  }
	}
}
