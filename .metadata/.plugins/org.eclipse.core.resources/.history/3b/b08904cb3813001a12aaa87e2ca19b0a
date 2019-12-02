<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H1 style="text-align: center;">Authors</H1>
	<div>
	<form action='<sp:url value="/books/list" />'>
		<select name="author" id="author">
			<c:forEach items="${requestScope.authorList}" var="auth">
				<option value="${auth.id}">${auth.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="See Books By Author">
		</form>
	</div>
</body>
</html>