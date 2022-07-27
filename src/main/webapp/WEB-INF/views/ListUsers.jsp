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
	<h3>List User</h3>

<table class="table">
  <thead>
    <tr>
      <th scope="col">UserId</th>
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">Gender</th>
      <th scope="col">Email</th>
      <th scope="col">Password</th>
      <th scope="col">User Type</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${ users}" var="u">
    <tr>
      <th scope="row">${u.userId }</th>
      <th >${u.firstName }</th>
      <td>${u.lastName }</td>
      <td>${u.gender }</td>
      <td>${u.email }</td>
      <td>${u.password}</td>
      <td>${u.userType}</td>
      <td> <a href="deleteUser?userId=${u.userId}"> delete</a> </td>
    </tr>
   </c:forEach>
  </tbody>
</table>
</body>
</html>