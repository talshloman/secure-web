<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ForgetPassword</title>
<link rel="stylesheet" href="CSS/styleLogin.css">
</head>
<body>
<div class="container">
	<section id="content">
		<form ACTION="ForgotPassword" METHOD="Post">
			<div>
				Please Enter Your Email: <input type="text" name="Email"
					VALUE=""
					pattern="[a-z0-9._-]{1,}+@[a-z0-9.-]{1,}+\.[a-z]{2,3}"
					maxlength="100" required><BR>
			</div>
			<div>
				<button TYPE="button" Value="Register"
					onClick="validation (this.form);">Reset Password</button>
			</div>
		</form>
	</section><!-- content -->
</div><!-- container -->
	<div id="comment"></div>
	<script>
	 
		 function validation (form)
		 {
			var email = form.Email.value;
			
			if((checkEmail(email , email.length)) == 1)
			{
				form.submit();
			}
			else
			{
				document.getElementById('comment').innerHTML = "Please enter a valid email adress.";
			}
		 }
		 
		 
		
		function checkEmail(email, size)
		{
		    var atpos = email.indexOf("@");
		    var dotpos = email.lastIndexOf(".");
		    if ( size > 4 && atpos > 1 && (dotpos - atpos) > 2 && (dotpos + 2) <= email.length) 
		    {
		        return 1;
		    }
		    
		    return 0;
		}
		
		</script>
		
</body>
</html>