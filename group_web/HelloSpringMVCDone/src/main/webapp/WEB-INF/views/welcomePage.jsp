<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2023-05-04
  Time: 오후 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>환영합니다.</title>
</head>
<body>
    <h2 align="center">${welcomeMessage}</h2>
    <table align="center">
        <tr>
            <td><a href="/HelloSpringMVC/login">로그인</a></td>
            <td><a href="/HelloSpringMVC/register">회원가입</a></td>
        </tr>
    </table>
</body>
</html>
