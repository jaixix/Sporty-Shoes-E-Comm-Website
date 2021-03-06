<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="java.util.*, entity.Products" language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Searched Users - Result</title>
<style>
body {
	text-align: center;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	text-align: center;
	margin-top: 140px !important;
}
table {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	<h2>Searched Products - Results</h2>
	<%
		List<Products> products = (List) request.getAttribute("products");
		if(products.size()==0){
			out.println("<br><br><h2>No Products Found!</h2><br><br>");
		}
		else{
	%>
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
	<% } %>
	<br>
	<a href='indexAdmin.jsp'>Go to Home Page?</a>
</body>
</html>