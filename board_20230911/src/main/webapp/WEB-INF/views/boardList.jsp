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
                <form class="col-2" name="frm">
                    <div class="input-group">
                    <select class="form-select" name="key">
                        <option selected value="boardWriter">작성자</option>
                        <option value="boardTitle">제목</option>
                        <option value="boardContents">내용</option>
                        <option value="boardHits">조회수</option>
                    </select>
                    <input name="query" class="form-control" placeholder="검색어">
                    <input class="btn btn-primary" value="검색"  type="submit">
                    </div>
                </form>
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
    const search_fn = (id) => {
        location.href = "/board?id=" + id;
    }

    $(frm).on("submit", function(e){
        $(frm).submit();
        e.preventDefault();
        const key = $(frm.key).val();
        const query = $(frm.query).val();
        $.ajax({
            type:"get",
            url:"/board/search",
            data:{
                key, query
            },
            success:function(){

            }
        })
    })
</script>
</html>
