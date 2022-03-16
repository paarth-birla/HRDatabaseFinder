<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HRDATABASEFINDER</title>
<link rel="stylesheet" href="css/login_css.css">
</head>
<body>
	 
	<div class="form">
		<div class="form-toggle"></div>
		    <div class="form-panel one">
		        <div class="form-header">
		            <h1>Employee Login</h1>
		        </div>
		        <div class="form-content">
		            <form action="LoginEmployee">
		                <div class="form-group"><label for="jobid">JOB ID</label><input type="text" id="username" name="jobid" required="required" /></div>
		                <div class="form-group"><label for="empid">EMPLOYEE ID</label><input type="password" id="password" name="empid" required="required" /></div>
		                <!-- <div class="form-group"><label class="form-remember"><input type="checkbox" />Remember Me</label><a class="form-recovery" href="#">Forgot Password?</a></div> -->
		                <div class="form-group"><button type="submit">Log In</button></div>
		            </form>
	        </div>
	    </div>
        <a href="login.jsp" class="form-panel two"></a>
	</div>
	
</body>
</html>