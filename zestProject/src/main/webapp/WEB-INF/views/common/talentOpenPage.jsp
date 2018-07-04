<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    

    <!-- 타이틀 -->
    <title>수업 등록</title>
    <link href="/zest/css/bootstrap.css" rel="stylesheet">
    <!--  혜진 - 현재페이지 CSS -->
    <link href="/zest/css/talent/talentOpen.css" rel="stylesheet">
    <!-- 썸머노트CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.css" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <%--데이터피커 다른녀석--%>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    <!-- 시멘틱 ui css -->
    <link href="/zest/css/semantic.min.css" rel="stylesheet">    
    

</head>
<body>

<!-- 헤더 -->
<div id="header_subn">
    <div class="gnb">
        <div class="leftmenu">
            <ul>
                <li><a href=""><span>소개</span></a></li>
                <li><a href=""><span>수업검색</span></a></li>
            </ul>
        </div>
        <div class="logo"><a href="http://localhost:8080/zest/main"><img src="/zest/images/logo2.png" alt="Logo"/></a></div>
        <div class="rightmenu">
            <ul>
                <li style="width:180px;"></li>
                <li>
                    <a href="" id="btn-myPage" onmousemove="join01.src='images/myPage2.png'"
                       onmouseout="join01.src='images/myPage1.png'">
                        <span><img src="images/myPage1.png" name="join01"/></span><span>마이페이지</span></a>
                </li>
                <li>
                    <a href="" id="btn-logout" onmousemove="join02.src='images/logout2.png'"
                       onmouseout="join02.src='images/logout1.png'">
                        <span><img src="images/logout1.png" name="join02"/></span><span>로그아웃</span></a>
                </li>

            </ul>
        </div>
    </div>
</div>
<!-- //헤더 -->

<!-- 페이지 제목 -->
<div class="pageTitle">
    <h1><span class="title webFont">수업 개설하기</span></h1>
</div>

<!-- 수업 정보 -->
<div id="content">
    <div class="box eventAdd" style="width: 1050px;">
        <form id="openAdd" name="writeForm" action="/zest/tutorPage/talentRegi" method="post" enctype="multipart/form-data"
              class="innerBorder" onsubmit="return lastSubmit()">
            <div class="Information">
                <!-- 수업 제목 -->
                <div class="openName ui input">
                    <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 수업제목</b>
                    <!-- 수업 제목 input tag-->
                    <input id="title" type="text" name="tc_subject" class="title" placeholder=" 수업제목을 입력해 주세요. (30자 이내)"
                           maxlength="64" autofocus="autofocus" style="margin-top: -14px; height: 45px;">
                </div>
                <!-- 대표이미지 -->
                <div class="row" style="display: block;">
                    <div class="col-lg-6 openCate">
                        <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 카테고리</b>
                        <!-- 카테고리 대 분류 인풋테그 -->
                        <select name="talent_category_id" id="ca_id" class="form-control" multiple style="text-align: center" required="required">
                            <option value>선택하세요</option>
                            <option value="SPORTS" onclick="fetchPage('/zest/main/sports')">스포츠</option>
                            <option value="BEAUTY" onclick="fetchPage('/zest/main/beauty')">뷰티</option>
                            <option value="MUSIC" onclick="fetchPage('/zest/main/music')">음악</option>
                            <option value="FOOD" onclick="fetchPage('/zest/main/food')">요리/음식</option>
                            <option value="DESIGN" onclick="fetchPage('/zest/main/design')">디자인</option>
                            <option value="BUSINESS" onclick="fetchPage('/zest/main/business')">실무</option>
                            <option value="LANGUAGE" onclick="fetchPage('/zest/main/language')">외국어</option>
                            <option value="PROGRAM" onclick="fetchPage('/zest/main/program')">프로그래밍</option>
                            <option value="LIFE" onclick="fetchPage('/zest/main/life')">라이프스타일</option>
                        </select>
                        <br>
                        <!-- 카테고리 소 분류인풋테그 -->
                        <select name="talent_lecture_id" id="ca_dt" class="form-control" multiple style="text-align: center" required="required">
                            <option value>세부카테고리</option>
                        </select>
                    </div>
                    <!-- 지역 -->
                    <div class="col-lg-5 openZone">
                        <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 지역</b>
                        <select name="ca_id1" id="ca_id1" class="form-control" multiple style="text-align: center">
                            <option value>선택하세요</option>
                            <option value="10" onclick="cityPage('seoul')">서울</option>
                            <option value="20" onclick="cityPage('gyeongi')">인천/경기</option>
                            <option value="30">강원</option>
                            <option value="40">대전/충청</option>
                            <option value="50">대구/경북</option>
                            <option value="60">광주/전라</option>
                            <option value="70">부산/경남</option>
                            <option value="80">제주/기타</option>
                        </select>
                        <br>
                        <select name="ca_dt1" id="ca_dt1" class="form-control" multiple style="text-align: center">
                            <option value>세부지역</option>
                        </select>
                        <%--지역추가 버튼--%>
                        <div class="col-lg-2 openZone">
                            <input type="button" class="btn btn-primary" value="지역추가하기" onclick="addZone()">
                        </div>
                        <div class="col-lg-2 openZone">
                            <input type="button" class="btn btn-secondary" value="지역삭제하기" onclick=""
                                   style="margin-left: 50px;">
                        </div>
                    </div>
                </div>

                <br>
                <%--지역설정--%>
                <br>
                <div class="row" style="display: block">
                    <%--선택한 지역의 이름을 저장시키는 곳--%>
                    <input type="hidden" id="selectDivZone">
                    <%--선택한 지역의 div 이름을 저장시키는곳--%>
                    <input type="hidden" id="selectDivId" value="0">

                    <div id="zoneDiv1" class="col-4" style="float: left">
                    </div>
                    <div id="zoneDiv2" class="col-4" style="float: left">
                    </div>
                    <div id="zoneDiv3" class="col-4" style="float: left; margin-bottom: 30px;">
                    </div>
                </div>
                <br>
                <br>
                <%--원데이 항목 체크박스--%>
                <div class="ui toggle checkbox">
                    <input type="checkbox" name="" id="checkDayType">
                    <label><b>OneDay 강의 등록시 체크해주세요.</b></label>
                </div>
                <br>

                <div class="row">
                    <div class="col-md-8">
                        <div class="card" style="width: 900px">
                            <div class="card-body">
                                <h4 class="card-title">시간,일정 등록하기</h4>
                                <!-- Nav tabs -->
                                <div class="vtabs">
                                    <ul class="nav nav-tabs tabs-vertical" role="tablist">
                                        <li class="nav-item"> <a class="nav-link active show" data-toggle="tab" href="#timeManual" role="tab" aria-selected="true">
                                            <span class="hidden-sm-up">
                                                <i class="ti-home"></i>
                                            </span>
                                            <span class="hidden-xs-down">어떻게?</span>
                                        </a>
                                        </li>

                                        <%--장소 1--%>
                                        <li class="nav-item">
                                            <a class="nav-link" id="zoneA1" onclick="selectZoneNumber(1)" data-toggle="tab" href="#zone1" role="tab" aria-selected="false" style="display: none;">
                                            <span class="hidden-sm-up">
                                                <i class="ti-user"></i></span>
                                            <span class="hidden-xs-down" id="zonSpan1"></span>
                                        </a>
                                        </li>

                                        <%--장소 2--%>
                                        <li class="nav-item">
                                            <a class="nav-link" id="zoneA2" onclick="selectZoneNumber(2)" data-toggle="tab" href="#zone2" role="tab" aria-selected="false" style="display: none;">
                                                <span class="hidden-sm-up"><i class="ti-email"></i></span>
                                                <span class="hidden-xs-down" id="zonSpan2"></span></a>
                                        </li>

                                        <%--장소 3--%>
                                        <li class="nav-item">
                                            <a class="nav-link" id="zoneA3" onclick="selectZoneNumber(3)" data-toggle="tab" href="#zone3" role="tab" aria-selected="false" style="display: none;">
                                                <span class="hidden-sm-up"><i class="ti-email"></i></span>
                                                <span class="hidden-xs-down" id="zonSpan3"></span></a>
                                        </li>
                                    </ul>
                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div class="tab-pane active show" id="timeManual" role="tabpanel">
                                            <div class="p-20">
                                                <h5>사용법</h5>
                                                <p>강의를 하실 요일을 설정하신 후에 해당 시간을 설정해주세요.</p>
                                                <p>시간을 설정하신 후에는 꼭 저장 버튼을 클릭해주세요.</p>
                                            </div>
                                        </div>

                                        <%--OneDay가 아닌 항목 설정--%>
                                        <div class="notOnedayDiv" style="display: none">
                                            <!-- 요일 -->
                                            <div>
                                                <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 요일</b>
                                            </div>

                                            <div class="selectDay" style="margin-left: 50px; margin-top: 10px;">
                                                <div class="row">
                                                    <div class="custom-control custom-checkbox col-2">
                                                        <input type="checkbox" class="custom-control-input" id="dayCheckMon" name="selectDay"
                                                               value="mon" onclick="checkConfirm('#dayCheckMon','#monTab','mon')">
                                                        <label class="custom-control-label" for="dayCheckMon">월요일</label>
                                                    </div>
                                                    <div class="custom-control custom-checkbox col-2">
                                                        <input type="checkbox" class="custom-control-input" id="dayCheckTue" name="selectDay"
                                                               value="tue" onclick="checkConfirm('#dayCheckTue','#tueTab','tue')">
                                                        <label class="custom-control-label" for="dayCheckTue">화요일</label>
                                                    </div>
                                                    <div class="custom-control custom-checkbox col-2">
                                                        <input type="checkbox" class="custom-control-input" id="dayCheckWed" name="selectDay"
                                                               value="wed" onclick="checkConfirm('#dayCheckWed','#wedTab','wed')">
                                                        <label class="custom-control-label" for="dayCheckWed">수요일</label>
                                                    </div>

                                                    <div class="custom-control custom-checkbox col-2">
                                                        <input type="checkbox" class="custom-control-input" id="dayCheckTur" name="selectDay"
                                                               value="tur" onclick="checkConfirm('#dayCheckTur','#turTab','tur')">
                                                        <label class="custom-control-label" for="dayCheckTur">목요일</label>
                                                    </div>
                                                    <div class="custom-control custom-checkbox col-2">
                                                        <input type="checkbox" class="custom-control-input" id="dayCheckFri" name="selectDay"
                                                               value="fri" onclick="checkConfirm('#dayCheckFri','#friTab','fri')">
                                                        <label class="custom-control-label" for="dayCheckFri">금요일</label>
                                                    </div>
                                                    <div class="custom-control custom-checkbox col-2">
                                                        <input type="checkbox" class="custom-control-input" id="dayCheckSat" name="selectDay"
                                                               value="sat" onclick="checkConfirm('#dayCheckSat','#satTab','sat')">
                                                        <label class="custom-control-label" for="dayCheckSat">토요일</label>
                                                    </div>
                                                    <div class="custom-control custom-checkbox col-2">
                                                        <input type="checkbox" class="custom-control-input" id="dayCheckSun" name="selectDay"
                                                               value="sun" onclick="checkConfirm('#dayCheckSun','#sunTab','sun')">
                                                        <label class="custom-control-label" for="dayCheckSun">일요일</label>
                                                    </div>
                                                </div>


                                                <div id="saveTimeData">
                                                    <%--저장되는 공간--%>

                                                </div>
                                            </div>

                                            <%--요일,시간선택--%>
                                            <div class="card">
                                                <div class="card-body p-b-0">
                                                    <h4 class="card-title">시간 및 날짜 선택 (시간은 최대 3개까지 나눠서 등록 가능합니다.)</h4>
                                                    <h6>시간을 선택한 후에는 <b>꼭</b> 저장을 눌러주세요!</h6>
                                                    <!-- Nav tabs -->
                                                    <ul class="nav nav-tabs customtab2" role="tablist">
                                                        <li class="nav-item">
                                                            <a class="nav-link" data-toggle="tab" href="void(0)" id="monTab"
                                                               onclick="alert('선택되지 않은 요일입니다.');return false;"
                                                               role="tab" aria-selected="false">
                                    <span class="hidden-sm-up">
                                        <i class="ti-home"></i></span>
                                                                <span class="hidden-xs-down">월요일</span></a></li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" data-toggle="tab" href="void(0)" role="tab"
                                                               id="tueTab" onclick="alert('선택되지 않은 요일입니다.');return false;"
                                                               aria-selected="false"><span class="hidden-sm-up"><i
                                                                    class="ti-user"></i></span> <span class="hidden-xs-down">화요일</span></a></li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" data-toggle="tab" role="tab" id="wedTab"
                                                               aria-selected="false" href="void(0)"
                                                               onclick="alert('선택되지 않은 요일입니다.');return false;"><span
                                                                    class="hidden-sm-up"><i
                                                                    class="ti-email"></i></span> <span class="hidden-xs-down">수요일</span></a>
                                                        </li>

                                                        <li class="nav-item">
                                                            <a class="nav-link" data-toggle="tab" role="tab" id="turTab"
                                                               aria-selected="false" href="void(0)"
                                                               onclick="alert('선택되지 않은 요일입니다.');return false;">
                                    <span class="hidden-sm-up">
                                        <i class="ti-email"></i></span>
                                                                <span class="hidden-xs-down">목요일</span></a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" data-toggle="tab" role="tab" id="friTab"
                                                               aria-selected="false" href="void(0)"
                                                               onclick="alert('선택되지 않은 요일입니다.');return false;">
                                    <span class="hidden-sm-up">
                                        <i class="ti-email"></i>
                                    </span>
                                                                <span class="hidden-xs-down">금요일</span></a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" data-toggle="tab" role="tab" href="void(0)" id="satTab"
                                                               onclick="alert('선택되지 않은 요일입니다.');return false;"
                                                               aria-selected="false"><span class="hidden-sm-up"><i
                                                                    class="ti-email"></i></span> <span class="hidden-xs-down">토요일</span></a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" data-toggle="tab" role="tab" href="void(0)" id="sunTab"
                                                               onclick="alert('선택되지 않은 요일입니다.');return false;"
                                                               aria-selected="false"><span class="hidden-sm-up"><i
                                                                    class="ti-email"></i></span> <span class="hidden-xs-down">일요일</span></a>
                                                        </li>
                                                    </ul>
                                                    <br>
                                                    <!-- Tab panes -->
                                                    <div class="tab-content">
                                                        <%--월요일--%>
                                                        <div class="tab-pane p-20" id="mon" role="tabpanel">
                                                            <div class="p-20">

                                                                <input type="button" class="btn btn-lg btn-primary"
                                                                       onclick="dayTabBtn('mon')" value="저장하기"/>
                                                                <div class="time-group" id="montimeData">
                                                                    <%--시간 id값 체크--%>
                                                                    <div class="plusTimeClass">
                                                                        <input type="hidden" value="1" id="moncheckPlusTime1">
                                                                        <input type="hidden" value="2" id="moncheckPlusTime2">
                                                                        <%--추가 되는 div check--%>
                                                                        <input type="hidden" value="0" id="mondivTime">

                                                                        <select name="montime01" id="montime01" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        부터
                                                                        <select name="montime02" id="montime02" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        까지
                                                                        <input type="button" class="btn btn-primary" id="plusTime" value="추가"
                                                                               onclick="addTime('mon')">
                                                                        <br>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <%--화요일--%>
                                                        <div class="tab-pane p-20" id="tue" role="tabpanel">
                                                            <div class="p-20">
                                                                <input type="button" class="btn btn-lg btn-primary" onclick="dayTabBtn('tue')"
                                                                       value="저장하기"/>
                                                                <div class="time-group" id="tuetimeData">
                                                                    <%--시간 id값 체크--%>
                                                                    <div class="plusTimeClass">
                                                                        <input type="hidden" value="1" id="tuecheckPlusTime1">
                                                                        <input type="hidden" value="2" id="tuecheckPlusTime2">
                                                                        <%--추가 되는 div check--%>
                                                                        <input type="hidden" value="0" id="tuedivTime">

                                                                        <select name="tuetime01" id="tuetime01" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        부터
                                                                        <select name="tuetime02" id="tuetime02" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        까지
                                                                        <input type="button" class="btn btn-primary" id="plusTime" value="추가"
                                                                               onclick="addTime('tue')">
                                                                        <br>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <%--수요일--%>
                                                        <div class="tab-pane p-20" id="wed" role="tabpanel">
                                                            <div class="p-20">
                                                                <input type="button" class="btn btn-lg btn-primary" onclick="dayTabBtn('wed')"
                                                                       value="저장하기"/>
                                                                <div class="time-group" id="wedtimeData">
                                                                    <%--시간 id값 체크--%>
                                                                    <div class="plusTimeClass">
                                                                        <input type="hidden" value="1" id="wedcheckPlusTime1">
                                                                        <input type="hidden" value="2" id="wedcheckPlusTime2">
                                                                        <%--추가 되는 div check--%>
                                                                        <input type="hidden" value="0" id="weddivTime">

                                                                        <select name="wedtime01" id="wedtime01" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        부터
                                                                        <select name="wedtime02" id="wedtime02" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        까지
                                                                        <input type="button" class="btn btn-primary" value="추가"
                                                                               onclick="addTime('wed')">
                                                                        <br>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <%--목요일--%>
                                                        <div class="tab-pane p-20" id="tur" role="tabpanel">
                                                            <div class="p-20">
                                                                <input type="button" class="btn btn-lg btn-primary" onclick="dayTabBtn('tur')"
                                                                       value="저장하기"/>
                                                                <div class="time-group" id="turtimeData">
                                                                    <%--시간 id값 체크--%>
                                                                    <div class="plusTimeClass">
                                                                        <input type="hidden" value="1" id="turcheckPlusTime1">
                                                                        <input type="hidden" value="2" id="turcheckPlusTime2">
                                                                        <%--추가 되는 div check--%>
                                                                        <input type="hidden" value="0" id="turdivTime">

                                                                        <select name="turtime01" id="turtime01" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        부터
                                                                        <select name="turtime02" id="turtime02" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        까지
                                                                        <input type="button" class="btn btn-primary" value="추가"
                                                                               onclick="addTime('tur')">
                                                                        <br>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <%--금요일--%>
                                                        <div class="tab-pane p-20" id="fri" role="tabpanel">
                                                            <div class="p-20">
                                                                <input type="button" class="btn btn-lg btn-primary" onclick="dayTabBtn('fri')"
                                                                       value="저장하기"/>
                                                                <div class="time-group" id="fritimeData">
                                                                    <%--시간 id값 체크--%>
                                                                    <div class="plusTimeClass">
                                                                        <input type="hidden" value="1" id="fricheckPlusTime1">
                                                                        <input type="hidden" value="2" id="fricheckPlusTime2">
                                                                        <%--추가 되는 div check--%>
                                                                        <input type="hidden" value="0" id="fridivTime">

                                                                        <select name="fritime01" id="fritime01" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        부터
                                                                        <select name="fritime02" id="fritime02" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        까지
                                                                        <input type="button" class="btn btn-primary" value="추가"
                                                                               onclick="addTime('fri')">
                                                                        <br>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <%--토요일--%>
                                                        <div class="tab-pane p-20" id="sat" role="tabpanel">
                                                            <div class="p-20">
                                                                <input type="button" class="btn btn-lg btn-primary" onclick="dayTabBtn('sat')"
                                                                       value="저장하기"/>
                                                                <div class="time-group" id="sattimeData">
                                                                    <%--시간 id값 체크--%>
                                                                    <div class="plusTimeClass">
                                                                        <input type="hidden" value="1" id="satcheckPlusTime1">
                                                                        <input type="hidden" value="2" id="satcheckPlusTime2">
                                                                        <%--추가 되는 div check--%>
                                                                        <input type="hidden" value="0" id="satdivTime">


                                                                        <select name="sattime01" id="sattime01" class="btn btn-default"
                                                                               >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        부터
                                                                        <select name="sattime02" id="sattime02" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        까지
                                                                        <input type="button" class="btn btn-primary" value="추가"
                                                                               onclick="addTime('sat')">
                                                                        <br>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <%--일요일--%>
                                                        <div class="tab-pane p-20" id="sun" role="tabpanel">
                                                            <div class="p-20">
                                                                <input type="button" class="btn btn-lg btn-primary" onclick="dayTabBtn('sun')"
                                                                       value="저장하기"/>
                                                                <div class="time-group" id="suntimeData">
                                                                    <%--시간 id값 체크--%>
                                                                    <div class="plusTimeClass">
                                                                        <input type="hidden" value="1" id="suncheckPlusTime1">
                                                                        <input type="hidden" value="2" id="suncheckPlusTime2">
                                                                        <%--추가 되는 div check--%>
                                                                        <input type="hidden" value="0" id="sundivTime">


                                                                        <select name="suntime01" id="suntime01" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        부터
                                                                        <select name="suntime02" id="suntime02" class="btn btn-default"
                                                                                >
                                                                            <option value="시간협의">시간협의</option>
                                                                            <option value="6:00">6:00</option>
                                                                            <option value="6:30">6:30</option>
                                                                            <option value="7:00">7:00</option>
                                                                            <option value="7:30">7:30</option>
                                                                            <option value="8:00">8:00</option>
                                                                            <option value="8:30">8:30</option>
                                                                            <option value="9:00">9:00</option>
                                                                            <option value="9:30">9:30</option>
                                                                            <option value="10:00">10:00</option>
                                                                            <option value="10:30">10:30</option>
                                                                            <option value="11:00">11:00</option>
                                                                            <option value="11:30">11:30</option>
                                                                            <option value="12:00">12:00</option>
                                                                            <option value="12:30">12:30</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="15:30">15:30</option>
                                                                            <option value="16:00">16:00</option>
                                                                            <option value="16:30">16:30</option>
                                                                            <option value="17:00">17:00</option>
                                                                            <option value="17:30">17:30</option>
                                                                            <option value="18:00">18:00</option>
                                                                            <option value="18:30">18:30</option>
                                                                            <option value="19:00">19:00</option>
                                                                            <option value="19:30">19:30</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                            <option value="22:30">22:30</option>
                                                                            <option value="23:00">23:00</option>
                                                                            <option value="23:30">23:30</option>
                                                                        </select>
                                                                        까지
                                                                        <input type="button" class="btn btn-primary" value="추가"
                                                                               onclick="addTime('sun')">
                                                                        <br>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%--실제데이터공간 지역1--%>
                                        <div class="tab-pane p-20" id="zone1" role="tabpanel">
                                            <%--원데이항목 div--%>
                                            <div class="oneDayDiv" style="display: none;">
                                                <i class="fas fa-plus fa-2x" onclick="addOnedayTime('#oneDayDiv2-1','#oneDayDiv3-1')"></i>
                                                <i class="fas fa-minus fa-2x" onclick="delOnedayTime('#oneDayDiv2-1','#oneDayDiv3-1')" style="margin-left: 5px"></i>
                                                <input type="button" class="btn btn-sm btn-outline-danger" style="float: right; margin-left: 3px" value="삭제" onclick="deleteOneday(1)">
                                                <input type="button" class="btn btn-sm btn-outline-primary"  style="float: right" value="저장하기" onclick="saveOneday(1)">
                                                <h5>한 지역에 최대 3타임까지 등록이 가능합니다.</h5>
                                                <div class="row" id="oneDayDiv1-1" style="display: none">
                                                    <%--날짜--%>
                                                    <div class="col-lg-3">
                                                        <label for="ondDayDate1-1">날짜 선택 : </label>
                                                        <input type="text" id="ondDayDate1-1" class="form-control oneday1"/>
                                                    </div>


                                                    <%--시간--%>
                                                    <div class="col-lg-5">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="oneDayTime1_1-1">시작 시간 : </label>
                                                                <input type="text" id="oneDayTime1_1-1" class="form-control oneDayFont oneday1"/>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="oneDayTime1_2-1">종료 시간 : </label>
                                                                <input type="text" id="oneDayTime1_2-1" class="form-control oneDayFont oneday1"/>
                                                            </div>
                                                        </div>
                                                    </div>


                                                </div>

                                                <div>
                                                    <div class="row" id="oneDayDiv2-1" style="display: none">
                                                        <%--날짜--%>
                                                        <div class="col-lg-3">
                                                            <label for="ondDayDate2-1">날짜 선택 : </label>
                                                            <input type="text" id="ondDayDate2-1" class="form-control oneday1" />
                                                        </div>


                                                        <%--시간--%>
                                                        <div class="col-lg-5">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <label for="oneDayTime2_1-1">시작 시간 : </label>
                                                                    <input type="text" id="oneDayTime2_1-1" class="form-control oneDayFont oneday1"/>
                                                                </div>
                                                                <div class="col-6">
                                                                    <label for="oneDayTime2_2-1">종료 시간 : </label>
                                                                    <input type="text" id="oneDayTime2_2-1" class="form-control oneDayFont oneday1"/>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>

                                                <div>
                                                    <div class="row" id="oneDayDiv3-1" style="display: none">
                                                        <%--날짜--%>
                                                        <div class="col-lg-3">
                                                            <label for="ondDayDate3-1">날짜 선택 : </label>
                                                            <input type="text" id="ondDayDate3-1" class="form-control oneday1"/>
                                                        </div>


                                                        <%--시간--%>
                                                        <div class="col-lg-5">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <label for="oneDayTime3_1-1">시작 시간 : </label>
                                                                    <input type="text" id="oneDayTime3_1-1" class="form-control oneDayFont oneday1"/>
                                                                </div>
                                                                <div class="col-6">
                                                                    <label for="oneDayTime3_2-1">종료 시간 : </label>
                                                                    <input type="text" id="oneDayTime3_2-1" class="form-control oneDayFont oneday1"/>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>




                                            </div>

                                        </div>
                                        <%--실제데이터공간 지역2--%>
                                        <div class="tab-pane p-20" id="zone2" role="tabpanel">
                                            <%--원데이항목 div--%>
                                            <div class="oneDayDiv" style="display:none;">
                                                <i class="fas fa-plus fa-2x" onclick="addOnedayTime('#oneDayDiv2-2','#oneDayDiv3-2')"></i>
                                                <i class="fas fa-minus fa-2x" onclick="delOnedayTime('#oneDayDiv2-2','#oneDayDiv3-2')" style="margin-left: 5px"></i>
                                                <input type="button" class="btn btn-sm btn-outline-danger" style="float: right; margin-left: 3px" value="삭제" onclick="deleteOneday(2)">
                                                <input type="button" class="btn btn-sm btn-outline-primary"  style="float: right" value="저장하기" onclick="saveOneday(2)">
                                                <h5>한 지역에 최대 3타임까지 등록이 가능합니다.</h5>

                                                <div class="row" id="oneDayDiv1-2" style="display: none">
                                                    <%--날짜--%>
                                                    <div class="col-lg-3">
                                                        <label for="ondDayDate1-2">날짜 선택 : </label>
                                                        <input type="text" id="ondDayDate1-2" class="form-control oneday2"/>
                                                    </div>


                                                    <%--시간--%>
                                                    <div class="col-lg-5">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="oneDayTime1_1-2">시작 시간 : </label>
                                                                <input type="text" id="oneDayTime1_1-2" class="form-control oneDayFont oneday2"/>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="oneDayTime1_2-1">종료 시간 : </label>
                                                                <input type="text" id="oneDayTime1_2-2" class="form-control oneDayFont oneday2"/>
                                                            </div>
                                                        </div>

                                                    </div>


                                                </div>

                                                <div class="row" id="oneDayDiv2-2" style="display: none;">
                                                        <%--날짜--%>
                                                        <div class="col-lg-3">
                                                            <label for="ondDayDate2-1">날짜 선택 : </label>
                                                            <input type="text" id="ondDayDate2-2" class="form-control oneday2"/>
                                                        </div>


                                                        <%--시간--%>
                                                        <div class="col-lg-5">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <label for="oneDayTime2_1-1">시작 시간 : </label>
                                                                    <input type="text" id="oneDayTime2_1-2" class="form-control oneDayFont oneday2"/>
                                                                </div>
                                                                <div class="col-6">
                                                                    <label for="oneDayTime2_2-1">종료 시간 : </label>
                                                                    <input type="text" id="oneDayTime2_2-2" class="form-control oneDayFont oneday2"/>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>

                                                <div class="row" id="oneDayDiv3-2" style="display: none;">
                                                        <%--날짜--%>
                                                        <div class="col-lg-3">
                                                            <label for="ondDayDate3-2">날짜 선택 : </label>
                                                            <input type="text" id="ondDayDate3-2" class="form-control oneday2"/>
                                                        </div>


                                                        <%--시간--%>
                                                        <div class="col-lg-5">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <label for="oneDayTime3_1-2">시작 시간 : </label>
                                                                    <input type="text" id="oneDayTime3_1-2" class="form-control oneDayFont oneday2"/>
                                                                </div>
                                                                <div class="col-6">
                                                                    <label for="oneDayTime3_2-2">종료 시간 : </label>
                                                                    <input type="text" id="oneDayTime3_2-2" class="form-control oneDayFont oneday2"/>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>

                                            </div>
                                        </div>
                                        <%--실제데이터공간 지역3--%>
                                        <div class="tab-pane p-20" id="zone3" role="tabpanel">
                                            <%--원데이항목 div--%>
                                            <div class="oneDayDiv" style="display: none;">
                                                <i class="fas fa-plus fa-2x" onclick="addOnedayTime('#oneDayDiv2-3','#oneDayDiv3-3')"></i>
                                                <i class="fas fa-minus fa-2x" onclick="delOnedayTime('#oneDayDiv2-3','#oneDayDiv3-3')" style="margin-left: 5px"></i>
                                                <input type="button" class="btn btn-sm btn-outline-danger" style="float: right; margin-left: 3px" value="삭제" onclick="deleteOneday(3)">
                                                <input type="button" class="btn btn-sm btn-outline-primary"  style="float: right" value="저장하기" onclick="saveOneday(3)">
                                                <h5>한 지역에 최대 3타임까지 등록이 가능합니다.</h5>

                                                <div class="row" id="oneDayDiv1-3" style="display: none">
                                                    <%--날짜--%>
                                                    <div class="col-lg-3">
                                                        <label for="ondDayDate1-2">날짜 선택 : </label>
                                                        <input type="text" id="ondDayDate1-3" class="form-control oneday3"/>
                                                    </div>


                                                    <%--시간--%>
                                                    <div class="col-lg-5">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="oneDayTime1_1-2">시작 시간 : </label>
                                                                <input type="text" id="oneDayTime1_1-3" class="form-control oneDayFont oneday3"/>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="oneDayTime1_2-1">종료 시간 : </label>
                                                                <input type="text" id="oneDayTime1_2-3" class="form-control oneDayFont oneday3"/>
                                                            </div>
                                                        </div>

                                                    </div>


                                                </div>

                                                <div class="row" id="oneDayDiv2-3" style="display: none">
                                                    <%--날짜--%>
                                                    <div class="col-lg-3">
                                                        <label for="ondDayDate2-1">날짜 선택 : </label>
                                                        <input type="text" id="ondDayDate2-3" class="form-control oneday3"/>
                                                    </div>


                                                    <%--시간--%>
                                                    <div class="col-lg-5">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="oneDayTime2_1-1">시작 시간 : </label>
                                                                <input type="text" id="oneDayTime2_1-3" class="form-control oneDayFont oneday3"/>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="oneDayTime2_2-1">종료 시간 : </label>
                                                                <input type="text" id="oneDayTime2_2-3" class="form-control oneDayFont oneday3"/>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>

                                                <div class="row" id="oneDayDiv3-3" style="display: none">
                                                    <%--날짜--%>
                                                    <div class="col-lg-3">
                                                        <label for="ondDayDate3-2">날짜 선택 : </label>
                                                        <input type="text" id="ondDayDate3-3" class="form-control oneday3"/>
                                                    </div>


                                                    <%--시간--%>
                                                    <div class="col-lg-5">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="oneDayTime3_1-2">시작 시간 : </label>
                                                                <input type="text" id="oneDayTime3_1-3" class="form-control oneDayFont oneday3"/>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="oneDayTime3_2-2">종료 시간 : </label>
                                                                <input type="text" id="oneDayTime3_2-3" class="form-control oneDayFont oneday3"/>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>



                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <!-- 이미지파일  -->
                <div class="openImg" style="margin-bottom: 35px;">
                    <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 대표이미지</b>
                    <h6>수업을 대표하는 사진을 올려주세요 . 9장까지 가능합니다.</h6>
                    <%--사진올리는파일의 이름--%>
                    <div>
                        <input id="talentImg1" type="file" name="talentImg" class="upload1 btn btn-default" autofocus="autofocus" accept=".jpg,.jpeg,.png,.gif,.bmp" >
                        <input id="talentImg2" type="file" name="talentImg" class="upload1 btn btn-default" autofocus="autofocus" accept=".jpg,.jpeg,.png,.gif,.bmp" >
                        <input id="talentImg3" type="file" name="talentImg" class="upload1 btn btn-default" autofocus="autofocus" accept=".jpg,.jpeg,.png,.gif,.bmp" >
                        <input id="talentImg4" type="file" name="talentImg" class="upload1 btn btn-default" autofocus="autofocus" accept=".jpg,.jpeg,.png,.gif,.bmp" >
                        <input id="talentImg5" type="file" name="talentImg" class="upload1 btn btn-default" autofocus="autofocus" accept=".jpg,.jpeg,.png,.gif,.bmp" >
                        <input id="talentImg6" type="file" name="talentImg" class="upload1 btn btn-default" autofocus="autofocus" accept=".jpg,.jpeg,.png,.gif,.bmp" >
                        <input id="talentImg7" type="file" name="talentImg" class="upload1 btn btn-default" autofocus="autofocus" accept=".jpg,.jpeg,.png,.gif,.bmp" >
                        <input id="talentImg8" type="file" name="talentImg" class="upload1 btn btn-default" autofocus="autofocus" accept=".jpg,.jpeg,.png,.gif,.bmp" >
                        <input id="talentImg9" type="file" name="talentImg" class="upload1 btn btn-default" autofocus="autofocus" accept=".jpg,.jpeg,.png,.gif,.bmp" >
                    </div>

                    <%--사진보여주기--%>
                    <input type="button" class="btn btn-outline-primary" value="사진 미리보기" style="margin-left: 10px; margin-top: 10px;" id="viewImgBtn" onclick="viewImg()">
                        <div id="talentImgView" class="carousel slide" data-ride="carousel" style="display: none">
                            <div class="carousel-inner" id="imgInner">

                            </div>
                            <%--이동 화살표--%>
                            <a class="carousel-control-prev" href="#talentImgView" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#talentImgView" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                    </div>

                </div>
                <br>
                <!-- 가격(시간) -->
                <div style="margin-bottom: 20px;">
                    <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 가격(시간)</b>
                    <input id="price" type="text" name="talent_price_hour" class="form-control" placeholder="시간당 가격을 입력"
                           maxlength="6" autofocus="autofocus" required style="margin-top: 5px; width: 200px;">
                </div>
               	<!-- 만나는 시간 -->
               <div style="margin-bottom: 20px;">
                    <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 1회 수업 시간을 입력</b>
                    <input id="meet_count" type="number" name="talent_meet_time" class="form-control" placeholder="한 회차에 수업시간을 입력"
                           maxlength="6" autofocus="autofocus" required style="margin-top: 5px; width: 200px;" min="1">
                </div>

                <!-- 최소최대인원 -->
                <div class="people-group">
                    <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 최대인원</b>
                    <input id="people" type="number" name="tc_max_client" class="form-control people" placeholder=" 최대인원 ex)10" autofocus="autofocus" min="1" required>
                </div>

                <!-- 장소 -->
                <div class="place-group">
                    <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;">세부 장소</b>
                    <input id="place" type="text" name="place" class="place form-control" placeholder=" 장소를 입력해 주세요." style="width: 500px"
                           autofocus="autofocus" required>
                </div>

                <!-- 추가비용  -->
                <div class="add-group">
                    <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;">추가비용 발생시 이유와 금액을 적어주세요 </b>
                    <input id="add" type="text" name="tc_price_detail" class="form-control add" placeholder="ex)스터디룸 대여료 별도 15000" maxlength="30" style="width: 500px" required
                           autofocus="autofocus">
                </div>

                <!-- 튜터한마디  -->
                <div class="word-group">
                    <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 튜터한마디</b>
                    <input id="word" type="text" name="tc_tt_message" class="word form-control" placeholder=" 수강생에게 튜터의 한마디를 입력해 주세요.(30자 이내)" style="width: 800px" required
                           maxlength="60" autofocus="autofocus">
                </div>


                <!-- 썸머노트  -->
                <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 튜터정보</b>
                <input type="button" onclick="test1()">
                <textarea id="note_tutorinfo" name="tc_tt_info" class="summer" required ></textarea>
                <br>


                <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 수업소개</b>
                <textarea id="note_classinfo" name="tc_class_info" class="summer" required></textarea>
                <br>

                <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 수업대상</b>
                <textarea id="note_target" name="tc_class_taget" class="summer" required></textarea>
                <br>
                <div id="curriDiv">
                    <input type="hidden" id="checkCurriCount" value="1">
                <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 커리큘럼</b>
                <h6>1 회차 이상시 추가버튼을 눌러서 내용을 입력해주세요</h6>
                <input type="button" onclick="addCurri()" class="btn btn-outline-primary" value="추가">
                <h4>1회차</h4>
                <textarea id="note_curri1" name="tc_curriculum" class="summer" required></textarea>
                </div>
                <br>

                <!-- 지도 -->
                <span class="req">*</span><b style="font-size: 20px; padding-right: 20px;"> 위치</b>
                <h6>대략적인 위치를 검색해서 설정해주세요.</h6>
                <input type="text" id="searchMap" name="searchMap" class="form-control" style="width: 300px">
                <input class="btn btn-primary" type="button" id="searchMapbtn" onclick="search()" value="찾기">
                <!-- 지도 좌표 위치값 저장 인풋 태그 -->
                <input type="hidden" id="locationXY" name="tc_location">
                <div id="map" style="width:100%;height:400px;"></div>

                <!-- 개설/취소 버튼 -->
                <div class="result">
                    <input type="submit" id="sumbmit1" class="btn btn-default" value="개설완료"/>
                    <input type="button" id="cancel1" class="btn btn-default" value="취소"/>
                </div>


            </div> <!-- div Information끝 -->
        </form>

    </div>
</div>

<!-- /footer -->

<!-- 부트스트랩 자바 스크립트 -->

<%--날짜 피커--%>
<script src="/zest/js/jquery-3.3.1.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<script src="/zest/js/bootstrap.js"></script>
<script src="/zest/js/popper.js"></script>
 <!-- 네이버지도 혜진 -->
    <script type="text/javascript"
            src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=pk_psC42XxmixgAb1TmT&submodules=geocoder"></script>   

<!-- 썸머노트  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.js"></script>
<%--타임피커--%>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

<%--sweet alert--%>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- 아이콘 -->
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>

<script src="/zest/js/talent/talentOpen.js"></script>
</body>
</html>