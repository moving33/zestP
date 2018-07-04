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
		src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<%--sweet alert--%>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	
	var check = 0;
	IMP.init('imp89921116'); // 'iamport' 대신 부여받은"가맹점식별코드"를 사용
	IMP.request_pay({ 
   	pg : 'kcp', // version 1.1.0부터 지원.   		
	   	pay_method : 'card', merchant_uid : 'merchant_' + new Date().getTime(), 
	   	name : '최초인증결제', 
   		amount: '1004', buyer_email : '1@1.net', 
   		buyer_name : '아임포트', 
   		buyer_tel : '02-1234-1234',  
   		//m_redirect_url : 'https://www.yourdomain.com/payments/complete'
   		}, 
   function(rsp) { 
      if ( rsp.success ) {
         var msg = '결제가 완료되었습니다.'; 
         	check=1;
         	swal("결제가 성공적으로 이루어졌습니다", {
                icon: "success"
            });
			setTimeout(function(){
			window.location.href="/zest/clientPage";	
			},2000);			           
         } else { 
            var msg = '결제에 실패하였습니다.';  
         	check=0;
         	window.close();
         }
      alert(msg);
      
   /*    if(check==1){   
         $("#hiddenForm").submit();
      }else if(check==2){
         window.location="home.do";
         } */
   });



})
</script>

</body>
</html>