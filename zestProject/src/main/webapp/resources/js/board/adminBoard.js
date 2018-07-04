//관리자 게시판 js

$(document).ready(function() {
	$("#deleteboard").click(function() {
		var a = $("#add_no").val();
		location.href = "/zest/admin/delete?add_no=" + a;
	});
});

function goUpdatePage() {
	location.href = "/zest/admin/boardupdateform";
}

function goListAll() {
	location.href = "/zest/admin/adminBoard";
}

function CommentCheck() {

	if ($("#Comment").val() == "") {
		alert("댓글을 입력해주세요 !");
		return false;
	}

	function insertboard() {

		if ($("#add_name").val() == "") {
			alert("이름을 입력해주세요 !");
			return false;
		}
		if ($("#add_title").val() == "") {
			alert("제목을 입력해주세요 !");
			return false;
		}
		if ($("#add_content").val() == "") {
			alert("내용을 입력해주세요 !");
			return false;
		}
	}
}
