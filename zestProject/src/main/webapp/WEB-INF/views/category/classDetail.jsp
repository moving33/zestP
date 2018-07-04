<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

	
<!-- 부트스트랩 CSS -->
<link href="/zest/css/bootstrap.css" rel="stylesheet">
<!-- classDetail css -->
<link href="/zest/css/category/classDetail.css" rel="stylesheet">
<script src="/zest/js/jquery.min.js"></script>


<title>수업상세 페이지</title>
</head>
<body>
<!-- 헤더 -->
<div id="header_subn">
	<div class="gnb">
		<div class="leftmenu">
			<ul>			
				<li><a href=""><span>소개</span></a></li>
				<li><a href=""><span>튜터등록</span></a></li>
				<li><a href=""><span>수업검색</span></a></li>
			</ul>
		</div>
		<div class="logo"><a href="/zest/main"><img src="/zest/images/logo2.png" alt="Logo"/></a></div>
            <div class="rightmenu" style="margin-top:33px;" id="loginCheck">
            	<ul>
            		<!-- <li style="width:180px;"></li>
					<li>
						<a href="#" id="regi" onmousemove="join01.src='/zest/images/join2.png'" onmouseout="join01.src='/zest/images/join1.png'">
						<span><img src="/zest/images/join1.png" name="join01"/></span><span>회원가입</span></a>
					</li>
					<li>
						<a href="#" id="login" onmousemove="join02.src='/zest/images/login2.png'" onmouseout="join02.src='/zest/images/login1.png'">
						<span><img src="/zest/images/login1.png" name="join02"/></span><span>로그인</span></a>
					</li> -->
					<li class="nav-item"><a class="nav-linkj" id="regi" href="#" style="font-size: 20px;"><b>회원 가입</b></a></li>
              		<li class="nav-item"><a class="nav-linkj" id="login" href="#" style="font-size: 20px;"><b>로그인</b></a></li>
            		
            	</ul>
            </div>	
	</div>
</div>
<!-- //헤더 -->


<!-- CONTAINER -->
<div id="container_detail">
	<div class="class_wrap">
		<!-- 수업결제 정보 -->
		<div class="class_price" id ="class_price" style="position:relative;">
			<div class="area_info">
				<div class="area" id="area"><h1>위치</h1>	
				
				<c:forEach var="zone" items="${zone }" varStatus="status">
				<input type="button" id="area_zone${status.count }" class="area_zone" value="${zone.zone_name }">
				
				</c:forEach>
				
				</div> 
				<!-- 수업시간 -->
				<script>
					$("#area_zone1").click(function(){
						$("#area_zone1").css("background","#ff7200");
						$("#area_zone1").css("color","#fff");
						$("#area_zone2").css("background","#e9e9e9");
						$("#area_zone2").css("color","#999");
						$("#area_zone3").css("background","#e9e9e9");
						$("#area_zone3").css("color","#999");
						$("#section1").css("display","block");
						$("#section2").css("display","none");
						$("#section3").css("display","none");
					});
					$("#area_zone2").click(function(){
						$("#area_zone1").css("background","#e9e9e9");
						$("#area_zone1").css("color","#999");
						$("#area_zone2").css("background","#ff7200");
						$("#area_zone2").css("color","#fff");
						$("#area_zone3").css("background","#e9e9e9");
						$("#area_zone3").css("color","#999");
						$("#section1").css("display","none");
						$("#section2").css("display","block");
						$("#section3").css("display","none");
					});
					$("#area_zone3").click(function(){
						$("#area_zone1").css("background","#e9e9e9");
						$("#area_zone1").css("color","#999");
						$("#area_zone2").css("background","#e9e9e9");
						$("#area_zone2").css("color","#999");
						$("#area_zone3").css("background","#ff7200");
						$("#area_zone3").css("color","#fff");
						$("#section1").css("display","none");
						$("#section2").css("display","none");
						$("#section3").css("display","block");
					});
				</script>
				
				
				<div id = "dayId1" >
				<c:forEach var="week" items="${weekDay}" varStatus="status">
				<!-- 첫번째구역  -->
				<c:if test="${week.key == 'mon1'}">
				<script>
					$(document).ready(function(){
							var bnt = "<p>월요일 ${week.value}</p>";
								$("#section1").append(bnt);
					});
				</script>
				</c:if> 
				
				<c:if test="${week.key == 'tue1'}">
			 	<script>
				 	$(document).ready(function(){
				 		var bnt = "<p>화요일 ${week.value}</p>";
						$("#section1").append(bnt);
				 	});
						

				</script> 
				</c:if>
				
				<c:if test="${week.key == 'wed1'}">
			 	<script>
			 		$(document).ready(function(){
							var bnt = "<p>수요일 ${week.value}</p>";
								$("#section1").append(bnt);
			 		});

				</script> 
				</c:if>
				
				<c:if test="${week.key == 'tur1'}">
			 	<script>
			 		$(document).ready(function(){
							var bnt = "<p>목요일 ${week.value}</p>";
								$("#section1").append(bnt);
			 		});

				</script> 
				</c:if>
				
				<c:if test="${week.key == 'fri'}">
			 	<script>
			 		$(document).ready(function(){
							var bnt = "<p>금요일 ${week.value}</p>";
								$("#section1").append(bnt);
			 		});

				</script> 
				</c:if>
				
				<c:if test="${week.key == 'sat1'}">
			 	<script>
			 		$(document).ready(function(){
							var bnt = "<p>토요일 ${week.value}</p>";
								$("#section1").append(bnt);
			 		});

				</script> 
				</c:if>
				
				<c:if test="${week.key == 'sun1'}">
			 	<script>
			 		$(document).ready(function(){
							var bnt = "<p>일요일 ${week.value}</p>";
								$("#section1").append(bnt);
			 		});

				</script> 
				</c:if>
				
				<!-- 두번째 구역 -->
				
				<c:if test="${week.key == 'mon2' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>월요일 ${week.value}</p>";
								$("#section2").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'tue2' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>화요일 ${week.value}</p>";
								$("#section2").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'wed2' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>수요일 ${week.value}</p>";
								$("#section2").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'tur2' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>목요일 ${week.value}</p>";
								$("#section2").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'fri2' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>금요일 ${week.value}</p>";
								$("#section2").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'sat2' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>토요일 ${week.value}</p>";
								$("#section2").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'sun2' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>일요일 ${week.value}</p>";
								$("#section2").append(aaa);
					});

				</script>
				</c:if>
				
				<!-- 세번째 구역 -->
				<c:if test="${week.key == 'mon3' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>월요일 ${week.value}</p>";
								$("#section3").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'tue3' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>화요일 ${week.value}</p>";
								$("#section3").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'wed3' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>수요일 ${week.value}</p>";
								$("#section3").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'tur3' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>목요일 ${week.value}</p>";
								$("#section3").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'fri3' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>금요일 ${week.value}</p>";
								$("#section3").append(aaa);
					});

				</script>
				</c:if>
				
				<c:if test="${week.key == 'sat3' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>토요일 ${week.value}</p>";
								$("#section3").append(aaa);
					});

				</script>
				
				</c:if>
				
				<c:if test="${week.key == 'sun3' }">
				<script>
					$(document).ready(function(){
							var aaa = "<p>일요일 ${week.value}</p>";
								$("#section3").append(aaa);
					});

				</script>
				</c:if>
				
				
				<div id="section1" style="display: block"></div>
				
				<div id="section2" style="display: none"></div>
				
				<div id="section3" style="display: none"></div>

				</c:forEach>

				</div>
				
			
		
				<!-- <div class="time" id="time"><h1>날짜<br>시간</h1></div> -->
				<div class="add" id="add1"><br>추가비용 : ${detail.tc_price_detail}</div>
				<div class="tutor_t">
				<dl class="tutor_txt">
					<dt><div class="tutorPro"><img id="tt_img1" src="${pro0 }"></div></dt>
					<dd>${detail.tc_tt_message}<dd>
					
					<script>
					$(document).ready(function(){
						var meet_time = ${talent.talent_meet_time}
						var meet_count = ${talent.talent_meet_count}
						var meet = meet_time * meet_count
						$("#ti").prepend(meet);
					});
						
					</script>
				</dl>
				</div>
				<button style="width: -webkit-fill-available;"class="btn btn-lg btn-primary" onclick="propTalent(${talent.talent_no},${tutor.tt_no},${talent.talent_total_price})">수업 신청하기</button>
				<div class="price">
					<div class="hp1"><b>￦${talent.talent_price_hour }</b>/시간</div>
					<div class="tp1">￦${talent.talent_total_price } / 총 ${talent.talent_meet_count }회 <b id="ti"></b>시간</div>
				</div>
				<div class="btn_area">
					<a class="btn_qna" onclick="#"><img src="/zest/images/classDetail/icon_btn_qna.png"> 실시간 톡하기</a>
					<a class="btn_wish" onclick="#"><img src="/zest/images/classDetail/icon_btn_wish.png"> 찜하기</a>
				</div>
			</div>
		</div>
		
		
		<!-- 상단이미지 -->
		<div class="class_img">
		
			<div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
			<ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
           
            <div class="carousel-inner" role="listbox">
              <c:forEach var="images" items="${imgPath}" varStatus="status">
              <c:choose>
              <c:when test="${status.index == 0}">
              <div class="carousel-item active">	
                <img class="d-block img-fluid" src="${images}" alt="First slide">
              </div>
              </c:when>
              <c:otherwise>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="${images}" alt="Second slide">
              </div>
              </c:otherwise>
              </c:choose>
             </c:forEach>
            </div>
            
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
		</div>
		</div>
		<div class="class_d_wrqp">
		
		<!-- 상세단락 네비 -->
			<div id="class_navi"class="class_navi">
				<ul>
					<li><a href="#sumary" class="" id="sli">요약</a></li>
					<li><a href="#tutorinfo" class="" id="tli">튜터</a></li>
					<li><a href="#Introduction" class="" id="ili">수업소개</a></li>
					<li><a href="#review" class="" id="rli">리뷰</a></li>
					<li><a href="#qna" class="" id="qli">지도</a></li>
				</ul>
			</div>
			
		<!-- 수업요약 -->
			<div class="class_detail" id="sumary">
				<div class="class_name">
					<div class="tutor_img"><img id="tt_img2" src="${pro0}"></div>

					<div class="name">${tutor.tt_name }</div>
					<div class="nickname">${tutor.tt_nn }</div>
				</div>
				<div class="class_title">
				<div class="title">${detail.tc_subject}</div>
				<div class="info">
		
			<div class="star_comment">
			<c:choose>
			<c:when test="${1 eq avg2.total_value }">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 					
					<span class="star-input1">
					<span class="input">
					<input type="radio" value="1" checked >
					<label for="curri1">1</label>
					</span>
					</span>
				</div>
				</c:when>
				<c:when test="${2 eq avg2.total_value }">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" value="2" checked >
					<label for="curri2">2</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${3 eq avg2.total_value}">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" value="3" checked>
					<label for="curri3">3</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${4 eq avg2.total_value}">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio"  value="4" checked >
					<label for="curri4">4</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${5 eq avg2.total_value}">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" value="5" checked>
					<label for="curri5">5</label>
					</span>
					</span>
				</div>
				</c:when>
				</c:choose>
				</div>
				
				</div>
				
				
				<div class="info">
					<ul>
						<li class="ar"><div class="icon1"><img src="/zest/images/classDetail/icon_info01.png"></div>
						<c:forEach var="zone" items="${zone }" varStatus="status">${zone.zone_name }<br></c:forEach></li>							
						<li class="hu"><div class="icon2"><img src="/zest/images/classDetail/icon_info02.png"></div><font color="#ff005a">${talent.talent_meet_time }</font>시간/회</li>
						<li class="gr"><div class="icon3"><img src="/zest/images/classDetail/icon_info03.png"></div>최대인원:<font color="#ff005a">${detail.tc_max_client}</font>명</li>
						<li class="ohu"><div class="icon4"><img src="/zest/images/classDetail/icon_info04.png"></div><font color="#ff005a">￦${talent.talent_price_hour }</font>/시간</li>
					</ul>
				</div>
				</div>
			</div>
			
			<!-- 튜터 소개 -->
			<div class="tutor_in" id="tutorinfo">
			<h1>튜터정보</h1>
			<div class="intro1">${detail.tc_tt_info}</div>
			</div>
			
			<!-- 수업소개 -->
			<div class="class_in" id="Introduction">
			<h1>수업소개</h1>
			<div class="intro2">${detail.tc_class_info}</div>
			</div>
			
			<!-- 수업대상 -->
			<div class="target_in">
			<h1>수업대상</h1>
			<div class="intro6">${detail.tc_class_taget} </div>
			</div>
			
			<!-- 커리큘럽 -->
			<div class="curri_in">
			<h1>커리큘럼</h1>
			<c:forEach items="${cur}" var="cur" varStatus="status">
			<div class="intro3"><br><p style="font-size: 18px; color:red;"><c:out value="${status.count}회차"/><p>${cur}</div><br>
			
			</c:forEach>
			
			</div> 
			  
			<!-- 리뷰 -->
			<div class="review_in" id="review">
			
			<input type="hidden" id="talent_no" name="talent_no" value="${talent_no }">
			<input type="hidden" id="tt_no" name="tt_no" value="${tutor.tt_no }">
			<h1>리뷰 <input type="button" class="btn_st" id="btn-write-revice" onclick="reviewCheck()" value="리뷰쓰기"></h1>
			
			<div class="intro4">
			
			<!-- 리뷰별점 -->
			<div class="star_comment">
			<c:choose>
			<c:when test="${1 eq avg.total_value }">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="total_value" value="1" checked id="curri1">
					<label for="curri1">1</label>
					</span>
					</span>
				</div>
				</c:when>
				<c:when test="${2 eq avg.total_value }">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="total_value" value="2" checked id="curri2">
					<label for="curri2">2</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${3 eq avg.total_value}">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="total_value" value="3" checked id="curri3">
					<label for="curri3">3</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${4 eq avg.total_value}">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="total_value" value="4" checked id="curri4">
					<label for="curri4">4</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${5 eq avg.total_value}">
				<div class="review-scores-detail review-scores-price">
					<label>총점&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="total_value" value="5" checked id="curri5">
					<label for="curri5">5</label>
					</span>
					</span>
				</div>
				</c:when>
				
				</c:choose>
				
				
				
				<c:choose>
				<c:when test="${1 eq avg.tr_curri_value }">
				<div class="review-scores-detail review-scores-price">
					<label>커리큘럼&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="tr_curri_value" value="1" checked id="curri1">
					<label for="curri1">1</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${2 eq avg.tr_curri_value }">
				<div class="review-scores-detail review-scores-price">
					<label>커리큘럼&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="tr_curri_value" value="2" checked id="curri2">
					<label for="curri2">2</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${3 eq avg.tr_curri_value }">
				<div class="review-scores-detail review-scores-price">
					<label>커리큘럼&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="tr_curri_value" value="3" checked id="curri3">
					<label for="curri3">3</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${4 eq avg.tr_curri_value }">
				<div class="review-scores-detail review-scores-price">
					<label>커리큘럼&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="tr_curri_value" value="4" checked id="curri4">
					<label for="curri4">4</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${5 eq avg.tr_curri_value }">
				<div class="review-scores-detail review-scores-price">
					<label>커리큘럼&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="tr_curri_value" value="5" checked id="curri5">
					<label for="curri5">5</label>
					</span>
					</span>
				</div>
				</c:when>
				</c:choose>
				
				<c:choose>
				<c:when test="${1 eq avg.tr_commu_value }">
				<div class="review-scores-detail review-scores-quality">
					<label>전달력&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input2">
					<span class="input">
					<input type="radio" name="tr_commu_value" value="1" checked id="delivery1">
					<label for="delivery1">1</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${2 eq avg.tr_commu_value }">
				<div class="review-scores-detail review-scores-quality">
					<label>전달력&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input2">
					<span class="input">
					<input type="radio" name="tr_commu_value" value="2" checked id="delivery2">
					<label for="delivery2">2</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${3 eq avg.tr_commu_value }">
				<div class="review-scores-detail review-scores-quality">
					<label>전달력&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input2">
					<span class="input">
					<input type="radio" name="tr_commu_value" value="3" checked id="delivery3">
					<label for="delivery3">3</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${4 eq avg.tr_commu_value }">
				<div class="review-scores-detail review-scores-quality">
					<label>전달력&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input2">
					<span class="input">
					<input type="radio" name="tr_commu_value" value="4" checked id="delivery4">
					<label for="delivery4">4</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${5 eq avg.tr_commu_value }">
				<div class="review-scores-detail review-scores-quality">
					<label>전달력&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input2">
					<span class="input">
					<input type="radio" name="tr_commu_value" value="5" checked id="delivery5">
					<label for="delivery5">5</label>
					</span>
					</span>
				</div>
				</c:when>
				</c:choose>

				<c:choose>
				<c:when test="${1 eq avg.tr_ready_value }">
				<div class="review-scores-detail review-scores-recommend">
					<label>준비성&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input3">
					<span class="input">
					<input type="radio" name="tr_ready_value" value="1" checked id="prepare1">
					<label for="prepare1">1</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${2 eq avg.tr_ready_value }">
				<div class="review-scores-detail review-scores-recommend">
					<label>준비성&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input3">
					<span class="input">
					<input type="radio" name="tr_ready_value" value="2" checked id="prepare2">
					<label for="prepare2">2</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${3 eq avg.tr_ready_value }">
				<div class="review-scores-detail review-scores-recommend">
					<label>준비성&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input3">
					<span class="input">
					<input type="radio" name="tr_ready_value" value="3" checked id="prepare3">
					<label for="prepare3">3</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${4 eq avg.tr_ready_value }">
				<div class="review-scores-detail review-scores-recommend">
					<label>준비성&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input3">
					<span class="input">
					<input type="radio" name="tr_ready_value" value="4" checked id="prepare4">
					<label for="prepare4">4</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${5 eq avg.tr_ready_value }">
				<div class="review-scores-detail review-scores-recommend">
					<label>준비성&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input3">
					<span class="input">
					<input type="radio" name="tr_ready_value" value="5" checked id="prepare5">
					<label for="prepare5">5</label>
					</span>
					</span>
				</div>
				</c:when>
				</c:choose>

				<c:choose>
				<c:when test="${1 eq avg.tc_kind_value }">
				<div class="review-scores-detail review-scores-tran">
					<label>친절도&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input4">
					<span class="input">
					<input type="radio" name="tc_kind_value" value="1" checked id="kind1">
					<label for="kind1">1</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${2 eq avg.tc_kind_value }">
				<div class="review-scores-detail review-scores-tran">
					<label>친절도&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input4">
					<span class="input">
					<input type="radio" name="tc_kind_value" value="2" checked id="kind2">
					<label for="kind2">2</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${3 eq avg.tc_kind_value }">
				<div class="review-scores-detail review-scores-tran">
					<label>친절도&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input4">
					<span class="input">
					<input type="radio" name="tc_kind_value" value="3" checked id="kind3">
					<label for="kind3">3</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${4 eq avg.tc_kind_value }">
				<div class="review-scores-detail review-scores-tran">
					<label>친절도&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input4">
					<span class="input">
					<input type="radio" name="tc_kind_value" value="4" checked id="kind4">
					<label for="kind4">4</label>
					</span>
					</span>
				</div>
				</c:when>
				
				<c:when test="${5 eq avg.tc_kind_value }">
				<div class="review-scores-detail review-scores-tran">
					<label>친절도&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input4">
					<span class="input">
					<label for="kind5">5</label>
					</span>
					</span>
				</div>
				</c:when>
				</c:choose>

				
			<c:choose>
			<c:when test="${1 eq avg.tc_time_value }">
				<div class="review-scores-detail review-scores-kind">
					<label>시간준수&nbsp;</label>
					<span class="star-input5">
					<span class="input">
					<input type="radio" name="tc_time_value" value="1" checked id="time1">
					<label for="time1">1</label>
					</span>
					</span>
			</div>
			</c:when>
			
			<c:when test="${2 eq avg.tc_time_value }">
				<div class="review-scores-detail review-scores-kind">
					<label>시간준수&nbsp;</label>
					<span class="star-input5">
					<span class="input">
					<input type="radio" name="tc_time_value" value="2" checked id="time2">
					<label for="time2">2</label>
					</span>
					</span>
			</div>
			</c:when>
			
			<c:when test="${3 eq avg.tc_time_value }">
				<div class="review-scores-detail review-scores-kind">
					<label>시간준수&nbsp;</label>
					<span class="star-input5">
					<span class="input">
					<input type="radio" name="tc_time_value" value="3" checked id="time3">
					<label for="time3">3</label>
					</span>
					</span>
			</div>
			</c:when>
			
			<c:when test="${4 eq avg.tc_time_value }">
				<div class="review-scores-detail review-scores-kind">
					<label>시간준수&nbsp;</label>
					<span class="star-input5">
					<span class="input">
					<input type="radio" name="tc_time_value" value="4" checked id="time4">
					<label for="time4">4</label>
					</span>
					</span>
			</div>
			</c:when>
			
			<c:when test="${5 eq avg.tc_time_value }">
				<div class="review-scores-detail review-scores-kind">
					<label>시간준수&nbsp;</label>
					<span class="star-input5">
					<span class="input">
					<input type="radio" name="tc_time_value" value="5" checked id="time5">
					<label for="time5">5</label>
					</span>
					</span>
			</div>
			</c:when>
			</c:choose>
			
			</div>
			</div>
			
			
			
			<c:forEach var="review" items="${review }" varStatus="status">
			<hr>
			<p class="name">${review.cl_name } 님</p>
			<div class="review-content">${review.tr_content } </div>
	
			</c:forEach>
			
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
										<a href="/zest/talent/${talent_no}?pageNum=${bp.getPage_start()-bp.p_size}">이전 </a>
									</button>
								</li>
							</c:if>

							<%--페이징처리 --%>

							<c:forEach var="counter" begin="${bp.getPage_start()}" end="${bp.getPage_end()}">
								<c:if test="${search_text ne ''}">
									<li class="page-item">
										<button class="page-link"
											onclick="window.location='/zest/talent/${talent_no}?pageNum=${counter}'">
											${counter}</button>
									</li>
								</c:if>

								<c:if test="${search_text eq ''}">
									<li class="page-item">
										<button class="page-link"
											onclick="window.location='/zest/talent/${talent_no}?pageNum=${counter}'">
											${counter}</button>
									</li>
								</c:if>
							</c:forEach>


							<%--다음버튼 --%>
							<c:if test="${bp.isNext()}">
								<li class="page-item">
									<button class="page-link">
										<a href="/zest/talent/${talent_no}?pageNum=${bp.getPage_start()+bp.p_size}">다음 </a>
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
			
			<script type="text/javascript">
				function reviewCheck(){
				
					window.name = "parent";
					var talent_no = $('#talent_no').val();
					var tt_no = $('#tt_no').val();
					var gsWin = window.open('/zest/reviewPage/${talent_no }?talent_no='+talent_no+'&tt_no='+tt_no,'리뷰쓰기','width=550,height=573');
					
					
				}
			</script>
			

			 
			<!-- 지도 -->
			<div class="map_in" id="qna">
			<div id="map" style="width:100%;height:400px;"></div>
			<div class="intro5">
				
			</div>
		
			</div>
			
			
			
		</div>	
	</div>
	
		



	<!-- Bootstrap core JavaScript -->

	<script src="/zest/js/bootstrap.bundle.min.js"></script>
	<script src="/zest/js/category/classDetail.js"></script>
	<script src="/zest/js/main/mainPage.js"></script>
 
	

</body>
</html>