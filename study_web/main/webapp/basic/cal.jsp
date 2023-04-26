<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! // 컴파일시 Servlet의 외부에 선언됨.
	public String dateFormat(int year, int month, int date) {
		return year + "년 " + month + "월 " + date + "일"; 
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% // 컴파일시 Servlet의 service()에 선언됨.

	// 인스턴스를 얻어오는 시점의 날짜가 세팅됨.
	Calendar cal = Calendar.getInstance();

	// JSP에서는 내장 객체로 out을 가지고 있음.
	// session, request, response등등이 있다.
	// out.println();
%>

<!-- 표현식 -->
<h1><%=dateFormat(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE))%></h1>
</body>
</html>