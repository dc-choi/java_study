<%@page import="board.model.BoardDto"%>
<%@page import="board.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	
	Long no = Long.parseLong(request.getParameter("no"));
	String title = request.getParameter("title");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	
	BoardDto board = new BoardDto();
	board.setNo(no);
	board.setTitle(title);
	board.setName(name);
	board.setPassword(password);
	board.setContent(content);
	
	boolean result = BoardDao.getInstance().updateBoard(board);
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
				alert("글이 수정되었습니다.");
				location.href = 'list.jsp';
			<%} else {%>
				alert("글 수정 실패.");
				location.href = 'javascript:history.back();';
			<%}%>
		</script>
	</body>
</html>