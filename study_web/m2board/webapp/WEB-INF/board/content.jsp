<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet"  href="css/board.css" type="text/css" />
	</head>
	<script>
		const confirm_delete = () => {
			if (!confirm('정말로 삭제하시겠습니까?')) {
				return;
			}
			
			location.href = 'BoardDeleteAction.do?no=${dto.no}';
		};
	</script>
	<body>
		<table width="600">
			<caption>상세보기</caption>
			<tr>
				<th>글번호</th>
				<td>${dto.no}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.title}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${dto.memberDto.name} (${dto.memberDto.id})</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.readcount}</td>
			</tr>
			<tr>
				<th>작성시간</th>
				<td>${dto.regdate}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${dto.content}</td>
			</tr>
		</table>
		<a href="BoardList.do">[리스트]</a>
		<!-- sessionScope 객체는 jsp에서 세션에 접근시 사용한다. -->
		<jstl:if test="${dto.memberDto.id == sessionScope.member.id }">
			<a href="BoardUpdate.do?no=${dto.no}">[수정]</a>
			<a href="javascript:;" onclick="confirm_delete();">[삭제]</a>
		</jstl:if>
	</body>
</html>