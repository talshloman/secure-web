package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AntiXss;
import model.InformationDB;
import model.Item;

public class SearchItemController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public SearchItemController()
	{
		super();
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException
	{
		Item item = null;
		HttpSession session = request.getSession(false);
		RequestDispatcher rd = null;
		String  nameItem = request.getParameter("item");
		if(AntiXss.isUsername(nameItem) == true){
		  InformationDB information = new InformationDB();
		  String result = information.checkIfItemExist(nameItem);
 			response.setContentType("text/html");
 			PrintWriter out = response.getWriter();
          if(result.contentEquals("success"))
          {
        	  item = information.getItem(nameItem);
        	  session.setAttribute("itemToLook", item);
        	  out.println("item exists");
        	  
          }
   		  else{
   			out.println("item not exists");
		  }
		}
		else
		{
			rd = request.getRequestDispatcher("error.jsp");
	    	if(session != null){
	    		session.invalidate();
	    	}
			rd.forward(request, response);
		}
	}
}
