<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>demodb2 페이지입니다.</h2>


<c:forEach items="${demolist}" var="list">
    <table>
        <tr>
             <td>
             <a href="/find?id=${list.id}">${list.id}</a>
             </td>
             <td>${list.name}</td>
             <td>${list.age}</td>

        <tr>
    </table>
</c:forEach>

<form action="/req4" method="post">
     <input name="id"><button>삭제</button>
</form>

</body>
</html>

