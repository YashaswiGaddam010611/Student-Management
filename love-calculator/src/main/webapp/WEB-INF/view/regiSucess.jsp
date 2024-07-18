<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	user: ${registrationInfo.user}
	<br /> UserName: ${registrationInfo.userName}
	<br /> Password: ${registrationInfo.password}
	<br /> Country: ${registrationInfo.country}
	<br /> Hobbies:
	<c:forEach var="hobby" items="${registrationInfo.hobbies}">
		${hobby}
	</c:forEach>
	<br /> Gender: ${registrationInfo.gender}
	<br /> Age: ${registrationInfo.age}
	<br /> Email: ${registrationInfo.communicationDTO.mail}
	<br /> Phone: ${registrationInfo.communicationDTO.phone}
</body>
</html>