<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="java.util.*, entity.Products" language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products Table</title>
</head>
<body>
	<h2>Products Table</h2>
	<table border="1">
		<tr>
			<th>Product ID</th>
			<th>Name</th>
			<th>Company</th>
			<th>Price</th>
			<th>Description</th>
			<th>Category</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.company}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				<td>${product.category}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="indexAdmin.jsp">Go Back to Home Page?</a>
</body>
</html>