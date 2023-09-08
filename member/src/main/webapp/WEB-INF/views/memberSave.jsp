<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

    <style>
        #section {
            margin: auto;
        }
    </style>
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>
<div id="section">
    <form action="/save" method="post">
        <input class="form-control" type="text" name="memberEmail" placeholder="이메일" id="member-email" onkeyup="check_fn()"> <br>
        <p id="p-check"></p>
        <input type="text" name="memberPassword" placeholder="비밀번호"> <br>
        <input type="text" name="memberName" placeholder="이름"> <br>
        <input type="text" name="memberBirth" placeholder="생년월일(YYYYMMDD)"> <br>
        <input type="text" name="memberMobile" placeholder="전화번호"> <br>
        <input type="submit" value="회원가입">
    </form>
</div>
<%@include file="component/footer.jsp"%>

</body>
<script>
    const check_fn = () => {
        const memberEmail = document.getElementById("member-email").value;
        const p = document.getElementById("p-check");
            $.ajax({
                type: "get",
                data: {memberEmail},
                url: "/checkEmail",
                success:function(data){
                    if(memberEmail.length>0){
                        p.innerHTML = data;
                    }else {
                        p.innerHTML = "";
                    }
                }, error:function (){
                    alert("실패");
                }
            })
    }
</script>
</html>
