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




public class AddAccount {

	public String addAccount(String firstName, String lastName, String userName, 
			String password, String birthday, String country, 
			String adreesStreet, String city, int zipCode, String email, String pathPicture) throws ClassNotFoundException
	{
		Connection c = null;
		String result = null;
		PreparedStatement qustion = null;
		int rs;
		int defaultConfimEmail = 0;
		int code = 0;
		Random rand = new Random(); 
		code = rand.nextInt(999999) + 100000; 
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			qustion = c.prepareStatement("INSERT INTO Customer(FirstName, LastName, UserName, Password, Birthday, Country, AdreesStreet, City, ZipCode, PathPicture, Email, ConfirmEmail, code) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
			qustion.setString(1, firstName);
			qustion.setString(2, lastName);
			qustion.setString(3, userName);
			qustion.setString(4, password);
			qustion.setString(5, birthday);
			qustion.setString(6, country);
			qustion.setString(7, adreesStreet);
			qustion.setString(8, city);
			qustion.setInt(9, zipCode);
			qustion.setString(10, pathPicture);
			qustion.setString(11, email);
			qustion.setInt(12, defaultConfimEmail);
			qustion.setInt(13, code);                
			rs = qustion.executeUpdate();
		  if (rs > 0) {
			  result = "success";
			  sendEmail(email, userName, code);
		  } 
		  else
		  {
			  result = "failure";
		  }
	   }
		catch(SQLException  e)
		{
			 System.out.println(e.getMessage());
			result = "SQL ERROR";
		}finally{
			try{
				c.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	private void sendEmail(String email, String user, int code)
	{
		final String username = "iwantsomthingnow";
		final String password = "12345iwantsomthing67890";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("iwantsomthingnow@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email));
					message.setSubject("Testing Subject");
					message.setText("Dear Mail Crawler, http://localhost:8080/SecureDev/verify.jsp?u="
							+user + "&code=" + code
						+ "\n\n No spam to my email, please!");

					Transport.send(message);

					System.out.println("Done");

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}

	}
}

