<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String str = "테스트 " + name;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1><%=str%></h1>
	</body>
</html>