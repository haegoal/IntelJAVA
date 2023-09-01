<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>안녕</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
    <h1>안녕하세요~ 반갑습니다!</h1>
    <a href="/req1">req1 주소요청</a>
    <a href="/req2?q1=안녕&q2=5">query String</a>

    <form action="/req3">
        p1: <input name="p1"> <br>
        p2: <input name="p2"> <br>
        <input type="submit" value="전송">
    </form>
</body>
</html>
