<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글조회</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
    <div id="div-search">
        <table class="table">
            <tr>
                <td>아이디</td>
                <td>작성자</td>
                <td>내용</td>
                <td>제목</td>
                <td>조회수</td>
                <td>비번</td>
                <td>작성일</td>
            </tr>
            <tr>
                <td>${result.id}</td>
                <td>${result.boardWriter}</td>
                <td>${result.boardContents}</td>
                <td>${result.boardTitle}</td>
                <td>${result.boardHits}</td>
                <td>${result.boardPass}</td>
                <td>${result.createdAt}</td>
                <c:if test="${result.fileAttached==1}">
                    <tr>
                        <th>image</th>
                        <td>
                            <img src="${pageContext.request.contextPath}/upload/${boardFile.storedFileName}"
                                 alt="" width="100" height="100">
                        </td>
                    </tr>
                </c:if>

                <td><button class="btn btn-success" onclick="up_fn(${result.id})">수정</button></td>
                <td><button class="btn btn-danger" onclick="del_fn(${result.id})">삭제</button></td>
            </tr>
        </table>
    </div>
<div>
    <input type="text" id="commentWriter" placeholder="댓글작성자"><br>
    <input type="text" id="commentContents" placeholder="댓글내용내용"><br>
        <button onclick="com_fn(${result.id})">댓글작성</button>
</div>
<div id="div-comment">
    <c:if test="${cl==a}">
    <h1>댓글이없습니다.</h1>
    </c:if>
    <c:if test="${cl!=a}">
    <table class="table">
        <tr>
            <th>아이디</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
<c:forEach items="${cl}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.commentWriter}</td>
            <td>${c.commentContents}</td>
            <td>${c.commentCreatedDate}</td>
        </tr>
</c:forEach>
</c:if>
    </table>
</div>
</body>
<script>
    const list = document.getElementById("div-comment");

    const com_fn = (boardId) => {
      const commentWriter = document.getElementById("commentWriter").value;
      const commentContents = document.getElementById("commentContents").value;
      alert(commentWriter + commentContents)
      $.ajax({
          type:"post",
          url:"/comment/save",
          data:{
              boardId, commentWriter, commentContents
          },
          success:function(){
              document.getElementById("commentContents").value = "";
              document.getElementById("commentWriter").value = "";
              $.ajax({
                  type:"get",
                  url:"/comment",
                  data:{boardId},
                  success:function(data){
                      console.log(data);
                      let result = "<table class='table'>";
                          result += "<tr>";
                          result += "<th>아이디</th>";
                          result += "<th>작성자</th>";
                          result += "<th>제목</th>";
                          result += "<th>작성일</th>";
                          result += "</tr>";
                      for(let i=0; i<data.length; i++){
                          result += "<tr>";
                          result += "<td>" + data[i].id + "</td>";
                          result += "<td>" + data[i].commentWriter +"</td>";
                          result += "<td>" + data[i].commentContents + "</td>";
                          result += "<td>" + data[i].commentCreatedDate +"</td>";
                          result += "</tr>";
                      }
                          result += "</table>";
                      list.innerHTML = result;
                  }
              })
          },error:function (){
              console.log("실패")
          }
      })
    }

    const del_fn = (id) => {
      location.href="/deleteCheck?id=" + id;
    }

    const up_fn = (id) => {
        location.href="/board/update?id=" + id;
    }
</script>
</html>
