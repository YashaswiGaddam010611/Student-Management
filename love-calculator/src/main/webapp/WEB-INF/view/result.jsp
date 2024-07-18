<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	span {
		color: red;
		font-style: italic;
	}
</style>

</head>
<body>
	<h1 align="center">Love Calculator</h1><hr/>
	<div align="center">
		<h2>Hi ${userInfo.yourName}</h2>
		<br />
		
		<h3>Love calculator Predected that: </h3>
		<p>you and ${userInfo.crushName} are <span>${userInfo.result}</span></p>
	</div>
	
	<div align="left">
		<a href="send-email">send results to ${userInfo.crushName} through Love calculator <span>Email services</span></a>
	</div>
</body>
</html>