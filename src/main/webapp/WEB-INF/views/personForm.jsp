<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PersonForm</title>
</head>
<body>

	<h1>Person Form:</h1>
	
	<form:form method="post" modelAttribute="personDetail"  action="personDetailFormProcess">
	<h3>Login: <form:input path="login" /></h3>
	<h3>Password: <form:password path="password" /></h3>
	<h3>Email: <form:input path="email" /></h3>
	<input type="submit" value="Send" />
	
	</form:form>
	

</body>
</html>