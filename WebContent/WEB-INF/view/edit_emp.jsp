<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<style type="text/css">
	body{
		background-color:#b3b3ff;
	}
	#save_btn,#cancel_btn{
		width:100%;
		margin-top:5px;
	}
	#parent_div{
			width:35%;
			margin-top:4%;
			background-color:#8080ff;
	}
	#title{
		color:black;
		text-align : center;
	}
	label{
		color:blue;
	}
	h1{
		text-decoration:underline;
		color:black;
	}
</style>
<title >Edit Employee</title>
</head>
<body>
		<div id="parent_div" class="container">
			 <h1 id="title">Edit Employee</h1>  
	      	<form:form  method="POST" action="../save"> 
	       
	       		<form:hidden  path="id" /> 
	      
	         <div class="form-group">    
	          	<label >	Name :  </label> 
	          	<form:input class="form-control" path="name"  required="true" />
	         </div>
	         
	       	 <div class="form-group"> 
	        	<label > Salary :</label>   
	          <form:input class="form-control" path="salary" required="true" />
	         </div>
	         
	         <div class="form-group"> 
	         	<label >Designation : </label>		   
	          	<form:input class="form-control" path="designation" required="true" />  
	         </div>
	         
	         <div class="form-group text-center">   
	          	<input class="btn btn-success" id="save_btn" type="submit" value="Save" />
	          	<a id="cancel_btn" href="../view_emp" class="btn btn-danger" > Cancel</a>
	        </div>
	         
	       </form:form> 
	   </div>   
</body>
</html>