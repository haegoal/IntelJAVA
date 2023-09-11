<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글조회</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
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
                <td><button class="btn btn-success" onclick="up_fn(${result.id})">수정</button></td>
                <td><button class="btn btn-danger" onclick="del_fn(${result.id})">삭제</button></td>
            </tr>
        </table>
    </div>
<div>
    <form name="frm1">
    <input type="text" name="commentWriter" placeholder="댓글작성자"><br>
    <input type="text" name="commentContents" placeholder="댓글내용내용"><br>
        <button onclick="com_fn(${result.id})">댓글작성</button>
    </form>
</div>
</body>
<script>

    const com_fn = (boardId) => {

      const commentWriter = $(frm1.commentWriter).val();
      const commentContents = $(frm1.commentContents).val();
      $.ajax({
          type:"post",
          url:"/comment/save",
          data:{
              boardId, commentWriter, commentContents
          },
          success:function(){

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
