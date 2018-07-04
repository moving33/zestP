<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="https://service.iamport.kr/js/iamport.payment-1.1.4.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		var check = 0;
		IMP.init('imp89921116'); // 'iamport' 대신 부여받은"가맹점식별코드"를 사용
		IMP.certification({
		    merchant_uid : 'merchant_' + new Date().getTime() //본인인증과 연관된 가맹점 내부 주문번호가 있다면 넘겨주세요
		}, function(rsp) {
		    if ( rsp.success ) {
		    	 // 인증성공
		        console.log(rsp.imp_uid);
		        console.log(rsp.merchant_uid);
		        
		         $.ajax({
						type : 'POST',
						url : '/certifications/confirm',
						dataType : 'json',
						data : {
							imp_uid : rsp.imp_uid
						}
				 }).done(function(rsp) {
				 		// 이후 Business Logic 처리하시면 됩니다.
				 }); 
		        	
		    } else {
		    	 // 인증취소 또는 인증실패
		        var msg = '인증에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;

		        alert(msg);
		    }
		});
	});
	
	
	</script>
</body>
</html>