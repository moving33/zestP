

function insertboard() {
	
	if ($("#add_name").val() == "") {
		alert("이름을 입력해주세요 !");
		return false;
	}
	if($("#add_title").val() == "") {
		alert("제목을 입력해주세요 !");
		return false;
	}if ($("#add_content").val() == "") {
		alert("내용을 입력해주세요 !");
		return false;
	}
}