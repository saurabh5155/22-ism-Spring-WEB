<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<label for="cars">Select Seq Que</label>
	<form action="secQue" method="post">
		<select name="que" id="cars">
			<option value="What is your addhar card last 4 disit?">What
				is your addhar card last 4 disit?</option>
			<option value="Which is your favorite book?">Which is your
				favorite book?</option>
			<option value="What is your mother name?">What is your
				mother name?</option>
			<option value="What is your brother name?">What is your
				brother name?</option>
		</select> <br>
		<br>
		<br>
		<br> Ans. <input type="text" name="ans"> <br>
		<br> <input type="submit" value="submit">

	</form>
</body>
</html>