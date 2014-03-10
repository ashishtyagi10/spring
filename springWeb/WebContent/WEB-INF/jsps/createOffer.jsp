<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<title>Create the offer</title>
</head>
<body>
	<sf:form method="POST"
		action="${pageContext.request.contextPath }/doCreateOffer" commandName="offer">
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td><sf:input name="name" type="text" path="name" class="control"/><br/><sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input name="email" type="text" path="email" class="control"/><br/><sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Text:</td>
				<td><sf:textarea name="text" path="text" class="control"></sf:textarea><br/><sf:errors path="text" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="control" name="Create advert" type="submit"/></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>