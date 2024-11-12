<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception Processing 예외처리</title>
</head>
<body>
<%
	try {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		int c = a / b;
		out.println(num1 + " / " + num2 + " = " + c);
	} catch(NumberFormatException e) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"1106_tryCatch_error.jsp");
		dispatcher.forward(request, response);
	} catch(ArithmeticException e) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"1107_tryCatch_zeroerror.jsp");
		dispatcher.forward(request, response);
	} finally {
		out.println("<h2 style='color:red'>Finally!.....</h2>");
	}


%>
</body>
</html>