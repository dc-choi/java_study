<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("id", URLEncoder.encode("흥민", "UTF-8"));
	// cookie.setMaxAge(60 * 60 * 24 * 30); // 한달동안 쿠키 유지 (설정안하면 브라우저를 닫을 시 자동으로 삭제)
	response.addCookie(cookie);
	response.sendRedirect("using_cookie.jsp");
%>