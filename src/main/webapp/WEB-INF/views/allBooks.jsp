<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Spring01hibernate/resources/css/style.css">

<title>All books</title>
</head>
<body>
<div align="center" >
<h1>Menu</h1>
<h3>	<a href="http://localhost:8080/Spring01hibernate/day3/validate/addBookForm">Add new Book</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/publishers">Publisher list</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/authors">Authors list</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/books">Book list</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/addAuthor">Add new Author</a>
		<a href="http://localhost:8080/Spring01hibernate/day3/validate/processPublisherForm">Add new Publisher</a>
</h3>

</div>


	<h1 align="center">Book list:</h1>
	
	<table class="tg" align="center">
  <tr>
    <th class="tg-kiyi">Title</th>
    <th class="tg-kiyi">Description</th>
    <th class="tg-kiyi">Rating</th>
    <th class="tg-kiyi">Publisher</th>
    <th class="tg-g3xm">Action</th>
  </tr>
  <c:forEach items="${books }" var="book"> 
  <tr>
    <td align="center" class="tg-phtq">${book.title}</td>
    <td align="center" class="tg-phtq">${book.description}</td>
    <td align="center" class="tg-phtq">${book.rating}</td>
    <td align="center" class="tg-phtq">${book.getPublisherDto().getName()}</td>
    <td align="center" class="tg-hmp3"><a href="getBook/${book.id}" >Edit</a> | <a href="confirmDelete/${book.id}"> Delete</a> </td>
  </tr>
  
  
  </c:forEach>
  <tr>
</table>



</body>
</html>