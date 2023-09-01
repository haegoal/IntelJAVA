<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="l">
        <h2>${l.p1}</h2>
        <h2>${l.p2}</h2>
        <h2>${l.p3}</h2>
    </c:forEach>
</body>
</html>
