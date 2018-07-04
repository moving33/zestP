<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>관리자 등록 페이지</title>


<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- 커스텀 css -->
<link href="css/admin/adminLoginPage.css" rel="stylesheet">

<script src="/zest/js/jquery.min.js"></script>
<script src="/zest/js/admin/adminRegiPage.js"></script>
</head>
<body>
	

	<c:if test="${result == 'fail' }">
		<script>
			alert("이미 가입된 아이디 입니다.");
			$("#id").focus();
		</script>
	</c:if>

	<form action="" method="post" onsubmit="return codeCheck()" class="form-signin" style="text-align: center!important; padding-top: 100px;">
		<h1 class="h3 mb-3 font-weight-normal">Admin Legistration</h1>
		<input type="text" id="id" name="id" class="form-control" placeholder="ID" required autofocus> 
		<input type="password" id="pass" name="pass" class="form-control" placeholder="Password" required>
		<input type="password" id="repass"  class="form-control" placeholder="Password Confirm" required>
		<input type="text" id="name" name="name" class="form-control" placeholder="Name">
		<input type="text" id="tell" name="tell" class="form-control" placeholder="Tell" required autofocus>
		<input type="text" id="code" class="form-control" placeholder="Code" required autofocus>
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Legistration"/>
		<input type="button" class="btn btn-lg btn-dark btn-block" value="Cancel" onclick="location.href = 'adminLogin'"/>
	</form>
	
</body>
</html>