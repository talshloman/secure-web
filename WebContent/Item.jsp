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
                <li>
                    <a href="Profile.jsp">Profile</a>
                </li>
<c:if test = "${users.permissions == 'Admin'}">
                <li>
                    <a href="Upload.jsp">Upload</a>
                </li>
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
					<c:out value="${itemToLook.nameItem}" />
					<!--<small>Item Subheading</small>-->
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Portfolio Item Row -->
		<div class="row">

			<div class="col-md-8">
				<img src=<c:out value="${itemToLook.pathPicture}" /> alt=""
					class="img-responsive">
			</div>

			<div class="col-md-4">
				<a href="Payment.jsp" onclick="check('${itemToLook.nameItem}')" class="btn btn-primary btn-lg">Add to cart</a>
				<h3>Item Description</h3>
				<p>Blah blah blah blah blah blah blah blah blah blah blah blah
					blah blah blah blah blah blah blah blah blah blah blah blah blah
					blah blah blah blah blah blah.</p>
				<h3>Item Details</h3>
				<ul>
					<li>Price item: $<c:out value="${itemToLook.price}" /></li>
					<li>color item: <c:out value="${itemToLook.colorItem}" /></li>
					<li>Size item: <c:out value="${itemToLook.sizeItem}" /></li>
					<li>Exist in store: <c:out value="${itemToLook.existInStore}" /></li>
					<li>How much: <c:out value="${itemToLook.howMuch}" /></li>
					<li>Type: <c:out value="${itemToLook.type}" /></li>
				</ul>
			</div>

		</div>

		<hr>
		
				<!-- Show all the comments -->
		<div class="row">
		<h1>Comments</h1>
		</div>
		
		<!-- Type new comment -->
		<div class="container">
			<form action="NewMassage" method="post" class="form-horizontal">
			<div>
			<!-- Show Comments -->
				<ul id="showData" style="height:200px;width:1000px;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;">
				</ul>
			</div>
			<!-- Type New Message -->
				<div >
					<input type="hidden" name="item" value="${itemToLook.nameItem}">
					 <input style="width:1000px" type="text" name="massage" maxlength="140" class="form-control">
						<button style="width:200px" class="btn btn-primary" TYPE="button" Value="Send" onClick="validation (this.form);">Submit Massage</button>
				</div>
				
			</form>
			<!-- content -->
		</div>
		<!-- container -->

		<script type="text/javascript">
		//Post new comment
			function validation(form) {
				var Massage = form.massage.value;
				var ItemNum = form.item.value;

				if ((checkMessage(Massage, Massage.length)) == 1)
				{
					if((checItemNum(ItemNum, ItemNum.length))==1)
					{
						form.submit();
						location.reload();
					}
					else
						{
						document.getElementById("comment").innerHTML = "The data you entered are not good";
						var iframe = document.getElementById("comment");
						iframe.style.visibility = "visible";
						}
				} else {
					document.getElementById("comment").innerHTML = "The data you entered are not good";
					var iframe = document.getElementById("comment");
					iframe.style.visibility = "visible";
				}
			}
			
			function checItemNum(item, size) {
				for (var i = 0; i < size; i++) {
					if (/[a-zA-Z0-9_]/.test(item[i]) == true) {
						return 1;
					}
				}

				return 0;
			}

			function checkMessage(item, size) {
				for (var i = 0; i < size; i++) {
					if (/[a-zA-Z0-9_]/.test(item[i]) == true) {
						return 1;
					}
				}

				return 0;
			}
			
			function check(numItem)
			{
		        var xmlhttp = new XMLHttpRequest();
		        var item = numItem;
				if((txtSearch(item, item.length)) == 1)
				{
					var url = "CheckItem?item=" + item;
				     try
				     {
				     	xmlhttp.open("post",url,true);
				        xmlhttp.send();
				     }catch(e){
				        	alert("unable to connect to server");
				     }
				}
		    }
		</script>

		<script>
		//Get all comments
			$(document).ready(function() {
					$('.page-content').hide();
					var itemID = "${itemToLook.nameItem}";
					// the URL for the request
					$.get('ForumControl', {
						// Parameter to be sent to server side
						itemID : itemID
					}, function(jsonResponse) {
						$.each(jsonResponse, function(index, value) {
							$("#showData").append("<li>"+value+"</li>");
						});
						$('.form-control').show();
					});
			});
		</script>
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