<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<h2>Signup</h2>

	<form action="saveUser" method="post">
		firstName:<input type="text" name="firstName" > <br><br>
		lastName:<input type="text" name="lastName" ><br><br>
		email:<input type="text" name="email" ><br><br>
		password:<input type="text" name="password" ><br><br>
		<input type="submit" value="sublit"><br><br>
	</form>
</body>
</html>