// 관리자 페이지 세션
$(document).ready(function(){	
	fetch("/zest/adminSession",{      
      method : 'POST',
      credentials: "same-origin"
      }).then(function(response) {
         if (!response.ok) {
            throw Error(response.statusText);
         }
         return response.json();
      }).then((data) => {
         if(data == "0"){
        	 window.location.href = "login";
        	
         }
      }).catch((e) => {
         console.log(e);
      });
   
   
   $('.counter').each(function() {
	   var $this = $(this),
	       countTo = $this.attr('data-count');
	   
	   $({ countNum: $this.text()}).animate({
	     countNum: countTo
	   },

	   {
	     duration: 4000,
	     easing:'linear',
	     step: function() {
	       $this.text(Math.floor(this.countNum));
	     },
	     complete: function() {
	       $this.text(this.countNum);
	       //alert('finished');
	     }

	   });   
	 });
   
   ////
   $('#table_id').DataTable();
   
});