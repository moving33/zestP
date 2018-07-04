<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 썸머노트CSS -->
<script src="/zest/js/jquery.min.js"></script>
<link href="/zest/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.css" rel="stylesheet">
</head>
<body>

	<script>
	 // 섬머노트
     $(document).ready(function() {
        $('#summernote').summernote({
        	height: 500,
        	width: 948
        });
    });
	</script>
	<div style="margin: auto;width: 65%; margin-top: 5px;">
	<h2 style="text-align: center;">공지사항 작성</h2><br>
	<form  method="post" action="/zest/notice/insert">
		<div style="font-size: large;">
			제목 
		<br>
		<input name="notice_title" id="notice_title" size="80" placeholder="제목을 입력해주세요" style="width:947px;" class="form-control">
		</div>
		<div style="width: 800px;font-size: large;">
			내용
			<br>
			<textarea id="summernote" class="summernote"name="notice_content" id="notice_content" rows="4" cols="80"
				placeholder="내용을 입력해주세요"></textarea>
		</div><br>
		<div style="text-align: right;  margin-right: 10px;">
			<button class="btn btn-primary"type="submit">확인</button>
			<button class="btn btn-dark" type="reset">취소</button>
		</div>
	</form>
	
	</div>
	
	
<!-- 썸머노트  -->

<script src="/zest/js/bootstrap.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.js"></script>
</body>
</html>