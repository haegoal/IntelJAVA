<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<button onclick="ajax11()">함수호출</button>
<div id="result-area">

</div>
</body>
<script>
    const ajax11 = () => {
        const email = "member@member.com";
        const pass = "1234";
        const name = "회원1";
        const birth = "19990101";
        const mobile = "010-9999-9999";
        $.ajax({
            type: "post",
            url: "/ajax11",
            data: {
                memberEmail: email,
                memberPassword: pass,
                memberName: name,
                memberBirth: birth,
                memberMobile: mobile
            },
            success: function (res) {
                console.log("성공", res);
                const resultArea = document.getElementById("result-area");
                let result = "<table>";
                for (let i in res) {
                    result += "<tr>";
                    result += "<td>" + res[i].memberEmail + "</td>";
                    result += "<td>" + res[i].memberName + "</td>";
                    result += "<td>" + res[i].memberBirth + "</td>";
                    result += "<td>" + res[i].memberMobile + "</td>";
                    result += "</tr>";
                }
                result += "</table>";
                resultArea.innerHTML = result;
            },
            error: function (err) {
                console.log("실패", err);
                alert(err.responseText);
            }
        });
    }
</script>
</html>
