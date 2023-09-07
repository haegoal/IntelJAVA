<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<button onclick="ajax01()">함수호출</button>
</body>
<script>
    const ajax01 = () => {
        $.ajax({
            type: "get",
            url: "/ajax01",
            success: function () {
                console.log("성공");
            },
            error: function () {
                console.log("실패");
            }
        });
    }
</script>
</html>
