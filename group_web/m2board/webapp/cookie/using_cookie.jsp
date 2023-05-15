<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 값 확인</h1>
<%
	// 쿠키에서 값을 가져올 때는 배열로 가져와야 함.
	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		for (Cookie cookie: cookies) {
			out.println("쿠키 이름: " + cookie.getName() + ", ");
			out.println("쿠키 값: " + URLDecoder.decode(cookie.getValue(), "UTF-8") + "<br>");
		}
	}
%>
</body>
</html>