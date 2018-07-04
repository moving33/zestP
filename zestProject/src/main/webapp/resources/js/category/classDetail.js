

// 세션

$(document).ready(function(){
   var sessionURL = "/zest/session";
   var list = $('#loginCheck');
   var listHtml = '';
   
   
   fetch("/zest/session",{      
      
      method : 'POST',
      //
      credentials: "same-origin"
      }).then(function(response) {
         if (!response.ok) {
            throw Error(response.statusText);
         }
         return response.json();
      }).then((data) => {
         if(data == 1){
            var listHtml = "<ul>" +
			"<li class='nav-item'>"+
			"<a class='nav-linkj' id='myPage' href='/zest/clientPage' style='font-size: 20px;'><b>마이페이지</b></a></li>" +
			"<li class='nav-item'>"+
			"<a class='nav-linkj' id='logout' href='/zest/main/logout' style='font-size: 20px;'>"+			
			"<b>로그아웃</b></a></li>" +
			"</ul>";
            list.html(listHtml);
            changePageColor();
            
         }
      }).catch((e) => {
         console.log(e);
      });  
});

function changePageColor(){
	 $("#myPage").on({
			mouseenter : function() {
				$(this).css("background-color", "#ffffff"),
				$(this).css("color", "#ff7200");
			},
			mouseleave : function() {
				$(this).css("background-color", "#ffffff"),
				$(this).css("color", "#000000");
			}
		});
	 $("#logout").on({
			mouseenter : function() {
				$(this).css("background-color", "#ffffff"),
				$(this).css("color", "#ff7200");
			},
			mouseleave : function() {
				$(this).css("background-color", "#ffffff"),
				$(this).css("color", "#000000");
			}
		});
}

function propTalent(talent_no,tutor_no,price_total){
	window.location.href = "/zest/talentProp?talent_no="+talent_no;	
}










