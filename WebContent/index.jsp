<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./commons/_head.jspf"%>
</head>
<body>
	<%@ include file="./commons/_nav.jspf"%>
	<div class="middle">
		<div>
			<div class="newslist">
				<div class="jumbotron">
					<div class="container">
						<div class="news-title">
							<h2>Hello, world! Hello, world! Hello, world! Hello, world!</h2>
						</div>
						<div class="news-control">
							<button type="button" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-cog"></span>
								<button type="button" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-remove"></span>
						</div>
						<div class="news-contents">
							<p>contents contents contents contents contents contents
								contents contents contents contents contents contents contents
								contents contents contents contents contents contents contents
								contents contents contents contents contents contents contents
								contents contents contents contents contents contents contents
								contents contents contents contents contents contents contents
								contents contents contents contents contents contents</p>
						</div>
						<div class="news-comment">
							<div class="comment-indent"></div>
							<div class="comment-name">쿠쿠</div>
							<div class="comment-contents-box">
								<div class="comment-contents">comment comment comment
									comment comment comment comment comment comment comment comment
									comment comment comment comment comment comment comment comment
									comment comment comment comment comment comment comment comment
									comment</div>
								<div class="comment-control">
									<button type="button" class="btn btn-default btn-ssm">
										<span class="glyphicon glyphicon-chevron-down"></span>
										<button type="button" class="btn btn-default btn-ssm">
											<span class="glyphicon glyphicon-cog"></span>
											<button type="button" class="btn btn-default btn-ssm">
												<span class="glyphicon glyphicon-remove"></span>
								</div>

								<div class="comment-form">
									<input class="form-control input-sm" type="text"
										placeholder="comment">
								</div>

							</div>
						</div>
					</div>
				</div>

				<div class="div-limit">
					<ul class="nav nav-stacked">
						<li class="active">
						<li><a href="#">전체</a></li>
						<li><a href="#">정치</a></li>
						<li><a href="#">경제</a></li>
						<li><a href="#">사회</a></li>
						<li><a href="#">문화</a></li>
					</ul>
				</div>
				<div></div>
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