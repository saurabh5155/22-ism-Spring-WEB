<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>
<form action="login" method="post">
	email:<input type="text" name="email"> <br><br>
	password:<input type="text" name="password"> <br><br>
	<input type="submit" value="submit"><br><br>
</form>
${msg }
</body>
</html>