<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="searchUserByName" modelAttribute="searchByNameBean" method="post">
		<s:input path="firstName"/>
		<input type="submit" value="submit">
	</s:form>
</body>
</html>