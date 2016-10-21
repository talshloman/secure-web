<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="org.sqlite.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SecureApp</title>
</head>
<body>

	<form name="verifyForm" action="VerifyReset" method="post">
		
		<div>
		Enter Password:
			<input type="password" name="password" VALUE="" maxlength="15">
		</div>
		<div>
		Enter Password Again:
			<input type="password" name="verifyPassword" VALUE="" maxlength="15">
		</div>
		<p>
			<button TYPE="button" Value="Login" onClick="validation(this.form);">Reset Password</button>
		</p>
		<%
			out.println("<input type='hidden' name='email' value='" + request.getParameter("u") + "'><BR></p>");
			out.println("<input type='hidden' name='code' value='" + request.getParameter("code") + "'><BR></p>");
		%>
	</form>

	<div id="comment"></div>

	<script type="text/javascript">

	function validation(form)
		{	
			var verifyPassword = form.password.value;
			var Password = form.verifyPassword.value;
			if((checkVerifyPassword(verifyPassword,verifyPassword.length)) == 1)
			{
				if(checkPassword(Password,Password.length) == 1)
				{
					if(verifyPassword === Password)
						{
						document.getElementById("comment").innerHTML = "IS OK";
						var iframe = document.getElementById("comment");  
					    iframe.style.visibility="visible";
						form.submit(); 
						}
					else
						{
						document.getElementById("comment").innerHTML = "Please match the passwords";
						var iframe = document.getElementById("comment");  
					    iframe.style.visibility="visible";
						}
				}
				else
				{
				   	document.getElementById("comment").innerHTML = "The data you entered are not good";
					var iframe = document.getElementById("comment");  
				    iframe.style.visibility="visible";
				}
			}
			else
			{
			   	document.getElementById("comment").innerHTML = "The data you entered are not good";
				var iframe = document.getElementById("comment");  
			    iframe.style.visibility="visible";
			}
		}
	
		
	function checkPassword(password,size){
		
		if(size < 1 || size > 10 || password == null || password == "")
		{
			return 0;
		}
		for(var i = 0;i< size;i++){
			if (/^[a-zA-Z0-9!_]/.test(password[i]) == false) {
		    	return 0;
			}
		}
		return 1;
	}

		function checkVerifyPassword(password,size){
			
			if(size < 1 || size > 10 || password == null || password == "")
			{
				return 0;
			}
			for(var i = 0;i< size;i++){
				if (/^[a-zA-Z0-9!_]/.test(password[i]) == false) {
			    	return 0;
				}
			}
			return 1;
		}
	</script>

</body>
</html>