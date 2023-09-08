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
    <h1 class="text-center">로그인</h1>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<jsp:include page="component/header.jsp"></jsp:include>
<div class="input-group">
    <form action="member-login" method="post">
        <input type="text" class="form-control" name="memberEmail" id="member-email" placeholder="이메일"><br>
        <input type="password" name="memberPassword" id="member-pass" placeholder="비번"><br>
        <input type="submit" value="로그인">
    </form>
</div>


<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>
