<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<!-- 부트스트랩 CSS -->
<link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>

	<c:if test="${result == 'success' }">
		<script>
			alert("로그인 세션 가동");
			opener.document.location.reload();
			window.close();
		</script>
	</c:if>


	<c:if test="${result == 'fail' }">
		<script>
			alert("이미 가입된 이메일 입니다.");
		</script>
	</c:if>


	<br>
	<center>
		<h5>
			<label style="color: #ff7200;"><b>드루와&nbsp;</b></label><b>회원가입</b>
		</h5>
		<label style="font-size: 14px;">회원가입을 하시면<br>드루와의 모든 서비스를
			이용하실 수 있습니다.
		</label>
	</center>
	<br>
	<br>

	<form action="/zest/common/regiPage" method="post" onsubmit="return checkLoginData()">
		<div class="form-group">
			<input type="text" class="form-control" name="cl_name" id="name" placeholder="Name" />
			<br>  
			<input type="email" class="form-control" name="cl_email" id="email" aria-describedby="emailHelp" placeholder="Email" />
			<br>  
			<input type="password" class="form-control" name="cl_pass" id="pass" placeholder="Password" />
			<br>  
			<input type="password" class="form-control" name="repass" id="repass" placeholder="Confirm Password" />
			<br> 
		    <input type="checkbox" class="form-check-input" id="exampleCheck1" />
			<label class="form-check-label" for="exampleCheck1" style="font-size: 14px; color: #ff7200;">
			드루와 이용약관 및 개인정보취급방침에 동의합니다.
			</label>			
			<br> 
			<input class="btn btn-dark btn-lg btn-block" type="submit" value="이메일 아이디로 가입" />
		</div>
	</form>

	<!-- SHA256 암호화 -->
	<script src="../js/sha256/sha256.min.js"></script>
	<script src="../js/regi/regiPage.js"></script>
	<script src="../js/jquery.min.js"></script>





</body>
</html>