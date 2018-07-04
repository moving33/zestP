$(document).ready(function() {
	if ($('#matchTime0').length) {
		var picker0 = new MaterialDatetimePicker({
			el : document.querySelector('#matchTime0'),
			format : 'YYYY-MM-DD HH:mm'
		}).on('submit', function(d) {

		});
		$("#test0").click(function() {
			picker0.open();
		});
	}

	if ($('#matchTime1').length) {
		var picker1 = new MaterialDatetimePicker({
			el : document.querySelector('#matchTime1'),
			format : 'YYYY-MM-DD HH:mm'
		}).on('submit', function(d) {

		});
		$("#test1").click(function() {
			picker1.open();
		});

	}

	if ($('#matchTime2').length) {

		var picker2 = new MaterialDatetimePicker({

			el : document.querySelector('#matchTime2'),
			format : 'YYYY-MM-DD HH:mm'
		}).on('submit', function(d) {

		});
		$("#test2").click(function() {
			picker2.open();
		});

	}

	if ($('#matchTime3').length) {
		var picker3 = new MaterialDatetimePicker({

			el : document.querySelector('#matchTime3'),
			format : 'YYYY-MM-DD HH:mm'
		}).on('submit', function(d) {

		});
		$("#test3").click(function() {
			picker3.open();
		});

	}

	if ($('#matchTime4').length) {
		var picker4 = new MaterialDatetimePicker({

			el : document.querySelector('#matchTime4'),
			format : 'YYYY-MM-DD HH:mm'
		}).on('submit', function(d) {

		});
		$("#test4").click(function() {
			picker4.open();
		});
		
	}

	if ($('#matchTime5').length) {
		var picker5 = new MaterialDatetimePicker({

			el : document.querySelector('#matchTime5'),
			format : 'YYYY-MM-DD HH:mm'
		}).on('submit', function(d) {

		});
		$("#test5").click(function() {
			picker5.open();
		});

	}

	

	var pageType = $("#confirmType").val();
	var tutorCheck = $("#tutorCheck").val();
	// 페이지타입이 튜터 페이지 이면
	if (tutorCheck == 'fail') {
		alert("튜터 신청을 하신후에 서비스를 이용하실 수 있습니다.");
	}

	if (pageType == 'tutor') {
		// #t1,#c1은 페이지를 구분해주는 div
		$("#t1").removeClass("tab");
		$("#t1").addClass("tabon");
		$("#c1").removeClass("tabon");
		$("#c1").addClass("tab");
	}

	// 클라이언트 페이지 js
	// 매칭 날짜 정하기
	for (var i = 0; i <= 5; i++) {
		var idText = "#matchTime" + i;
		var id = $(idText);
		if (id.length) {

			/*
			 * $(idText).click(function() { alert('bbb'); picker.open(); },
			 * false);
			 */
		}
	}

});

function matchingTalent(to_no, tt_no, ps_money, index) {

	var timeId = "#matchTime" + index;
	var ti_date = $(timeId).val();
	var sendData = {
		'to_no' : to_no,
		'tt_no' : tt_no,
		'ps_money' : ps_money,
		'ti_date' : ti_date
	};
	var myHeaders = new Headers();

	myHeaders.append("Content-Type", "application/json;Charset=UTF-8");
	fetch('/zest/clientPage/matchingClient', {
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
			alert('튜터에게 처리 요청을 보냈습니다.');
		} else {

		}
	});

}

function a() {

	var id = "matchTime";
	document.getElementById(id).datetimepicker({
		format : 'd.m.y H:00',
		inline : true
	});

}

// 신청한 강의 승인하기
function submitTalent(ts_no){
	alert(ts_no);
	
	 swal({
         title: "매칭 승인 신청 ",
         text: '수업을 승인 하시겠습니까?',
         icon: "info",
         buttons: true
	 }).then(function(value){
		 
		 var sendData = {'ts_no':ts_no};
		 
		 if(value){			 
			 var myHeaders = new Headers();
				myHeaders.append("Content-Type", "application/json;Charset=UTF-8");
				fetch('/zest/tutorPage/matchingTutor', {
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
					if(text=="success"){
						swal("매칭이 성공적으로 이루어졌습니다", {
			                    icon: "success"
			                });
						setTimeout(function(){
							window.location.href="/zest/clientManager";	
						},2000);			           
					}else{
						swal("매칭이 실패했습니다", {
		                    icon: "warning"
		                });
					}
			 
				});
			 
		 }else{
			 
		 }
	 });
}



// 튜터 등록 페이지 보여주기
function viewRegiTalentPage() {
	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json;Charset=UTF-8");
	fetch('/zest/tutorPage/regiTalent', {
		method : 'GET',
		credentials : 'same-origin',
		headers : myHeaders
	}).then(function(response) {
		if (!response.ok) {
			throw Error(response.statusText);
		}
		// 텍스트 기반으로 처리
		return response.text();
	}).then(function(text) {
		alert(text)
		// 실패시
		if (text == 'fail') {
			alert('튜터 등록이 되어있지 않은 사용자 입니다.');
			return;
			// 성공시
		} else {
			// css 변경
			$("#talentRegi").css("display", "block");
			$("#tutorPropDiv").css("display", "none");
			$("#talentManage").css("display", "none");
			$("#li1").attr("class", '');
			$("#li2").attr("class", 'on');
			$("#li3").attr("class", '');
		}

	});
}
// 튜터 신척확인 보여주기
function viewPropTalentPage() {
	$("#talentRegi").css("display", "none");
	$("#tutorPropDiv").css("display", "block");
	$("#talentManage").css("display", "none");
	$("#li1").attr("class", 'on');
	$("#li2").attr("class", '');
	$("#li3").attr("class", '');
}

// 신청한 수업관리
function viewTalentClient(){
	$("#talentRegi").css("display", "none");
	$("#tutorPropDiv").css("display", "none");
	$("#talentManage").css("display", "block");
	$("#li1").attr("class", '');
	$("#li2").attr("class", '');
	$("#li3").attr("class", 'on');
}





