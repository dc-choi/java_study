<%@page import="board.model.BoardDto"%>
<%@page import="board.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 문자열로 값이 넘어옴.
	Long no = Long.parseLong(request.getParameter("no"));
	BoardDao dao = BoardDao.getInstance();
	boolean result = dao.updateReadcount(no);
	if (!result) {
%>
		<script>
			alert('해당하는 글이 존재하지 않습니다.');
			location.href = 'list.jsp';
		</script>
<%
		return;
	}
	BoardDto dto = dao.getBoardView(no);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet"  href="../css/board.css" type="text/css" />
	</head>
	<body>
		<table width="600">
			<caption>상세보기</caption>
			<tr>
				<th>글번호</th>
				<td><%=dto.getNo()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=dto.getTitle()%></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><%=dto.getName()%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=dto.getReadcount()%></td>
			</tr>
			<tr>
				<th>작성시간</th>
				<td><%=dto.getWriteday()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><%=dto.getContent()%></td>
			</tr>
		</table>
		<a href="list.jsp">[리스트]</a>
		<a href="update.jsp?no=<%=dto.getNo()%>">[수정]</a>
		<a href="delete.jsp?no=<%=dto.getNo()%>">[삭제]</a>
	</body>
</html>