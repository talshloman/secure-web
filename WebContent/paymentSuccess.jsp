<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	if (session == null) {
%><jsp:forward page="Home.html" />
<%
	}
	if (session.getAttribute("CreditToken") == null) {
%><jsp:forward page="Home.html" />
<%
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Refresh" content="2;url=Index.jsp">
<title>PaymentSuccess</title>
</head>
<body>
<h1>Your Payment was successful!</h1><br>
</body>
</html>