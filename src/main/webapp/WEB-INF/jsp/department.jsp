<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
</head>
<body>
	<h3>username::<c:out value="${username}" /></h3>
	<h2>Department</h2>
	<table>
		<tr>
			<td>Department ID</td>
			<td>Department Name</td>
			<c:forEach items="${list}" var="department">
				<tr>
					<td><c:out value="${department.departmentId}" /></td>
					<td><c:out value="${department.departmentName}" /></td>
				</tr>
			</c:forEach>
	</table>
	<h3><a href = "<%= request.getContextPath() %>/secure/logout" >Logout</a></h3>
</body>
</html>