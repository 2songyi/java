<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Pricing example · Bootstrap v4.6</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/pricing/">
	<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet">


    <!-- Bootstrap core CSS -->
	<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">



    <style>
    @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap');

    body {
    	font-family: 'Nanum Gothic', sans-serif;
    }

      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>


    <!-- Custom styles for this template -->
    <link href="<c:url value='/resources/css/success_login.css'/>" rel="stylesheet">
  </head>
  <body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
  <h5 class="my-0 mr-md-auto font-weight-normal">SongBank</h5>
  <nav class="my-2 my-md-0 mr-md-3">
    <a href="#">${userId}님 환영합니다.</a>
    <a class="p-2 text-dark" href="#">내 통장</a>
    <a class="p-2 text-dark" href="#">잔고</a>
    <a class="p-2 text-dark" href="#">송금</a>
    <a class="p-2 text-dark" href="#">계좌 개설</a>
  </nav>
  <a class="btn btn-outline-primary" href="#">Log out</a>
</div>
<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <!-- <h1 class="display-4">Pricing</h1> -->
  <!-- <p class="lead">Quickly build an effective pricing table for your potential customers with this Bootstrap example. It’s built with default Bootstrap components and utilities with little customization.</p> -->
</div>
<div class="container">
  <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">내 통장</h4>
      </div>
      <div class="card-body">
        <ul class="list-unstyled mt-3 mb-4">
          <li></li>
          <li></li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href='find_account'">내 계좌 목록</button>
        <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href='get_balance'">잔고 확인</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">계좌 개설</h4>
      </div>
      <div class="card-body">
        <!-- <h1 class="card-title pricing-card-title">$15 <small class="text-muted">/ mo</small></h1> -->
        <ul class="list-unstyled mt-3 mb-4">
          <li>예금 통장 개설</li>
          <li>입출금 통장 개설</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href='add_account'">지금 계좌 개설하기</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">송금</h4>
      </div>
      <div class="card-body">
        <!-- <h1 class="card-title pricing-card-title">$29 <small class="text-muted">/ mo</small></h1> -->
        <ul class="list-unstyled mt-3 mb-4">
          <li>다른사람의 계좌로<br>이체할 수 있습니다</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href='transfer'">계좌이체</button>
      </div>
    </div>
  </div>

  <footer class="pt-4 my-md-5 pt-md-5 border-top">
    <div class="row">
      <div class="col-12 col-md">
        <img class="mb-2" src="../assets/brand/bootstrap-solid.svg" alt="" width="24" height="24">
        <small class="d-block mb-3 text-muted">&copy; LeeSongYi</small>
      </div>
    </div>
  </footer>
</div>



  </body>
</html>
