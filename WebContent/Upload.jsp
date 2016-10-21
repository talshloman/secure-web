<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
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
<c:if test = "${users.permissions != 'Admin'}">
<c:redirect url="Home.html"/>
</c:if>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Upload Item</title>

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
                <li>
                    <a href="Upload.jsp">Upload</a>
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

    <div class="container">
        <div class="col-md-4"></div>
        <div class="col-md-4">

            <form name = "Upload" action="UploadItem" method="post" enctype="multipart/form-data">
                <div class="form-group">

                    <label for="exampleInputEmail1">
                        Number item:
                    </label>
                    <input type="text" name ="NumberItem" value="" class="form-control" pattern="[0-9]{1,10}" id="exampleInputEmail1" />
                </div>
                <div class="form-group">

                    <label for="exampleInputPassword1">
                        Name item:
                    </label>
                    <input type="text" name="NameItem"  value="" class="form-control" pattern="[A-Za-z0-9]{1,15}" id="exampleInputPassword1" />
                </div>
                <div class="form-group">

                    <label for="exampleInputEmail1">
                        Type item:
                    </label>
                    <input type="text" name="TypeItem" value="" class="form-control" pattern="[A-Za-z]{1,3}" id="exampleInputEmail1" />
                </div>
                <div class="form-group">

                    <label for="exampleInputEmail1">
                        Color item:
                    </label>
                    <input type="text" name="ColorItem" value="" class="form-control" pattern="[A-Za-z]{1,7}" id="exampleInputEmail1" />
                </div>
                <div class="form-group">

                    <label for="exampleInputEmail1">
                        Size item:
                    </label>
                    <input type="text" name="SizeItem" value="" class="form-control" pattern="[s,S,m,M,l,L,xl,XL,xxl,XXL]{1,3}" id="exampleInputEmail1" />
                </div>
                <div class="form-group">

                    <label for="exampleInputEmail1">
                        Exist in store:
                    </label>
                    <input type="text" name="ExistInStore" value="" class="form-control"  id="exampleInputEmail1" />
                </div>
                <div class="form-group">

                    <label for="exampleInputEmail1">
                       How much:
                    </label>
                    <input type="text" name="HowMuch" value="" class="form-control" pattern="[0-1]{1}" id="exampleInputEmail1" />
                </div>
                <div class="form-group">

                    <label for="exampleInputEmail1">
                        Price item:
                    </label>
                    <input type="text" name="PriceItem" value="" class="form-control" pattern="[0-9]{1,4}" id="exampleInputEmail1" />
                </div>
                <div class="form-group">

                    <label for="files">
                        Picture:
                    </label>
                    <input type="file" id="files" name="Files" value = "" accept="image/.,.png,.gif,.jpg" multiple="multiple" />
                    <p class="help-block">
                        Example block-level help text here.
                    </p>
                </div>
                <input TYPE="sumbit" value="UploadFiles" class="btn btn-lg btn-primary"/>
            </form>
            <div id="comment"></div>
        </div>
        <div class="col-md-4"></div>
    </div>

    <!-- you need to include the ShieldUI CSS and JS assets in order for the Upload widget to work
    <link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
    <script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
    -->


    <script type="text/javascript">
        jQuery(function ($) {
            $("#files").shieldUpload();
        });
    </script>


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