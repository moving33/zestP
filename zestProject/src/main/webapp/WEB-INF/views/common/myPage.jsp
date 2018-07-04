<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="css/bootstrap2.css" rel="stylesheet">
<link rel="stylesheet" href="css/material-datetime-picker.css">
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="css/common/myPage.css" rel="stylesheet">
<style>
 body {
      font-family: 'Roboto', sans-serif;
      -webkit-font-smoothing: antialiased;
    }
</style>
</head>
<body>

	<div id="wrap">
		<!-- header -->
		<div id="header_subn">


			<div class="gnb">
				<div class="leftmenu">
					<ul>

						<li><a href="tutorRegiPage"> <span>튜터등록</span>
						</a></li>
						<li><a href="/zest/main"> <span>수업검색</span>
						</a></li>
					</ul>
				</div>
				<div class="logo">
					<a href="main"><img src="images/logo.png" alt="제스트"></a>
				</div>
				<div class="rightmenu">
					<ul>
						<li><a href="#"> <span> <img
									src="images/common/icon_ttalk.png"><br>
							</span> <span>실시간톡</span>
						</a></li>
						<li><a href="#"> <span> <img
									src="images/common/icon_tlist.png">
							</span> <span>수업신청서</span>
						</a>
						<li><a href="/zest/clientPage"> <span> <img
									src="images/common/icon_sjoin.png">
							</span> <span>마이페이지</span>
						</a></li>
						<li><a href="/zest/main/logout"> <span> <img
									src="images/common/icon_slogout.png">
							</span> <span>로그아웃</span>
						</a></li>
					</ul>
				</div>
				<!-- 마이메뉴 -->
				<div class="submy">
					<div class="area">
						<div class="sec01">
							<div class="box">
								<div class="left"
									style="background-image: url(/${client.cl_im_path})">
								</div>
								<div class="right">
									<div class="right01">${client.cl_name} 님</div>
									<div class="right02">${client.cl_nn} </div>
										<div class="right03">
											<a href="clientModifyPage"> <span>정보수정</span></a>
											<a href="#"> <span>튜터 정보수정</span>
											</a>
										</div>
								</div>
							</div>
						</div>

						<div class="sec02">
							<div class="box">
								<div class="box1">
									<img src="images/common/icon_my_menu01.png">
									<div class="middle">받은수업신청서</div>
									<c:if test="${talentForClientCount == null }">
									<div class="bottom">0건</div>
									</c:if>
									<c:if test="${talentForClientCount != null }">
									<div class="bottom">${talentForClientCount}건</div>
									</c:if>
								</div>

								<div class="box2">
									<img src="images/common/icon_my_menu02.png">
									<div class="middle">신청한수업</div>
									<c:if test="${confirmCount == null }">
									<div class="bottom">0건</div>
									</c:if>
									<c:if test="${confirmCount != null }">
									<div class="bottom">${confirmCount}건</div>
									</c:if>
								</div>
								<div class="box3">
									<img src="images/common/icon_my_menu03.png">
									<div class="middle">위시리스트</div>
									<div class="bottom">0건</div>
								</div>

							</div>
						</div>
						<div class="sec03">
							<div class="box">
								<div class="left">
									<div class="lgsize">핸드폰 번호</div>
									<div class="middle lgsize" style="font-size: 15px">등록된 이메일</div>
									
								</div>

								<div class="right">
									<div class="lgsize">
										<c:if test="${client.cl_hp == 'none'}">
										미인증
                                        <a href="#">
                                        <span>번호등록</span>
                                        </a>
										</c:if>
										<c:if test="${client.cl_hp != 'none'}">
										${client.cl_hp}
										</c:if>
									</div>
									<div class="middle lgsize">
									${client.cl_email
									}</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 컨테이너 -->
	<%--수강생페이지인지 튜터 페이지 인지 확인--%>
	<input id="confirmType" value="${pageType}" type="hidden">
	<!-- 튜터 신청 내역이 있는지 없는지 확인 -->
	<input id="tutorCheck" value="${tutorData}" type="hidden">
	${tutorData}
	<div id="container_my">
		<br> <br> <br>
		<div class="box">
			<div class="cont01">
				<div class="box">
					<a href="/zest/clientPage">
						<div class="tabon font" id="c1">수강생</div>
					</a> <a href="/zest/tutorPage">
						<div class="tab font" id="t1">튜터 </div>
					</a>
				</div>
			</div>
			<div class="cont04">
				<%--튜터와 수강생 구분 페이지처리--%>
				<div class="topmenu">
					<c:if test="${pageType == null}">
						<ul>
							<li class="on"><a href="#">수업신청서
							<span>
							<c:if test="${confirmCount != null }">							
							(${confirmCount})
							</c:if>
							<c:if test="${confirmCount == null }">							
							(0)
							</c:if>
							</span></a></li>
							<li><a href="#">수강목록</a></li>
							<li><a href="#">위시리스트</a></li>
						</ul>
					</c:if>

					<c:if test="${pageType == 'tutor'}">
						<ul>
							<li class="on" id="li1">
							<a href="javascript:void(0)" onclick="viewPropTalentPage()">튜터신청확인</a></li>
							<li id="li2"><a href="javascript:void(0)"
								onclick="viewRegiTalentPage()">강의 등록하기</a></li>
<!-- 							<li id="li3"><a href="javascript:void(0)" onclick="viewTalentClient()">신청 수강생 관리</a></li> -->
							<li id="li3"><a href="/zest/clientManager">신청 수강생 관리</a></li>
							<li id="li3"><a href="#">계좌 관리</a></li>
						</ul>
					</c:if>


				</div>
			</div>			
			<!-- 수업 신청 div -->
			<div class="cont12" id="clientPropTalent">
			<c:if test="${pageType == null}">
				<c:if test="${result != null}">
					<div class="row">
					<c:forEach items="${result}" var="list" varStatus="status">
						<div class="col-sm-9">
						    <div class="card" style="margin-bottom: 2px;">
						      <div class="card-body">
						        <a href="/zest/talent/${list.talent_no}"><h5 class="card-title">${list.tc_subject}</h5></a>
						       	<span class="badge badge-warning">매칭 대기 중</span>	
						        <p class="card-text"><b>튜터 전화번호 </b> : ${list.tt_hp}</p>
						        <p class="card-text">신청 일자  : <fmt:formatDate value="${list.to_reg_date}" pattern="yyyy-MM-dd KK:mm:ss"/></p>
						        <button class="btn btn-primary" id="test${status.index}">최초수업일 설정하기</button>
						        <input type="text" value="${list.ti_date}" id="matchTime${status.index}" readonly="readonly">						        
						        <c:if test="${list.ti_date == null}">						        
						        <input type="button" class="btn btn-outline-danger btn-sm" onclick="matchingTalent('${list.to_no}','${list.tt_no}','${list.to_price_total}','${status.index}')" value="승인요청">
						        </c:if>
						        
						        <button class="btn btn-outline-info btn-sm">수정</button>
						     							        				        
						      </div>
						    </div>
				  		</div>								
					</c:forEach>
					</div>				
				</c:if>	
			</c:if>			
			</div>
			
			<!-- 튜터 신청 확인 div -->			
			<div class="cont12" id="tutorPropDiv">
				<c:if test="${pageType == 'tutor'}">
					<!-- 승인된 사용자 -->
					<c:if
						test="${tt_prop.tp_message eq null and tt_prop.tp_status != 0}">
						<div class="alert alert-primary" role="alert"
							style="width: 80%; margin: auto;">
							축하드립니다, 튜터로 선정되셨습니다. 자유롭게 자신의 재능을 나누어주세요! <br> <span
								style="font-size: large;"><b> ${client.cl_name} </b></span>님 께서
							수업신청시 채택가능성이 높은 분야는 <span style="font-size: large;"><b>
									${tt_prop.tp_category_id} </b></span>항목 입니다.
						</div>
					</c:if>
					<!--  대기중인 사용자  -->
					<c:if test="${ tt_prop.tp_status eq 0}">
						<div class="alert alert-primary" role="alert"
							style="width: 80%; margin: auto;">
							<span style="font-size: large;"><b> ${client.cl_name}
							</b></span> 님 께서 신청하신 항목을 검토 중에 있습니다, 신청하신 날짜 1~2일 안에 처리 될 예정입니다.
						</div>
					</c:if>
					<!--  거부 처리된 사용자  -->
					<c:if test="${ tt_prop.tp_status eq 1 and tt_prop.tp_message eq 0}">
						<div class="alert alert-danger" role="alert"
							style="width: 80%; margin: auto;">
							<span style="font-size: large;"><b> ${client.cl_name}
							</b></span> 님 의 튜터 신청 처리가 <span style="font-size: large; color: black;"><b>
									신분증 인증 항목과 프로필 사진 인증 </b></span> 이 양식에 맞지 않아 취소 되었습니다 .
						</div>
					</c:if>
					<c:if test="${ tt_prop.tp_status eq 1 and tt_prop.tp_message eq 1}">
						<div class="alert alert-danger" role="alert"
							style="width: 80%; margin: auto;">
							<span style="font-size: large;"><b> ${client.cl_name}
							</b></span> 님 의 튜터 신청 처리가 <span style="font-size: large; color: black;"><b>
									프로필 사진 </b></span> 이 양식에 맞지 않아 취소 되었습니다 .
						</div>
					</c:if>
					<c:if test="${ tt_prop.tp_status eq 1 and tt_prop.tp_message eq 2}">
						<div class="alert alert-danger" role="alert"
							style="width: 80%; margin: auto;">
							<span style="font-size: large;"><b> ${client.cl_name}
							</b></span> 님 의 튜터 신청 처리가 <span style="font-size: large; color: black;"><b>
									신분증 인증 항목 </b></span> 이 양식에 맞지 않아 취소 되었습니다 .
						</div>
					</c:if>
					<ul>
						<li>&nbsp;</li>
					</ul>
				</c:if>
			</div>
			<!-- 튜터등록 div -->
			<div class="cont12" id="talentRegi" style="display: none;">
				<h1>드루와 강의를 등록하세요</h1>
				<div class="tutor_eximg">
					<img src="images/common/tutor/img_tutor_reg06.png" style="width: 1000px;">
				</div>
				<a href="/zest/tutorPage/talentProp" class="btn btn-primary" style="width: 500px;height: 50px; font-size: x-large; margin-left: 290px; margin-top: 30px;">강의 등록하기</a>
			</div> 
			<!-- 수업별 Client 관리 -->
			<div class="cont12" id="talentManage" style="display: none;">
				<c:if test="${pageType == 'tutor'}">
					<c:if test="${smallType == 'managerClient'}">
					<!-- 매칭된 수업이 있으면 -->
					<div class="accordion" id="talentSubject" style="margin-top: -50px;">						
						<c:if test="${matchingList1 != null}">							
										<div class="card">
							<c:forEach items="${matchingList1}" varStatus="count1" var="list1">										
										   <c:if test="${count1.first}">
										    <div class="card-header" id="headingOne">
										      <h5 class="mb-0">
										        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse${list1.talent_no}" aria-expanded="true" aria-controls="collapse${list1.talent_no}">
										       	 	<i class="fas fa-graduation-cap fa-3x"></i>${list1.tc_subject} &nbsp;&nbsp;
										        </button>
										      </h5>
										    </div>
									    <div id="collapse${list1.talent_no}" class="collapse" aria-labelledby="headingOne" data-parent="#talentSubject">
									      <div class="card-body">
										    </c:if>							
									      		
									   <div class="col-sm-9">
										    <div class="card" style="margin-bottom: 2px;">
										      <div class="card-body">
										        <h5 class="card-title">${list1.cl_name}</h5>
										        <c:if test="${list1.ts_status == 0}">		
										       	<span class="badge badge-warning">매칭 대기 중</span>
										       	</c:if>	
										       	<c:if test="${list1.ts_status == 1}">
										       	<span class="badge badge-primary">매칭 성공</span>
										       	</c:if>	
										        <p class="card-text"><b>수강생 전화번호 </b> : ${list1.cl_hp}</p>
										        <c:set var="TextValue" value="${list1.ti_date}"/>										        									    		
										        <p class="card-text">희망 하는 첫수업 날짜  : <b>${fn:substring(TextValue,0,10)}</b>&nbsp; 시간 : <b>${fn:substring(TextValue,11,16)}</b></p>
										           <p class="card-text">결제 금액  : <b><fmt:formatNumber value="${list1.to_price_total}" pattern="#,###"/></b></p>
										       <%--  <button class="btn btn-primary" id="test${status.index}">최초수업일 설정하기</button> --%>
										       <p class="card-text"><b>경력 </b> : ${list1.tp_career_month}개월</p>
										      <i class="far fa-comment-dots fa-3x"></i>${list1.tp_message }	
										      <br>
										      	<c:if test="${list1.ts_status == 0}">								 	      					      					 		       
			       						        <input type="button" class="btn btn-outline-danger btn-sm"  value="승인하기" onclick="submitTalent('${list1.ts_no}')">
			       						        </c:if>
										        <button class="btn btn-outline-info btn-sm">수정</button>
										      </div>
										    </div>
								  		</div>								      		
									     
									      <c:if test="${count1.last}">
									      		</div>
									    	</div>
									  	</div>						
									 	 </c:if>	
							</c:forEach>						 
						 </c:if>
							 
						<c:if test="${matchingList2 != null}">
										<div class="card">
							 <c:forEach items="${matchingList2}" varStatus="count1" var="list1">										
										   <c:if test="${count1.first}">
										    <div class="card-header" id="headingOne">
										      <h5 class="mb-0">
										        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse${list1.talent_no}" aria-expanded="true" aria-controls="collapse${list1.talent_no}">
										       <i class="fas fa-graduation-cap fa-3x"></i>${list1.tc_subject}
										        </button>
										      </h5>
										    </div>
										    <div id="collapse${list1.talent_no}" class="collapse" aria-labelledby="headingOne" data-parent="#talentSubject">
										      <div class="card-body">
										    </c:if>							
									      		
									   <div class="col-sm-9">
										    <div class="card" style="margin-bottom: 2px;">
										      <div class="card-body">
										        <h5 class="card-title">${list1.cl_name}</h5>
										       <c:if test="${list1.ts_status == 0}">		
										       	<span class="badge badge-warning">매칭 대기 중</span>
										       	</c:if>	
										       	<c:if test="${list1.ts_status == 1}">
										       	<span class="badge badge-primary">매칭 성공</span>
										       	</c:if>
										        <p class="card-text"><b>수강생 전화번호 </b> : ${list1.cl_hp}</p>
										        <c:set var="TextValue" value="${list1.ti_date}"/>										        									    		
										        <p class="card-text">신청 일자  : <b>${fn:substring(TextValue,0,10)}</b>&nbsp; 시간 : <b>${fn:substring(TextValue,11,16)}</b></p>
										         <p class="card-text">결제 금액  : <b><fmt:formatNumber value="${list1.to_price_total}" pattern="#,###"/></b></p>
										       <%--  <button class="btn btn-primary" id="test${status.index}">최초수업일 설정하기</button> --%>
										           <p class="card-text"><b>경력 </b> : ${list1.tp_career_month}개월</p>
										      <i class="far fa-comment-dots fa-3x"></i>${list1.tp_message }										      					        
			       						        	<c:if test="${list1.ts_status == 0}">								 	      					      					 		       
			       						        <input type="button" class="btn btn-outline-danger btn-sm"  value="승인하기" onclick="submitTalent('${list1.ts_no}')">
			       						        </c:if>
										        <button class="btn btn-outline-info btn-sm">수정</button>
										      </div>
										    </div>
								  		</div>								      		
									     
									      <c:if test="${count1.last}">
									      		</div>
									    	</div>
									  	</div>						
									 	 </c:if>	
							</c:forEach>							 
						</c:if>	 
						
						<c:if test="${matchingList3 != null}">
										<div class="card">
							 <c:forEach items="${matchingList2}" varStatus="count1" var="list1">										
										   <c:if test="${count1.first}">
										    <div class="card-header" id="headingOne">
										      <h5 class="mb-0">
										        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse${list1.talent_no}" aria-expanded="true" aria-controls="collapse${list1.talent_no}">
										       	<i class="fas fa-graduation-cap fa-3x"></i>${list1.tc_subject}
										        </button>
										      </h5>
										    </div>
									    <div id="collapse${list1.talent_no}" class="collapse" aria-labelledby="headingOne" data-parent="#talentSubject">
									      <div class="card-body">
										    </c:if>							
									      		
									   <div class="col-sm-9">
										    <div class="card" style="margin-bottom: 2px;">
										      <div class="card-body">
										        <h5 class="card-title">${list1.cl_name}</h5>
										       	 <c:if test="${list1.ts_status == 0}">		
										       	<span class="badge badge-warning">매칭 대기 중</span>
										       	</c:if>	
										       	<c:if test="${list1.ts_status == 1}">
										       	<span class="badge badge-primary">매칭 성공</span>
										       	</c:if>
										        <p class="card-text"><b>수강생 전화번호 </b> : ${list1.cl_hp}</p>
										        <c:set var="TextValue" value="${list1.ti_date}"/>										        									    		
										        <p class="card-text">신청 일자  : <b>${fn:substring(TextValue,0,10)}</b>&nbsp; 시간 : <b>${fn:substring(TextValue,11,16)}</b></p>
										       <p class="card-text">결제 금액  : <b><fmt:formatNumber value="${list1.to_price_total}" pattern="#,###"/></b></p>
										       <%--  <button class="btn btn-primary" id="test${status.index}">최초수업일 설정하기</button> --%>
										           <p class="card-text"><b>경력 </b> : ${list1.tp_career_month}개월</p>
										      <i class="far fa-comment-dots fa-3x"></i>${list1.tp_message }										      					        
										      <br>
			       						       	<c:if test="${list1.ts_status == 0}">								 	      					      					 		       
			       						        <input type="button" class="btn btn-outline-danger btn-sm"  value="승인하기" onclick="submitTalent('${list1.ts_no}')">
			       						        </c:if>
										        <button class="btn btn-outline-info btn-sm">수정</button>
										      </div>
										    </div>
								  		</div>								      		
									     
									      <c:if test="${count1.last}">
									      		</div>
									    	</div>
									  	</div>						
									 	 </c:if>	
							</c:forEach>							 
						</c:if>	 				 
					</div>
						
						 
						 <!-- 매칭된 수업이 없으면 -->
						 <c:if test="${matchingList != null}">
						
						</c:if>														
					</c:if>
				</c:if>					
			</div> 			
		</div>
	</div>
	<br>
	<br>
	<br>


	</div>
	<!-- /컨테이너 -->
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
						<li><img src="images/common/yellow.png">&nbsp;KAKAO
							옐로우ID / @Droowa</li>
						<li>운영시간 / 평일 10:00~19:00</li>
					</ul>
				</div>
			</div>
			<div style="overflow: hidden; padding-top: 79px">
				<div class="bt_info">
					상호 : (주)드루와 | 주소 : 서울시 성동구 무학로2길 54 신방빌딩 4,5층 | 사업자등록번호 :
					123-45-67890 |<br> Copyright ⓒ2018 droowa inc, ltd.
					All rights reserved
				</div>
				<div class="logo_box">
					<a href="#" target="_blank"><img
						src="images/common/ic_sns_facebook_38_38.png"></a> <a href="#"
						target="_blank"> <img
						src="images/common/ic_sns_instagram_38_38.png"></a> <a href="#"
						target="_blank"><img
						src="images/common/ic_sns_youtube_38_38.png"></a>
				</div>

			</div>
		</div>
	</div>
	<script src="/zest/js/jquery.min.js"></script>
	<script src="/zest/js/bootstrap.bundle.min.js"></script>
	<!-- <script src="/zest/js/sugar.min.js"></script> -->
	 <script src="https://unpkg.com/babel-polyfill@6.2.0/dist/polyfill.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.js"></script>
  <script>
    moment().format();
  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/rome/2.1.22/rome.standalone.js"></script>
  <script src="/zest/js/material-datetime-picker.js" charset="utf-8"></script>
	<%--sweet alert--%>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<!-- 아이콘 -->
	<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>
	<script src="/zest/js/tutor/myPage.js"></script>	
	
</body>
<c:if test="${pageType == 'tutor'}">
<c:if test="${smallType == 'managerClient'}">
						<script type="text/javascript">
						$("#talentRegi").css("display", "none");
						$("#tutorPropDiv").css("display", "none");
						$("#talentManage").css("display", "block");
						$("#li1").attr("class", '');
						$("#li2").attr("class", '');
						$("#li3").attr("class", 'on');	
						</script>					
			</c:if>
			</c:if>

</html>