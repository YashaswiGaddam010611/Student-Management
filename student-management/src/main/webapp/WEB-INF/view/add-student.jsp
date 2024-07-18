<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="studentInfo" action="save-student" method="post">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td>
						<label>Name: </label>
					</td>
					<td>
						<form:input path="studentName"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>mobile: </label>
					</td>
					<td>
						<form:input path="mobileNumber"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>country: </label>
					</td>
					<td>
						<form:input path="country"/>
					</td>
				</tr>
			
			</table>
			
			<input type="submit" value="submit" />
		</form:form>
	</div>
</body>
</html>