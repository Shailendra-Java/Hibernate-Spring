<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	#l
	{
		width:48%;
		height:250px;
		border:solid 1px black;
		float: left;
		padding-left: 30px;
	}
	
</style
</head>
<body>
<center>
	<h1>Online Shopping Website</h1> 
</center>
<div id="l">
	<form action="StoreData" method="post">
	<h3>Store product details</h3>
		
			Product ID:<br>
			<input type="text" name="pid"/><br>
			Product Name:<br>
			<input type="text" name="pname"/><br>
			Product Price:<br>
			<input type="text" name="price"/><br>
			Product Stock:<br>
			<input type="text" name="stock"/><br>
			<input type="submit" value="Store"/>
	</form>
</div>
</body>
</html>