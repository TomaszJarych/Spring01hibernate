<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm delete</title>
</head>

<h1>Menu</h1>
<h3>	<a href="../day2/addBookForm">Add new Book</a>
		<a href="../day2/publishers">Publisher list</a>
		<a href="../day2/authors">Authors list</a>
		<a href="../day2/books">Book list</a>
		<a href="../day2/addBookForm">Add new Book</a>
		<a href="../day2/addAuthor">Add new Author</a>
		<a href="../day2/publisherForm">Add new Publisher</a>
</h3>

<body>
<h1>Delete this book?</h1>
<h2>Title: ${book.title}</h2>
<h2>Description: ${book.description}</h2>
<h2>Publisher: ${book.getPublisherDto().getName()}</h2>

<h3><a href="http://localhost:8080/Spring01hibernate/day2/deleteBook/${book.id}" >YES</a> | <a href="http://localhost:8080/Spring01hibernate/day2/books">NO</a></h3>

</body>
</html>