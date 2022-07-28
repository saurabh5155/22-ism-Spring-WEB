<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<h2>Signup</h2>

	<!-- <form action="saveUser" method="post">
		firstName:<input type="text" name="firstName" > <br><br>
		lastName:<input type="text" name="lastName" ><br><br>
		email:<input type="text" name="email" ><br><br>
		password:<input type="text" name="password" ><br><br>
		<input type="submit" value="sublit"><br><br>
	</form> -->

	<s:form action="updateUser" modelAttribute="userBean">
		<%-- <input type="hidden" name="userId" value="${userBean.userId }"> --%>
		
		<s:hidden path="userId"/>
		
		FirstName:<s:input path="firstName" />
		<s:errors path="firstName"></s:errors>
		<br>
		<br>
		LastName:<s:input path="lastName" />
		<s:errors path="lastName"></s:errors>
		<br>
		<br>
		Gender: <br>
		<br>
		Male:<s:radiobutton path="gender" value="male" />
		Female:<s:radiobutton path="gender" value="female" />
		<s:errors path="gender"></s:errors>
		<br>
		<br>
		Email:<s:input path="email" />
		<s:errors path="email"></s:errors>
		<br>
		<br>
		Password:<s:password path="password" />
		<s:errors path="password"></s:errors>
		<br>
		<br>
		<s:errors path="userType"></s:errors>

		<input type="submit" value="sublit">
		<br>
		<br>
	</s:form>
</body>
</html>