<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
</head>
<body>
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
<div class="container" id="list">
    <table class="table table-striped table-hover text-center">
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성시간</th>
            <th>조회수</th>
        </tr>
        <c:forEach items="${boardList}" var="board">
            <tr>
                <td>${board.id}</td>
                <td><a href="/board?id=${board.id}&page=${paging.page}">${board.boardTitle}</a></td>
                <td>${board.boardWriter}</td>
                <td>${board.createdAt}</td>
                <td>${board.boardHits}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%-- 페이지 번호 출력 부분 --%>
<div class="container">
    <ul class="pagination justify-content-center">
        <c:choose>
            <%-- 현재 페이지가 1페이지면 이전 글자만 보여줌 --%>
            <c:when test="${paging.page<=paging.startPage}">
                <li class="page-item disabled">
                    <a class="page-link">[<<]</a>
                </li>
            </c:when>
            <%-- 1페이지가 아닌 경우에는 [이전]을 클릭하면 현재 페이지보다 1 작은 페이지 요청 --%>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="/board/list?page=${paging.startPage}">[<<]</a>
                </li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <%-- 현재 페이지가 1페이지면 이전 글자만 보여줌 --%>
            <c:when test="${paging.page<=1}">
                <li class="page-item disabled">
                    <a class="page-link">[이전]</a>
                </li>
            </c:when>
            <%-- 1페이지가 아닌 경우에는 [이전]을 클릭하면 현재 페이지보다 1 작은 페이지 요청 --%>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="/board/list?page=${paging.page-1}">[이전]</a>
                </li>
            </c:otherwise>
        </c:choose>

        <%--  for(int i=startPage; i<=endPage; i++)      --%>
        <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
            <c:choose>
                <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 텍스트만 보이게 --%>
                <c:when test="${i eq paging.page}">
                    <li class="page-item active">
                        <a class="page-link">${i}</a>
                    </li>
                </c:when>

                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="/board/list?page=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${paging.page>=paging.maxPage}">
                <li class="page-item disabled">
                    <a class="page-link">[다음]</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="/board/list?page=${paging.page+1}">[다음]</a>
                </li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${paging.page>=paging.maxPage}">
                <li class="page-item disabled">
                    <a class="page-link">[>>]</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="/board/list?page=${paging.endPage}">[>>]</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
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
                const boardList = document.getElementById("list");
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
