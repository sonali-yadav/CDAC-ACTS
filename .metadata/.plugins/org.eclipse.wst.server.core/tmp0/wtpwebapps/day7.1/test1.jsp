<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
  String message="some mesg!!!!";
%>
<body>
<h4>From main page</h4>
<%
   int data=100;
   pageContext.setAttribute("attr", 1234);
%>
<%@ include file="test2.jsp" %>
</body>
</html>