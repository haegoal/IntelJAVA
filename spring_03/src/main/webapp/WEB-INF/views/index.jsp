<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>안녕하세요</h1>
<a href="/demo1">demo1</a>
    <form action="/demo2" method="post">
        p1: <input type="text" name="param1"><br>
        p2: <input type="text" name="param2"><br>
        <input type="submit" value="전송">
    </form>

    <form action="/demo3" method="post">
            p1: <input type="text" name="param1"><br>
            p2: <input type="text" name="param2"><br>
            <input type="submit" value="전송">
    </form>

    <a href="/result1">변수 화면에 출력</a>
    <a href="/result2">DTO 화면에 출력</a>
    <a href="/result3">List 화면에 출력</a>
    <br>

</body>
</html>
