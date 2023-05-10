<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>로그인</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
  
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="/login.do">
        <h2 class="form-signin-heading text-center mb-5">로그인</h2>

        <p>
            <label for="username" class="sr-only">아이디</label>
            <input type="text" id="uid" name="uid" class="form-control" placeholder="아이디" required="아이디를 입력해주세요" autofocus="autofocus">
        </p>
        <p>
            <label for="password" class="sr-only">비밀번호</label>
            <input type="password" id="pwd" name="pwd" class="form-control" placeholder="비밀번호" required="비밀번호를 입력해주세요">
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
    </form>

    <form class="form-signin" method="get" action="/joinForm.do">
        <button class="btn btn-lg btn-warning btn-block" type="submit">회원가입하기</button>
    </form>
</div>
</body>
</html>