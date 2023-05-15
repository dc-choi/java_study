<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2023-05-09
  Time: 오전 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <form:form action="/HelloSpringMVC/loginSuccess"
               method="post" modelAttribute="login">
        <table>
            <tr>
                <td>아이디:</td>
                <td><form:input path="id" /></td>
                <td><form:errors path="id" cssClass="error" /> </td>
            </tr>
            <tr>
                <td>비밀번호:</td>
                <td><form:password path="pass" /></td>
                <td><form:errors path="pass" cssClass="error" /> </td>
            </tr>
            <tr>
                <td><input type="submit" value="로그인"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
