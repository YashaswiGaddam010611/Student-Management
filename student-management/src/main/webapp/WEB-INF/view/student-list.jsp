<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/staticFiles/css/general.css">

<script type="text/javascript">
	function reConfirm() {
		let info = "Are you sure you want to delete the student?";
		
		if(!(confirm(info))) return false;
		
		return true;
	}
</script>
</head>
<body>
	<h1 align="center">Student Management App</h1>
	
	<div align="center">
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Country</th>
			</tr>
			
			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td><a href="updateStudent?userId=${student.id}">UPDATE</a></td>
					<td>
						<a href="deleteStudent?userId=${student.id}" onclick="return reConfirm()">
							DELETE
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="add-student">ADD STUDENT</a>
	</div>
	
	
</body>
</html>