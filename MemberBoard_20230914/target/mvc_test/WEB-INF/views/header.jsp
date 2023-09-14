<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
          crossorigin="anonymous"></script>
</head>
<div class="row">
  <div class="col">
    <p style="text-align: center;">
      <img src="/resources/image/header01%20.jpg" width="20%" id="img_header">
    </p>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      <div class="container-fluid">
        <a class="navbar-brand" href="/" id="home">Home</a>
        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/member/save">회원가입</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/board/list">글목록</a>
              </li>
        <c:if test="${user!=null}">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/member/read">마이페이지</a>
            </li>
        </c:if>
            <c:if test="${sessionScope.user == 'admin@admin.com'}">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/member/admin">관리자화면</a>
              </li>
            </c:if>
          </ul>
          <ul class="navbar-nav mb-2 mb-lg-0">
            <c:if test="${user==null}">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/member/login">로그인</a>
              </li>
            </c:if>
            <c:if test="${user!=null}">
              <li class="nav-item">
                <li class="nav-link active" aria-current="page">${user}님</li>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/member/logout">로그아웃</a>
              </li>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</div>
