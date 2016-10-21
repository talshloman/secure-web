package model;

import java.sql.*;


public class Authenticator {

	public String authenticate(String username, String password) 
	{
		Connection c = null;
		String result = null;
		ResultSet rs = null;
		try{
			Class.forName("org.sqlite.JDBC");
			
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			PreparedStatement qustion = c.prepareStatement("SELECT * FROM Customer WHERE UserName = ? AND Password = ? And ConfirmEmail = ?");
			qustion.setString(1, username);
			qustion.setString(2, password);
			qustion.setInt(3, 1);
			rs = qustion.executeQuery();
		  if (rs.next()) {
			  result = "success";
		  } 
		  else
		  {
			  result = "failure";
		  }
	   }
		catch(Exception e)
		{
			result = "SQL ERROR";
		}finally{
			try{
				c.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String verification(String username, int code) 
	{
		Connection c = null;
		String result = null;
		ResultSet rs = null;
		try{
			Class.forName("org.sqlite.JDBC");
			
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			PreparedStatement qustion = c.prepareStatement("SELECT * FROM Customer WHERE UserName = ? AND code = ?");
			qustion.setString(1, username);
			qustion.setInt(2, code);
			rs = qustion.executeQuery();
		  if (rs.next()) {
			  result = "success";
			  try
			  {
				PreparedStatement ps = c.prepareStatement("UPDATE Customer SET ConfirmEmail = 1 WHERE UserName=?");
			  	ps.setString(1, username);
			  	ps.executeUpdate();
			  }
			  catch (SQLException e)
			  {
			    // log the exception
			    System.out.println(e);
			  }
		  } 
		  else
		  {
			  result = "failure";
		  }
	   }
		catch(Exception e)
		{
			result = "SQL ERROR";
		}finally{
			try{
				c.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String checkUsername(String username)
	{
		Connection c = null;
		String result = null;
		ResultSet rs = null;
    	    try {
				Class.forName("org.sqlite.JDBC");
    	    c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
            PreparedStatement ps = c.prepareStatement("SELECT  * FROM Customer WHERE UserName = ?",
            		ResultSet.TYPE_SCROLL_SENSITIVE);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()){
            	result = "User already exists";
            }else{
            	result = "User name is valid";
            }
        }catch (ClassNotFoundException e) {
        	System.out.println(e);
		}
    	    catch (SQLException e){
            System.out.println(e);  
        }
    	    return result;
	}
	
	public String CheckAdmin(String username)
	{
		Connection c = null;
		String result = null;
		ResultSet rs = null;
    	    try {
				Class.forName("org.sqlite.JDBC");
    	    c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
            PreparedStatement ps = c.prepareStatement("SELECT  * FROM Customer, Admin WHERE Customer.UserName = ? And Customer.UserName =?",
            		ResultSet.TYPE_SCROLL_SENSITIVE);
            ps.setString(1,username);
            ps.setString(2,username);
            rs = ps.executeQuery();
            if(rs.next()){
            	result = "you admin";
            }else{
            	result = "you not admin";
            }
        }catch (ClassNotFoundException e) {
        	System.out.println(e);
		}
    	    catch (SQLException e){
            System.out.println(e);  
        }
    	    return result;
	}
	
	public String verificationReset(String username, int code) {
		Connection c = null;
		String result = null;
		ResultSet rs = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			PreparedStatement qustion = c.prepareStatement("SELECT * FROM Customer WHERE Email = ? AND code = ?");
			qustion.setString(1, username);
			qustion.setInt(2, code);
			rs = qustion.executeQuery();
			if (rs.next()) {
				result = "success";
			} else {
				result = "failure";
			}
		} catch (Exception e) {
			result = "SQL ERROR";
		} finally {
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}