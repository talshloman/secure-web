package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddItem {
	public String addItem(int numberItem, String nameItem, String typeItem, 
			String colorItem, String sizeItem, String existInStore, 
			int howMuch, int priceItem, String pathPicture) throws ClassNotFoundException
	{
		Connection c = null;
		String result = null;
		PreparedStatement qustion = null;
		int rs;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:D:\\WorkSpace\\SecureDev\\resource\\IWantSomthing.db");
			qustion = c.prepareStatement("INSERT INTO ShirtMan(NumberItem, NameItem, Type, ColorItem, SizeItem, ExistInStore, HowMuch, Picture, Price) VALUES(?,?,?,?,?,?,?,?,?);");
			qustion.setInt(1, numberItem);
			qustion.setString(2, nameItem);
			qustion.setString(3, typeItem);
			qustion.setString(4, colorItem);
			qustion.setString(5, sizeItem);
			qustion.setString(6, existInStore);
			qustion.setInt(7, howMuch);
			qustion.setInt(8, priceItem);
			qustion.setString(9, pathPicture);
                
			rs = qustion.executeUpdate();
		  if (rs > 0) {
			  result = "success";
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
}
