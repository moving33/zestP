function checkLoginData() {
	
	
	var id = $("#name").val();
	var pass = $("#pass").val();
	var repass = $("#repass").val();
	if (!chk( /^[가-힣]{2,4}$/, id, "한글만 입력해주세요. 2~4자 이내")){
		return false;
	}
	if (!pwchk(pass, repass, "비밀번호가 다릅니다.")){
		return false;
	}
	return true;
}

// 유효성 검사
function chk(re, e, msg) {
	if (re.test(e)){
		return true;
	}

	alert(msg);

	 $("#name").val("");

	 $("#name").focus();

	return false;
}

function pwchk(e1, e2, msg) {

	if (e1 == e2)
		return true;

	alert(msg);

	var repass = $("#repass").val("");

	$("#repass").focus();

	return false;

}