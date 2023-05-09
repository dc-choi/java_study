<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>서울의 자존심! LG Twins Go for V3!</h1>
    <p>현재 선수 ${total}명</p>

    <table border="1">
        <tr>
            <th>등번호</th>
            <th>이름</th>
            <th>연봉(만원)</th>
        </tr>
        <c:forEach var="twins" items="${list}">
            <tr>
                <td>${twins.sunsu_id}</td>
                <td>${twins.sunsu}</td>
                <td>${twins.salary}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
