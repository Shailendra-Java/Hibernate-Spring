<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students List</title>
</head>
<body>
	<center>
		<u><h1>All Students List</h1></u>
	</center>
	<table border="2">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>DOB</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<c:forEach items="${requestScope.allStd }" var="std">
			<tr>
				<td><c:out value="${std.firstName }"/></td>
				<td><c:out value="${std.lastName }"/></td>
				<td><c:out value="${std.gender }"/></td>
				<td><c:out value="${std.dob }"/></td>
				<td><c:out value="${std.address }"/></td>
				<td><c:out value="${std.phone }"/></td>
				<td><c:out value="${std.email }"/></td>
				<td><c:out value="${std.password }"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>