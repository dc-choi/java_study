<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet"  href="css/board.css" type="text/css" />
	</head>
	<body>
		${logInfo} <a href="Logout.do">[로그아웃]</a>
		<table width="600">
			<caption>게시판 리스트</caption>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!--
			JSTL(jsp standard tag library)
			자바를 사용하지 않고, 제어문을 사용할 수 있도록 해주는 라이브러리
			-->
			<jstl:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.no}</td>
					<td><a href="BoardView.do?no=${dto.no}">${dto.title}</a></td>
					<td>${dto.memberDto.name} (${dto.memberDto.id})</td>
					<td>${dto.regdate}</td>
					<td align="right">${dto.readcount}</td>
				</tr>
			</jstl:forEach>
		</table>
		<a href="BoardInsert.do">글쓰기</a>
	</body>
</html>