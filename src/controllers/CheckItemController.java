package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AntiXss;
import model.Item;

public class CheckItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CheckItemController()
	{
		super();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(false);
		String nameItem = request.getParameter("item");
		if(AntiXss.isUsername(nameItem)){
			List<Item> item = (List<Item>)session.getAttribute("listItems");
			boolean isExist = false;
			for (Item itemCheck : item)
			{
				if(itemCheck.getNameItem().equals(nameItem))
				{
					session.setAttribute("itemToLook", itemCheck);
					isExist = true;
					break;
				}
			}
			if(isExist == false)
			{
				rd = request.getRequestDispatcher("error.jsp");
		    	if(session != null){
		    		session.invalidate();
		    	}
		    	rd.forward(request, response);
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
