<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2023-05-08
  Time: 오전 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/HelloSpringMVC/register">등록</a>
    <h2>사용자 등록 애플리케이션</h2>
    <table border="1">
        <tr>
            <th>id</th>
            <th>이름</th>
            <th>생년월일</th>
            <th>비번</th>
        </tr>
        <c:forEach var="member" items="${memberlist}">
            <tr>
                <td>${member.id}</td>
                <td>${member.name}</td>
                <td>${member.birth}</td>
                <td>${member.password}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
