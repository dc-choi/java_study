<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BMI 수치 정하기</title>
</head>
<body>
    <form action="bmi" method="post">
        <p>
            키(cm): <input type="number" name="height" />
        </p>
        <p>
            몸무게(kg): <input type="number" name="weight" />
        </p>
        <p>
            <input type="submit" value="실행" />
        </p>
    </form>
</body>
</html>