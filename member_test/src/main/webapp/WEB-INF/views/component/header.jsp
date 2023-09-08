<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="nav">
  <ul class="menu">
    <li class="menu-item">
      <a href="/">home</a>
    </li>
    <li class="menu-item">
      <a href="/save">회원가입</a>
    </li>
    <c:if test="${sessionScope.loginEmail ==null}">
    <li class="menu-item">
      <a href="/login">로그인</a>
    </li>
    </c:if>
    <li class="menu-item">
      <a href="/members">회원목록</a>
    </li>
    <c:if test="${sessionScope.loginEmail == 'admin'}">
      <li class="menu-item">
        <a href="/member">회원조회</a>
      </li>
    </c:if>
  </ul>
</div>