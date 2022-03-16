<%@page import="java.util.List"%>
<%@page import="com.DAO.EmployeeDAO"%>
<%@page import="com.models.EmployeeModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("name") == null)
{
	response.sendRedirect("../login.jsp");
} 
%>
	<header>
		<nav class="navbar navbar-expand-md navbar-light bg-primary fixed-top">
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
		                <form action="../Logout">
		                	<button class="btn btn-primary">Logout</button>
		                </form>
		            </li>
		        </ul>
		    </div>
		</nav>
	</header>
	<br>
	<br>
  	<%
    EmployeeDAO employeeDAO = new EmployeeDAO();
    ArrayList<EmployeeModel> employees = employeeDAO.getEmployeesList();
    %>
    
    
  <table class="table table-bordered table-hover">
    <thead class="thead-light">
      <tr>
        <th><span>Employee ID</span></th>
        <th><span>First Name</span></th>
        <th><span>Last Name</span></th>
        <th><span>Job Title</span></th>
        <th><span>Salary</span></th>
        <th><span>Department</span></th>
        <th><span>Location</span></th>
        <th><span>Country</span></th>
        <th><span>Region</span></th>
      </tr>
    </thead>
    <tbody>
    <%
    for(int i = 0; i < employees.size(); i++)
    {
    	EmployeeModel model = employees.get(i);
    %>
    <tr>
        <th><span><%= model.getEmpID() %></span></th>
        <th><span><%= model.getFirstname() %></span></th>
        <th><span><%= model.getLastname() %></span></th>
        <th><span><%= model.getJob() %></span></th>
        <th><span><%= model.getSalary() %></span></th>
        <th><span><%= model.getDepartment() %></span></th>
        <th><span><%= model.getLocation() %></span></th>
        <th><span><%= model.getCountry() %></span></th>
        <th><span><%= model.getRegion() %></span></th>
     </tr>
    <%	
    }
    %>
    </tbody>
  </table>
  
</body>
</html>