package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AntiXss;
import model.Authenticator;
import model.ResetPassword;

public class VerifyResetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VerifyResetController() 
	{
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(AntiXss.isEmail(request.getParameter("email")) == false){
			response.sendRedirect("error.jsp");
		}
		if(AntiXss.isCodeZip(request.getParameter("code")) == false){
			response.sendRedirect("error.jsp");
		}
		String email = request.getParameter("email");
		int code = Integer.parseInt(request.getParameter("code"));
		String password = request.getParameter("password");
		RequestDispatcher rd = null;

		Authenticator authenticator = new Authenticator();
		String result = authenticator.verificationReset(email, code);

		if (result.equals("success")) {

			if (password != null) {
				ResetPassword resetPass = new ResetPassword();
				result = resetPass.resetPassword(email, password);

				if (result.equals("success")) {
					rd = request.getRequestDispatcher("VerficationConfirmForResetPassword.jsp");
				} else {
					rd = request.getRequestDispatcher("error.jsp");
				}

			} else {
				rd = request.getRequestDispatcher("Reset.jsp?u="+email+"&code="+code);
			}

		} else {
			rd = request.getRequestDispatcher("error.jsp");
		}

		rd.forward(request, response);
	}

}