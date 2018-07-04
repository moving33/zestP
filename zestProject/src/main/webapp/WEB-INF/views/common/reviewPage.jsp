<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰별점</title>

<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/common/reviewPage.css" rel="stylesheet">

</head>
<body>
	
	<c:if test="${result == 'success' }">
		<script>
		alert("리뷰작성이 성공되었습니다");
		opener.document.location.reload();
		window.close();
		</script>
	</c:if>
	
		<c:if test="${result == 'fail' }">
		<script>
			alert("로그인을 하세요");
		</script>
	</c:if>
	
	
	
	<div id="popup-write-review" class="popup popup-write-review">
		<form action="" method="post" class="popup-content" id="frm-write-review" onsubmit="return reCheck()">
		<input type="hidden" id="talent_no" name="talent_no" >
		<input type="hidden" id="tt_no" name="tt_no" >
			<h1><strong>튜터 이름</strong> 튜터의 수업은 어떠셨나요?</h1>
			<div class="review-scores row">
				<div class="star_comment">
				<div class="review-scores-detail review-scores-price">
					<label>커리큘럼&nbsp;</label> 
					<span class="star-input1">
					<span class="input">
					<input type="radio" name="tr_curri_value" value="1" id="curri1">
					<label for="curri1">1</label>
					<input type="radio" name="tr_curri_value" value="2" id="curri2">
					<label for="curri2">2</label>
					<input type="radio" name="tr_curri_value" value="3" checked id="curri3">
					<label for="curri3">3</label>
					<input type="radio" name="tr_curri_value" value="4" id="curri4">
					<label for="curri4">4</label>
					<input type="radio" name="tr_curri_value" value="5" id="curri5">
					<label for="curri5">5</label>
					</span>
					</span>


				</div>

				<div class="review-scores-detail review-scores-quality">
					<label>전달력&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input2">
					<span class="input">
					<input type="radio" name="tr_commu_value" value="1" id="delivery1">
					<label for="delivery1">1</label>
					<input type="radio" name="tr_commu_value" value="2" id="delivery2">
					<label for="delivery2">2</label>
					<input type="radio" name="tr_commu_value" value="3" checked id="delivery3">
					<label for="delivery3">3</label>
					<input type="radio" name="tr_commu_value" value="4" id="delivery4">
					<label for="delivery4">4</label>
					<input type="radio" name="tr_commu_value" value="5" id="delivery5">
					<label for="delivery5">5</label>
					</span>
					</span>

				</div>


				<div class="review-scores-detail review-scores-recommend">
					<label>준비성&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input3">
					<span class="input">
					<input type="radio" name="tr_ready_value" value="1" id="prepare1">
					<label for="prepare1">1</label>
					<input type="radio" name="tr_ready_value" value="2" id="prepare2">
					<label for="prepare2">2</label>
					<input type="radio" name="tr_ready_value" value="3" checked id="prepare3">
					<label for="prepare3">3</label>
					<input type="radio" name="tr_ready_value" value="4" id="prepare4">
					<label for="prepare4">4</label>
					<input type="radio" name="tr_ready_value" value="5" id="prepare5">
					<label for="prepare5">5</label>
					</span>
					</span>


				</div>


				<div class="review-scores-detail review-scores-tran">
					<label>친절도&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<span class="star-input4">
					<span class="input">
					<input type="radio" name="tc_kind_value" value="1" id="kind1">
					<label for="kind1">1</label>
					<input type="radio" name="tc_kind_value" value="2" id="kind2">
					<label for="kind2">2</label>
					<input type="radio" name="tc_kind_value" value="3" checked id="kind3">
					<label for="kind3">3</label>
					<input type="radio" name="tc_kind_value" value="4" id="kind4">
					<label for="kind4">4</label>
					<input type="radio" name="tc_kind_value" value="5" id="kind5">
					<label for="kind5">5</label>
					</span>
					</span>

				</div>




				<div class="review-scores-detail review-scores-kind">
					<label>시간준수&nbsp;</label>
					<span class="star-input5">
					<span class="input">
					<input type="radio" name="tc_time_value" value="1" id="time1">
					<label for="time1">1</label>
					<input type="radio" name="tc_time_value" value="2" id="time2">
					<label for="time2">2</label>
					<input type="radio" name="tc_time_value" value="3" checked id="time3">
					<label for="time3">3</label>
					<input type="radio" name="tc_time_value" value="4" id="time4">
					<label for="time4">4</label>
					<input type="radio" name="tc_time_value" value="5" id="time5">
					<label for="time5">5</label>
					</span>
					</span>
			</div>
			</div>
			</div>
			
			<div class="review-content">
				<textarea name="tr_content" id="content" placeholder="리뷰를 입력 해 주세요"></textarea>
			</div>
			<input type="submit" id="submit" class="btn btn-pink btn-sm pull-right" value="리뷰 올리기">
		</form>
	</div>
	
	<script>
	function _GET(search) {
        var obj = {};
        var uri = decodeURI(search);
            uri = uri.slice(1,uri.length);
        var param = uri.split('&');
        
        for (var i = 0; i < param.length; i++) {
            var devide = param[i].split('=');
            obj[devide[0]] = devide[1];
        }
        return obj;
    }
	   window.onload = function () {
	        var search = window.location.search;
	        var getData =  _GET(search);
	        var talent_no = document.querySelector('#talent_no');
	        var tt_no = document.querySelector('#tt_no');
	 
	        talent_no.value = getData.talent_no;
	        tt_no.value = getData.tt_no;
	    }
	</script>

	
	<script src="../js/jquery.min.js"></script>
	<script src="../js/regi/reviewPage.js"></script>
</body>
</html>