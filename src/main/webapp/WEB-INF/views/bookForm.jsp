<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add book form</title>
<style>
.errors {
	color: red;
	border-color: red;
	border: 1px;
	font: bold;
}
</style>

</head>
<body>
	<h1>Menu</h1>
	<h3>
		<a href="../day2/addBookForm">Add new Book</a> <a
			href="../day2/publishers">Publisher list</a> <a
			href="../day2/authors">Authors list</a> <a href="../day2/books">Book
			list</a> <a href="../day2/addBookForm">Add new Book</a> <a
			href="../day2/addAuthor">Add new Author</a> <a
			href="../day2/publisherForm">Add new Publisher</a>
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
		<h2>
			Rating: (*number format)
			<form:input path="rating" />
			<form:errors path="rating" cssClass="errors" />
		</h2>
		<h2>
			Publisher:
			<form:select path="publisherDto.id" items="${publishers}"
				itemValue="id" itemLabel="name"></form:select>
			<form:errors path="publisherDto" cssClass="errors" />
		</h2>
		<h2>
			Authors:
			<form:select size="5em" path="authors" multiple="true"
				items="${authors }" itemLabel="fullName" itemValue="id" />
			<form:errors path="authors" cssClass="errors" />
		</h2>
		<h2>
			Pages:
			<form:input path="pages" />
			<form:errors path="pages" cssClass="errors" />
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