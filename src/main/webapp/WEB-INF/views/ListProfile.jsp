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
				<th scope="col">Profile ID</th>
				<th scope="col">ImgURL</th>
				<th scope="col">Img</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${profile}" var="u">
				<tr>
					<th scope="row">${u.userId }</th>
					<th>${u.profileId }</th>
					<td>${u.imgUrl }</td>
					<%-- <td>${u.isActive }</td> --%>
					<td> <img alt="" src="${u.imgUrl } " height="100px" width="100px"> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>