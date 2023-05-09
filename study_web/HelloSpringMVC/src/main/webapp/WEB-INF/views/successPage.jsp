<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2023-05-09
  Time: 오전 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h3 align="center">귀하가 로그인한 정보는 다음과 같습니다.</h3>
  <table align="center" border="5px">
      <tr>
          <td>id:</td>
          <td>${member.id}</td>
      </tr>
      <tr>
          <td>이름:</td>
          <td>${member.name}</td>
      </tr>
      <tr>
          <td>생년월일:</td>
          <td>${member.birth}</td>
      </tr>
  </table>
</body>
</html>
