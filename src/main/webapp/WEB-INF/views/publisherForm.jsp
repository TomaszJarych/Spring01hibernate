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
<h3>	<a href="http://localhost:8080/Spring01hibernate/day3/validate/addBookForm">Add new Book</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/publishers">Publisher list</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/authors">Authors list</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/books">Book list</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/addAuthor">Add new Author</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/processPublisherForm">Add new Publisher</a>
</h3>

<h1 align="center" >Author:</h1>
	
	<form:form method="post" modelAttribute="publisher" action="processPublisherForm"> 
	
	<h2>Publisher name: <form:input path="name"/>
		<form:errors path="name" cssClass="errors" />
	</h2>
	
	<h2>NIP: <form:input path="nip"/>
		<form:errors path="nip" cssClass="errors" />
	</h2>
	<h2>REGON: <form:input path="regon"/>
		<form:errors path="regon" cssClass="errors" />
	</h2>
	
	<form:hidden path="id" />
	<input type="submit" value="Add">
	
	</form:form>

</body>
</html>