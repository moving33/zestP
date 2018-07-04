// 관리자 코드 및 비밀번호 체크
function codeCheck(){
	var code = $('#code').val(); // 코드 값
	var adminCode = "admin"; // 관리자 등록 승인 코드
	
	var pass = $("#pass").val(); // 비밀번호 값
	var repass = $("#repass").val(); // 비밀번호 확인 값
	
	if(pass != repass){ // 비밀번호가 동일하지 않음
		alert("비밀번호가 동일하지 않습니다.");
		$("#repass").focus();
		return false;
		
	}else if(code != adminCode){ // 코드 불일치
		alert("관리자 코드가 잘못되었습니다.");
		$("#code").focus();
		return false;
	}
	return true;
}