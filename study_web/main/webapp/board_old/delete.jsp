<%@page import="board.model.BoardDto"%>
<%@page import="board.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Long no = Long.parseLong(request.getParameter("no"));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet"  href="../css/board.css" type="text/css" />
	</head>
	<body>
		<form action="delete_action.jsp" method="post">
			<table>
				<caption>글 수정</caption>
				<tr>
					<th>번호</th>
					<td>
						<%=no%>
						<input type="hidden" name="no" required="required" value="<%=no%>" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="password" required="required" /><br>
						* 처음 글을 작성시 입력한 비밀번호를 동일하게 재입력해주세요.
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="완료" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>