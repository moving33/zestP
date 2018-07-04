<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-31
  Time: 오후 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
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
		<form action="getboard" method="post">
			<input id="add_no" name="add_no" type="hidden" value="${board.add_no }" />
			<table class="table table-hover" border="1" cellpadding="0" cellspacing="0">
				

				<tr>
					<th width="85"  >아이디</th>
					<td><input type="text" name="id" class="form-control" value="${board.add_id}" readonly="readonly" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"  class="form-control" value="${board.add_title}" readonly="readonly" /></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"  class="form-control" value="${board.add_name}" readonly="readonly" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea style="resize: none; height: 100px;" name="content"  class="form-control" cols="10" rows="10" readonly="readonly">${board.add_content }</textarea></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td style="font-weight: 600" ><fmt:formatDate value="${board.add_reg_date}" pattern="yyyy.MM.dd HH:mm:ss"  /></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td style="font-weight: 600" >${board.add_readcount }</td>
				</tr>
			</table>
		</form>
		<c:if test="${board.add_id == admin.id}">
			<input class="btn btn-primary btn-lg disabled" onclick="goUpdatePage()" type="button" value="게시글 수정" />
			<input class="btn btn-primary btn-lg disabled" id="deleteboard" type="button" value="게시글 삭제" />
		</c:if>
		<input class="btn btn-primary btn-lg disabled" type="button" onclick="goListAll()" value="글목록" />
		<hr>

		<!-- 댓글 입력 -->
		<div class="container">
			<form onsubmit="return CommentCheck()" action="boardcommentinsert" method="post">
				<div>
					<input type="hidden" name="ad_reple_addno" value="${board.add_no }" />
					<input type="text" id="Comment"  size="50" name="ad_reple_content" value="${ad_reple_content }" placeholder="내용을 입력하세요.">
					<input type="submit"    class="btn btn-primary btn-lg disabled"  value="등록" />
				</div>
			</form>
		</div>
		<div class="container">
		<div class="commentList"></div>
		</div>


		<!-- 게시판 댓글 목록 -->
		<c:forEach items="${commentlist}" var="comment">
			<form action="commentdelete" method="post">
				<div>
					<div style="font-size: 18px; ">
						<dl class="row">
							<dt class="col-sm-3"> ID :  ${comment.ad_reple_id }</dt>
					<c:if test="${comment.ad_reple_id == admin.id}">
						<input type="hidden" name="ad_reple_no" value="${comment.ad_reple_no}" />
						<input type="hidden" name="add_no" value="${board.add_no}" />
						<input type="submit" class="btn btn-primary btn-lg disabled"  value="삭제" />
					</c:if>	
						
						</dl>
						<dl class="row">
							<dd class="col-sm-3"> ${comment.ad_reple_content } </dd>
						</dl>
					</div>
					<hr>
				</div>
			</form>
		</c:forEach>
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
