<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Exception 예외 표시</title>
</head>
<body>
	<h1>잘못된 데이터가 입력되었습니다.</h1>
	<p><%= "숫자1: " + request.getParameter("num1") %></p>
	<p><%= "숫자2: " + request.getParameter("num2") %></p>
</body>
</html>