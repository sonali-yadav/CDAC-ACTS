<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H1 style="text-align: center;">Books</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Book Title</th>
				<th>Publish Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.bookList}" var="book">
				<tr>
					<td>${book.bookTitle}</td>
					<td>${book.publishDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>