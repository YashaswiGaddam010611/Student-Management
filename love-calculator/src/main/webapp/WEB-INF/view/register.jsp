<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.mail {
	width: 200px;
}

.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 5px;
}
</style>

</head>
<body>
	<h1 align="center">Please register here</h1>
	<hr />
	<div align="center">
		<form:form action="registration-sucess" method="get"
			modelAttribute="registrationInfo">
			<label for="user">User: </label>
			<form:input id="user" path="user" />
			<form:errors path="user" cssClass="error"/>
			<br />
			<br />

			<label for="un">User Name: </label>
			<form:input id="un" path="userName" />
			<form:errors path="userName" cssClass="error"/>
			<br />
			<br />

			<label for="pass">Password: </label>
			<form:password path="password" />
			<form:errors path="password" cssClass="error"/>
			<br />
			<br />

			<label for="country">Country: </label>
			<form:select path="country">
				<form:option value="null" label="choose"></form:option>
				<form:option value="ind" label="India"></form:option>
				<form:option value="sl" label="Srilanka"></form:option>
				<form:option value="usa" label="United States Of America"></form:option>
				<form:option value="aus" label="Australia"></form:option>
			</form:select>
			<br />
			<br />

			<label>Hobbies: </label>
			Programming<form:checkbox path="hobbies" value="programming" />
			cricket<form:checkbox path="hobbies" value="cricket" />
			Reading<form:checkbox path="hobbies" value="reading" />
			<br />
			<br />

			<label>Gender: </label>
			Male<form:radiobutton path="gender" value="male" />
			Female<form:radiobutton path="gender" value="female" />
			<br />
			<br />

			<label>Age: </label>
			<form:input path="age" />
			<form:errors path="age" cssClass="error" />
			<br />
			<br />

			<h3>Communication</h3>
			<br />
			<br />
			Email: <form:input path="communicationDTO.mail" class="mail" />
			<form:errors path="communicationDTO.mail" cssClass="error"/>

			<br />
			<br />
			Phone: <form:input path="communicationDTO.phone" />
			<form:errors path="communicationDTO.phone" cssClass="error"/>

			<br />
			<br />

			<input type="submit" value="Register" />
		</form:form>
		<br /> <br />
	</div>
</body>
</html>