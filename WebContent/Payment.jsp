<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	if (session == null) {
%><jsp:forward page="Home.html" />
<%
	}
	if (session.getAttribute("users") == null) {
%><jsp:forward page="Home.html" />
<%
	}
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Item page</title>

<!-- Bootstrap Core CSS -->
<link href="CSS/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="CSS/shop-homepage.css" rel="stylesheet">


<!-- jQuery -->
<script src="JS/jquery-3.1.0.min.js" type="text/javascript"></script>

</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1"></button>
			<a class="navbar-brand" href="Index.jsp">IWantSomething</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="Profile.jsp">Profile</a></li>
				<c:if test="${users.permissions == 'Admin'}">
					<li><a href="Upload.jsp">Upload</a></li>
				</c:if>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>



	<!-- --------------------------------------------------------------------------------------- -->
	<!-- Page Content -->
	<div class="container">

		<!-- --------------------------------------------------------------------------------------- -->
		<!-- Start of main content -->



		<!-- Portfolio Item Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<c:out value="${itemToLook.nameItem}" /> - $<c:out value="${itemToLook.price}"/>
					<!--<small>Item Subheading</small>-->
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Portfolio Item Row -->
		<div class="row">

			<div class="col-md-8">
				<form action="CreditCard" method="post">
					<h1>Credit Card Information</h1>
					<div>
						<label for="numberInput" class="col-lg-2 control-label">Card Number</label>
							<input type="text" name="number"
							class="form-control" VALUE="4293823865785698" maxlength="20">
					</div>
					<div>
						<label for="typeInput" class="col-lg-2 control-label">Card
							Type</label>
							 <input type="text" name="type"
							class="form-control" VALUE="Visa" maxlength="20">
					</div>
					<div>
						<button TYPE="button" Value="Enter" class="btn btn-primary"
							onClick="validation (this.form);">Pay</button>
					</div>
				</form>
				<script type="text/javascript">

	function validation (form)
		{	
			var Number = form.number.value;
			var Type = form.type.value;
			
			if((checkNumber(Number,Number.length)) == 1)
			{
				if(checkType(Type,Type.length) == 1)
				{
					form.submit(); 
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
	
		
	function checkNumber(item, size)
	{
		for(var i = 0;i < size;i++){
			if (/[0-9_]/.test(item[i]) == true) 
			{
		    	return 1;
			}
		}
		
		return 0;
	}

	function checkType(password, size)
	{
		for(var i = 0;i < size;i++){
			if (/[a-zA-Z_]/.test(item[i]) == true) 
			{
		    	return 1;
			}
		}
		
		return 0;
	}
	</script>
			</div>

			<div class="col-md-4">
				<img src=<c:out value="${itemToLook.pathPicture}" /> alt=""
					class="img-responsive">
			</div>

		</div>


	</div>
	<!-- /.container -->
	<hr>
	<!-- Footer -->
	<footer>
	<div class="row">
		<div class="col-lg-12">
			<button type="button" class="btn btn-link">About Us</button>
			<button type="button" class="btn btn-link">Help</button>
			<button type="button" class="btn btn-link">Jobs</button>
			<button type="button" class="btn btn-link">Terms</button>
			<button type="button" class="btn btn-link">Privacy</button>
			<button type="button" class="btn btn-link">Contact Us</button>
		</div>
	</div>
	</footer>


	<!-- --------------------------------------------------------------------------------------- -->


	<!-- Bootstrap Core JavaScript -->
	<script src="JS/bootstrap.min.js"></script>
</body>
</html>