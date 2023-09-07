<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/main.css">

    <style>
        #section {
            margin: auto;
        }
    </style>
</head>
<body>
<%@include file="component/header.jsp" %>
<%@include file="component/nav.jsp" %>
<div id="section">
    <form action="/update" method="post" name="updateForm">
        <input type="hidden" name="id" value="${member.id}">
        <input class="form-control" type="text" name="memberEmail" value="${member.memberEmail}" placeholder="이메일"
               readonly> <br>
        <input type="text" name="memberPassword" id="member-password" placeholder="비밀번호"> <br>
        <input type="text" name="memberName" value="${member.memberName}" placeholder="이름"> <br>
        <input type="text" name="memberBirth" value="${member.memberBirth}" placeholder="생년월일(YYYYMMDD)" readonly> <br>
        <input type="text" name="memberMobile" value="${member.memberMobile}" placeholder="전화번호"> <br>
        <input type="button" value="수정" onclick="update_fn()">
        <%--        <button onclick="fun1()">함수호출</button>--%>
    </form>
</div>
<%@include file="component/footer.jsp" %>
</body>
<script>
    const update_fn = () => {
        const passInput = document.getElementById("member-password").value;
        const passDB = '${member.memberPassword}';
        if (passInput == passDB) {
            document.updateForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다!");
        }
    }
</script>
</html>
