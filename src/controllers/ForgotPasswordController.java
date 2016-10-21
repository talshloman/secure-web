package controllers;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AntiXss;
import model.ResetPassword;

public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgotPasswordController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		String email = request.getParameter("Email");
		if(AntiXss.isEmail(email))
		{
			System.out.println("Sending email " + email);
			ResetPassword resetPass = new ResetPassword();
			String result = null;
			try {
				result = resetPass.resetSendEmail(email);
				if (result.equals("success")) {
					rd = request.getRequestDispatcher("/Waiting.jsp");
				} else {
					rd = request.getRequestDispatcher("/error.jsp");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
	}

}
