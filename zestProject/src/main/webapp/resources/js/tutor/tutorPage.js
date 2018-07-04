$(document).ready(function() {
	alert('kkkk');
	//프로필 사진이미지 input tag를 가져온다.
	var file = document.querySelecor('#picture');
	alert('ttt');
	//해당 값이 변환되면 스크립트 작동
	file.onchange=function(){
		
		var fileList = file.files;
		alert('bbbb');
		//읽기
		var reader = new FileReader();		
		reader.readAsDataURL(fileList[0]);
		
		//로드 한후 
		reader.onload = function(){
			//썸네일 이미지 생성
			var tempImage = new Image(); 
			tempImage.src = reader.result; //data-uri 를 이미지 객체에 주입
			alert('ppp');
			//이미지가 로드 된 후
			tempImage.onload = function(){
				//리사이즈를 위해 캔버스 객체 생성
				alert('ddd');
				var canvas = document.createElement('canvas');
				var canvasContext = canvas.getContext("2d");
				alert('aaa');
				//캔버스의 크기 설정
				canvas.width = 100;
				canvas.height = 100;
				
				//이미지를 캔버스에 그리기
				canvasContext.drawImage(this,0,0,100,100);
				alert('bbb');
				//캔버스에 그린 이미지를 다시 data-uri 형태로 변환
				var dataURI  = canvas.toDataURL("image/jpeg");
				
				alert(dataURI);
				
				//썸네일 이미지 보여주기 
				$("#thumbnail").src = dataURI;
				/*$("#thumbnail").style.backgroundimage="url("+dataURI+")";*/
			}
		}
	}
});