<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>From included page</h4>
	<h4>
		Instance var
		<%=message%></h4>
	<h4>
		Method local var
		<%=data%></h4>
	<h4>Page Scoped Attr ${pageScope.attr}</h4>
</body>
</html>