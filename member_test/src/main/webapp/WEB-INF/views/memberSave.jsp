<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-08
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h1 class="text-center">회원가입</h1>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<jsp:include page="component/header.jsp"></jsp:include>
<div class="input-group">
    <form action="member-save" method="post" name="frm">
        <input type="text" class="form-control" name="memberEmail" id="member-email" placeholder="이메일"><br>
        <input type="password" name="memberPassword" id="member-pass" placeholder="비번" onblur="check_fn()"  maxlength='16' minlength="8" n><br>
        <p id="p-check"></p>
        <input type="text" name="memberName" id="member-name" placeholder="이름"><br>
        <input type="date" class="form-control" name="memberBirth" id="member-birth" placeholder="생일"><br>
        <input type="text" class="form-control" name="memberMobile" id="member-mobile" placeholder="번호"><br>
        <input type="submit" value="등록">
    </form>
</div>

<jsp:include page="component/footer.jsp"></jsp:include>
</body>

<script>

    const check_fn = () => {
        const pw = document.getElementById("member-pass").value;
        const pckeck = document.getElementById("p-check");
        // 정규식 패턴을 정의합니다.
        const regex = /^(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]+$/;
        if (regex.test(pw)) {
            pckeck.innerHTML = "올바른 비밀번호입니다.";
            pckeck.style.color = "black";
        } else {
            // 패턴과 일치하지 않는 경우
            pckeck.innerHTML = "영소문자, 특수문자, 숫자가 포함되어야합니다.";
            pckeck.style.color = "red";
        }
    }




    $(frm).on("submit", function(e){
       const memberEmail = document.getElementById("member-email").value;
       const memberName = document.getElementById("member-name").value;
       const memberPassword = document.getElementById("member-pass").value;
       const memberBirth = document.getElementById("member-birth").value;
       const memberMobile = document.getElementById("member-mobile").value;
       e.preventDefault();
       if(memberEmail == ""){
           alert("이메일입력바람!")
       }else if(memberPassword==""){
           alert("비번입력바람!")
       }else if(memberName==""){
           alert("이름입력바람!")
       }else if(memberBirth==""){
           alert("생일입력바람!")
       }else if(memberMobile==""){
           alert("번호입력바람!")
       }else{
           $(frm).submit();
       }
   })




</script>
</html>
