<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>IWantSomething</title>

    <!-- Bootstrap Core CSS -->
    <link href="CSS/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="CSS/shop-homepage.css" rel="stylesheet">

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
</head>
<body>
 <!-- Navigation -->
 <FORM Name = "searchForm" ACTION="" METHOD="" maxlength="20" size=20>
            Please enter what you want to search:
            <BR>
            <INPUT TYPE="TEXT" NAME="txtSearch"><BR>
            <button TYPE="button"  Value="search" onClick="checkExist()">search</button><BR>
            <span id="answer"></span><br>
 </FORM>
 	<script>
	function checkExist()
	{
        var xmlhttp = new XMLHttpRequest();
        var item = document.forms["searchForm"]["txtSearch"].value;
		if((txtSearch(item, item.length)) == 1)
		{
			var url = "SearchItem?item=" + item;
		    xmlhttp.onreadystatechange = function()
		    {
			    if(xmlhttp.readyState == 4 && xmlhttp.status == 200)
			    {
			    	if(xmlhttp.responseText.trim() == 'item exists')
			        {
			        	document.getElementById("answer").style.color = "green";
	                    document.getElementById("answer").innerHTML = xmlhttp.responseText;
	                    document.location.href='Item.jsp';
			        }
			        else
			        {
			        	document.getElementById("answer").style.color = "red";
	                    document.getElementById("answer").innerHTML = xmlhttp.responseText;	
			        } 
			    }
		     };
		     try
		     {
		     	xmlhttp.open("post",url,true);
		        xmlhttp.send();
		     }catch(e){
		        	alert("unable to connect to server");
		     }
		}
		else
		{
			document.getElementById("answer").style.color = "red";
		    document.getElementById('answer').innerHTML = "you entered name invalide";
		}
    }
	
	function txtSearch(item, size)
	{
		for(var i = 0;i < size;i++){
			if (/[a-zA-Z0-9]/.test(item[i]) == true) 
			{
		    	return 1;
			}
		}
		
		return 0;
	}
</script>
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

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-9">
                <div class="row">

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src=<c:out value="${item0.pathPicture}" /> alt="">
                            <div class="caption">
                                <h4 class="pull-right">$<c:out value="${item0.price}" /></h4>
                                <h4><a href="Item.jsp" onclick="check('${item0.nameItem}')"><c:out value="${item0.nameItem}" /></a></h4>

                                <p>This is a short description</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src=<c:out value="${item1.pathPicture}" /> alt="">
                            <div class="caption">
                                <h4 class="pull-right">$<c:out value="${item1.price}" /></h4>
                                <h4><a href="Item.jsp" onclick="check('${item1.nameItem}')"><c:out value="${item1.nameItem}" /></a></h4>
                                <p>This is a short description</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src=<c:out value="${item2.pathPicture}" /> alt="">
                            <div class="caption">
                                <h4 class="pull-right">$<c:out value="${item2.price}" /></h4>
                                <h4><a href="Item.jsp" onclick="check('${item2.nameItem}')"><c:out value="${item2.nameItem}" /></a></h4>

                                <p>This is a short description</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src=<c:out value="${item3.pathPicture}" /> alt="">
                            <div class="caption">
                                <h4 class="pull-right">$<c:out value="${item3.price}" /></h4>
                                <h4><a href="Item.jsp" onclick="check('${item3.nameItem}')"><c:out value="${item3.nameItem}" /></a></h4>
                                                              
                                <p>This is a short description</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src=<c:out value="${item4.pathPicture}" /> alt="">
                            <div class="caption">
                                <h4 class="pull-right">$<c:out value="${item4.price}" /></h4>
                                <h4><a href="Item.jsp" onclick="check('${item4.nameItem}')"><c:out value="${item4.nameItem}" /></a></h4>
 	<script>
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
                                <p>This is a short description</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">18 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.container -->

    <div class="container">

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

    <!-- jQuery -->
    <script src="JS/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="JS/bootstrap.min.js"></script>
</body>
</html>