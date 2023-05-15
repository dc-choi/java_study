<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2023-05-08
  Time: 오후 1:41
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
    <form:form action="/HelloSpringMVC/registerSuccess" method="post"
        modelAttribute="member">
        <table>
            <tr>
                <td>id</td>
                <td><form:input path="id"/></td>
                <td><form:errors path="id" cssClass="error"/></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td>생년월일(ex. 1995-06-01)</td>
                <td><form:input path="birth"/></td>
                <td><form:errors path="birth" cssClass="error"/></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="등록"></td>
                <td></td>
            </tr>
        </table>
    </form:form>

  <%--<form action="/HelloSpringMVC/registerSuccess" method="post">
      <table>
          <tr>
              <td>id</td>
              <td><input type="text" name="id"></td>
          </tr>
          <tr>
              <td>이름</td>
              <td><input type="text" name="name"></td>
          </tr>
          <tr>
              <td>생년월일(ex. 1995/06/01)</td>
              <td><input type="text" name="birth"></td>
          </tr>
          <tr>
              <td>비밀번호</td>
              <td><input type="password" name="password"></td>
          </tr>
          <tr>
              <td><input type="submit" value="등록"></td>
              <td></td>
          </tr>
      </table>
  </form>--%>
</body>
</html>
