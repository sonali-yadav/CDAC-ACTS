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
	<h1>Courses offered</h1>
	<div>
	<h2>${requestScope.status}</h2>
		<table>
			<c:forEach var="course" items="${requestScope.courseList}">
				<tr>
					<td>${course.name}</td>
					<td><a href='<sp:url value="/courses/delete?cid=${course.id}"/>'>Delete Course</a></td>
					<td><a href='<sp:url value="/student/add?cid=${course.id}" />'>Admit Student</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>