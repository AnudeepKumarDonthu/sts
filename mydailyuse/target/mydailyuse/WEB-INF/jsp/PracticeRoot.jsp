<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<title>Practice Home</title>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
</head>
<body>
	<h1>Login</h1>
	<h2>${messgae}</h2>
	<spring:message code="language" />
	<a href="?language=en">English</a>||
	<a href="?language=tl">Telugu</a>
	<form:form commandName="UserDetails" action="userdetails" method="post">
		<table>
			<tr>
				<td><spring:message code="user.id" /></td>
				<td><form:input path="userid" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.password" /></td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.age" /></td>
				<td><form:password path="age" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>

	</form:form>
</body>
</html>