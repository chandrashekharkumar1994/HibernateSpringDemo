<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
	body{
		background-color:#d9d9d9;
		
	}
	table{
		border:0px;
	}
	h1{
		text-align:center;
		text-decoration:underline;
		color:red;
	}
	a{
		margin-left:10px;
	}
</style>
<title>Employee List</title>
</head>
<body>
	<div class="container" >
	<h1 >Employees List</h1>  
	<table class="table table-striped"  border="2" width="70%" cellpadding="2">  
	<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>  
	   <c:forEach var="emp" items="${emp_list}">   
	   <tr>  
	   <td>${emp.id}</td>  
	   <td>${emp.name}</td>  
	   <td>${emp.salary}</td>  
	   <td>${emp.designation}</td>  
	   <td><a class="btn btn-info" onclick="return confirm('Are you sure to edit ${emp.name} ?')" href="edit_emp/${emp.id}">Edit</a></td>  
	   <td><a class="btn btn-warning" onclick="return confirm('Are you sure to delete ${emp.name} ?')" href="delete_emp/${emp.id}">Delete</a></td>  
	   </tr>  
	   </c:forEach>
	   <tr><td colspan="6"><a class="btn btn-success" href="emp_form">Add New Employee</a> <a class="btn btn-danger" href="/HibernateSpringMVCDemo">Home</a></td> </tr>
	 	
   </table> 
   </div> 
   <br/>  
   <p>${MSG}</p>  
</body>
</html>