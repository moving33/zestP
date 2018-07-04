<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>관리자 로그인 페이지</title>



<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- 커스텀 css -->
<link href="css/admin/adminLoginPage.css" rel="stylesheet">

</head>
<body>

	<c:if test="${result == 'idFail' }">
		<script>
			alert("없는 계정 입니다.");
		</script>
	</c:if>
	
	<c:if test="${result == 'passFail' }">
		<script>
			alert("비밀번호가 틀렸습니다.");
		</script>
	</c:if>

	<form action="" method="post" class="form-signin" style="text-align: center!important; padding-top: 150px;">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<input type="text" id="id" name="id" class="form-control" placeholder="ID" required autofocus> 
		<input type="password" id="password" name="pass" class="form-control" placeholder="Password" required>
		
		<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		<button class="btn btn-lg btn-dark btn-block" onclick="location.href='/zest/adminRegi'">Admin Legistration</button>
	</form>
</body>
</html>