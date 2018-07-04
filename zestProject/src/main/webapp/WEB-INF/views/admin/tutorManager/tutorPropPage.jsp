<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-31
  Time: 오후 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta name="viewport" content="width=device-width, initial-scale = 1.0" />
<html>
<head>
<title>$Title$</title>

<link rel="stylesheet" href="/zest/css/style.css" type="text/css">
<link href="/zest/css/admin/zest_admin.css" rel="stylesheet">
<link href="/zest/css/bootstrap.css" rel="stylesheet">

</head>
<body class="fix-header fix-sidebar" style="font-size:18px;">
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
						관리자 <b style="color: #ff7200;">${admin.name}</b>님 환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/zest/admin/logout" style="float: right;">로그아웃</a>
					</div>
				</nav>
			</div>
		</div>
		<div
			style="position: relative; width: 1663px; height: 60px; display: block; vertical-align: baseline; float: none;"></div>

		<%--leftsidebar navigation--%>
		<jsp:include page="../leftSideBar.jsp"></jsp:include>
		<%--end left sidebar--%>
		<div class="page-wrapper" style="min-height: 824px;">
			<%--low title--%>
			<div class="row page-titles" style="margin: 0">
				<div class="col-md-5 align-self-center">
					<%--타이틀이 들어가는 영역--%>
					<h3 class="text-primary" style="color:#000000 !important;">Tutor Manager</h3>
				</div>
			</div>

			<%--content가 들어가는영역!--%>
			<div class="container-fluid" style="background-color: white;">
				<div class="row">
					<%--최대로 맞춤--%>
					<div class="col-12">
						<div class="card-body">
							<%--소제목위치--%>
							<h4 class="card-title">튜터 신청 관리</h4>
							<%--요약설명--%>
							<h6 class="card-subtitle">신청한 튜터를 승인및 거부합니다.</h6>
						</div>

						<%--실제 data가 들어감--%>
						<div class="m-t-40">
							<table data-text-content="true" class="table table-bordered"
								style="width: 100%;">
								<tbody>
									<tr style="text-align: center">
										<th style="width: 5%;">Number</th>
										<th style="width: 23%;">E-mail</th>
										<th style="width: 10%;">휴대폰번호</th>
										<th style="width: 10%;">신청날짜</th>
										<th style="width: 8%">대표특기</th>
										<th style="width: 10%;">상태</th>
									</tr>
									<c:forEach var="item" items="${tutorPropList}"
										varStatus="status">
										<%-- <c:set var="result" value="${item.tp_status}"/>--%>

										<tr style="text-align: center">
											<td>${item.tp_no}</td>
											<td><a
												href="/zest/admin/tutorManager/prop/${item.tp_no}"
												id="detailPage">${item.tp_email}</a></td>
											<td>${item.tp_hp}</td>
											<td>${item.format_tpd}</td>
											<td>${item.tp_category_id}</td>
											<td><c:if test="${item.tp_status == 0}">미승인
                    								</c:if></td>
										</tr>

									</c:forEach>
								</tbody>
							</table>

							<%--페이징처리--%>
							<div>
								<div class="row">
									<div class="col-8">
										<div class="pagePro"
											style="text-align: center; margin: auto; display: table;">
											<%-- pagination 사용 --%>
											<ul class="pagination">

												<%--이전버튼 --%>
												<c:if test="${bp.isPre()}">
													<li class="page-item">
														<button class="page-link">
															<a
																href="/zest/admin/tutorManager/prop?pageNum=${bp.getPage_Start()-bp.p_size}">
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
																onclick="window.location='/zest/admin/tutorManager/prop?pageNum=${counter}&search_type=${search_type}&search_text=${search_text}'">
																${counter}</button>
														</li>
													</c:if>

													<c:if test="${search_text eq ''}">
														<li class="page-item">
															<button class="page-link"
																onclick="window.location='/zest/admin/tutorManager/prop?pageNum=${counter}&search_type=${search_type}&search_text=${search_text}'">
																${counter}</button>
														</li>
													</c:if>
												</c:forEach>


												<%--다음버튼 --%>
												<c:if test="${bp.isNext()}">
													<li class="page-item">
														<button class="page-link">
															<a
																href="/zest/admin/tutorManager/prop?pageNum=${bp.getPage_Start()+bp.p_size}">
																Next </a>
														</button>
													</li>
												</c:if>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<!-- end Paging -->

						</div>
					</div>
					<!-- end 테이블 정보 div -->

					<!-- 튜터 상세페이지 -->
					<div class="col-12">
						<div id="detailArticle"
							style="display: ${display}; padding: 0 14px;">
							<!-- 프로필사진 -->
							<div class="row">
								<div class="col-lg-5">
									<div class="card">
										<div class="card-body">
											<div class="card-two">
												<header>
													<div class="avatar">
														<img src="${profile}" alt="프로필 사진">
													</div>
												</header>

												<h3 style="text-align: center;">프로필사진</h3>
												<!-- 버튼 -->
												<div class="desc row">
													<button class="button2 col-3 " id="profileBtn1">승인</button>
													<button class="button3 col-3 " id="profileBtn2">불가</button>
													<input type="hidden" id="profileCheck" value="0">
												</div>

											</div>
										</div>
									</div>
								</div>
								<!-- 프로필사진 end -->
								<div class="col-lg-4">
									<div class="card">
										<div class="card-body">
											<div class="card-two">
												<header>
													<h3 style="text-align: center;">신분확인 /자격증사진 보기</h3>
												</header>
												<!-- 신분확인 -->
												<div class="alert alert-primary" style="margin-left: 40px;">
													<a
														href="javascript:window.open('${certification}','_blank','width=640,height=800')"
														style="margin-left: 28px; text-align: center;">신분확인이미지보기</a>
												</div>
												<!-- 자격증 -->
												<div class="license">
													<h2>자격증</h2>
													<div class="licenseconfirm">
														<ul>
															<li>
																<div class="alert alert-primary"
																	style="text-align: center">
																	<a
																		href="javascript:window.open('${add0}','_blank','width=640,height=800')">자격증첨부이미지보기</a>
																</div>
															</li>
															<c:if test="${add1 != null}">
																<li><div class="alert alert-primary"
																		style="text-align: center">
																		<a
																			href="javascript:window.open('${add1}','_blank','width=640,height=800')">자격증첨부이미지보기</a>
																	</div></li>
															</c:if>
															<c:if test="${add2 != null}">
																<li><div class="alert alert-primary"
																		style="text-align: center">
																		<a
																			href="javascript:window.open('${add2}','_blank','width=640,height=800')">자격증첨부이미지보기</a></li>
															</c:if>
															<c:if test="${add3 != null}">
																<li><div class="alert alert-primary"
																		style="text-align: center">
																		<a
																			href="javascript:window.open('${add3}','_blank','width=640,height=800')">자격증첨부이미지보기</a></li>
															</c:if>
															<c:if test="${add4 != null}">
																<li><div class="alert alert-primary"
																		style="text-align: center">
																		<a
																			href="javascript:window.open('${add4}','_blank','width=640,height=800')">자격증첨부이미지보기</a></li>
															</c:if>
														</ul>
													</div>
													<!-- 버튼 -->
													<div class="desc row">
														<button class="button2 col-3" id="certiBtn1">승인</button>
														<button class="button3 col-3" id="certiBtn2">불가</button>
														<input type="hidden" id="certiCheck" value="0">
													</div>

												</div>
											</div>
										</div>
									</div>

								</div>

								<div class="col-lg-2">
									<h4>승인 하기</h4>
									<div class="allconfirm">
										<button class="allbutton allbutton2" id="submitBtn1">승인</button>
										<button class="allbutton allbutton3" id="submitBtn2">불가</button>
										<!-- 이메일과 넘버키를 저장해놓는 녀석 -->
										<input type="hidden" id="emailData" value="${tempVO.tp_email}">
										<input type="hidden" id="numberData" value="${tempVO.tp_no}">

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<script src="/zest/js/jquery.min.js"></script>
		<script src="/zest/js/bootstrap.bundle.min.js"></script>
		<script src="/zest/js/popper.js"></script>
		<script src="/zest/js/admin/tutorPropPage.js"></script>
</body>
</html>
