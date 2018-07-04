/**
 * 
 */


// 최상단 메뉴바 색 전환 마우스 이벤트 처리
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
$("#regi").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$(this).css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$(this).css("color", "#000000");
	}
});
$("#login").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$(this).css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$(this).css("color", "#000000");
	}
});

// 메뉴바 색 전환 마우스 이벤트 처리
$("#hot").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #hot").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #hot").css("color", "#000000");
	}
});

$("#sports").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #sports").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #sports").css("color", "#000000");
	}
});

$("#beauty").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #beauty").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #beauty").css("color", "#000000");
	}
});

$("#music").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #music").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #music").css("color", "#000000");
	}
});

$("#food").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #food").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #food").css("color", "#000000");
	}
});

$("#design").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #design").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #design").css("color", "#000000");
	}
});

$("#business").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #business").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #business").css("color", "#000000");
	}
});

$("#language").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #language").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #language").css("color", "#000000");
	}
});

$("#progam").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #progam").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #progam").css("color", "#000000");
	}
});

$("#life").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #life").css("color", "#ff7200");
	},
	mouseleave : function() {
		$(this).css("background-color", "#f0f0f0"),
		$("div #life").css("color", "#000000");
	}
});

/* 카테고리별 이벤트 처리 */
function fetchPage(name){
	var list1 = $('.list-group1');
	var list2 = $('.list-group2');
	var listHtml1 = '';
	var listHtml2 = '';
	
	fetch(name,{
		method : 'GET'
		}).then(function(response) {
			if (!response.ok) {
				throw Error(response.statusText);
			}
			return response.json();
		}).then((data) => {
			/* for문 처리 */
			$.each(data,function(index,value){
				// var lecture = value.lecture_id;
				if(index > 7){
					listHtml2 += "<a href='/zest/category/" + value.category_id + "/" + value.lecture_id + "' class='list-group-item' style='font-size:middle; color:#000000 !important; right:-4px; border: 0px; background-color:#00000000;'><b>"+value.lecture_name+"</b></a>";
				}else{
				listHtml1 += "<a href='/zest/category/" + value.category_id + "/" + value.lecture_id + "' class='list-group-item' style='font-size:middle; color:#000000 !important; border: 0px; background-color:#00000000;'><b>"+value.lecture_name+"</b></a>";
				}
			});
			list1.html(listHtml1);
			list2.html(listHtml2);
		}).catch((e) => {
			console.log(e);
		});
}

/* 로그인 창 띄우기 */
$(document).ready(function(){
    $("#login").click(function(){
       // window.open(); //빈 새창띄우기
       // window.open('http://localhost:8080/test/view/join.jsp','회원가입'); //새창에
		// 해당 사이트 띄우기
       var test = 'width=400,height=362,scrollbars=yes,resizable=yes,top=100,left=500,toolbar=yes';
       window.open('http://localhost:8080/zest/common/loginPage','로그인',test); // 새창에
																				// 해당
																				// 사이트
																				// 띄우기
																				// test값으로
    });
    
    /* 회원가입 창 띄우기 */
    $("#regi").click(function(){
        // window.open(); //빈 새창띄우기
        // window.open('http://localhost:8080/test/view/join.jsp','회원가입'); //새창에
 		// 해당 사이트 띄우기
        var test = 'width=400,height=487,scrollbars=yes,resizable=yes,top=250,left=700,toolbar=yes';
        window.open('http://localhost:8080/zest/common/regiPage','회원가입',test); // 새창에
 																				// 해당
 																				// 사이트
 																				// 띄우기
 																				// test값으로
     });   

 
});

// 로그아웃

function logout(){
$("#logout").click(function(){
	
	var url = "main/logout"
	fetch(url,{
		method : 'GET'
		}).then(function(response) {    			
			if (!response.ok) {
				throw Error(response.statusText);
			}
			alert("로그아웃 처리");
			
		}).catch((e) => {
			console.log(e);
		});
 
 });
}





