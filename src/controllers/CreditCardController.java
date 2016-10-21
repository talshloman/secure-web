package controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AntiXss;

public class CreditCardController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	String numberStr;
	String type;
	int number;
	RequestDispatcher rd;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
 
		numberStr = request.getParameter("number");
		type = request.getParameter("type");
		rd = null;
		HttpSession session = request.getSession(false);

		if(session != null){
			if(AntiXss.isCodeZip(numberStr) == true){
				if(AntiXss.isLetters(type) == true)
				{
					Random rand = new Random(); 
					int Token = rand.nextInt(999999) + 100000; 
					session.setAttribute("CreditToken",Token);
						rd = request.getRequestDispatcher("paymentSuccess.jsp");
				}
				else
				{
					rd = request.getRequestDispatcher("Payment.jsp");
				}
				rd.forward(request, response);
			}
			else
			{
		    	if(session != null){
		    		session.invalidate();
		    	}
		    	response.sendRedirect("error.jsp");
			}
		}
	} 
}
