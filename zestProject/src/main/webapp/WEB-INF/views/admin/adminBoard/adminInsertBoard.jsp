<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-31
  Time: 오후 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta name="viewport" content="width=device-width, initial-scale = 1.0" />

<html>
<head>
<title>$Title$</title>

<!-- 세션 검사 -->

<link href="/zest/css/admin/zest_admin.css" rel="stylesheet">
<link href="/zest/css/bootstrap.css" rel="stylesheet">
<link href="/zest/css/admin/adminBoard.css" rel="stylesheet">

<style type="text/css"></style>


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
					<h3 class="text-primary">관리자게시판</h3>
				</div>
			</div>

			<%--content가 들어가는영역!--%>
			<div class="container-fluid" style="background-color: white;">
				<div class="row">
					<%--최대로 맞춤--%>
					<div class="col-12">
					
						<div class="card-body">

	<center>
		<form onsubmit="return insertboard()" action="insert" method="post">
			<table class="table table-hover" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th width="70">이름</th>
					<td><input id="add_name" type="text"  name="add_name" class="form-control" /></td>
				</tr>
				<tr>
					<th >제목</th>
					<td><input id="add_title" type="text" name="add_title" class="form-control"></td>
				</tr>
				<tr>
					<th >내용</th>
					<td><textarea id="add_content"  style="resize: none; height: 100px;" name="add_content" class="form-control" cols="10" rows="10"></textarea></td>
				</tr>

			</table>
			
			<input class="btn btn-primary btn-lg disabled" type="submit"value="새글 등록" />
			<input class="btn btn-primary btn-lg disabled" type="button"value="글목록"  onclick="window.location.href='adminBoard'"/>
		</form>
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
		<script src="/zest/js/board/insertBoard.js"></script>
</body>
</html>