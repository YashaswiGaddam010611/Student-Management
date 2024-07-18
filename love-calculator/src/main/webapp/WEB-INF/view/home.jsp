<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
	.error {
		color: red;
		position: fixed;
		text-align: left;
		margin-left: 5px;
	}
</style>

<script>
	function validate() {
		var userName = document.getElementById("yn").value;
		var crushName = document.getElementById("cn").value;
		if(userName.length < 1 || crushName.length < 1) {
			alert("feel free to share your pair names with us...");
			return false;
		} else {
			return true;
		}
	}
</script>


</head>
<body>
	<h1 align="center">Love Calculator</h1><hr/>
	<div align="center">
		<form:form action="result" method="get" modelAttribute="userInfo">
			<p>
				<label for="yn">Your Name: </label>
				<form:input id="yn" path="yourName"></form:input>
				<form:errors path="yourName" cssClass="error"></form:errors>
			</p>
			
			<p>
				<label for="cn">Crush Name: </label>
				<form:input id="cn" path="crushName"></form:input>
				<form:errors path="crushName" cssClass="error"></form:errors>
			</p>
			
			<form:checkbox path="termAndCondition"/>
			<label>I am agreeing that "I am doing it just for fun"</label>
			<form:errors path="termAndCondition" cssClass="error"></form:errors>
			
			<p>
				<input type="submit" value="Calculate"/>
			</p>
		</form:form>
	</div>
</body>
</html>