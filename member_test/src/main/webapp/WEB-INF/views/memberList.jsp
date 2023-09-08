<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h1 class="text-center">회원목록</h1>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<jsp:include page="component/header.jsp"></jsp:include>
<div id="member-list">
    <table class="table table-dark">
        <th>이메일</th>
        <th>이름</th>
        <th>생일</th>
        <th>번호</th>
        <c:forEach items="${memberList}" var="member">
    <tr>
        <td onclick="search_fn(${member.id})" style="cursor: pointer">${member.memberEmail}</td>
        <td>${member.memberName}</td>
        <td>${member.memberBirth}</td>
        <td>${member.memberMobile}</td>
        <td><a href="update?id=${member.id}"><button>수정</button></a></td>
    </tr>
</c:forEach>
    </table>
</div>
<div id="member-about"></div>
<jsp:include page="component/footer.jsp"></jsp:include>
</body>
<script>
    const search_fn = (id) => {
        const member = document.getElementById("member-about");
        $.ajax({
            type:"post",
            data:{
                id
            },
            url:"/member-ajax",
            success:function (data){
                console.log(data);
                let result = "<table class='table table-dark'>";
                result += "<tr>";
                result += "<td>" + data.id + "</td>";
                result += "<td>" + data.memberEmail + "</td>";
                result += "<td>" + data.memberName + "</td>";
                result += "<td>" + data.memberMobile + "</td>";
                result += "<td>" + data.memberBirth + "</td>";
                result += "</tr>";
                result += "</table>";
                member.innerHTML = result;
            },error:function (){
                console.log("없음")
            }
        })
    }
</script>
</html>
