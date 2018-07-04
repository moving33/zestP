<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 부트스트랩 CSS -->
<link href="/zest/css/bootstrap.css" rel="stylesheet">
<!-- 부트스트랩 슬라이더 CSS -->
<link href="/zest/css/half-slider.css" rel="stylesheet">
<!--  main css -->
<link href="/zest/css/main/mainPage.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bgj-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="/zest/main"> <img alt="Logo"
			src="/zest/images/logo2.png">
		</a>
		<!-- 검색창 -->
		<form class="flyout-search" action="/zest/category" name="search">
			<div class="searchdiv" style="border: 2px solid #ff7200">
				<div class="inputlmg" style="padding-top: 1px;">
					<button type="submit"
						style="background-color: #00000000; outline-color: #00000000; border: 0; cursor: pointer">
						<img src="/zest/images/돋보기.png" onclick='#'
							style="margin-left: 5px;">
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
					id="service" href="/zest/notice/list"> <b>공지사항</b> <span
						class="sr-only">(current)</span>
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

	<!-- 메뉴바 -->
	<div class="container" align="center" style="padding-top: 6%;">
		<div class="row">
			<div id="hot" class="colj">
				<a id="hot" href="/zest/category/hot" style="color: #000000;">인기수업</a>
			</div>
			<div id="sports" class="colj"
				onmouseover="getCategory('/zest/main/sports')">
				<a id="sports" href="/zest/category/sports" style="color: #000000;">스포츠</a>
			</div>
			<div id="beauty" class="colj"
				onmouseover="getCategory('/zest/main/beauty')">
				<a id="beauty" href="/zest/category/beauty" style="color: #000000;">뷰티</a>
			</div>
			<div id="music" class="colj"
				onmouseover="getCategory('/zest/main/music')">
				<a id="music" href="/zest/category/music" style="color: #000000;">음악</a>
			</div>
			<div id="food" class="colj"
				onmouseover="getCategory('/zest/main/food')">
				<a id="food" href="/zest/category/food" style="color: #000000;">요리/음식</a>
			</div>
			<div id="design" class="colj"
				onmouseover="getCategory('/zest/main/design')">
				<a id="design" href="/zest/category/design" style="color: #000000;">디자인</a>
			</div>
			<div id="business" class="colj"
				onmouseover="getCategory('/zest/main/business')">
				<a id="business" href="/zest/category/business"
					style="color: #000000;">실무</a>
			</div>
			<div id="language" class="colj"
				onmouseover="getCategory('/zest/main/language')">
				<a id="language" href="/zest/category/language"
					style="color: #000000;">외국어</a>
			</div>
			<div id="progam" class="colj"
				onmouseover="getCategory('/zest/main/program')">
				<a id="progam" href="/zest/category/program" style="color: #000000;">프로그래밍</a>
			</div>
			<div id="life" class="colj"
				onmouseover="getCategory('/zest/main/life')">
				<a id="life" href="/zest/category/life" style="color: #000000;">라이프스타일</a>
			</div>
		</div>
	</div>

	<!-- 카테고리 -->
	<div class="container" align="center">
		<div class="row subCate" style="background-color: #ffffff;"></div>
	</div>
	<hr>
	<br>

	<!-- 공지사항 -->
	<div style="padding-left: 21%;padding-right: 20%;">
		<h2>공지사항</h2>
		<br>
		<table class="table" width="600px">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.notice_no}</td>
					<td><a href="/zest/notice/detail?notice_no=${list.notice_no}">${list.notice_title}</a></td>
					<td>
						<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 --> <fmt:formatDate
							value="${list.notice_date}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td>${list.notice_count}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 공지사항 리스트 끝 -->
		
		<%--페이징처리--%>
		<div>
			<div class="row" style="padding-left: 22%;">
				<div class="col-8">
					<div class="pagePro"
						style="text-align: center; margin: auto; display: table;"><br>
						<%-- pagination 사용 --%>
						<ul class="pagination" >

							<%--이전버튼 --%>
							<c:if test="${bp.isPre()}">
								<li class="page-item">
									<button class="page-link">
										<a
											href="/zest/notice/list?pageNum=${bp.getPage_Start()-bp.p_size}">
											Previous </a>
									</button>
								</li>
							</c:if>

							<%--페이징처리 --%>

							<c:forEach var="counter" begin="${bp.getPage_start()}"
								end="${bp.getPage_end()}">
								<c:if test="${search_text ne ''}">
									<li class="page-item">
										<button class="page-link"
											onclick="window.location='/zest/notice/list?pageNum=${counter}&search_type=${search_type}&search_text=${search_text}'">
											${counter}</button>
									</li>
								</c:if>

								<c:if test="${search_text eq ''}">
									<li class="page-item">
										<button class="page-link"
											onclick="window.location='/zest/notice/list?pageNum=${counter}&search_type=${search_type}&search_text=${search_text}'">
											${counter}</button>
									</li>
								</c:if>
							</c:forEach>


							<%--다음버튼 --%>
							<c:if test="${bp.isNext()}">
								<li class="page-item">
									<button class="page-link">
										<a
											href="/zest/notice/list?pageNum=${bp.getPage_Start()+bp.p_size}">
											Next </a>
									</button>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div><br><br><br>
		<!-- end Paging -->

		<!-- footer -->
		<div class="footer">
			<div class="footer_cont">
				<div class="info_box">
					<div class="info">
						<b>COMPANY</b>
						<ul>
							<li><a href="#">서비스 소개</a></li>
							<li><a href="#" target="_blank">블로그</a></li>
							<li><a href="#" target="_blank">언론보도</a></li>
						</ul>
					</div>
					<div class="info">
						<b>POLICIES</b>
						<ul>
							<li><a href="#">이용약관</a></li>
							<li><a href="#">결제서비스약관</a></li>
							<li><a href="#">개인정보취급방침</a></li>
						</ul>
					</div>
					<div class="info">
						<b>SUPPORT</b>
						<ul>
							<li><a href="#">FAQ</a></li>
							<li><a href="#">드루와센터</a></li>
						</ul>
					</div>
				</div>
				<div class="info_box2">
					<div class="info">
						<b>드루와</b>
						<ul>
							<li><img src="/zest/images/yellow.png">&nbsp;KAKAO 옐로우ID /
								@Droowa</li>
							<li>운영시간 / 평일 10:00~19:00</li>
						</ul>
					</div>
				</div>
				<div style="overflow: hidden; padding-top: 79px">
					<div class="bt_info">
						상호 : (주)드루와 | 주소 : 서울시 성동구 무학로2길 54 신방빌딩 4,5층 | 사업자등록번호 :
						123-45-67890 |대표자명 : ZEST<br> Copyright ⓒ2018 droowa inc,
						ltd. All rights reserved
					</div>
					<div class="logo_box">
						<a href="#" target="_blank"><img
							src="/zest/images/ic_sns_facebook_38_38.png"></a> <a href="#"
							target="_blank"><img src="/zest/images/ic_sns_instagram_38_38.png"></a>
						<a href="#" target="_blank"><img
							src="/zest/images/ic_sns_youtube_38_38.png"></a>
					</div>

				</div>
			</div>
		</div>
		<!-- /footer -->
		<script src="/zest/js/jquery.min.js"></script>
		<script src="/zest/js/bootstrap.bundle.min.js"></script>
		<script src="/zest/js/category/categoryPage.js"></script>
		<script src="/zest/js/common.js"></script>
</body>
</html>