<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add author</title>
<link rel="stylesheet" href="/Spring01hibernate/resources/css/style.css">
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


	<h1 align="center">Publisher list:</h1>

	<table class="tg" align="center">
		<tr>
			<th class="tg-kiyi">Name:</th>
			<th class="tg-g3xm">Action</th>
		</tr>
		<c:forEach items="${publishers }" var="publisher">
			<tr>
				<td align="center" class="tg-phtq">${publisher.name}</td>
				<td align="center" class="tg-hmp3"><a href="editPublisher/${publisher.id}">Edit</a>
					| <a href="deletePublisher/${publisher.id}"> Delete</a></td>
			</tr>
		</c:forEach>
</body>
</html>