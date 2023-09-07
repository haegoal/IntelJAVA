<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        table {
            margin: auto;
        }
    </style>
</head>
<body>
<%@include file="component/header.jsp" %>
<%@include file="component/nav.jsp" %>
<div class="container">
    <div id="member-detail">
        <table class="table table-bordered">
            <tr>
                <td>id</td>
                <td>email</td>
                <td>name</td>
                <td>birth</td>
                <td>mobile</td>
            </tr>
            <tr>
                <td>${member.id}</td>
                <td>${member.memberEmail}</td>
                <td>${member.memberName}</td>
                <td>${member.memberBirth}</td>
                <td>${member.memberMobile}</td>
            </tr>
        </table>
        <a href="/members">목록으로 돌아가기</a>
    </div>
</div>

<%@include file="component/footer.jsp" %>
</body>
</html>
