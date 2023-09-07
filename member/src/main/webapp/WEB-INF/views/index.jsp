<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
<%@include file="component/header.jsp" %>
<%@include file="component/nav.jsp" %>

<h2>Member Project</h2>

로그인이메일: ${sessionScope.loginEmail} <br>
model에 담은 이메일: ${email} <br>

<a href="/ajax">ajax 알아보기</a>

<%@include file="component/footer.jsp" %>
</body>
</html>
