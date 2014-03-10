<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>

<script type="text/javascript">
	function onLoad() {
		$("#password").keyup(checkPasswordMatch);
		$("#confirmpass").keyup(checkPasswordMatch);
		$("#detail").submit(canSubmit);
	}

	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		if (password != confirmpass) {
			alert("Password do not match !!!")
			return false;
		} else {
			return true;
		}

	}
	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		if (password.length > 3 || confirmpass.length > 3) {
			if (password == confirmpass) {
				$("#matchpass").text("<fmt:message key='MatchedPassword.user.password'></fmt:message>");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("<fmt:message key ='UnmatchedPassword.user.password'> </fmt:message>");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}

	$(document).ready(onLoad);
</script>
<title>Create the User</title>
</head>
<body>


	<h2>Create New Account</h2>
	<sf:form id="detail" method="POST"
		action="${pageContext.request.contextPath }/createAccount"
		commandName="user">
		<table class="formtable">
			<tr>
				<td class="label">UserName:</td>
				<td><sf:input name="username" type="text" path="username"
						class="control" /><br />
					<div class="error">
						<sf:errors path="username"></sf:errors>
				</div>
				</td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input name="email" type="text" path="email"
						class="control" /><br />
					<div class="error">
						<sf:errors path="email"></sf:errors>
				</div>
				</td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input id="password" type="password" name="password"
						path="password" class="control"></sf:input><br />
					<div class="error">
						<sf:errors path="password"></sf:errors>
				</div>
				</td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpass" name="confirmpass" class="control"
					type="password" /><br />
					<div id="matchpass"></div>
			</tr>
			<tr>
				<td></td>
				<td><input class="control" name="Create Account" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>