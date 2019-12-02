<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="bk" class="beans.BookBean" 
scope="session" />
<body>
	<h3>${sessionScope.cust.message}</h3>
	<h4>Customer Details ${sessionScope.cust.details}</h4>
	<form action="category_dtls.jsp" method="get">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Choose A Category</td>
				<td><select name="cat">
						<c:forEach var="c" 
						items="${sessionScope.bk.categories}">
							<option value="${c}">${c}</option>
						</c:forEach>
				</select></td>
			</tr>


			<tr>
				<td><input type="submit" value="Choose" /></td>
				<td><input type="submit" value="Show Cart"
					formaction="show_cart.jsp" /></td>

			</tr>
		</table>
		
	</form>
	<h5>
			<a href="logout.jsp">Log Me Out</a>
		</h5>
</body>
</html>