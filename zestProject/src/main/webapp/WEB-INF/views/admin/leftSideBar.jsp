	
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
	<div class="left-sidebar">
				<img src="/zest/images/logo.png" style="margin-left: 50px;'"/>
			<div class="slimScrollDiv"
				style="position: relative; overflow: hidden; width: auto; height: 100%; margin-top: 25px;">
				
				
				<div class="scroll-sidebar"
					style="overflow: hidden; width: auto; height: 100%;">
					<%--sidebar nav--%>
					<nav class="sidebar-nav">
						<ul>
							<li class="nav-devider"></li>
							<li class="nav-label"><a href="/zest/admin/main">ADMIN
									PAGE</a></li>
						</ul>
						
						
						<li>
							<a href="#clientManager" aria-expanded="true"
								aria-controls="clientManager" data-toggle="collapse"> <span
									class=""><b>ClientManager</b></span>
							</a>						
							<ul class="collapse" id="clientManager">								
								<li><a href="#">회원 관리</a></li>								
							</ul>
						</li>						
						
						<li>
							<a href="#tutorManger" aria-expanded="true"
								aria-controls="tutorManger" data-toggle="collapse"> <span
									class=""><b>TutorManager</b></span>
							</a>						
							<ul class="collapse" id="tutorManger">
								<li><a href="/zest/admin/tutorManager/prop">튜터 신청 관리</a></li>
								<li><a href="#">튜터 지급 금액 관리</a></li>
								<li><a href="#">튜터 통합 관리</a></li>
							</ul>
						</li>
						
						
						
						
						
						<li>
							<a href="/zest/admin/notice/noticeList"> <span
								class=""><b>공지사항</b></span>
							</a>
						</li>
						<li>
							<a href="#statistics" aria-expanded="true"
								aria-controls="statistics" data-toggle="collapse">
							 	<span class=""><b>통계</b></span>
							</a>
							<ul class="collapse" id="statistics">
								<li><a href="/zest/admin/statistics">카테고리별 누적 인원 수</a></li>
								<li><a href="/zest/admin/statisticsCate">카테고리별 활동 수</a></li>
								<li><a href="/zest/admin/sales">카테고리별 매출현황</a></li>
							</ul>
						</li>
						<li>
							<a href="#"><span class=""><b>매출 현황</b></span></a>
						</li>
							<li>
							<a href="/zest/admin/adminBoard"> <span
								class=""><b>관리자 게시판</b></span>
							</a>
						</li>
					</nav>
				</div>
			</div>
		</div>