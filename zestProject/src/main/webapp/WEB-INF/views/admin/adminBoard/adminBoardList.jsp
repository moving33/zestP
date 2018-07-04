<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-31
  Time: 오후 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<meta name="viewport" content="width=device-width, initial-scale = 1.0" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>$Title$</title>

<!-- 세션 검사 -->

<link href="/zest/css/admin/zest_admin.css" rel="stylesheet">
<link href="/zest/css/bootstrap.css" rel="stylesheet">
<link href="/zest/css/admin/adminBoard.css" rel="stylesheet">

<style>
#search {
	margin-left: 70%;
	width: 90px;
	flex: none;
}
</style>

</head>
<body class="fix-header fix-sidebar">
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
		<jsp:include page="../leftSideBar.jsp"></jsp:include>
		<%--end left sidebar--%>
		<div class="page-wrapper" style="min-height: 824px;">
			<%--low title--%>
			<div class="row page-titles" style="margin: 0">
				<div class="col-md-5 align-self-center">
					<%--타이틀이 들어가는 영역--%>
					<h3 class="text-primary">관리자게시판</h3>
				</div>
			</div>


			<%--content가 들어가는영역!--%>
			<div class="container-fluid" style="background-color: white;">
				<div class="row">
					<%--최대로 맞춤--%>
					<div class="col-12">

						<%--실제 data가 들어감--%>
						<div class="m-t-40">
							<!-- 실제 데이터가 들어가는 영역 -->
								<center>
									<!-- 검색시작 -->
									<form action="adminBoard" method="get">
										<div class="input-group">
											<select id="search" dir="rtl" name="searchCondition"
												class="custom-select">
												<option value="ID">아이디</option>
												<option value="TITLE">제목</option>
												<option value="CONTENT">내용</option>
											</select>
											<div class="input-group-append">
												<input name="searchKeyword" type="text" class="form-control" />
												<input class="btn btn-outline-secondary" type="submit"
													value="검색" class="btn btn-primary" value=${keyword }/>
											</div>
										</div>
									</form>
									<!-- 검색종료 -->
									<table class="table table-bordered">
										<tr style="text-align: center">
											<th style="width: 5%;">NO</th>
											<th style="width: 15%;">아이디</th>
											<th style="width: 25%;">제목</th>
											<th style="width: 15%;">아이피</th>
											<th style="width: 6%;">조회수</th>
											<th style="width: 10%;">등록일</th>
										</tr>

										<!-- getboard 가 보여지는 화면 -->
										<c:forEach items="${boardList}" var="board">
											<tr style="text-align: center">
												<td>${board.add_no}</td>
												<td>${board.add_id }</td>
												<td><a href="getBoard?add_no=${board.add_no}">${board.add_title }</a></td>
												<td>${board.add_ip }</td>
												<td>${board.add_readcount }</td>
												<td><fmt:formatDate value="${board.add_reg_date}"
														pattern="yyyy.MM.dd HH:mm:ss" /></td>
											</tr>
										</c:forEach>

										<!-- 검색 C 테그 -->
										<c:forEach items="${searchList}" var="board">
											<tr>
												<td>${board.add_no}</td>
												<%--<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title }</a></td>--%>
												<td>${board.add_id }</td>
												<td><a href="getBoard?add_no=${board.add_no}">${board.add_title }</a></td>
												<td>${board.add_ip }</td>
												<td>${board.add_readcount }</td>
												<td>${board.add_reg_date }</td>
											</tr>
										</c:forEach>
									</table>
									<!-- 페이징처리 -->
									<c:if test="${paging.isPre()}">
										<a 
										href="adminBoard?pageNum=${paging.getPage_start()-paging.p_size}&searchCondition=${type}&searchKeyword=${keyword}">Previous</a>
									</c:if>
									<table>
										<tr>
											<c:forEach var="count" begin="${paging.getPage_start() }"
												end="${paging.getPage_end()}">
												<td><a
													href="adminBoard?pageNum=${count}&searchCondition=${type}&searchKeyword=${keyword}">${count}</a>
												</td>
											</c:forEach>
										</tr>
									</table>

									<!-- 다음 -->
									<c:if test="${paging.isNext()}">
										<a
											href="adminBoard?pageNum=${paging.getPage_start()+paging.p_size}&searchCondition=${type}&searchKeyword=${keyword}">Next</a>
									</c:if>

									<br>
									<input type="button" class="btn btn-primary btn-lg disabled"
										onclick="window.location.href='insert'" value="새글작성" />
								</center>
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
		<script src="/zest/js/popper.js"></script>
		<script src="/zest/js/board/adminBoard.js"></script>

</body>
</html>
