<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>
			you: ${you}<br> <!-- EL(Expression Language): 표현언어 사용 -->
			com: ${com}<br> <%-- ${}를 주석안에서 사용하려면 이렇게 해야함. --%>
			result: ${result}
		</h1>
	</body>
</html>