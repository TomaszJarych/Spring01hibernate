<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add book form</title>

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

	<h1 align="center">Book:</h1>

	<form:form method="post" modelAttribute="book" action="processBookForm">

		<h2>
			Title:
			<form:input path="title" />
			<form:errors path="title" cssClass="errors" />
		</h2>
		<h2>
			Description:
			<form:input path="description" />
			<form:errors path="description" cssClass="errors" />
		</h2>
		<h2>Is pproposition? <form:checkbox	path="proposition"/>
			<form:errors path="proposition" cssClass="errors" />
		</h2>

		<form:hidden path="id" />
		<input type="submit" value="Send">

	</form:form>



</body>
</html>
<!-- private Long id;
	private String title;
	private Set<AuthorDto> authors = new HashSet<>();
	private Integer rating;
	private PublisherDto publisherDto; -->