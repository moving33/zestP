<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 썸머노트CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="/zest/css/bootstrap.css" rel="stylesheet">
<script src="/zest/js/jquery.min.js"></script>
</head>
<body>
	<script>
	 // 섬머노트
     $(document).ready(function() {
        $('#summernote').summernote();
    });
	</script>
	<br><br>
	<form name="form1" method="post" action="/zest/notice/update">
		
			제목 <input name="notice_title" id="notice_title" size="80"
				value="${dto.notice_title}" placeholder="제목을 입력해주세요">
		</div>
		<div>
			내용
			<textarea id="summernote" name="notice_content" rows="4"
				cols="80" placeholder="내용을 입력해주세요">${dto.notice_content}</textarea>
		</div><br>
		<div style="width: 650px; text-align: center;">
			<!-- 게시물번호를 hidden으로 처리 -->
			<input type="hidden" name="notice_no" value="${dto.notice_no}">
			<input class="btn btn-primary"type="submit" id="btnUpdete" value="수정">
		</div>
	</form>

<!-- 썸머노트  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.js"></script>
<script src="/zest/js/bootstrap.js"></script>

</body>
</html>