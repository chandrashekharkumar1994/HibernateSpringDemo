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
		color:blue;
	}
	#w1{
		background-color:#8080ff;
		width:40%;
		margin-top:7%;
	}
	#cancel_btn{
		margin-top:5px;
	}
	h1{
		color:black;
		text-decoration:underline;
	}
</style>
<title>Add Employee</title>
</head>
<body>
	<div  id="w1" class="container">
		<h1 class="text-center">Add New Employee</h1>  
		
       <form:form method="post" action="add_emp" > 
          
         <div class="form-group">
      		<label> Name :</label>
       		<form:input class="form-control" path="name" required="true" /> 
       	</div>
       	
       	<div class="form-group">
       		<label>Salary :</label>    
         	<form:input class="form-control" path="salary" required="true" />  
        </div>
           
         <div class="form-group">  
          	<label>Designation :</label> 
          	<form:input class="form-control" path="designation" required="true" />
         </div>
         
         <!-- <div class="form-group">  
          	<input id="file_upload" name="file" class="form-control btn btn-info" type="file" value="Save" />
         </div> -->
         
         <div class="form-group">  
          	<input id="sbmt_btn" class="form-control btn btn-primary" type="submit" value="Save" />  
          	<a href="view_emp" class="btn btn-warning form-control" id="cancel_btn">Cancel</a>
         </div>  
         
         
       </form:form>
       <p>${MSG}</p>  
      </div>
</body>
</html>