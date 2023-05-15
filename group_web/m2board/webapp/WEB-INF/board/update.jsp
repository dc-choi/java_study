<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet"  href="css/board.css" type="text/css" />
		<script src="se2/js/service/HuskyEZCreator.js"></script>
		<script>
			const goUpdate = () => {
				let f = document.myform;
				// 에디터의 내용이 textarea에 적용된다.
				oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
				f.submit();
			};
		</script>
	</head>
	<body>
		<form action="BoardUpdateAction.do" method="post" name="myform">
			<table>
				<caption>글 수정</caption>
				<tr>
					<th>번호</th>
					<td>
						${dto.no}
						<input type="hidden" name="no" required="required" value="${dto.no}" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" autofocus="autofocus" required="required" value="${dto.title}" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="5" style="width:645px;" name="content" id="content" required="required">${dto.content}</textarea>
						<script>
							var oEditors = [];
							
							nhn.husky.EZCreator.createInIFrame({
								oAppRef: oEditors,
								elPlaceHolder: "content",
								sSkinURI: "se2/SmartEditor2Skin.html",
								fCreator: "createSEditor2"
							});
						</script>
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