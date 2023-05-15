<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Calculator</title>
</head>
<body>
    <h1>Web Calculator</h1>
    <form action="calculate" method="post">
        <p>
            첫번째 숫자: <input type="number" name="a" required />
        </p>
        <p>
            두번째 숫자: <input type="number" name="b" required />
        </p>
        <p>
            <input type="submit" value="실행" />
        </p>
    </form>
</body>
</html>