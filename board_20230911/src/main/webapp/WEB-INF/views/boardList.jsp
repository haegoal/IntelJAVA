<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="row">
    <div class="col">
        <div class="col-2">
                    <div class="input-group">
                    <select class="form-select" id="key">
                        <option selected value="boardWriter">작성자</option>
                        <option value="boardTitle">제목</option>
                        <option value="boardContents">내용</option>
                        <option value="boardHits">조회수</option>
                    </select>
                    <input id="query" class="form-control" placeholder="검색어">
                        <button class="btn btn-primary" onclick="query_fn()">검색</button>
                    </div>
        </div>
        <div id="board-list">
            <table class="table table-bordered">
                <tr>
                    <td>작성자</td>
                    <td>제목</td>
                    <td>내용</td>
                    <td>조회수</td>
                    <td>작성일</td>
                </tr>
                <c:forEach items="${board}" var="bd">
                    <tr style="cursor: pointer;" onclick="search_fn(${bd.id})">
                        <td>${bd.boardWriter}</td>
                        <td>${bd.boardTitle}</td>
                        <td>${bd.boardContents}</td>
                        <td>${bd.boardHits}</td>
                        <td>${bd.createdAt}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
<script>

    
    const query_fn= () => {
        const key = document.getElementById("key").value;
        const query = document.getElementById("query").value;
        $.ajax({
            type: "get",
            url: "/board/search",
            data: {
                key, query
            },
            success: function (data) {
                const boardList = document.getElementById("board-list");
                let result = "<table class='table'>";
                result += "<tr>";
                result += "<th>아이디</th>";
                result += "<th>작성자</th>";
                result += "<th>제목</th>";
                result += "<th>내용</th>";
                result += "<th>조회수</th>";
                result += "<th>작성일</th>";
                result += "</tr>";
                for (let i in data) {
                        result += "<tr style='cursor: pointer;'  onclick=search_fn("+data[i].id+")>";
                        result += "<td>" + data[i].id + "</td>";
                        result += "<td>" + data[i].boardWriter + "</td>";
                        result += "<td>" + data[i].boardTitle + "</td>";
                        result += "<td>" + data[i].boardContents + "</td>";
                        result += "<td>" + data[i].boardHits + "</td>";
                        result += "<td>" + data[i].createdAt + "</td>";
                        result += "</tr>";
                }
                result += "</table>";
                boardList.innerHTML = result;
            },error:function (){
                console.log("에러")
            }
        })
    }

    const search_fn = (id) => {
        location.href = "/board?id=" + id;
    }





</script>
</html>
