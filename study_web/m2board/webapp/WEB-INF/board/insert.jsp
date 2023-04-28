<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- 
			model1과 달리 프로젝트 루트(/webdev)의 절대경로로 접근해야 한다.
			/를 붙이면 프로젝트의 루트가 아니라 서버 경로의 루트로 인식한다.
			EX) /를 붙이면... /webdev/css/board.css로 접근해야함.
		-->
		<link rel="stylesheet"  href="css/board.css" type="text/css" />
	</head>
	<body>
		<form action="BoardInsertAction.do" method="post">
			<table>
				<caption>글쓰기</caption>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" autofocus="autofocus" required="required" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required="required" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password" required="required" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="5" cols="50" name="content" required="required"></textarea>
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