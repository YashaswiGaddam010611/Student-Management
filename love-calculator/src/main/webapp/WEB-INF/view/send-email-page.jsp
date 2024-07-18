<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr />
	
	<h2 align="center">Hi ${userInfo.yourName}</h2>
	<div align="center">
		<form:form action="email-status" method="get"
			modelAttribute="emailInfo">
			<label for="email"> To MailID: </label>
			<form:input path="emailId" />
			
			<input type="submit" value="send"/>
		</form:form>
	</div>
</body>
</html>