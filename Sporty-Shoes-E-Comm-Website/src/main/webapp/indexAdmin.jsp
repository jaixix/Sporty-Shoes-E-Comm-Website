<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Homepage</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	text-align: center;
}

.header {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background:
		url("https://www.xmple.com/wallpaper/blue-gradient-white-linear-1920x1080-c2-87cefa-ffffff-a-105-f-14.svg");
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
}
</style>

<%
		String emailId = "default";
		String userName = "default";
		int userId = 0;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if (cookie.getName().equals("emailId")) {
					emailId = cookie.getValue();
					System.out.println(emailId);
				}
				if (cookie.getName().equals("userName")) {
					userName = cookie.getValue();
					System.out.println(userName);
				}
				if (cookie.getName().equals("userId")) {
					userId = Integer.parseInt(cookie.getValue());
					System.out.println(userId);
				}
			}
		}
		if(emailId.equalsIgnoreCase("default")){
			response.sendRedirect("loginForm.html");
		}
%>

</head>
<body>
	<div class="header">
		<hr>
		<h1 align="center">Sporty Shoes : Back-End</h1>
		<h3>Welcome, <%=userName%></h3>
		<h3 align="center">Action Menu</h3>
		<hr>
	</div>
	<br>
	<table border='1' align="center">
		<tr>
			<th>Action</th>
			<th>Description</th>
			<th>Link</th>
		</tr>
		<tr>
			<td>Add a User</td>
			<td>In order to add users to the database.</td>
			<td><a href="createUserFormUpdated.html">Add User</a></td>
		</tr>
		<tr>
			<td>Add a Product</td>
			<td>In order to add products to the database.</td>
			<td><a href="createProductForm.html">Add Product</a></td>
		</tr>
		<tr>
			<td>Search Users</td>
			<td>In order to search users from the database.</td>
			<td><a href="searchUsers.jsp">Search Users</a></td>
		</tr>
		<tr>
			<td>Search Products</td>
			<td>In order to search products from the database.</td>
			<td><a href="searchProducts.jsp">Search Products</a></td>
		</tr>
		<tr>
			<td>Delete a User</td>
			<td>In order to delete users from the database.</td>
			<td><a href="deleteUser.html">Delete User</a></td>
		</tr>
		<tr>
			<td>Delete a Product</td>
			<td>In order to delete products from the database.</td>
			<td><a href="deleteProduct.html">Delete Product</a></td>
		</tr>
		<tr>
			<td>View Users</td>
			<td>In order to view all users from the database.</td>
			<td><a href="viewUsersServlet">View Users</a></td>
		</tr>
		</tr>
		<tr>
			<td>View Users</td>
			<td>In order to view all users from the database.</td>
			<td><a href="viewProductsServlet">View Products</a></td>
		</tr>
		<tr>
			<td>View Transactions</td>
			<td>In order to view all transactions from the database.</td>
			<td><a href="viewTransactionsServlet">View Transactions</a></td>
		</tr>
		<tr>
			<td>Logout</td>
			<td>In order to Logout from website.</td>
			<td><a href="logoutFunctionality">Logout</a></td>
		</tr>
	</table>
</body>
</html>