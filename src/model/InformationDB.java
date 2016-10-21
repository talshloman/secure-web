package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class InformationDB {
	
	public String checkIfItemExist(String item)
	{
		Connection c = null;
		String result = null;
		ResultSet rs = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			PreparedStatement qustion = c.prepareStatement("SELECT * FROM ShirtMan Where NameItem = ?");
			qustion.setString(1, item);
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
	
	public User getDetailsOnUser(String username)
	{
		User userDatail = null;
		Connection c = null;
		ResultSet rs = null;
		try{
			Class.forName("org.sqlite.JDBC");
			
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			PreparedStatement qustion = c.prepareStatement("SELECT * FROM Customer WHERE UserName = ?");
			qustion.setString(1, username);
			rs = qustion.executeQuery();
		  if (rs.next()) {
			  userDatail = new User();
			  userDatail.setName(rs.getString("FirstName") +" " + rs.getString("LastName"));
			  userDatail.setBirthday(rs.getString("Birthday"));
			  userDatail.setPathPicture(rs.getString("PathPicture"));
			  userDatail.setUsername(rs.getString("UserName"));
			  userDatail.setLocation(rs.getString("Country") + "," + rs.getString("City"));
			  userDatail.setEmail(rs.getString("Email"));
			  qustion = c.prepareStatement("SELECT c.UserName FROM Customer as c, Admin as a WHERE c.UserName = ? And a.UserName = ?");
			  qustion.setString(1, username);
			  qustion.setString(2, username);
			  rs = qustion.executeQuery();
			  if (rs.next()) 
			  {
				  userDatail.setPermissions("Admin");
			  }
			  else
			  {
				  userDatail.setPermissions("User");
			  }
		  } 
	   }
		catch(Exception e)
		{
			System.out.println(e);
		}finally{
			try{
				c.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return userDatail;
	}
	
	public List<Item> getDetailsItems()
	{
		List<Item> itemList = new ArrayList<Item>();
		Item item = null;
		Connection c = null;
		ResultSet rs = null;
		try{
			Class.forName("org.sqlite.JDBC");
			
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			PreparedStatement qustion = c.prepareStatement("SELECT * FROM ShirtMan");
			rs = qustion.executeQuery();
			while(rs.next()) {
			  item = new Item();
			  item.setNameItem(rs.getString("NameItem"));
			  item.setType(rs.getString("Type"));
			  item.setColorItem(rs.getString("ColorItem"));
			  item.setSizeItem(rs.getString("SizeItem"));
			  item.setExistInStore(rs.getString("ExistInStore"));
			  item.setHowMuch(rs.getInt("HowMuch"));
			  item.setPathPicture(rs.getString("Picture"));
			  item.setPrice(rs.getInt("Price"));
			  itemList.add(item);
		  } 
	   }
		catch(Exception e)
		{
			System.out.println(e);
		}finally{
			try{
				c.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return itemList;
	}
	
	public Item getItem(String nameItem)
	{
		Item item = null;
		Connection c = null;
		ResultSet rs = null;
		try{
			Class.forName("org.sqlite.JDBC");
			
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			PreparedStatement qustion = c.prepareStatement("SELECT * FROM ShirtMan WHERE NameItem = ?");
			qustion.setString(1, nameItem);
			rs = qustion.executeQuery();
			while(rs.next()) {
			  item = new Item();
			  item.setNameItem(rs.getString("NameItem"));
			  item.setType(rs.getString("Type"));
			  item.setColorItem(rs.getString("ColorItem"));
			  item.setSizeItem(rs.getString("SizeItem"));
			  item.setExistInStore(rs.getString("ExistInStore"));
			  item.setHowMuch(rs.getInt("HowMuch"));
			  item.setPathPicture(rs.getString("Picture"));
			  item.setPrice(rs.getInt("Price"));
		  } 
	   }
		catch(Exception e)
		{
			System.out.println(e);
		}finally{
			try{
				c.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return item;
	}
}
