$(document).ready(function() {
	
});

function commentdelete(e) {
	var ad_reple_no = e.siblings(".comment_no").text();
	var add_no = $("#add_no").val();
	$.ajax({
		type : "post",
		data : {
				"ad_reple_no" : ad_reple_no,
				"add_no" : add_no
				},
		url : "commentdelete",
	});
}