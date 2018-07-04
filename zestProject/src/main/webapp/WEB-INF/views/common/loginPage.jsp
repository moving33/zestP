<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<!-- 네이버 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<!-- 부트스트랩 CSS -->
<link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<c:if test="${result == 'noEmail' }">
		<script>
			alert("해당 이메일은 존재하지 않습니다.");
		</script>
	</c:if>
	<c:if test="${result == 'false' }">
		<script>
			alert("비밀번호가 틀렸습니다.");
		</script>
	</c:if>
	<c:if test="${result == 'success' }">
		<script>
			opener.document.location.reload();
			window.close();
		</script>
	</c:if>
	<br>
	<center>
		<h5>
			<label style="color: #ff7200;"><b>드루와</b></label><b>에 오신 것을 환영해요!</b>
		</h5>
		<label style="font-size: 14px;">드루와는 서로 간의 재능을 연결해<br>모두의
			경쟁력을 높이는 플랫폼 서비스 입니다.
		</label>
	</center>

	<form action="/zest/common/loginPage" method="post">
		<div class="form-group">
			<input type="email" class="form-control" id="email" name="cl_email"
				aria-describedby="emailHelp" placeholder="Enter email">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" id="pass" name="cl_pass"
				placeholder="Password">
		</div>
		<div class="form-group form-check" style="float: left;">
			<input type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">로그인 상태 유지</label>
			
		</div>
		<div style="float: right;">
			<!-- 네이버아이디로로그인 버튼 노출 영역 -->
			<div id="naverIdLogin" style="width: 100px%;"></div>
			<!-- 페북 로그인 버튼 -->
			<div class="fb-login-button" data-width="210" data-max-rows="1"
				data-size="large" data-button-type="login_with"
				data-show-faces="false" data-auto-logout-link="false"
				data-use-continue-as="false" scope="public_profile,email"
				onlogin="checkLoginState();"></div>
		</div>
		<br>
		<button type="submit" class="btn btn-dark btn-lg btn-block">이메일
			아이디로 로그인</button>
	</form>
	
	
	
	<!-- 네이버아디디로로그인 초기화 Script -->
	<script type="text/javascript">
		var naverLogin = new naver.LoginWithNaverId({
			clientId : "7KYC_rPZz0PoBsomjyBW",
			callbackUrl : "http://localhost:8080/zest/naverLoginPage",
			isPopup : false, /* 팝업을 통한 연동처리 여부 */			
			loginButton : {
				color : "green",
				type : 3,
				height : 52
			}
		/* 로그인 버튼의 타입을 지정 */
		});

		/* 설정정보를 초기화하고 연동을 준비 */
		naverLogin.init();
	</script>


	

	<!-- 페북 javaScript용 Facebook SDK 설정 -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = 'https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.0&appId=412382525894818&autoLogAppEvents=1';
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		/* JavaScript용 Facebook SDK 설정 초기화 */
		window.fbAsyncInit = function() {
			FB.init({
				appId : '{412382525894818}',
				cookie : true,
				xfbml : true,
				version : '{v3.0}'
			});
		};

		// 로그인 여부 확인
		function checkLoginState() {
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		}

		// 콜백
		function statusChangeCallback(response) {
			console.log('response를 통해 다양한 정보를 확인할 수 있다');
			console.log(response);

			if (response.status === 'connected') {
				console.log('사용자가 페이스북에 로그인하고 앱에 로그인 성공');
				FB.api('/me', function(response) {
					alert('사용자 아이디: ' + response.id);
					alert('사용자 이름: ' + response.name);
					alert('사용자 아이디: ' + response.email);
					
					var fbid = response.id;
					var fbname = response.name;
					
					
					/* 사용자 정보를 보낼 URL 설정 */
					window.location
							.replace("http://"
									+ window.location.hostname
									+ ((location.port == "" || location.port == undefined) ? ""
											: ":"
													+ location.port)
									+ "/zest/facebookLogin/session"
									+ "?id=" + fbid
									+ "&name=" + fbname);
				});

				/* testAPI(); */
			} else {
				// The person is not logged into your app or we are unable to tell.
				document.getElementById('status').innerHTML = 'Please log '
						+ 'into this app.';
			}
		}
	</script>
	






</body>
</html>