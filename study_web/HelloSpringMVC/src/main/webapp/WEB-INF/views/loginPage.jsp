<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <form:form action="login" method="post" modelAttribute="login">
        <table>
            <tr>
                <td>아이디</td>
                <td><form:input type="text" path="id"/></td>
                <td><form:errors path="id" cssClass="error" /></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><form:input type="password" path="password" /></td>
                <td><form:errors path="password" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="추가"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
