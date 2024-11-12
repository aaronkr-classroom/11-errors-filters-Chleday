<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Exception 예외 표시</title>
</head>
<body>
	<h1>오류가 발생하였습니다!</h1>
	<h3>예외: <%= exception %></h3>
	<p>toString(): <%= exception.toString() %></p>
	<p>getClass().getName(): <%= exception.getClass().getName() %></p>
	<p>getMessage(): <%= exception.getMessage() %>
</body>
</html>