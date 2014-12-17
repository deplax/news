<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./commons/_head.jspf"%>
</head>
<body>
	<%@ include file="./commons/_nav.jspf"%>
	<div class="signin-form">
		<form class="form-horizontal" role="form" action="/users/signUp" method="post">
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Email</label>
				<div class="col-lg-10">
					<input type="email" class="form-control" id="inputEmail1" name="email"
						placeholder="Email">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label"></label>
				<div class="col-lg-10">
					<input type="email" class="form-control"
						id="inputEmail1" name="emailVerify" placeholder="Confirm your email">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword1" class="col-lg-2 control-label">Password</label>
				<div class="col-lg-10">
					<input type="password" class="form-control" id="inputPassword1" name="password"
						placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-lg-2 control-label"></label>
				<div class="col-lg-10">
					<input type="password" class="form-control"
						id="inputPassword1" name="passwordVerify" placeholder="Confirm your password">
				</div>
			</div>
			<div class="form-group">
				<label for="inputName" class="col-lg-2 control-label">name</label>
				<div class="col-lg-10">
					<input type="name" class="form-control" id="inputName"  name="name"
						placeholder="name">
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button type="submit" class="btn btn-default">Sign Up</button>
				</div>
			</div>
		</form>

	</div>

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) 
  <script src="//code.jquery.com/jquery.js"></script>
-->
	<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) 
  <script src="js/respond.js"></script>
-->
</body>
</html>