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
		<h1 style="color: red;
					font-size: 100px;">Feedback</h1>
					
		<form:form action="feedback-success" method="get" modelAttribute="feedbackInfo">
			<label>Name: </label>
			<form:input path="name"/>
			<br />
			<br />
			
			<label>Email: </label>
			<form:input path="email"/>
			<br />
			<br />
			
			<label>Feedback: </label><br />
			<form:textarea path="feedback" rows="10" cols="30"/>
			<br />
			<br />
			
			<input type="submit" value="Submit Feedback" />
			
		</form:form>
	</div>
</body>
</html>