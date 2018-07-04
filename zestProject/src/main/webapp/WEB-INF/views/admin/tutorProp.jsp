<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-29
  Time: 오후 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%--튜터신청관리페이지--%>
<meta name="viewport" content="width=device-width, initial-scale = 1.0" />
<html>
<head>
<title>Title</title>
</head>
<link href="/zest/css/admin/tutor.css" rel="stylesheet" type="text/css">
<link href="/zest/css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
	<!-- header -->
	<div id="menu" class="box">

		<ul class="box">
			<li><a href="DesignMain.jsp"><span>디자인</span></a></li>
			<li><a href="Membermain.jsp"><span>회원관리</span></a></li>
			<li><a href="tutormanage.jsp"><span>튜터관리</span></a></li>
			<li><a href="lessonmanage.jsp"><span>강의관리</span></a></li>
			<li><a href="#"><span>통 계</span></a></li>
			<li><a href="#"><span>상담</span></a></li>
			<li><a href="#"><span>게시판</span></a></li>
			<li><a href="#"><span>?</span></a></li>

		</ul>

	</div>
	<!-- /header -->
	<hr>
	<div class="submenu">
		<table class="cate">

			<tr>
				<td><a href="tutormanage.jsp">튜터 인증 </a></td>
			</tr>
			<tr>
				<td><a href="tutorinfo.jsp">튜터 정보</a></td>
			</tr>
			<tr>
				<td><a href="tutoredit.jsp">튜터 수정</a></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<div class="article">
		<span>-튜터 신청 (${count}) 명</span>
		<div class="search">
			<input id="filter" type="text" placeholder="Search"
				style="margin-left: 20px;" /> <i id="" class="fa fa-search"></i>
		</div>
	</div>
	<div>
		<table data-text-content="true" class="tutor" style="width: 1000px">
			<tbody>
				<tr style="text-align: center">
					<th style="width: 5%;">Number</th>
					<th style="width: 23%;">E-mail</th>
					<th style="width: 10%;">휴대폰번호</th>
					<th style="width: 10%;">신청날짜</th>
					<th style="width: 8%">대표특기</th>
					<th style="width: 10%;">상태</th>
				</tr>
				<c:forEach var="item" items="${tutorPropList}" varStatus="status">
					<%-- <c:set var="result" value="${item.tp_status}"/>--%>

					<tr style="text-align: center">
						<td>${item.tp_no}</td>
						<td><a href="/zest/admin/tutorManager/prop/${item.tp_no}" id="detailPage" >${item.tp_email}</a></td>
						<td>${item.tp_hp}</td>
						<td>${item.format_tpd}</td>
						<td>${item.tp_category_id}</td>
						<td><c:if test="${item.tp_status == 0}">
                        미승인
                    </c:if></td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
		<br>
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
		</div>
		
		
		<!-- 튜터 상세페이지 -->
		<div id="detailArticle" style="display: ${display}">
		<div class="tutorth">
			<h2>프로필사진</h2>
			<div class="circle"
				style="background-image: url('${profile}'); background-size: cover;	background-position: center;">
			</div>
		</div>
		
		
		<div class="buttons">
			<button class="button button2" id="profileBtn1">승인</button>
			<br>
			<button class="button button3" id="profileBtn2">불가</button>
			<!-- 체크하기 -->
			
			<input type="hidden" id="profileCheck" value="0">
		</div>
		<div class="content">
			<h3>신청한 회원 상세 정보</h3>
			<ul>
				<li>신청한 이메일 : ${tempVO.tp_email}</li>
				<li>신청한 닉네임 : ${tempVO.tp_nn} </li>
				<li>신청자 핸드폰 : ${tempVO.tp_hp} </li>

			</ul>
		
		</div>
		<br>
		<div class="confirm">
			<h2>신분/학력인증</h2>
			<div class="schoolconfirm">		
			<br>	
					<button class="btn btn-primary" onclick="javascript:window.open('${certification}','_blank','width=640,height=800')"
					style="margin-left: 28px;">신분확인이미지보기</button>
			</div>
			<div class="schoolbutton">

				<button class="button button2" id="certiBtn1">승인</button>
				<br>
				<button class="button button3" id="certiBtn2">불가</button>
				<!-- 체크하기 -->
			<input type="hidden" id="certiCheck" value="0">
			</div>
		</div>
		<div class="license">
			<h2>자격증</h2>
			<div class="licenseconfirm">
				<ul>
					<li><a
						onclick="javascript:window.open('${add0}','_blank','width=640,height=800')">자격증첨부이미지보기</a></li>
					<c:if test="${add1 != null}">
						<li><a
							onclick="javascript:window.open('${add1}','_blank','width=640,height=800')">자격증첨부이미지보기</a></li>
					</c:if>
					<c:if test="${add2 != null}">
						<li><a
							onclick="javascript:window.open('${add2}','_blank','width=640,height=800')">자격증첨부이미지보기</a></li>
					</c:if>
					<c:if test="${add3 != null}">
						<li><a
							onclick="javascript:window.open('${add3}','_blank','width=640,height=800')">자격증첨부이미지보기</a></li>
					</c:if>
					<c:if test="${add4 != null}">
						<li><a
							onclick="javascript:window.open('${add4}','_blank','width=640,height=800')">자격증첨부이미지보기</a></li>
					</c:if>
				</ul>
			</div>
			<div class="licebutton">
				<button class="button button2">승인</button>
				<br>
				<button class="button button3">불가</button>
			</div>
		</div>
		<hr>
		<div class="allconfirm">
			<button class="allbutton allbutton2" id="submitBtn1">승인</button>
			<button class="allbutton allbutton3" id="submitBtn2">불가</button>
			<!-- 이메일과 넘버키를 저장해놓는 녀석 -->
			<input type="hidden" id="emailData" value="${tempVO.tp_email}" >
			<input type="hidden" id="numberData" value="${tempVO.tp_no}" >
			
		</div>
		
		</div>
		
		
		
		<script src="/zest/js/jquery.min.js"></script>
		<script src="/zest/js/admin/tutorPropPage.js"></script>
</body>
</html>
