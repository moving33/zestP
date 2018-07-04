$(document).on('ready', function(){
    $('.kv-ltr-theme-svg-star').rating({
        hoverOnClear: false,
        theme: 'krajee-svg'
    });
});


function reCheck(){
	var content = $('#content').val();
	if(content == null){
		alert("리뷰내용을 입력해 주세요");
		$("#content").focus();
		return false;
	}
}
