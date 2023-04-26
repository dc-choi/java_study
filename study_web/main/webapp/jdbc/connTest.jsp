<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection conn = null;

	boolean result = false; // db연결시 true로 변경
	
	try {
		Class.forName("oracle.jdbc.OracleDriver"); // orcle 드라이버 확인하기
		// 접속 url, 계정이름, password
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "oraclejava", "oraclejava");
		
		result = true;
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {}
		} 
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%if (result) {%>
			데이터베이스 연결 성공
		<%} else {%>
			데이터베이스 연결 실패
		<%}%>
	</body>
</html>
