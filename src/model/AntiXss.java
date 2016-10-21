package model;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class AntiXss {
	
	public static boolean isLetters(String name) {
	    return name.matches("[A-Za-z]+");
	}
	
	public static boolean isPassword(String password) {
		boolean isTrue = false;
		
		if(password.length()>1 && password.length()<10)
		{
			if(password.matches("[a-zA-Z0-9]+") == true)
			{
				isTrue = true;
			}
		}
	    return isTrue;
	}
	
	public static boolean isUsername(String username) {
	    return username.matches("[a-zA-Z0-9_]+");
	}
	
	public static boolean isBirthday(String birthday) {
        boolean isBirthday = true;
        try {
            Pattern.compile(birthday);
        } catch (PatternSyntaxException exception) {
            isBirthday = false;
        }
        return isBirthday;
	}
	
	public static boolean isAdress(String adress) {
	    return adress.matches("[A-Za-z\\s0-9]{3,20}");
	}
	
	public static boolean isCodeZip(String zip) {
	    return zip.matches("[0-9]{3,20}");
	}
	
	
	public static boolean isEmail(String email) {
		return org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(email);
	}
	
	public static boolean isPicture(String pic) {
		boolean valid = false;
		int dot = 0;
		int slash = pic.lastIndexOf("\\");
		char[] theNamePic = Arrays.copyOfRange( pic.toCharArray(), slash+1, pic.toCharArray().length);
		String theNamePicStr = new String(theNamePic);
		char[] stringToCharArray = null;
		String[] suffix = {"jpg","gif","png","bmp","JPG", "GIF", "PNG", "BMP"};
		String suffixStr = null;
		if(theNamePicStr.matches("[0-9a-zA-Z.]{3,50}")){
			dot = theNamePicStr.indexOf(".");
			stringToCharArray = Arrays.copyOfRange( theNamePicStr.toCharArray(), dot+1, theNamePicStr.toCharArray().length);
			suffixStr = new String(stringToCharArray);
			for(String check : suffix)
			{
				if(check.equals(suffixStr)){
					valid = true;
				}
			}
		}
		
		return valid;
	}

}
