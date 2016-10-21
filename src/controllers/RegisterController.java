package controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.AddAccount;
import model.AntiXss;


@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String pathPicture = null;
	private FileItem fileItem = null;
	private String firstName = null; 
	private String lastName = null; 
	private String userName = null; 
	private String password = null; 
	private String birthday = null; 
	private String country = null; 
	private String adreesStreet = null; 
	private String city = null;
	private int zipCode = 0;
	private String email = null;
	private boolean isAntiXss = true;
	public RegisterController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
	        if (isMultiPart == true) 
	        {
	            FileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            List<FileItem> items = null;
				try {
					items = upload.parseRequest(request);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				
	            Iterator<FileItem> iter = items.iterator();
	            while (iter.hasNext() == true) {
	                fileItem = iter.next();
	                if (fileItem.isFormField()) 
	                {
	                	if(initializationVariables(fileItem) == false){
	                		isAntiXss = false;
	                		break;
	                	}
	                } 
	                else 
	                {
	                	if(AntiXss.isPicture(fileItem.getName()) == true){
	                		pathPicture = pathPic(fileItem);
	                	}
	                	else{
	                		isAntiXss = false;
	                		break;
	                	}
	                }
	            }
	            if(isAntiXss == true)
	            {
	    			RequestDispatcher rd = null;
	    			
	    			AddAccount newAccount = new AddAccount();
	    			String result = null;
	    			try {
	    				result = newAccount.addAccount(firstName, lastName, userName, password, birthday, country, adreesStreet, city, zipCode, email, pathPicture);
	    			} catch (ClassNotFoundException e) {
	    				e.printStackTrace();
	    			}
	    			if (result.equals("success")) 
	    			{
	    				rd = request.getRequestDispatcher("/Waiting.jsp");
	    			} 
	    			else
	    			{
	    				rd = request.getRequestDispatcher("/error.jsp");
	    			}
	    			
	    			rd.forward(request, response);
	            }
	            else
	            {
	            	request.getRequestDispatcher("/error.jsp").forward(request, response);
	            }
		}
	}
	
	private boolean initializationVariables(FileItem fileItem)
	{
		boolean isOk = false;
        if (fileItem.getFieldName().equals("FirstName")) {
        	if(AntiXss.isLetters(fileItem.getString()))
        	{
        		firstName = fileItem.getString();
        		isOk = true;
        	}
        } 
        else if (fileItem.getFieldName().equals("LastName")) {
        	if(AntiXss.isLetters(fileItem.getString()))
        	{
        		lastName = fileItem.getString();
        		isOk = true;
        	}
        } 
        else if (fileItem.getFieldName().equals("UserName")) {
        	if(AntiXss.isUsername(fileItem.getString()))
        	{
        		userName = fileItem.getString();
        		isOk = true;
        	}
        }
        else if (fileItem.getFieldName().equals("Password")) {
        	if(AntiXss.isPassword(fileItem.getString())){
        		password = fileItem.getString();
        		isOk = true;
        	}
        } 
        else if (fileItem.getFieldName().equals("Birthday")) {
        	if(AntiXss.isBirthday(fileItem.getString())){
        		birthday = fileItem.getString();
        		isOk = true;
        	}
        }
        else if (fileItem.getFieldName().equals("Country")) {
        	if(AntiXss.isLetters(fileItem.getString())){
        		country = fileItem.getString();
        		isOk = true;
        	}
        } 
        else if (fileItem.getFieldName().equals("AdreesStreet")) {
        	if(AntiXss.isAdress(fileItem.getString())){
	        	adreesStreet = fileItem.getString();
	        	isOk = true;
        	}
        }
        else if (fileItem.getFieldName().equals("City")) {
        	if(AntiXss.isLetters(fileItem.getString())){
        		city = fileItem.getString();
        		isOk = true;
        	}
        } 
        else if (fileItem.getFieldName().equals("ZipCode")) {
        	if(AntiXss.isLetters(fileItem.getString())){
        		zipCode =Integer.parseInt(fileItem.getString());
        		isOk = true;
        	}
        }
        else if (fileItem.getFieldName().equals("Email")) {
        	if(AntiXss.isEmail(fileItem.getString())){
        		email = fileItem.getString();
        		isOk = true;
        	}
        }
        
        return isOk;
	}
	
	private String pathPic(FileItem fileItem)
	{
		String filePath = null;
    	if(AntiXss.isPicture(fileItem.getName())){
	        String uploadFolder = "C:\\Pictures\\IWantSomthing\\Users";
	        String fileName = new File(fileItem.getName()).getName();
	        filePath = uploadFolder + File.separator + fileName;
	        File uploadedFile = new File(filePath);
	        try {
	        	fileItem.write(uploadedFile);
			} catch (Exception e) {
				System.out.println(e);
			}
    	}
		
		return filePath;
	}
}
