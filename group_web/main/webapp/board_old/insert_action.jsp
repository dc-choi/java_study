<%@page import="board.model.BoardDto"%>
<%@page import="board.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String title = request.getParameter("title");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	
	BoardDto board = new BoardDto();
	board.setTitle(title);
	board.setName(name);
	board.setPassword(password);
	board.setContent(content);
	
	boolean result = BoardDao.getInstance().insertBoard(board);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<script>
			<%if(result){%>
				alert("글이 등록되었습니다.");
				location.href = 'list.jsp'; // 다음 이동할 url
			<%} else {%>
				alert("글 등록 실패.");
				// javascript 키워드는 생략 가능
				location.href = 'javascript:history.back();';
			<%}%>
		</script>
	</body>
</html>