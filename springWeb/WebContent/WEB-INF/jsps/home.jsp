<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springWeb</title>
</head>
<body>
	<p><a href="${pageContext.request.contextPath}/offers">Show current offers</a></p>
	<p><a href="${pageContext.request.contextPath}/createOffer">Create Offer</a></p>
	
	<p><a href="<c:url value='/j_spring_security_logout' />">Logout</a></p>
	<p><a href="<c:url value='/j_spring_security_check' />">Log-In</a></p>
</body>
</html>