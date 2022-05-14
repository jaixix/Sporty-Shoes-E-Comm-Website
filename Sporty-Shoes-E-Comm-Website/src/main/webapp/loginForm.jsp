<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="loginServlet" method="post">
		Enter your Email Id :<br>
		<input type="text" name="emailId">
		<br><br>
		Enter your Password :<br>
		<input type="text" name="password">
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>