<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-31
  Time: 오후 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<meta name="viewport" content="width=device-width, initial-scale = 1.0" />
<html>
<head>
<title>$Title$</title>


<!-- 세션 검사 -->
<link rel="stylesheet" href="/zest/css/style.css" type="text/css">
<link href="/zest/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<link href="/zest/css/admin/zest_admin.css" rel="stylesheet">

</head>
<body class="fix-header fix-sidebar" style="font-size: 18px;">
	<%--전체--%>
	<div id="main-wrapper">
		<%--Header header--%>
		<div class="header">
			<div class="header is_J"
				style="position: fixed; top: 0px; width: 1500px;">
				<nav class="navbar top-navbar navbar-expend-md navbar-light">
					<%--Logo--%>
					<div class="navbar-header">
						<%--헤더로고 넣기--%>
						<a></a>
					</div>
					<%--로그 오른쪽부분 --%>
					<div class="navbar-collapse" style="font-size: 18px;">
						관리자 <b style="color: #ff7200;">${admin.name}</b>님
						환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/zest/admin/logout"
							style="float: right;">로그아웃</a>
					</div>
				</nav>
			</div>
		</div>
		<div
			style="position: relative; width: 1663px; height: 60px; display: block; vertical-align: baseline; float: none;"></div>

		<%--leftsidebar navigation--%>
		<jsp:include page="leftSideBar.jsp"></jsp:include>
		<%--end left sidebar--%>
		<div class="page-wrapper" style="min-height: 824px;">
			<%--low title--%>
			<div class="row page-titles" style="margin: 0">
				<div class="col-md-5 align-self-center">
					<%--타이틀이 들어가는 영역--%>
					<h3 class="text-primary" style="color: #000000 !important;">관리자
						메인 페이지</h3>
				</div>
			</div>


			<%--content가 들어가는영역!--%>
			<div class="container-fluid" style="background-color: white;">
				<div class="row">
					<%--최대로 맞춤--%>
					<!-- 통계 -->
					<div class="col-12">
						<div class="card-body">
							<%--소제목위치--%>
							<h4 class="card-title"></h4>
							<%--요약설명--%>
							<h6 class="card-subtitle"></h6>
						</div>

						<%--실제 data가 들어감--%>
						<div class="m-t-40" style="margin-top: 0;">
							<div class="row">
								<!-- 월별 가입자 -->
								<div class="col-sm-3">
									<div class="card text-center" style="">
										<div class="card-body">
											<p class="card-text">
												<i class="fas fa-male fa-3x"></i><i
													class="fas fa-female fa-3x"></i>
											</p>
											<h5 class="card-title">월별 가입자</h5>
											<div class="counter" data-count="${vo.cl_counter}">0</div>
										</div>
									</div>
								</div>
								<!-- 월별 매출금액 -->
								<div class="col-sm-3">
									<div class="card text-center" style="">
										<div class="card-body">
											<p class="card-text">
												<i class="fas fa-dollar-sign fa-3x"></i>
											</p>
											<h5 class="card-title">월별 결제현황</h5>
											<div class="counter" data-count="${vo.to_counter}">0</div>
										</div>
									</div>
								</div>

								<!-- 튜터 등록 현황 -->
								<div class="col-sm-3">
									<div class="card text-center" style="">
										<div class="card-body">
											<p class="card-text">
												<i class="fas fa-graduation-cap fa-3x"></i>
											</p>
											<h5 class="card-title">등록된 튜터</h5>
											<div class="counter" data-count="${vo.tt_counter}">0</div>

										</div>
									</div>
								</div>


								<!-- 사용자 현황 -->
								<div class="col-sm-3">
									<div class="card text-center" style="">
										<div class="card-body">
											<p class="card-text">
												<i class="fas fa-walking fa-3x"></i>
											</p>
											<h5 class="card-title">진행중인 수업</h5>
											<div class="counter" data-count="${vo.tl_counter}">0</div>
										</div>
									</div>
								</div>
							</div>
							<!--  end row -->
						</div>


						<!-- 승인게시판 -->
						<div class="col-12" style="margin-top: 77px;">
							<button type="button" class="btn btn-primary"
								style="margin-bottom: 2px;">
								승인처리 <span class="badge badge-light"> ${listCounter} </span>
							</button>
							<table id="table_id" class="display"
								style="width: 100%; text-align: center;">
								<thead>
									<tr>
										<th>매칭no</th>
										<th>주문no</th>
										<th>튜터no</th>
										<th>사용자no</th>
										<th>결제금액</th>
										<th>지급금액</th>
										<th>이익금액</th>
										<th>첫수업날짜</th>
										<th>결제날짜</th>
										<th>승인상태</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${list}">
										<tr>
											<td>${list.ts_no}</td>
											<td>${list.to_no}</td>
											<td>${list.tt_no}</td>
											<td>${list.ts_cl_no}</td>
											<td><fmt:formatNumber value="${list.to_real_price}"
													pattern="#,###" /></td>
											<td><fmt:formatNumber value="${list.to_price_total}"
													pattern="#,###" /></td>
											<td><fmt:formatNumber value="${list.benefit}"
													pattern="#,###" /></td>
											<td><c:set var="TextValue" value="${list.ti_date}" />
												${fn:substring(TextValue,0,10)}&nbsp;${fn:substring(TextValue,11,16)}
											</td>
											<td><fmt:formatDate value="${list.to_reg_date}"
													pattern="yyyy-MM-dd KK:mm:ss" /></td>
											<td><c:if test="${list.ts_status == 1}">
													<!--  <button class="btn btn-outline-primary"> -->
													<span class="badge badge-danger" style="width: 110px;">승인대기</span>
													<!--  </button> -->
												</c:if></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>





					</div>
				</div>
				<!-- end row -->


			</div>
			<!--  end content -->
			<!-- end 전체 영역 -->
		</div>

		<script src="/zest/js/jquery.min.js"></script>
		<script src="/zest/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript" charset="utf8"
			src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
		<!-- 아이콘 -->
		<script defer
			src="https://use.fontawesome.com/releases/v5.0.13/js/all.js"
			integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
			type="text/javascript"></script>
		<script src="/zest/js/popper.js"></script>

		<script src="/zest/js/admin/adminCommon.js"></script>
</body>
</html>
