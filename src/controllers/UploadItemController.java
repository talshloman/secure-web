package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.AddItem;
import model.AntiXss;

public class UploadItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String numberItemStr;
	int numberItem;
	String nameItem;
	String typeItem;
	String colorItem;
	String sizeItem;
	String existInStore;
	String howMuchStr;
	int howMuch;
	String priceItemStr;
	int priceItem;
	String pathPicture = null;
	FileItem fileItem = null;
	boolean isAntiXss = true;
	
	
	public UploadItemController()
	{
		super();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if(session == null)
		{
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
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
            if(isAntiXss = true)
            {
            	RequestDispatcher rd = null;
    			
    			AddItem newItem = new AddItem();
    			String result = null;
    			try {
    				result = newItem.addItem(numberItem, nameItem, typeItem, 
    						colorItem, sizeItem, existInStore, 
    						howMuch, priceItem, pathPicture);
    			} catch (ClassNotFoundException e) {
    				e.printStackTrace();
    			}
    			if (result.equals("success")) 
    			{
    				rd = request.getRequestDispatcher("/success.jsp");
    			} 
    			else
    			{
    				rd = request.getRequestDispatcher("/error.jsp");
    			}
    			
    			rd.forward(request, response);
            }
            else{
            	request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }
		
	}
	
	private boolean initializationVariables(FileItem fileItem)
	{
		boolean isOK = false;
        if (fileItem.getFieldName().equals("NumberItem")) {
        	if(AntiXss.isCodeZip(fileItem.getString())){
            	numberItemStr = fileItem.getString();
            	numberItem = Integer.parseInt(numberItemStr);
            	isOK = true;
        	}
        } 
        else if (fileItem.getFieldName().equals("NameItem")) {
        	if(AntiXss.isEmail(fileItem.getString())){
        		nameItem = fileItem.getString();
        		isOK = true;
        	}
        } 
        else if (fileItem.getFieldName().equals("TypeItem")) {
        	if(AntiXss.isLetters(fileItem.getString()))
        	{
            	typeItem = fileItem.getString();
            	isOK = true;
        	}
        }
        else if (fileItem.getFieldName().equals("ColorItem")) {
        	if(AntiXss.isLetters(fileItem.getString()))
        	{
        		colorItem = fileItem.getString();
            	isOK = true;
        	}
        } 
        else if (fileItem.getFieldName().equals("SizeItem")) {
        	if(AntiXss.isLetters(fileItem.getString()))
        	{
        		sizeItem = fileItem.getString();
            	isOK = true;
        	}
        }
        else if (fileItem.getFieldName().equals("ExistInStore")) {
        	if(AntiXss.isLetters(fileItem.getString()))
        	{
        		existInStore = fileItem.getString();
            	isOK = true;
            	if(existInStore == "1")
            	{
            		existInStore = "true";
            	}
            	else
            	{
            		existInStore = "false";
            	}
        	}
        } 
        else if (fileItem.getFieldName().equals("HowMuch")) {
        	if(AntiXss.isLetters(fileItem.getString()))
        	{
            	howMuchStr = fileItem.getString();
            	howMuch = Integer.parseInt(howMuchStr);
            	isOK = true;
        	}
        }
        else if (fileItem.getFieldName().equals("PriceItem")) {
        	if(AntiXss.isLetters(fileItem.getString()))
        	{
            	priceItemStr = fileItem.getString();
            	priceItem = Integer.parseInt(priceItemStr);
            	isOK = true;
        	}
        }
        return isOK;
	}
	
	private String pathPic(FileItem fileItem)
	{
		String filePath = null;
		if(AntiXss.isPicture(fileItem.getName())){
	        String uploadFolder = "C:\\Pictures\\IWantSomthing\\Products";
	        String fileName = new File(fileItem.getName()).getName();
	        filePath = uploadFolder + File.separator + fileName;
	        File uploadedFile = new File(filePath);
	        System.out.println(uploadFolder);
	        System.out.println(fileName);
	        System.out.println(filePath);
	        // saves the file to upload directory
	        try {
	        	fileItem.write(uploadedFile);
			} catch (Exception e) {
				System.out.println(e);
			}	
		}
		return filePath;
	}
}
