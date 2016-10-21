package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ResetPassword {

	private String email;
	private int code;
	
	public String resetPassword(String email,String password)
	{
		String result = null;
		Connection c = null;
		PreparedStatement qustion = null;
		int rs;
		try {
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			qustion = c.prepareStatement("UPDATE Customer SET Password = ? WHERE Email = ? And ConfirmEmail = ?");
			qustion.setString(1, password);
			qustion.setString(2, email);
			qustion.setInt(3, 1);
			rs = qustion.executeUpdate();
			if (rs > 0) {
				result = "success";
			} else {
				result = "failure";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			result = "SQL ERROR";
		} finally {
			try {
				c.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	public String resetSendEmail(String email) throws ClassNotFoundException {
		this.email = email;
		String result = null;
		Connection c = null;
		PreparedStatement qustion = null;
		int rs;
		code = 0;
		Random rand = new Random();
		code = rand.nextInt(999999) + 100000;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			qustion = c.prepareStatement("UPDATE Customer SET Code = ? WHERE Email = ? And ConfirmEmail = ?");
			qustion.setInt(1, code);
			qustion.setString(2, email);
			qustion.setInt(3, 1);
			rs = qustion.executeUpdate();
			if (rs > 0) {
				result = sendEmail();
			} else {
				result = "failure";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			result = "SQL ERROR";
		} finally {
			try {
				c.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	private String sendEmail() {
		final String username = "iwantsomthingnow";
		final String password = "12345iwantsomthing67890";

		String result = null;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("iwantsomthingnow@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Testing Subject");
			message.setText("Hi! Your password reset link: \n http://localhost:8080/SecureDev/VerifyReset.jsp?u=" + email
					+ "&code=" + code + "\n\n");

			Transport.send(message);

			System.out.println("Done");
			result = "success";

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return result;

	}

}
