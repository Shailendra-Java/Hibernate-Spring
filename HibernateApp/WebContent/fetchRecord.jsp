<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
	<form action="fetch" method="post">
		<h2>Select Students by Country</h2>
		<select name="ctry" >
			<c:forEach items="${requestScope.stdList }" var="st">
				<option value="${st }"><c:out value="${st }"/></option>
			</c:forEach>
		</select>
		<input type="submit" value="Fetch"/>
	</form>
</body>
</html>