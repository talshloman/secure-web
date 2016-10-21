<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
  if (session == null)
  {
    %><jsp:forward page="Home.html" /><%
  }
if(session.getAttribute("users") == null)
{
	%><jsp:forward page="Home.html" /><%
}
%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Profile page</title>

    <!-- Bootstrap Core CSS -->
    <link href="CSS/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="CSS/shop-homepage.css" rel="stylesheet">
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="Index.jsp">IWantSomething</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
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
    <!-- /.container -->
</nav>



<div class="container">


    <!-- --------------------------------------------------------------------------------------- -->
    <!-- Start of main content -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4">
            </div>
            <div class="col-md-4">
                <div class="well well-sm">
                        <div class="col-sm-6 col-md-4">
                            <img src=<c:out value="${users.pathPicture}" /> alt="" class="img-rounded img-responsive" />
                        </div>
                        <div class="col-sm-6 col-md-8">
                            <h2>
                                <c:out value="${users.name}" /></h2>
                            <h5>
                                Authorization: <c:out value="${users.permissions}" /></h5>
                            <small><cite title="location:"><c:out value="${users.location}" /><i class="glyphicon glyphicon-map-marker">
                            </i></cite></small>
                            <p>
                                <i class="glyphicon glyphicon-envelope"></i> <c:out value="${users.birthday}" />
                                <i class="glyphicon glyphicon-gift"></i> <c:out value="${users.email}" />
                            <!--  button -->
                                <a href="Logout" class="btn btn-primary ">Logout</a>
                        </div>
                </div>
            </div>
            <div class="col-md-4">
            </div>
        </div>
    </div>


    <!-- End of main content -->
    <!-- --------------------------------------------------------------------------------------- -->


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




</div>
<!-- /.container -->

<!-- --------------------------------------------------------------------------------------- -->

<!-- jQuery -->
<script src="JS/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="JS/bootstrap.min.js"></script>
</body>
</html>