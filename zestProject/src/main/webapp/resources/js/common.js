// 세션
$(document).ready(function(){
   var sessionURL = "/session";
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
            var listHtml = "<ul class='navbar-nav ml-auto'>" +
			"<li class='nav-item activej'>"+
			"<a class='nav-linkj logo'id='service' href='/zest/notice/list'><b>공지사항</b>" +
			"<span class='sr-only'>(current)</span></a></li>" +
			"<li class='nav-item'>"+
			"<a class='nav-linkj' id='insert' href='/zest/tutorRegiPage' style='font-size: 20px;'><b>튜터 등록</b></a></li>" +
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
	 $("#service").on({
			mouseenter : function() {
				$(this).css("background-color", "#ffffff"),
				$(this).css("color", "#ff7200");
			},
			mouseleave : function() {
				$(this).css("background-color", "#ffffff"),
				$(this).css("color", "#000000");
			}
		});
	 
	 $("#insert").on({
			mouseenter : function() {
				$(this).css("background-color", "#ffffff"),
				$(this).css("color", "#ff7200");
			},
			mouseleave : function() {
				$(this).css("background-color", "#ffffff"),
				$(this).css("color", "#000000");
			}
		});
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