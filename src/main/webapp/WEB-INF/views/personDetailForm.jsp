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
	
	<form:form method="post" modelAttribute="personDetail" >
	<h3>Login: <form:input path="login" /></h3>
	<h3>Password: <form:password path="password" /></h3>
	<h3>Email: <form:input path="email" /></h3>
	<h3>First name: <form:input path="firstName" /></h3>
	<h3>Last name: <form:input path="lastName" /></h3>
	<div>
		<h3>Gender: </h3>
		<h4>Male: <form:radiobutton path="gender" value="Male"/>  Female: <form:radiobutton path="gender" value="Female"/></h4>
	</div>
	<h3>Country: 
		<form:select path="country">
			<form:option value="-" label="Please select your Country" ></form:option>
			<form:options items="${countries}" />
		</form:select></h3>
		<h3>Notes: <form:textarea path="notes"/></h3>
		<h3>Mailinglist: <form:checkbox path="mailingList"/></h3>
		<h3>Programming skills:	<form:select path="programmingSkills" multiple="true" items="${skills }"  >
								</form:select></h3>
		<h3>Hobby: <form:checkboxes	items="${hobbies}"	path="hobbies"	/></h3>	 
	
	<input type="submit" value="Send" />
	
	</form:form>
	

</body>
</html>