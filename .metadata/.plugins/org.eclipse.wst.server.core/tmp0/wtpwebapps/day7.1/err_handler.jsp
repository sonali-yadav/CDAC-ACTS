<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    isErrorPage="true" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4 style="color: red;">Message : ${pageContext.exception.message}</h4>
<h4 style="color: red;">Error Causing Page  : ${pageContext.errorData.requestURI}</h4>

</body>
</html>