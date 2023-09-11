<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<form name="frm">
    <input type="hidden" name="id" value="${id}">
    <input type="text" placeholder="비번입력바람" name="boardPass">
    <input type="submit" value="삭제">
</form>

</body>
<script>
    $(frm).on("submit", function (e) {
        e.preventDefault();
        const id = $(frm.id).val();
        const boardPass = $(frm.boardPass).val();
        $.ajax({
            type: "post",
            data: {
                id, boardPass
            },
            url: "/board/delete",
            success: function () {
                location.href = "/board/";
            }, error: function () {
                alert("비밀번호가 틀렸습니다.")
            }
        })

    })
</script>
</html>
