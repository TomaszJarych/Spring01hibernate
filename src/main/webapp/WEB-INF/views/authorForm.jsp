<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add author</title>
</head>
<body>
<h1>Menu</h1>
<h3>	<a href="../day2/addBookForm">Add new Book</a>
		<a href="../day2/publishers">Publisher list</a>
		<a href="../day2/authors">Authors list</a>
		<a href="../day2/books">Book list</a>
		<a href="../day2/addBookForm">Add new Book</a>
		<a href="../day2/addAuthor">Add new Author</a>
		<a href="../day2/publisherForm">Add new Publisher</a>
</h3>


<h1 align="center" >Author:</h1>
	
	<form:form method="post" modelAttribute="author" action="processAuthorForm"> 
	
	<h2>First name: <form:input path="firstName"/></h2>
	<h2>Last name: <form:input path="lastName"/></h2>
	
	<form:hidden path="id" />
	<input type="submit" value="Send">
	
	</form:form>

</body>
</html>