$(document).ready(
		function() {			
		
			// 상세페이지 출력
				
			$("#detailPage").click(function() {
			});

			// 프로필 사진
			$("#profileBtn1").click(function() {
				$("#profileCheck").val("success");
				this.style.backgroundColor = "blue";
				this.style.color = "white";

				$("#profileBtn2").css("background-color", "white");
				$("#profileBtn2").css("color", "black");

			});

			$("#profileBtn2").click(function() {
				$("#profileCheck").val("fail");
				this.style.backgroundColor = "red";
				this.style.color = "white";

				$("#profileBtn1").css("background-color", "white");
				$("#profileBtn1").css("color", "black");

			});

			// 신분인증 사진
			$("#certiBtn1").click(function() {
				$("#certiCheck").val("success");
				this.style.backgroundColor = "blue";
				this.style.color = "white";

				$("#certiBtn2").css("background-color", "white");
				$("#certiBtn2").css("color", "black");

			});
			$("#certiBtn2").click(function() {
				$("#certiCheck").val("fail");
				this.style.backgroundColor = "red";
				this.style.color = "white";

				$("#certiBtn1").css("background-color", "white");
				$("#certiBtn1").css("color", "black");
			});

			// 승인하기
			$("#submitBtn1").click(
					function() {
						if ($("#profileCheck").val() == "0"
								|| $("#certiCheck").val() == "0") {
							alert("인증 사진들의 승인 여부를 선택해주세요");
							return;
						}

						if ($("#profileCheck").val() == "fail"
								|| $("#certiCheck").val() == "fail") {
							alert("인증 사진들의 불가 항목있을경우 승인되지 않습니다.");
							return;
						}

						if (confirm("해당 사용자의 튜터신청을 승인 하시겠습니까?") == true) {

							var email = $("#emailData").val();
							var no = $("#numberData").val();
							var data = {
								email : email,
								no : no
							};

							// fetch 헤더생성
							var myHeaders = new Headers();
							myHeaders.append("Content-Type",
									"application/json;Charset=UTF-8");

							console.log(data);

							fetch('/zest/admin/tutorManager/propSubmit', {
								method : 'POST',
								credentials : 'same-origin',
								headers : myHeaders,
								body : JSON.stringify(data),

							}).then(function(response) {
								if (!response.ok) {
									throw Error(response.statusText);
								}
								// 텍스트 기반으로 처리
								return response.text();
							}).then(function(text) {
								console.log(text);

							});
							location.href = '/zest/admin/tutorManager/prop';
						} else {
							location.href = '/zest/admin/tutorManager/prop';
						}

					});

			$("#submitBtn2").click(
					function() {
						if ($("#profileCheck").val() == "0"
								|| $("#certiCheck").val() == "0") {
							alert("인증 사진들의 승인 여부를 선택해주세요");
							return;
						}

						if (confirm("해당 사용자의 승인요청을 거부 하시겠습니까?") == true) {
							var denyCode = ''; // 확인 코드 1이면 프로필사진 불가, 2면 신분증 인증
												// 불가, 0 이면 둘다 자격요건 미달
						
							if ($("#profileCheck").val() == "fail") {
								denyCode = '1';
								
							}
							if ($("#certiCheck").val() == "fail") {
								denyCode = '2';
							}
							if ($("#profileCheck").val() == "fail"
									&& $("#certiCheck").val() == "fail") {
								denyCode = '0';
							}
							
							alert(denyCode);
							
							var email = $("#emailData").val();
							var no = $("#numberData").val();					
							//전달할 data
							var data ={
									email :email,
									no : no,
									denyCode : denyCode
							}
							console.log(data);
							
							//fetch 설정
							var myHeaders = new Headers();
							myHeaders.append("Content-Type",
							"application/json;Charset=UTF-8");
							
							fetch('/zest/admin/tutorManager/propSubmit',{
								method:'POST',
								credentials:'same-origin',
								headers:myHeaders,
								body : JSON.stringify(data)
							}).then(function(response){
								if(!response.ok){
									throw Error(response.statusText);
								}										
							});
							location.href = '/zest/admin/tutorManager/prop';
						}

						// 취소
						else {
							location.href = '/zest/admin/tutorManager/prop';
						}
					});

		});