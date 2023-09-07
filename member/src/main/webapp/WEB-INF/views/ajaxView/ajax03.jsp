<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<button onclick="ajax03()">함수호출</button>
</body>
<script>
    const ajax03 = () => {
        $.ajax({
            type: "get",
            url: "/ajax03",
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
