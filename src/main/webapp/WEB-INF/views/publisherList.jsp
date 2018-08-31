<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add author</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #999;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #999;
	color: #444;
	background-color: #F7FDFA;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #999;
	color: #fff;
	background-color: #26ADE4;
}

.tg .tg-phtq {
	background-color: #D2E4FC;
	border-color: inherit;
	text-align: left;
	vertical-align: top
}

.tg .tg-kiyi {
	font-weight: bold;
	border-color: inherit;
	text-align: left
}

.tg .tg-hmp3 {
	background-color: #D2E4FC;
	text-align: left;
	vertical-align: top
}

.tg .tg-g3xm {
	font-weight: bold;
	font-size: 100%;
	font-family: serif !important;;
	text-align: left;
	vertical-align: top;
}
</style>
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