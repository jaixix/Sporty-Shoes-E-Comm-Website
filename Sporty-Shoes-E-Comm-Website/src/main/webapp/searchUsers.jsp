<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Users</title>
</head>
<body>
	<h2>Search users</h2>
	<form action="searchUsers" method="post">
		Enter User's Name to be searched :<br>
		<input type="text" name="findName">
		<br><br>
		<input type="submit" name="Submit">
	</form>
	<br><br>
	<a href="indexAdmin.jsp">Go to Home Page?</a>
</body>
</html>