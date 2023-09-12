<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
    <form action="/board/save" method="post" enctype="multipart/form-data">
        <input type="text" name="boardWriter" placeholder="글작성자"><br>
        <input type="password" name="boardPass" placeholder="비번"><br>
        <input type="text" name="boardTitle" placeholder="글제목"><br>
        <textarea name="boardContents" placeholder="글내용"></textarea><br>
        <input type="file" name="boardFile"><br>
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </form>
</body>
</html>
