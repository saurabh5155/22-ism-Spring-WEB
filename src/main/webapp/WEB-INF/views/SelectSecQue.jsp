<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

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
	
<body>
	<h3>List User</h3>
	
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Que</th>
				<th scope="col">Ans</th>
				<th scope="col">UserId</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ secQueBean}" var="u">
				<tr>
					<th scope="row">${u.seqQueId }</th>
					<th scope="row">${u.que }</th>
					<th scope="row">${u.ans }</th>
					<th scope="row">${u.userId }</th>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>