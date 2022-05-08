<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2023-05-08
  Time: 오후 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>멤버 추가</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <form:form action="addMemberAction" method="post" modelAttribute="member">
        <table>
            <tr>
                <td>아이디</td>
                <td><form:input type="text" path="id"/></td>
                <td><form:errors path="id" cssClass="error" /></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><form:input type="text" path="name" /></td>
                <td><form:errors path="name" cssClass="error" /></td>
            </tr>
            <tr>
                <td>생년월일 (yyyy/mm/dd)</td>
                <td><form:input type="text" path="birth" /></td>
                <td><form:errors path="birth" cssClass="error" /></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><form:input type="password" path="password" /></td>
                <td><form:errors path="password" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="추가"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
