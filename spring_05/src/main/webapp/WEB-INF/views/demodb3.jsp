<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>demodb3 페이지입니다.</h2>

<form action="update?id=${demo.id}" method="post">
    <input value="${demo.name}" name="name">
    <input value="${demo.age}" name="age">
    <button>수정</button>
</form>


</body>
</html>

