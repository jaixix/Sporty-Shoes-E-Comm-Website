<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, entity.Products" language="java"
	contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products Page</title>
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
	<h2>Products Page</h2>
	<table border="1" text-align="middle">
		<tr>
			<th>Product ID</th>
			<th>Name</th>
			<th>Company</th>
			<th>Price</th>
			<th>Description</th>
			<th>Category</th>
			<th>Add to Cart</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.company}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				<td>${product.category}</td>
				<td><a href="addToCartServlet?productId=${product.id}">Add</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="indexUser.jsp">Go Back to Home Page?</a>
</body>
</html>