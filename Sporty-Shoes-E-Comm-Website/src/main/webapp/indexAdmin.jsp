<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Homepage</title>
</head>
<body>
	<h2>Welcome to Sporty Shoes : Back-End</h2>
	<!-- Admin's Email -->
	<table border='1'>
		<tr>
			<th>Action</th>
			<th>Description</th>
			<th>Link</th>
		</tr>
		<tr>
			<td>Add a User</td>
			<td>In order to add users to the database.</td>
			<td><a href="createUserForm.html">Add User</a></td>
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
	</table>
</body>
</html>