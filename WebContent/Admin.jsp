<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin page</title>

    <!-- Bootstrap Core CSS -->
    <link href="CSS/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="CSS/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
            <a class="navbar-brand" href="index.html">IWantSomething</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="upload.html">Upload</a>
                </li>
                <li>
                    <a href="profile.html">Profile</a>
                </li>
                <li>
                    <a href="cart.html">Cart</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>



<!-- --------------------------------------------------------------------------------------- -->

<!-- Page Content -->
<div class="container">


    <!-- --------------------------------------------------------------------------------------- -->
    <!-- Start of main content -->

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4">
            </div>
            <div class="col-md-4">
                <div class="alert alert-dismissible alert-info">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    You are in the <strong>admin</strong> page!
                     </div>
            </div>
            <div class="col-md-4">
            </div>
        </div>
    </div>
    <!-- /.row -->


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
                <p> &copy; Secure Development Project 2016</p>
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