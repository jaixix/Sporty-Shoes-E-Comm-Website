<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, entity.Purchases" language="java"
	contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Purchases</title>
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
	<h2>Purchases Page</h2>
	<table border="1" text-align="middle">
		<tr>
			<th>Purchase ID</th>
			<th>User ID</th>
			<th>ProductID</th>
		</tr>
		<c:forEach var="purchase" items="${purchases}">
			<tr>
				<td>${purchase.id}</td>
				<td>${purchase.userId}</td>
				<td>${purchase.productId}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="sortCategory.jsp">Sort by Category?</a>
	<br><br>
	<a href="indexAdmin.jsp">Go Back to Home Page?</a>
</body>
</html>