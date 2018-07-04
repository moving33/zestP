/**
 * 
 */

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

$("#hot").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #hot").css("color", "#ff7200");

	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #hot").css("color", "#000000");

	}
});

$("#sports").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #sports").css("color", "#ff7200");

	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #sports").css("color", "#000000");

	}
});

$("#beauty").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #beauty").css("color", "#ff7200");

	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #beauty").css("color", "#000000");

	}
});

$("#music").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #music").css("color", "#ff7200");

	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #music").css("color", "#000000");

	}
});

$("#food").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #food").css("color", "#ff7200");

	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #food").css("color", "#000000");

	}
});

$("#design").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #design").css("color", "#ff7200");

		
	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #design").css("color", "#000000");

	}
});

$("#business").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #business").css("color", "#ff7200");

	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #business").css("color", "#000000");

	}
});

$("#language").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #language").css("color", "#ff7200");

	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #language").css("color", "#000000");

	}
});

$("#progam").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #progam").css("color", "#ff7200");

	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #progam").css("color", "#000000");
	
	}
});

$("#life").on({
	mouseenter : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #life").css("color", "#ff7200");

	},
	mouseleave : function() {
		$(this).css("background-color", "#ffffff"),
		$("div #life").css("color", "#000000");
		
	}
});

/* 카테고리별 이벤트 처리 */
function getCategory(name){
	var list = $('.subCate');
	var listHtml = '';
	
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
				
				listHtml += "<a class='colj' href='/zest/category/"+ value.category_id + "/" +  value.lecture_id + "'style='color: #ff7200; font-size: 15px;'>"+value.lecture_name+"</a>";
			});
			list.html(listHtml);
		}).catch((e) => {
			console.log(e);
		});
}

/*로그인 창 띄우기*/
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
 });

/*회원가입 창 띄우기*/
$(document).ready(function(){
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