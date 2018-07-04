

$(document).ready(function() {
	//카테고리 버튼 클릭
	$("#categoryBtn").click(function() {
		var index = $("#categorySelect option").index($("#categorySelect option:selected"));
		var category = $("#categorySelect");	
		if(index == 0){
			alert('특기분야를 선택해주세요');
			$("#IsCategory").val(0);
			return;
		}
		alert(category.find("option[value='"+category.val()+"']").text()+"를 선택하셨습니다.");
		//히든의 속성값 변경
		$("#IsCategory").val(1);
	});
	
	$("#categorySelect").change(function(){
		var index = $("#categorySelect option").index($("#categorySelect option:selected"));
		if(index == 0){			
			$("#IsCategory").val(0);
			this.style.backgroundColor="#ebebeb";
			return;
		}
		this.style.backgroundColor="#FAFFBD";
		$("#IsCategory").val(1);
	});
	
	/*//c
	$("file_certification").change(function(){
		if(document.getElementsByName("file_certification")[0].value == ''){
			this.style.backgroundColor="#ebebeb";
			return;
		}
		this.style.backgroundColor="#FAFFBD";
		
	});*/
	
	
	
});

function checkLayer(value){
	alert(value);
	if(value == 1){
		document.getElementById("SchoolMajor1").style.display="block";
		document.getElementById("SchoolMajor2").style.display="none";
		document.getElementById("Idcard").style.display="none";
		clearFile();
	}
	if(value == 2){
		document.getElementById("SchoolMajor1").style.display="none";
		document.getElementById("SchoolMajor2").style.display="block";
		document.getElementById("Idcard").style.display="none";
		 clearFile();
	}
	if(value == 3){
		document.getElementById("SchoolMajor1").style.display="none";
		document.getElementById("SchoolMajor2").style.display="none";
		document.getElementById("Idcard").style.display="block";
		 clearFile();
	}	
}

//업로드한 파일들 초기화하기
function clearFile(){
	
	/*explore 지우는 방법
	 * var files = document.getElementsByName("file_certification");
	files[0].select();
	document.selection.clear();*/
	
	document.getElementsByName("file_certification")[0].value='';
	document.getElementsByName("file_certification")[1].value='';
	document.getElementsByName("file_certification")[2].value='';
}

function validateFile(){
	if($("#IsCategory").val() != 1){
		alert('특기분야를 선택해주셔야 합니다.');
		return false;
	}
}



