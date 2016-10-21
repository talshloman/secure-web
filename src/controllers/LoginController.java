package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.owasp.esapi.ESAPI;

import model.AntiXss;
import model.Authenticator;
import model.InformationDB;
import model.Item;
import model.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public LoginController() {
		super();
	}
	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		HttpSession session = null;
		Cookie cookie = null;
		Authenticator authenticator;
		String result;
		List<Item> item;
		if(AntiXss.isUsername(username) == true)
		{
			if(AntiXss.isPassword(password) == true)
			{
				authenticator = new Authenticator();
				result = authenticator.authenticate(username, password);
				item = new ArrayList<Item>();
				if (result.equals("success")) 
				{
					session = request.getSession();
					InformationDB info = new InformationDB();
					User user = new User();
					user = info.getDetailsOnUser(username);
					item = info.getDetailsItems();
					String nameItem;
					for(int i = 0; i < item.size(); i++)
					{
						nameItem = "item"+i;
						session.setAttribute(nameItem, item.get(i));
					}
					String sessionId = request.getSession().getId();
					session.setAttribute("sessionId", sessionId);
					session.setAttribute("users", user);
					session.setAttribute("listItems", item);
					cookie = new Cookie("user", user.getName());
					cookie.setHttpOnly(true);
					session.setMaxInactiveInterval(30*60);
					response.setHeader("SET-COOKIE", cookie + "; HttpOnly");
					response.setHeader("SET-COOKIE", "JSESSIONID=" + sessionId + "; HttpOnly");
					request.setAttribute(sessionId, sessionId);
					rd = request.getRequestDispatcher("Index.jsp");
				}
				else
				{
					rd = request.getRequestDispatcher("error.jsp");
			    	if(session != null){
			    		session.invalidate();
			    	}
				}
			}
			else
			{
				rd = request.getRequestDispatcher("error.jsp");
		    	if(session != null){
		    		session.invalidate();
		    	}
			}
		}
		else
		{
			rd = request.getRequestDispatcher("error.jsp");
	    	if(session != null){
	    		session.invalidate();
	    	}
		}
		
		rd.forward(request, response);
	}
 
}