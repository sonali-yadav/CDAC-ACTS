<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">Hello , ${sessionScope.cust.details.email}</h4>
	<table style="background-color: cyan; margin: auto;" border="1">
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
		</tr>
		<c:forEach var="b" items="${sessionScope.bk.books}">
			<tr>
				<td>${b.title}</td>
				<td>${b.author}</td>
				<td>${b.price}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>Total Cart Value</td>
			<td>${sessionScope.bk.totalBill}</td>
		</tr>
	</table>
	<h5>You have logged out ....</h5>
	<%--invalidate HS --%>
	${pageContext.session.invalidate()}
	<h5>
		<a href="index.jsp">Visit Again</a>
	</h5>
</body>
</html>