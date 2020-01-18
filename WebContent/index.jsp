<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<style type="text/css">
	body{
			background-color:#F0F4F6;
		}
		#w1{
			background-color:#E3EBF8;
		}
		#login_fail{
			color:red;
			font-size:8 px;
		}
		
</style>
</head>
<body>
	<h1 style="margin-left:500px;color:red;">Welcome to Spring.</h1>
	<div class="text-center"><a href="hello" >Click Here</a></div>
	<div class="well " id="w1" style="padding:100px;margin:400px;margin-top:70px;">
	<form action="login" method="POST">
	<input type="text" class="form-control" name="user" placeholder="User Name" required /><br>
	<input type="text" class="form-control" name="password" placeholder="Password" required />
	<div id="login_fail">${MSG}</div><br>
	<div class="text-center">
	<input type="submit" class="btn btn-primary" value="Succeed" />
	</div>
	</form>
	</div> 
	
	
</body>
</html>