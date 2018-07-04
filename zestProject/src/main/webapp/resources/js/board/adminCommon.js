/**
 * 
 */

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
});