<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
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
    <div id="member-list">
        <table class="table table-bordered">
            <tr>
                <td>id</td>
                <td>email</td>
                <td>name</td>
                <td>birth</td>
                <td>mobile</td>
                <td>조회</td>
                <td>삭제</td>
            </tr>
            <c:forEach items="${memberList}" var="member">
                <tr>
                    <td>${member.id}</td>
                    <td onclick="search_fu(${member.id})" style="cursor: pointer">${member.memberEmail} </td>
                    <td>${member.memberName}</td>
                    <td>${member.memberBirth}</td>
                    <td>${member.memberMobile}</td>
                    <td>
                        <button class="btn btn-info" onclick="detail_fn('${member.id}')">조회</button>
                        <a href="/member?id=${member.id}">조회</a>
                    </td>
                    <td>
                        <button class="btn btn-danger" onclick="delete_fn('${member.id}')">삭제</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="search">

    </div>
</div>

<%@include file="component/footer.jsp" %>
</body>

<script>

    const search_fu = (id) => {
        $.ajax({
            type: "get",
            url: "/memberSearch",
            data: {id},
            success: function (data) {
                console.log(data);
                const resultArea = document.getElementById("search");
                let result = "<table class='table table-dark'>";
                result += "<th>" + "아이디" + "</th>";
                result += "<th>" + "생일" + "</th>"
                result += "<th>" + "이름" + "</th>"
                result += "<th>" + "번호" + "</th>"
                result += "<tr>";
                result += "<td>" + data.id + "</td>";
                result += "<td>" + data.memberBirth + "</td>";
                result += "<td>" + data.memberName + "</td>";
                result += "<td>" + data.memberMobile + "</td>";
                result += "</tr>";
                result += "</table>";
                resultArea.innerHTML = result;
            }, error: function () {
                console.log("회원정보가없습니다.");
            }
        })
    }
    const detail_fn = (id) => {
        location.href = "/member?id=" + id;
    }

    const delete_fn = (id) => {
        location.href = "/delete?id=" + id;
    }
</script>
</html>
