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
    <title>add_account</title>

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
    
  </head>
   

<body>

  <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">SongBank</h5>
    <nav class="my-2 my-md-0 mr-md-3">
      <a class="p-2 text-dark" href="#">내 통장</a>
      <a class="p-2 text-dark" href="#">잔고</a>
      <a class="p-2 text-dark" href="#">송금</a>
      <a class="p-2 text-dark" href="#">계좌 개설</a>
    </nav>
    <a class="btn btn-outline-primary" href="#">Log out</a>
  </div>

  <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">잔액조회</h1>
    <p class="lead"></p>
  </div>

  <div class="container">
    <div class="row justify-content-center">

      <div class="col-md-8 order-md-1">
        <form action="" method="post" class="needs-validation" novalidate>

          <div class="mb-3">
            <label for="accType">계좌 종류</label>
            <select name="accType" class="custom-select d-block w-100" id="accType" required>
              <option value="S">예금 계좌</option>
              <option value="C">입출금 계좌</option>
            </select>
          </div>

          <div class="mb-3">
            <label for="username">최초 입금액</label>
            <input type="number" name="balance" class="form-control" id="balance" placeholder="최초 입금액(원)" required>
            <div class="invalid-feedback" style="width: 100%;">
              최초입금액은 필수입니다.
            </div>
          </div>
          <hr class="mb-4">

          <button class="btn btn-primary btn-lg btn-block" type="submit">잔액 조회</button>
        </form>

        <hr class="mb-4">
        <div class="mb-3">
          <h4>${accountNum} 의 현재 잔액은</h4><br>
          <h3>${balacne} 원 입니다.</h3>
          </div>
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