<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SecureApp</title>
</head>
<body>

	<form name="verifyForm" action="VerifyReset" method="post">
	<%
	out.println("<input type='text' name='email' value='" + request.getParameter("u") + "'><BR></p>");
	out.println("<input type='text' name='code' value='" + request.getParameter("code") + "'><BR></p>");
	%>
		<p> <button TYPE="button" Value="Login" onClick="send(this.form);">Reset Password</button></p>
	</form>

<script type="text/javascript">

	function send (form)
		{	
		form.submit(); 
		}
		
	</script>

</body>
</html>