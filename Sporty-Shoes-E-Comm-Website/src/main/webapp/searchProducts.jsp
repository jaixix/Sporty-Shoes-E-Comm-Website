<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Products</title>
<style>
body {
	text-align: center;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	text-align: center;
	margin-top: 140px !important;
}
</style>
</head>
<body>
	<h2>Search Products</h2>
	<form action="searchProducts" method="post">
		Enter Product's Name to be searched :<br>
		<input type="text" name="findName">
		<br><br>
		<input type="submit" name="Submit">
	</form>
	<br><br>
	<a href="indexAdmin.jsp">Go to Home Page?</a>
</body>
</html>