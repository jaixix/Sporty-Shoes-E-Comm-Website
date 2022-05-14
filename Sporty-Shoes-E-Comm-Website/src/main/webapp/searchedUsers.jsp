<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="java.util.*, entity.Users" language="java" contentType="text/html; charset=ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Searched Users - Result</title>
</head>
<body>
	<h2>Searched Users - Results</h2>
	<%
		List<Users> users = (List) request.getAttribute("users");
		if(users.size()==0){
			out.println("<br><br><h2>No Users Found!</h2><br><br>");
		}
		else{
	%>
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>Name</th>
			<th>Email ID</th>
			<th>Password</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.emailId}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>
	</table>
	<% } %>
	<br>
	<a href='indexAdmin.jsp'>Go to Home Page?</a>
</body>
</html>