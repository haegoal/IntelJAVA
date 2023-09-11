<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<form name="frm">
    <input type="hidden" name="id" value="${result.id}">
    <input type="hidden" name="boardHits" value="${result.boardHits}">
    <input type="text" name="boardWriter" value="${result.boardWriter}" readonly><br>
    <input type="password" name="boardPass" placeholder="비번입력바람!"><br>
    <input type="text" name="boardTitle" value="${result.boardTitle}"><br>
    <textarea name="boardContents" placeholder="글내용" value="${result.boardContents}"></textarea><br>
    <input type="submit" value="수정">
    <input type="reset" value="취소">
</form>
</body>
<script>
    $(frm).on("submit", function(e){
        e.preventDefault();
        const id = $(frm.id).val();
        const boardWriter = $(frm.boardWriter).val();
        const boardPass = $(frm.boardPass).val();
        const boardTitle= $(frm.boardTitle).val();
        const boardContents = $(frm.boardContents).val();
        const boardHits = $(frm.boardHits).val();
        if(boardWriter==""){
            alert("글입력바람")
            $(frm.boardWriter).focus();
        }else if(boardPass==""){
            alert("비번입력바람")
            $(frm.boardPass).focus();
        }else if(boardTitle==""){
            alert("제목입력바람")
            $(frm.boardTitle).focus();
        }else if(boardContents==""){
            alert("내용입력바람")
            $(frm.boardContents).focus();
        }else{
            $.ajax({
                type:"post",
                url:"/board/update",
                data:{
                    id, boardWriter, boardContents, boardTitle, boardPass, boardHits
                },
                success:function () {
                    alert("수정완료")
                    location.href="/board1?id=" + ${result.id}; // 업데이트 후에는 조회수 늘어나지않게하기위해 새로 만듬
                },error:function (){
                    alert("비밀번호가 틀렸습니다.")
                }
            })
        }
    })
</script>
</html>
