<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/common/tutorResistPage.css" />
<link rel="stylesheet" href="css/bootstrap.css" />

<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<!-- header -->
		<div id="header_subn">


			<div class="gnb">
				<div class="leftmenu">
					<ul>

						<li><a href="#"> <span>튜터등록</span>
						</a></li>
						<li><a href="#"> <span>수업검색</span>
						</a></li>
					</ul>
				</div>
				<div class="logo">
					<a href="main"> <img src="images/common/logo.png" alt="제스트">
					</a>
				</div>
				<div class="rightmenu">
					<ul>
						<li><a href="#"> <span> <img
									src="images/common/icon_ttalk.png"><br>
							</span> <span>실시간톡</span>
						</a></li>
						<li><a href="#"> <span> <img
									src="images/common/icon_tlist.png">
							</span> <span>수업신청서</span>
						</a>
						<li><a href="/zest/clientPage"> <span> <img
									src="images/common/icon_sjoin.png">
							</span> <span>마이페이지</span>
						</a></li>
						<li><a href="/zest/main/logout"> <span> <img
									src="images/common/icon_slogout.png">
							</span> <span>로그아웃</span>
						</a></li>
					</ul>
				</div>


			</div>
		</div>
	</div>
	<!-- //header -->
	<div class="subt">
		<h1 class="subtit3">튜터 정보를 입력하세요</h1>
		<h2 class="subtxt3">프로필, 번호, 학교인증 등</h2>
		<div class="sub_top03">
			<img src="images/common/tutor/tutor_register_topimg.jpg">
		</div>
	</div>
	<!-- Container -->
	<div id="container_register">

		<h1>기본정보 입력</h1>
		<form method="POST" id="frm-register-detail" action="" enctype="multipart/form-data" onsubmit="return validateFile()">
			<div class="register_cont">
				<div class="reginput">
					<ul>
						<li><label>프로필사진</label>
							<div class="picture" id="thumbnail"
								style="background-image: url(//taling.me/Content/Uploads/Profile/339ed0e1d12129252e9b7a0df29088ddda7583c4.jpg)">
								<div class="picture-overlay">
									<!-- <img id="thumbnail" src=""> -->
									<i class="glyphicon glyphicon-edit"></i> 
									<input type="file" id="profile" name="file_profile" accept="image/*" required>

								</div>

							</div> <script>
								//프로필 사진이미지 input tag를 가져온다.
								var file = document.querySelector('#profile');
								//해당 값이 변환되면 스크립트 작동
								file.onchange = function() {

									//용량체크
									var maxSize = 2 * 1024 * 1024; //2M
									var fileSize = 0;


									fileSize = file.files.size;

									if (fileSize > maxSize) {
										alert("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.    ");
										return;
									}

									var fileList = file.files;
									//읽기
									var reader = new FileReader();
									reader.readAsDataURL(fileList[0]);

									//로드 한후 
									reader.onload = function() {
										//썸네일 이미지 생성
										var tempImage = new Image();
										tempImage.src = reader.result; //data-uri 를 이미지 객체에 주입
										//이미지가 로드 된 후
										tempImage.onload = function() {
											//리사이즈를 위해 캔버스 객체 생성
											var canvas = document
													.createElement('canvas');
											var canvasContext = canvas
													.getContext("2d");
											//캔버스의 크기 설정
											canvas.width = 100;
											canvas.height = 100;
											//이미지를 캔버스에 그리기
											canvasContext.drawImage(this, 0, 0,
													100, 100);
											//캔버스에 그린 이미지를 다시 data-uri 형태로 변환
											var dataURI = canvas
													.toDataURL("image/jpeg");
											//썸네일 이미지 보여주기 											
											$("#thumbnail").css(
													"background-image",
													"url('" + dataURI + "')");
											//d.style.backgroundimage="url(aa.gif)";
										}
									}
								}
							</script> <span class="pf_subtxt"> <b style="color: #ff005a">이미지를
									클릭 후</b> 프로필 사진을 업로드 해 주세요.<br> 수강생 분들에게 신뢰감을 높이기 위해 얼굴이 <br>
								나온 사진이 필수 입니다.
						</span>
							<div class="pf_image clearbt" style="padding-top: 30px;">
								<ul>
									<li><img src="images/common/20.jpg"><br>스타일리쉬한
										모습</li>
									<li><img src="images/common/profile2.jpg"><br>밝고
										쾌활히 웃는</li>
									<li><img src="images/common/profile3.jpg"><br>무언가에
										열중</li>
								</ul>
							</div></li>
						<li class="tip"><i>Tip</i>
							<p class="redtxt">프로필 사진</p>
							<p class="mt10">
								자신의 얼굴이 드러난 사진을 올려주세요. 예시처럼 밝고 웃는 자연스러운 사진이 가장 좋습니다.<br>
								자신의 얼굴이 없는 동물, 단순 배경 등은 승인이 되지 않습니다. 증명 사진처럼 부자연스러운 사진 또한 최대한
								지양해주세요.
							</p></li>
					</ul>
					<ul>
						<li><label>별명입력</label> 
						<input id="Description" name="tp_nn" type="text" placeholder="튜터님의 정체성을 가장 잘 드러낼 수 있는 별명을 입력해주세요" value=""
							class="input_txt05" required>
						</li>
						<li><label>휴대폰 번호</label> <!--select id="Phone1" name="Phone1" class="input_txt04 not">
						<option value="010" >010</option>
						<option value="011" >011</option>
						<option value="019" >019</option>
						<option value="016" >016</option>
					</select--> <input id="Phone" name="tp_hp" type="text" placeholder="010-1234-5678" value="" class="input_txt02" required>
							<!--input id="Phone3" name="Phone3" type="text" placeholder="휴대폰번호" value="" class="input_txt04"/-->

							<input type="hidden" id="IsPhone" value="0" required> <a
							class="inputbtn" id="btn-register-phone" style="height: 54px;">번호인증</a>
							<p class="regintxt01 clearbt redtxt" id="IsPhoneConfirm"
								style="width: -webkit-fill-available;">번호인증을 눌러 번호를 인증해주세요.</p>
							<p class="regintxt01 clearbt" id="IsPhoneConfirmed"
								style="display: none;">
								<font
									style="border: 1px solid red; background: #ff005a; color: #fff; padding: 5px;">인증완료</font>
							</p></li>
						<li class="tip"><i>Tip</i>
							<p class="redtxt">기본정보 입력</p>
							<p class="mt10">
								드루와는 개인정보 보호를 위해 항상 최선을 다하고 있습니다.<br> 카카오톡, 페이스북 ID등 개인정보가
								유추 될 수 있는 별명은 지양해주세요<br>
							</p></li>
					</ul>
					<ul>
						<li>
						<label style="padding: 0px 15px 0px 15px;">신분/학력<br>인증</label>
							<p class="regintxt05">소속된 대학이나 졸업한 대학을 인증해주세요. 없으시면 신분증인증을
								해주시면 됩니다(필수)</p>								
				
								<p class="regintxt04 clearbt">
									<b>학력 인증,신분인증(<font color="red">필수</font>)</b>
									<br>
									 학생증, 재학증명서, 졸업증명서 ,신분증
								</p>
								<p class="regintxt05 clearbt">
									<input type="file" id="certFile" name="file_certification" style="width: -webkit-fill-available;" id="cf1" required>
								</p>

								<p class="regintxt01 clearbt redtxt" id="IsSchoolVerified">파일을
									업로드해주세요.</p>
							
						</li>
					
						<li>
						<p class="regintxt04 clearbt" style="height: 30px;">
									<b>특기분야를 선택 해주세요(<font color="red">필수</font>)
									</b>
								<div class="input-group mb-3" style="width: 515px; margin-left: 145px; height: 70px;">
									<!-- <div class="input-group-prepend" style="height: 50px; margin-top: 10px;">
										<button class="btn btn-outline-secondary" type="button" id="categoryBtn">선택하기</button>
									</div> -->
									
									<select class="custom-select" id="categorySelect"
										name="tp_category_id" required>
										<option selected>선택해주세요</option>
										<option value="BEAUTY">뷰티</option>
										<option value="BUSINESS">실무</option>
										<option value="DESIGN">디자인</option>
										<option value="FOOD">요리/음식</option>
										<option value="LANGUAGE">외국어</option>
										<option value="LIFE">라이프스타일</option>
										<option value="MUSIC">뮤직</option>
										<option value="PROGRAM">프로그래밍</option>
										<option value="SPORTS">스포츠</option>
									</select> <input type="hidden" id="IsCategory" value="0">
								</div>
								</p>	
							
							</li>
							
							
						<li><label>자격증<br>(선택)
						</label> <input id="Cert0" name="Cert0" type="text" placeholder="예) 토플 117, HSK 6급, GTQ 1급, 입상경력.." value=""
							class="input_txt01" readonly="readonly">
							<p class="regintxt05 clearbt" style="margin-top: -17px;">
								<input type="file" name="file_add" style="width: 425px;" accept="image/*">
							</p>
							<div id="CertAdd"></div> <a onclick="addFile();" class="addbtn">추가+</a>
							<!-- 올려진 파일의 개수를 얻어오는 녀석 --> 
							<input type="hidden" id="fileCnt" name="fileCnt" value="0"> 
							
							<script>
								function removeFile() {
									var fileNoID = $('#fileCnt');
									var fileNoData = fileNoID.val();
									alert(fileNoData);
									//히든에 저장되있는 값을 -
									fileNoID.val(fileNoData - 1);
									alert(fileNoID.val());
									//삭제하기
									var item = document.getElementById("plusFile"+ fileNoData);
									if (item != null) {
										item.parentNode.removeChild(item);
									}

								}

								function addFile() {
									fileCnt = document
											.getElementById('fileCnt').value;
									fileCnt++;
									html = '';									
									html += '<p class="regintxt05 clearbt"><input type="file" accept="image/*" style="width: 425px;" name="file_add"/></p>';
									html += '<button type="button" onclick="removeFile()" style="margin-top: -70px; margin-right: -40px; float: right; width: 55px; height: 40px;">삭제</button>'

									var div = document.createElement('div');

									div.setAttribute('id', 'plusFile'+ fileCnt);

									div.style.width = "652px";
									div.innerHTML = html;
									document.getElementById('CertAdd').appendChild(div);
									document.getElementById('fileCnt').value = fileCnt;
									alert(fileCnt);
								}
							</script></li>
						<li class="tip"><i>Tip</i>
							<p class="redtxt">학력 및 자격 인증</p>
							<p class="mt10">
								학력과 자격 인증은 수강생 분들이 신청하 실 때 튜터님의 신뢰감을 높이기 위한 요소입니다.<br> 자격증의
								경우 업로드 파일은<br> <span class="blutxt">날짜와 자격증, 시험의 주관처
									공인</span>을 명확히 확인 할 수 있는 파일을 올려주시면 됩니다. <br> (자격 확인서, 자격증, 사진 등)
								<br> 관리자 인증은 하루정도 소요되며, 확인된 파일은 바로 삭제됩니다.
							</p></li>
					</ul>
				</div>
			</div>

			<div class="regbtn_cont">
				<!--a href="#" class="btn_gry">임시 저장</a-->
				<input type="submit" class="btn_red" value="등록 완료">
				<!--a href class="btn_red">등록 완료</a-->
			</div>
		</form>

	</div>
	<!-- footer -->
	<div class="footer">
		<div class="footer_cont">
			<div class="info_box">
				<div class="info">
					<b>COMPANY</b>
					<ul>
						<li><a href="#">서비스 소개</a></li>
						<li><a href="#" target="_blank">블로그</a></li>
						<li><a href="#" target="_blank">언론보도</a></li>
					</ul>
				</div>
				<div class="info">
					<b>POLICIES</b>
					<ul>
						<li><a href="#">이용약관</a></li>
						<li><a href="#">결제서비스약관</a></li>
						<li><a href="#">개인정보취급방침</a></li>
					</ul>
				</div>
				<div class="info">
					<b>SUPPORT</b>
					<ul>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">드루와센터</a></li>
					</ul>
				</div>
			</div>
			<div class="info_box2">
				<div class="info">
					<b>드루와</b>
					<ul>
						<li><img src="images/yellow.png">&nbsp;KAKAO 옐로우ID /
							@Droowa</li>
						<li>운영시간 / 평일 10:00~19:00</li>
					</ul>
				</div>
			</div>
			<div style="overflow: hidden; padding-top: 79px">
				<div class="bt_info">
					상호 : (주)드루와 | 주소 : 서울시 성동구 무학로2길 54 신방빌딩 4,5층 | 사업자등록번호 :
					123-45-67890 |대표자명 :권혜진<br> Copyright ⓒ2018 droowa inc, ltd.
					All rights reserved
				</div>
				<div class="logo_box">
					<a href="#" target="_blank"><img
						src="images/ic_sns_facebook_38_38.png"></a> <a href="#"
						target="_blank"><img src="images/ic_sns_instagram_38_38.png"></a>
					<a href="#" target="_blank"><img
						src="images/ic_sns_youtube_38_38.png"></a>
				</div>

			</div>
		</div>
	</div>
	<!-- /footer -->



	<script src="js/jquery.min.js"></script>
	<script src="js/tutor/tutorRegistPage.js"></script>
	<script src="js/common.js"></script>
	<!-- <script src="js/tutor/tutorPage.js"></script> -->
</body>
</html>