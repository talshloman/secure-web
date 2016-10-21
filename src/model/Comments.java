package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Comments {

	public String uploadMassage(String message, String itemNum) {
		Connection c = null;
		String result = null;
		PreparedStatement qustion = null;
		int rs;
		try {
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			qustion = c.prepareStatement("INSERT INTO Comments(Message,Item) VALUES(?,?);");
			qustion.setString(1, message);
			qustion.setString(2, itemNum);

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

	public String getData(String itemNum) {
		
		String jsonString = null;
		
		Connection c = null;
		ResultSet rs = null;
    	    try {
				Class.forName("org.sqlite.JDBC");
    	    c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
            PreparedStatement ps = c.prepareStatement("SELECT  * FROM Comments WHERE Item = ?");
            ps.setString(1,itemNum);
            rs = ps.executeQuery();
            
            List<String> result = new ArrayList<String>();
            
            while (rs.next()) {
            	String message = rs.getString("Message");
            	result.add(message);
            }
            
            jsonString = new Gson().toJson(result);
            
        }catch (ClassNotFoundException e) {
        	System.out.println(e);
		}
    	    catch (SQLException e){
            System.out.println(e);  
        }
    	   // return result;
		
		return jsonString;
	}
}
