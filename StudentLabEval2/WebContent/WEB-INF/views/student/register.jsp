<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Admission Form</h1>
	<h2>${requestScope.status}</h2>
	<spf:form method="post" modelAttribute="student">
		<table>
			<tr>
				<td>Name</td>
				<td><spf:input path="name" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><spf:input path="address" /></td>
			</tr>
			<tr>
				<td>CGPA</td>
				<td><spf:input type="number" path="cgpa" /></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><spf:input type="date" path="dob" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="courseId" value="${requestScope.courseId}" />
				<input type="submit" value="Admit Student" /></td>
			</tr>
		</table>
	</spf:form>
</body>
</html>