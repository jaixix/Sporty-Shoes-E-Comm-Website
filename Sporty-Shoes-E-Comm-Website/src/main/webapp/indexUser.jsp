<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
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
		<h1 align="center">Sporty Shoes - Home Page</h1>
		<h3>Welcome, <%=userName%></h3>
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
			<td>View Products</td>
			<td>In order to view available products.</td>
			<td><a href="viewProductsServletUser">View Products</a></td>
		</tr>
		<tr>
			<td>View Profile Details</td>
			<td>In order to view profile details.</td>
			<td><a href="#">View Profile</a></td>
		</tr>
		<tr>
			<td>Visit Cart</td>
			<td>In order to visit your shopping cart and make payments.</td>
			<td><a href="#">View Cart</a></td>
		</tr>
		<tr>
			<td>Logout</td>
			<td>In order to Logout from website.</td>
			<td><a href="logoutFunctionality">Logout</a></td>
		</tr>
	</table>
</body>
</html>