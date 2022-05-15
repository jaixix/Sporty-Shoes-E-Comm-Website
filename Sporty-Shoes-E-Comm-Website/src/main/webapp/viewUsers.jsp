<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="java.util.*, entity.Users" language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Table</title>
<style>
table {
	margin-left: auto;
	margin-right: auto;
}

body {
	text-align: center;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	text-align: center;
	margin-top: 140px !important;
}
</style>
</head>
<body>
	<h2>Users Table</h2>
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>Name</th>
			<th>Email ID</th>
			<th>Password</th>
			<th>Is User Admin</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.emailId}</td>
				<td>${user.password}</td>
				<td>${user.userType}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="indexAdmin.jsp">Go Back to Home Page?</a>
</body>
</html>