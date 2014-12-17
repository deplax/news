<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./commons/_head.jspf"%>
</head>
<body>
	<%@ include file="./commons/_nav.jspf"%>
	<div class="write-form">

		<form role="form">
			<div class="form-group">
				Title<input type="text" class="form-control" placeholder="Title">

				Category<select class="form-control">
					<option>Select Category</option>
					<option>정치</option>
					<option>경제</option>
					<option>사회</option>
					<option>문화</option>
					<option>미분류</option>
				</select> Article
				<textarea class="form-control" rows="10"></textarea>
				<button type="button" class="btn btn-default btn-align">write</button>
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