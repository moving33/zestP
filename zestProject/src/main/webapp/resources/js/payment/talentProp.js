
$(document).ready(function(){	
	var real_price_total = $("#real_price_total").val();
	var str  = Number(real_price_total).toLocaleString('en');	
	//str = real_price_total.substr(0,real_price_total.length-2);
	var html = "";
	html += str+"원";
	html += '<font color="#666" style="font-size: 12px;">(수업가격 + VAT 10%)</font>';
	$("#realPriceDiv").html(html);
	
	//포인트 변경시
	$("#usePoint").change(function(){
		
		var maxPoint = $("#maxPoint").val();
		var thisPoint = parseInt($("#usePoint").val());
		
		if(isNaN(thisPoint)){
			alert('숫자를 입력해주세요');
		}
		
		
		if(thisPoint > maxPoint ){
			alert("사용 가능 최대 포인트는 "+maxPoint+" 입니다.");
			$("#usePoint").val(0);
			this.focus();
			return;
		}		

		var real_price_total = $("#real_price_total").val();
		var usePoint = $("usePoint").val();		
		var resultPoint = real_price_total - thisPoint;	
		resultPoint = Number(resultPoint).toLocaleString('en');	
		//alert(resultPoint);
		var html = "";
		html += resultPoint+"원";
		html += '<font color="#666" style="font-size: 12px;">(수업가격 + VAT 10%)</font>';
		$("#realPriceDiv").html(html);

	});
	
	checkPaymentConfirm();
	
	
});





// 창 변환
function chageDiv() {
	if ($("#payPage").css("display") == "block") {
		$('#propPage').show();
		$('#payPage').hide();
		$('#propBtn2').removeClass('btn-primary');
		$('#propBtn2').addClass('btn-default');
		$('#propBtn1').removeClass('btn-default');
		$('#propBtn1').addClass('btn-primary');
		$('#submitDiv').text('다음');
	} else {
		$('#propPage').hide();
		$('#payPage').show();
		$('#propBtn1').removeClass('btn-primary');
		$('#propBtn1').addClass('btn-default');
		$('#propBtn2').removeClass('btn-default');
		$('#propBtn2').addClass('btn-primary');
		$('#submitDiv').text('결제하기');
	}
}
// 카카오 페이 결제
function kkaoPay() {
	//포인트
	var point = $("#usePoint").val();
	//talent 넘버
	var talent_no = $("#talent_no").val();	
	//전송할 data	
	var data = {'talent_no':talent_no,'point':point};	
	post_to_url('payment/kkaoPay',data);
	//window.open('payment/kkaoPay?talent_no='+talent_no+'&point='+point,'카카오 페이 결제', 'width=800,height=700');
}

// 휴대폰 인증창

function phoneCertification() {
	window.open('payment/phoneCertification', '휴대폰 인증', 'width=800,height=700');
}

// 계좌이체

function kcpPay() {
	window.open('payment/kcpPayment', '계좌이체', 'width=800,height=700');
}

// 사용자 숙련도 확인
function talentLevel(level) {
	var levelDiv1 = $("#level1");
	var levelDiv2 = $("#level2");
	var levelDiv3 = $("#level3");
	var classLevel = $("#talentLevel");

	if (level == '1') {
		levelDiv1.css("background-color", "blue");
		levelDiv1.css("color", "white");
		levelDiv2.css("background-color", "white");
		levelDiv2.css("color", "#999");
		levelDiv3.css("background-color", "white");
		levelDiv3.css("color", "#999");
		classLevel.val('1');
	}

	if (level == '2') {
		levelDiv2.css("background-color", "blue");
		levelDiv2.css("color", "white");
		levelDiv1.css("background-color", "white");
		levelDiv1.css("color", "#999");
		levelDiv3.css("background-color", "white");
		levelDiv3.css("color", "#999");
		classLevel.val('2');
	}

	if (level == '3') {
		levelDiv3.css("background-color", "blue");
		levelDiv3.css("color", "white");
		levelDiv1.css("background-color", "white");
		levelDiv1.css("color", "#999");
		levelDiv2.css("background-color", "white");
		levelDiv2.css("color", "#999");
		classLevel.val('3');
	}
}

// 신청한내용 보내기
function sendPropTalent() {

	
    var talent_no = $("#talent_no").val();
    var tt_no = $("#tutor_no").val();
    var price_total = $("#price_total").val();
    var career_level  = $("#talentLevel").val();
	var career  = $("#Career").val();
	var tp_message  = $("#message").val();
	// 유효성 검사하기 (미완)
	
	if(career_level == ""){
		alert("자신의 레벨을 선택해주세요 ");
		return;
	}
	
	
	if(isNaN(career)){
		alert("경력을 숫자로만 입력해주세요");
		 $("#Career").val("");
		 $("#Career").focus();
		 return;
	}
	
	if(tp_message.length > 30){
		alert("30자 이내로 작성해주세요");
		 $("#message").focus();
		 return;
	}	
	
	
	// json으로 보낼 data
	var sendData = {'talent_no':talent_no,
					'tt_no' : tt_no,
					'price_total':price_total,
					'career_level':career_level,
					'career':career,
					'tp_message':tp_message	
					};

	console.log(sendData);	
	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json;Charset=UTF-8");
	fetch('/zest/payment/talentProp', {
		method : 'POST',
		credentials : 'same-origin',
		headers : myHeaders,
		body : JSON.stringify(sendData)
	}).then(function(response) {
		if (!response.ok) {
			throw Error(response.statusText);
		}
		// 텍스트 기반으로 처리
		return response.text();
	}).then(function(text) {
		alert(text);
		if (text == "success") {
			chageDiv();
		} else {
			if(text == "loginError"){
				var test = 'width=400,height=500,scrollbars=yes,resizable=yes,top=100,left=500,toolbar=yes';
			    window.open('common/loginPage','로그인',test);
			}
			if(text == "fail"){
				alert('이미 결제 신청한 수업입니다. 결제를 진행해주세요');
				chageDiv();
			}
		}
	});
}

function checkPaymentConfirm(){
	var talent_no = $("#talent_no").val();
	var sendData = {
			'talent_no':talent_no			
			};
	var myHeaders = new Headers();	
	myHeaders.append("Content-Type", "application/json;Charset=UTF-8");
	fetch('/zest/payment/talentPropCheck', {
		method : 'POST',
		credentials : 'same-origin',
		headers : myHeaders,
		body : JSON.stringify(sendData)
	}).then(function(response) {
		if (!response.ok) {
			throw Error(response.statusText);
		}
		// 텍스트 기반으로 처리
		return response.text();
	}).then(function(text) {
			alert(text);		
			if(text == "fail"){
				alert('이미 결제 신청한 수업입니다. 결제를 진행해주세요');
				chageDiv();
			}
	});
	
}


// 보내기 버튼 
function send(){
	sendPropTalent();
}

//포인트 적용
function usePoint(){
	var real_price_total = $("#real_price_total").val();
	var usePoint = $("usePoint").val();	
	var resultPoint = real_price_total - usePoint;
	var str  = Number(resultPoint).toLocaleString('en');	
	alert(str);
	//var str = resultPoint.substr(0,real_price_total.length-2);
	var html = "";
	html += str+"원";
	html += '<font color="#666" style="font-size: 12px;">(수업가격 + VAT 10%)</font>';
	$("#realPriceDiv").html(html);
}

//포스트 형식 전송
function post_to_url(path, params, method) {
    method = method || "post"; // 전송 방식 기본값을 POST로
    
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);
    form.setAttribute("target","popup_window");
 
    //히든으로 값을 주입시킨다.
    for(var key in params) {
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", key);
        hiddenField.setAttribute("value", params[key]); 
        form.appendChild(hiddenField);
    }
 
    document.body.appendChild(form);    
    window.open('', 'popup_window', 'width=800,height=700');
    form.submit();
}
















