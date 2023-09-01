<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>req2 페이지입니다.</h2>


<c:forEach items="${demo2}" var="rlist">
     name = ${rlist.name}
     age = ${rlist.age}<br>
</c:forEach>

</body>
</html>

