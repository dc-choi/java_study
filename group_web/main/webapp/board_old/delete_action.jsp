<%@page import="board.model.BoardDto"%>
<%@page import="board.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Long no = Long.parseLong(request.getParameter("no"));
	String password = request.getParameter("password");
	
	BoardDto board = new BoardDto();
	board.setNo(no);
	board.setPassword(password);
	
	boolean result = BoardDao.getInstance().deleteBoard(board);
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
				alert("글이 삭제되었습니다.");
				location.href = 'list.jsp';
			<%} else {%>
				alert("글 삭제 실패.");
				location.href = 'javascript:history.back();';
			<%}%>
		</script>
	</body>
</html>