<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
<style type="text/css">
	#header
	{
		width:100%;
		height:100px;
		border:solid 1px #888;
		color: red;
	}
	#main
	{
		width:100%;
		height:100%;
		border:solid 1px #888;
		color: navy;
		font-weight: bold;
		font-family: serif;
		font-size: 15px;
	}
</style>
</head>
<body>
	<center>
		<div id="header">
		<h1>REGISTRATION FORM</h1>
		</div>
		<div id="main">
		<form action="Controller" method="post">
			<pre>
				Employee ID:<br/>
				<input type="text" name="eid"/><br>
				Employee Name:<br/>
				<input type="text" name="eName"/><br>
				Employee Email:
				<input type="text" name="eEmail"/><br>
				Employee Salary:
				<input type="text" name="eSalary"/><br>
				<input type="submit" value="Register"/>
				<input type="reset" value="Reset"/>
			</pre>
		</form>
		<b style="color: red"><i>${param.msg}</i></b>
		</div>
	</center>
</body>
</html>