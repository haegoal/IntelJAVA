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
    <form action="member-update" method="post">
        <input type="hidden" name="id" value="${member.id}">
        <input type="text" class="form-control" name="memberEmail" id="member-email" placeholder="이메일" value="${member.memberEmail}" readonly><br>
        <input type="password" name="memberPassword" id="member-pass" placeholder="비번" value="${member.memberPassword}" readonly><br>
        <input type="text" name="memberName" id="member-name" placeholder="이름" value="${member.memberName}"><br>
        <input type="date" class="form-control" name="memberBirth" id="member-birth" placeholder="생일" value="${member.memberBirth}"><br>
        <input type="text" class="form-control" name="memberMobile" id="member-mobile" placeholder="번호" value="${member.memberMobile}"><br>
        <input type="submit" value="등록">
    </form>
</div>

<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>
