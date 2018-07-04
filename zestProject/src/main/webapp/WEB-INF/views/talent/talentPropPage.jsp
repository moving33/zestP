<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<c:if test="${fail != null }">
	<script>
	alert('로그인이 필요한 서비스 입니다.');
	var test = 'width=400,height=500,scrollbars=yes,resizable=yes,top=100,left=500,toolbar=yes';
    window.open('common/loginPage','로그인',test);	
    window.location.href = '/zest/talent/'+${param.talent_no};
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link href="/zest/css/talent/talentProp.css" rel="stylesheet"
	type="text/css">
<link href="/zest/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="/zest/css/main/mainPage.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>


	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bgj-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/zest/main"> <img alt="Logo"
				src="images/logo2.png">
			</a>
			<!-- 검색창 -->
			<form class="flyout-search" action="/zest/category" name="search">
				<div class="searchdiv" style="border: 2px solid #ff7200">
					<div class="inputlmg" style="padding-top: 1px;">
						<button type="submit"
							style="background-color: #00000000; outline-color: #00000000; border: 0; cursor: pointer">
							<img src="images/돋보기.png" style="margin-left: 5px;">
						</button>
						<!-- 검색 텍스트 -->
						<input type="text" name="search_text"
							placeholder="배우고 싶은 수업 또는 튜터를 검색해보세요!" value=""
							style="border-color: #ffffff00; width: 330px; outline: none; padding-top: 3px;">
					</div>
				</div>
			</form>
			<!-- 토글 -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="loginCheck">
				<!-- 최상위 메뉴 -->
				<ul class="navbar-nav ml-auto">
					<li class="nav-item activej"><a class="nav-linkj logo"
						id="service" href="#"> <b>서비스소개</b> <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-linkj" id="insert" href="#"
						style="font-size: 20px;"><b>튜터 등록</b></a></li>


					<li class="nav-item"><a class="nav-linkj" id="regi" href="#"
						style="font-size: 20px;"><b>회원 가입</b></a></li>
					<li class="nav-item"><a class="nav-linkj" id="login" href="#"
						style="font-size: 20px;"><b>로그인</b></a></li>
				</ul>
			</div>
		</div>
	</nav>




	<div id="wrap">
		<div class="header"></div>
		<div id="container_apply">

			<div class="stepwizard">
				<div class="stepwizard-row">

					<div class="stepwizard-step2">
						<button type="button" id="propBtn1"
							class="btn btn-primary btn-circle"
							style="cursor: default; width: 100px; height: 30px;">1</button>
						<h1>신청서 작성</h1>
					</div>
					<div class="stepwizard-step2">
						<button type="button" id="propBtn2"
							class="btn btn-default btn-circle"
							style="cursor: default; width: 100px; height: 30px; margin-bottom: 8px;">2</button>
						<h1>결제</h1>
					</div>
				</div>
			</div>
			<div class="apply_cont" style="height: 625px; margin-top: 6px">
				<div class="tutortxt"
					style="width: 300px; height: -webkit-fill-available;">
					<!-- 튜터사진 -->
					<div class="tutor_img" style="background-image: url('')"></div>
					<div class="name"></div>
					<div class="arrow_box2">수업 준비를 위해 아래 항목들에 대해 미리 말씀 해 주세요!</div>
					<br> <br> <br> <br> <br>

				</div>
			<!-- 	<button onclick="chageDiv()">테스트창열고 닫기</button> -->


				<div class="appcont">
					<form id="form" name="form" action="#" method="POST">
						<!-- 신청페이지 시작 -->
						<div id="propPage" style="display: block;">
							<input type="hidden" id="Level" name="Level" value="2">
							<div class="level top">
								<div class="left" style="width: 120px;">자신의 레벨을 알려주세요.</div>
								<div class="right" id="box1">
									<div class="levelbox" id="level1" onclick="talentLevel(1);"
										style="cursor: pointer;">
										<img src="/zest/images/talent/icon_level01.png"> 입문자
									</div>
									<div class="levelbox on" id="level2" onclick="talentLevel(2);"
										style="cursor: pointer;">
										<img src="/zest/images/talent/icon_level02.png"> 초/중급자
									</div>
									<div class="levelbox" id="level3" onclick="talentLevel(3);"
										style="cursor: pointer;">
										<img src="/zest/images/talent/icon_level03.png"> 상급자
									</div>
								</div>
								<!-- 선택한 클래스 레벨이 저장되는 공간 -->
								<input type="hidden" value="" id="talentLevel">
							</div>
							<div class="level top" style="margin-top: 41px;">
								<div class="left" style="width: 115px;">
									경력을 개월로<br>적어주세요.
								</div>
								<div class="right">
									<input type="text" id="Career" name="Career" placeholder="개월수">
									개월
								</div>
							</div>

							<div class="texta top bottom" style="margin-top: 15px;">
								<div class="left">
									튜터에게<br>전하는말
								</div>
								<div class="right">
									<textarea rows="5"
										placeholder="튜터님에게 당신에 대해 알려주세요.                                                   목적은 무엇인가요?                                          
튜터님의 어떤 점이 마음에 들어 신청하셨나요?"
										id="message" name="message" style="width: 500px;"></textarea>

								</div>
							</div>

							<div class="level">
								<div class="left">
									휴대전화<br>번호
								</div>
								<div class="right">
									<input type="text" id="phone" placeholder="010-1234-5678"
										style="float: left;"> <input type="button"
										class="btn btn-primary" onclick="phoneCertification();"
										style="float: left; margin-left: 25px; background-color: #007bff; color: white;"
										value="인증번호요청">
								</div>
							</div>

							<div class="level">
								<div class="left" style="width: 99px;">
									인증<br>번호
								</div>
								<div class="right" style="float: left;">
									<input type="text" id="code" placeholder="12345"
										style="float: left;"> <input type="button"
										class="btn btn-primary" onclick="phone();"
										style="float: left; margin-left: 25px; background-color: #007bff; color: white;"
										value="인증하기">
								</div>
							</div>
							<div class="level textarea">
								<div style="padding: 10px 0 0 10px;">인증하신 전화번호로 5자리의 인증번호를
									보내드립니다.</div>
							</div>

							<!-- 선택한 수업의 주요내용 -->
							<input type="hidden" value="${talent.talent_no}" id="talent_no">
							<input type="hidden" value="${talent.talent_tt_no}" id="tutor_no">
							<input type="hidden" value="${talent.talent_total_price}" id="price_total">

							<!-- 신청페이지END -->
						</div>
						<!-- 실제주문금액(부가세포함) -->
						<input type="hidden"
							value="${talent.talent_total_price * 1.1 - ((talent.talent_total_price * 1.1 ) % 1)}"
							id="real_price_total">
						<!-- 결제페이지 -->
						<div id="payPage" style="display: none;">
							<div class="level">
								<div class="left" style="margin-top: 4px;">수업 가격</div>
								<div class="right2" id="realPriceDiv" style="float: left; margin-left: 15px; font-size: -webkit-xxx-large;">

									<%-- ${param.price_total * 1.1 - ((param.price_total * 1.1 ) % 1)} 원 --%>

									<font color="#666" style="font-size: 12px;">(수업가격 + VAT
										10%)</font>
								</div>
							</div>

							<!-- 포인트 사용란 -->
							<p style="float: none;">
								<a class="btn btn-primary" data-toggle="collapse"
									href="#collapseExample" role="button" aria-expanded="false"
									aria-controls="collapseExample"> 포인트 사용 </a>

							</p>
							<div class="collapse" id="collapseExample">
								<div class="card card-body" style="border: none;">
									
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text" id="">사용 가능 포인트</span>
										</div>
										<input type="number" class="form-control" value=${client.cl_point } id="maxPoint"
										readonly="readonly" style="margin-left: 0.5px;">
										<div class="input-group-prepend">
											<span class="input-group-text" id="">사용할 포인트</span>
										</div> 
										<input type="number" class="form-control" id="usePoint" value="0">
									</div>
								
								</div>
							</div>




							<div class="level2 top" style="width: 687px; margin-top: 1px;">
								<div class="alert alert-warning">
									수업은 어떻게 진행 되나요? <br> 튜터 에게 연락이 온 후 세부 일정을 잡으시면 됩니다.
								</div>

							</div>


							<div class="level">
								<div class="left">
									결제수단 <br>선택
								</div>
								<div class="right" id="pay" style="width: 600px;">
									<input type="button" class="btn btn-outline-primary"
										id="button1"
										style="cursor: pointer; width: 165px; border-color: #007bff;"
										onclick="kcpPay();" value="신용카드/체크카드"> <input
										type="button" class="btn btn-outline-primary"
										style="cursor: pointer; margin-left: 4px; border-color: #007bff;"
										id="button2" value="무통장 입금"> <input type="button"
										class="btn btn-outline-primary"
										style="cursor: pointer; margin-left: 4px; border-color: #007bff;"
										id="button2" onclick="kkaoPay();" value="카카오페이 결제">

								</div>
							</div>
							<!-- end결제페이지 -->
						</div>
					</form>

				</div>

			</div>
			<div class="apply_button">
				<div class="btn_red" onclick="send();" id="submitDiv">다음</div>
			</div>

		</div>
	</div>



</body>

<script src="/zest/js/jquery-3.3.1.min.js"></script>
<script src="/zest/js/bootstrap.bundle.min.js"></script>
<script src="/zest/js/main/mainPage.js"></script>
<script src="/zest/js/common.js"></script>
<script src="/zest/js/payment/talentProp.js"></script>
</html>