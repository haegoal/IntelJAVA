<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
<body id="particles-js"></body>
<div class="animated bounceInDown">
    <div class="container">
        <span class="error animated tada" id="msg"></span>
        <form name="frm" class="box">
            <a href="/">Home</a>
            <h4>멤버<span>게시판</span></h4>
            <h5 class="mt-2">로그인해주세요.</h5>
            <input type="text" name="email" placeholder="이메일" autocomplete="off" value="member@member.com" maxlength='25' oninput='isEng(this)'/>
            <i class="typcn typcn-eye" id="eye"></i>
            <input type="password" name="pw" placeholder="비밀번호" id="pw"  value="1234" autocomplete="off" maxlength='25'>
            <small class="rmb">계정정보저장</small>
            <input type="checkbox" name="keep">
            <a href="#" class="forgetpass">Forget Password?</a>
            <input type="submit" value="로그인" class="btn1">
        </form>
    </div>
</div>
</body>
<script>

    $(frm).on("submit", function(e){
        e.preventDefault();
        const memberEmail= $(frm.email).val();
        const memberPassword= $(frm.pw).val();
        const keep=$(frm.keep).is(":checked");
        if(memberEmail ==""){
            alert("이메일입력바람");
            $(frm.memberEmail).focus();
        }
        else if (!(memberEmail.includes("@"))){
            alert("이메일형식으로입력바람!");
            $(frm.memberEmail).focus();
        }else if(memberPassword==""){
            alert("비밀번호입력바람");
            $(frm.memberPassword).focus();
        }else{
            $.ajax({
                type:"post",
                data:{memberEmail, memberPassword, keep},
                url:"/member/login",
                success:function(data){
                    console.log(data)
                    alert(memberEmail + "님 환영합니다.");
                    location.href="/board/list";
                }, error:function (){
                    alert("이메일 또는 비밀번호가 일치하지않습니다.");
                }
            })
        }
    })

    function isEng(item) {
        item.value = item.value.replace(/[^A-Za-z0-9!@#$%^&*()_+{}\[\]:;<>,.?~\\/\-=| ]/ig, '');
    }
</script>
</html>
