<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <jsp:useBean id="bk" class="beans.BookBean" scope="session" /> --%>
<jsp:setProperty property="*" name="bk" />
<body>
	<h4 align="center">Books Under Category ${param.cat}</h4>
	<form action="add_to_cart.jsp" method="get">
		<table style="background-color: cyan; margin: auto;" border="1">
			<c:forEach var="b" items="${sessionScope.bk.booksByCategory}">
				<tr>
					<td><input type="checkbox" name="bkId" value="${b.id}"></td>
					<td>${b.title}</td>
					<td>${b.author}</td>
					<td>${b.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Add To Cart" /></td>
			</tr>
		</table>

	</form>

</body>
</html>