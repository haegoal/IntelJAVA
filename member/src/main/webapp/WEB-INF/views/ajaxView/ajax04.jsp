<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<button onclick="ajax04()">함수호출</button>
</body>
<script>
    const ajax04 = () => {
        $.ajax({
            type: "get",
            url: "/ajax04",
            data: {
                p1: "hello",
                p2: "안녕"
            },
            success: function (res) {
                console.log("성공", res);
            },
            error: function () {
                console.log("실패");
            }
        });
    }
</script>
</html>
