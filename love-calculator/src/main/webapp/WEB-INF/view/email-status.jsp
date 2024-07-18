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
	<h1>Hi ${userInfo.yourName}</h1>
	<br />
	
	result has been successfully sent to the mail id: ${emailInfo.emailId}
	
	<hr />
	<div align="center">
	
		<a href="feedback">Feed back</a>
		
	
	</div>
</body>
</html>