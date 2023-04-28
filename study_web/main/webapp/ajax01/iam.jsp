<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String msg = null;
	
	if (name.equals("송태섭")) {
		msg = "그래 난 " + name + ". NO1 가드";
	} else if (name.equals("서태웅")) {
		msg = "그래 난 " + name + ". 북산 농구팀 에이스";
	} else if (name.equals("강백호")) {
		msg = "그래 난 " + name + ". 빨간 머리지.";
	} else {
		msg = "그래 난 " + name + ".";
	}
%>

<%=msg%>