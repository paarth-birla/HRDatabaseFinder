<%@page import="com.models.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
</head>
<body>

	<%
	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("name") == null)
		{
			response.sendRedirect("../login.jsp");
		}
		
		EmployeeModel employee = (EmployeeModel)session.getAttribute("employeeDetails");
	%>
	<header>
		<nav class="navbar navbar-expand-md navbar-light bg-primary">
		    <a class="navbar-brand" href="#" style="color: white">Employee Management System</a>
		    <div class="collapse navbar-collapse" id="navbarNav">
		        <ul class="navbar-nav mr-auto">
		            <li class="nav-item">
		                <a class="nav-link" href="home.jsp" style="color: white">Home</a>
		            </li>
		            <li class="nav-item">
		                <a class="nav-link" href="employee_list.jsp" style="color: white">Employee Details</a>
		            </li>
		        </ul>
		        <ul class="navbar-nav">
		            <li class="nav-item">
		                <!-- <a class="nav-link" href="../login.jsp">Logout</a> -->
		                <form action="../Logout">
		                	<button class="btn btn-primary">Logout</button>
		                </form>
		            </li>
		        </ul>
		    </div>
		</nav>
	</header>
	<br>
	<div style="padding: 10px">
	<div class="card text-white bg-dark" style="width: 18rem; padding: 10px;">
	  <div class="card-body">
	    <h5 class="card-title">Name : <%= session.getAttribute("name") %></h5>
	    <h6 class="card-text">Job Title : <%= employee.getJob() %></h6>
	    <p class="card-text">Department : <%= employee.getDepartment() %></p>
	  </div>
	</div>
	</div>
</body>
</html>