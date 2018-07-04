<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<c:if test="${result == 'success' }">
	<script type="text/javascript">
		window.close();
	</script>
</c:if>
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
		
	var email = '${client.cl_email}';
	var name  = '${client.cl_name}';
	var tel = '${client.cl_hp}';
	IMP.init('imp89921116'); // 'iamport' 대신 부여받은"가맹점식별코드"를 사용
	IMP.request_pay({ 
   	pg : 'inicis', // version 1.1.0부터 지원.
	   	pay_method : 'card', merchant_uid : 'merchant_' + new Date().getTime(), 
	   	name : '최초인증결제', 
   		amount: ${realPrice}, 
   		buyer_email : email , 
   		buyer_name :  name, 
   		buyer_tel : tel  
   		//m_redirect_url : 'https://www.yourdomain.com/payments/complete'
   		}, 
   function(rsp) { 
      if ( rsp.success ) {        	
      	 	$("#hiddenForm").submit();
      		opener.parent.location='/zest/clientPage';		
      	 	swal("결제가 성공적으로 이루어졌습니다", {
                icon: "success"
            });					           
         } else { 
            var msg = '결제에 실패하였습니다.';              
            alert(msg);             	
         	window.close();
         }     
      	
		/*       if(check == 1){
    	  $("#hiddenForm").submit();        	  
          alert(msg+' 3초뒤에 창이 닫힙니다.');
          setTimeout(function(){
      		   window.close();
		 },3000);
      } */
   });	
});	
</script>
	<!-- 결제 폼 -->
	<form id="hiddenForm" action="/zest/payment/kkaoPayMent" method="post">
		<input type="hidden" name="cl_no" value="${client.cl_no}">
		<input type="hidden" name="talent_no" value="${talent.talent_no}">
		<input type="hidden" name="tt_no" value="${talent.talent_tt_no}">
		<input type="hidden" name="to_real_price" value="${realPrice}">
		<input type="hidden" name="to_use_point" value="${point}"> <input
			type="hidden" name="to_price_total"
			value="${talent.talent_total_price}"> <input type="hidden"
			name="to_meet_count" value="${talent.talent_meet_count}"> <input
			type="hidden" name="to_type" value="kkoPay">			
	</form>

</body>
</html>