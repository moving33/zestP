//보내기전 저장되는 데이터
var onedayCheckData1 = {
    zoneid: '',
    t1_start: '',
    t1_end: '',
    t2_start: '',
    t2_end: '',
    t3_start: '',
    t3_end: '',
    day1: '',
    day2: '',
    day3: ''
};
var onedayCheckData2 = {
    zoneid: '',
    t1_start: '',
    t1_end: '',
    t2_start: '',
    t2_end: '',
    t3_start: '',
    t3_end: '',
    day1: '',
    day2: '',
    day3: ''
};
var onedayCheckData3 = {
    zoneid: '',
    t1_start: '',
    t1_end: '',
    t2_start: '',
    t2_end: '',
    t3_start: '',
    t3_end: '',
    day1: '',
    day2: '',
    day3: ''
};
// Json으로 보낼때의 데이터
var onedayData1 = {zoneid: '', t1: '', t2: '', t3: '', day1: '', day2: '', day3: ''};
var onedayData2 = {zoneid: '', t1: '', t2: '', t3: '', day1: '', day2: '', day3: ''};
var onedayData3 = {zoneid: '', t1: '', t2: '', t3: '', day1: '', day2: '', day3: ''};
// 보낼 데이터 저장
var monArray = ['시간협의', '', ''];
var tueArray = ['시간협의', '', ''];
var wedArray = ['시간협의', '', ''];
var turArray = ['시간협의', '', ''];
var friArray = ['시간협의', '', ''];
var satArray = ['시간협의', '', ''];
var sunArray = ['시간협의', '', ''];
// 지역최대 3개
var data1 = {'zoneId': '', 'mon': '', 'tue': '', 'wed': '', 'tur': '', 'fri': '', 'sat': '', 'sun': ''};
var data2 = {'zoneId': '', 'mon': '', 'tue': '', 'wed': '', 'tur': '', 'fri': '', 'sat': '', 'sun': ''};
var data3 = {'zoneId': '', 'mon': '', 'tue': '', 'wed': '', 'tur': '', 'fri': '', 'sat': '', 'sun': ''};
// 선택한 zone이 몇번째인지 확인하는 변수
var selectZonedata = 0;
// json 방식으로 시간을 저장하는 함수
var callbackData = {
    data: '',
    dayArray: '',
    setDataName: function (data, Array) {
        this.data = data;
        this.dayArray = Array;
    },
    setDataTime: function (time1, time2, time3) {
        if (time1 != null && time1 != '') {
            this.dayArray.splice(0, 0, time1);
            this.dayArray.splice(1, 1);
        }
        if (time2 != null && time2 != '') {
            this.dayArray.splice(1, 0, time2);
            this.dayArray.splice(2, 1);
        }
        if (time3 != null && time3 != '') {
            this.dayArray.splice(2, 0, time3);
            this.dayArray.splice(3, 1);
        }
    },
    setData: function (data, key) {
        if (key == 'mon') {
            alert(this.dayArray);
            data.mon = this.dayArray;
        }
        if (key == 'tue') {
            data.tue = this.dayArray;
        }
        if (key == 'wed') {
            data.wed = this.dayArray;
        }
        if (key == 'tur') {
            data.tur = this.dayArray;
        }
        if (key == 'fri') {
            data.fri = this.dayArray;
        }
        if (key == 'sat') {
            data.sat = this.dayArray;
        }
        if (key == 'sun') {
            data.sun = this.dayArray;
        }
    }

}
// naver map 변수
var map;
// db에 넣을 좌표
var mapLocation = {'x':'','y':''};
/* 혜진 */
// 사진추가 버튼 눌렀을때
function addImg() {
    var count = 0;

    var saveHtml = '';
    var saveHtml2 = '';
    count++;
    if (count == 1) {
        var list = $("#addImg2");
        saveHtml += "<input type='file' id='file1' name='file1' class='upload1 btn btn-default' accept='.jpg,.jpeg,.png,.gif,.bmp'>";
        list.html(saveHtml);
    } else if (count == 2) {
        var list2 = $("#addImg3");
        saveHtml2 += "<input type='file' id='file2' name='file2' class='upload1 btn btn-default' accept='.jpg,.jpeg,.png,.gif,.bmp'>";
        list2.html(saveHtml2);
    }
}

// 데이터피커
$(function () {
    $("#picker1").datepicker({
        minDate: 0,
        dateFormat: 'yyyy-mm-dd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        changeMonth: true,
        changeYear: true,
        yearSuffix: '년'
    });
});

// 네이버 지도 검색
function search() {

    var addr = $('#searchMap').val();

    var myaddress = addr;// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
    naver.maps.Service.geocode({address: myaddress}, function (status, response) {

        if (status !== naver.maps.Service.Status.OK) {
            return swal(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
        }
        var result = response.result;
        // 검색 결과 갯수: result.total
        // 첫번째 결과 결과 주소: result.items[0].address
        // 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x

        // db에 넣을 좌표 저장
        mapLocation.x = result.items[0].point.x;
        mapLocation.y = result.items[0].point.y;
        $("#locationXY").val(mapLocation.x+","+mapLocation.y);

        var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
        map.setCenter(myaddr); // 검색된 좌표로 지도 이동
        // 마커 표시
        var marker = new naver.maps.Marker({
            position: myaddr,
            map: map
        });
        naver.maps.Event.addListener(map, 'click', function(e) {
            marker.setPosition(e.coord);
            // db에 저장할 내용 변경
            var x = e.coord.x;
            var y = e.coord.y;

            mapLocation.x = x;
            mapLocation.y = y;
            $("#locationXY").val(mapLocation.x+","+mapLocation.y);

        });
        /*
		 * // 마커 클릭 이벤트 처리 naver.maps.Event.addListener(marker, "click",
		 * function (e) { if (infowindow.getMap()) { infowindow.close(); } else {
		 * infowindow.open(map, marker); } }); // 마크 클릭시 인포윈도우 오픈 var infowindow =
		 * new naver.maps.InfoWindow({ content: '<h4> [네이버 개발자센터]</h4><a
		 * href="https://developers.naver.com" target="_blank"><img
		 * src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
		 * });
		 */
    });

}

// 지역 선택
function cityPage(name) {

    var cityHtml = '';
    var city1 = ["강남", "건대", "신촌홍대", "종로", "노원", "사당", "신림", "성북"];
    var city2 = ["분당", "일산", "수원"];

    switch (name) {
        case'seoul' :
            for (i = 0; i < city1.length; i++) {
                cityHtml += "<option value=''>" + city1[i] + "</option>";
                $('#ca_dt1').html(cityHtml);
            }
            break;
        case'gyeongi' :
            for (i = 0; i < city2.length; i++) {
                cityHtml += "<option value=''>" + city2[i] + "</option>";
                $('#ca_dt1').html(cityHtml);
            }


    }
}

// 날짜 추가 기능
function dateSave() {

    var saveHtml = '';
    var saveHtml2 = '';
    var saveHtml3 = '';
    count++;
    if (count == 1) {
        for (i = 1; i < 5; i++) {
            saveHtml += "<input type='text' id='date" + i + "'>";
            $('#p1').html(saveHtml);
        }

        var week = $('input[name=options]:radio:checked').val();
        var days = $("#picker1").datepicker({altField: "#getDate", altFormat: "yy-mm-dd"}).val();
        var time1 = $("#time01 option:selected").val();
        var time2 = $("#time02 option:selected").val();

        $("#date1").val(week);
        $("#date2").val(days);
        $("#date3").val(time1);
        $("#date4").val(time2);


    } else if (count == 2) {
        for (i = 5; i < 9; i++) {
            saveHtml2 += "<input type='text' id='date" + i + "'>";
            $('#p2').html(saveHtml2);
        }

        var week = $('input[name=options]:radio:checked').val();
        var days = $("#picker1").datepicker({altField: "#getDate", altFormat: "yy-mm-dd"}).val();
        var time1 = $("#time01 option:selected").val();
        var time2 = $("#time02 option:selected").val();


        $("#date5").val(week);
        $("#date6").val(days);
        $("#date7").val(time1);
        $("#date8").val(time2);

    } else if (count == 3) {
        for (i = 9; i < 13; i++) {
            saveHtml3 += "<input type='text' id='date" + i + "'>";
            $('#p3').html(saveHtml3);
        }

        var week = $('input[name=options]:radio:checked').val();
        var days = $("#picker1").datepicker({altField: "#getDate", altFormat: "yy-mm-dd"}).val();
        var time1 = $("#time01 option:selected").val();
        var time2 = $("#time02 option:selected").val();

        $("#date9").val(week);
        $("#date10").val(days);
        $("#date11").val(time1);
        $("#date12").val(time2);

    }
}

// 날짜삭제 기능
function dateDel() {
    var d = $("#timeSaveZone1").children().last();
    d.remove();
}


// 지역 선택
function fetchPage(name){
	var list = $('#ca_dt');
	var listHtml = '';
	fetch(name,{
		method : 'GET'
		}).then(function(response) {
			if (!response.ok) {
				throw Error(response.statusText);
			}
			return response.json();
		}).then((data) => {
			// for문 처리
			$.each(data,function(index,value){
				listHtml += "<option value='"+value.lecture_id+"'>"+value.lecture_name+"</option>";
			});
			list.html(listHtml);
		}).catch((e) => {
			console.log(e);
		});
}
// 데이터 피커 만들기
function createDatePicker(a) {
    a.datepicker({
        minDate: 0,
        dateFormat: 'yy-mm-dd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        changeMonth: true,
        changeYear: true,
        yearSuffix: '년',
        onSelect: function (dateText, inst) {
            var thidID = $(a).attr('id');
            switch (thidID) {
                case 'ondDayDate1-1': {
                    onedayCheckData1.day1 = $(a).val();
                    var week = new Array('일', '월', '화', '수', '목', '금', '토');                    
                    var today = new Date(dateText).getDay();
                    var todayLabel = week[today];
                    alert(todayLabel);
                    break;
                }
                case 'ondDayDate2-1': {
                    onedayCheckData1.day2 = $(a).val();
                    break;
                }
                case 'ondDayDate3-1': {
                    onedayCheckData1.day3 = $(a).val();
                    break;
                }
                case 'ondDayDate1-2': {
                    onedayCheckData2.day1 = $(a).val();
                    break;
                }
                case 'ondDayDate2-2': {
                    onedayCheckData2.day2 = $(a).val();
                    break;
                }
                case 'ondDayDate3-2': {
                    onedayCheckData2.day3 = $(a).val();
                    break;
                }
                case 'ondDayDate1-3': {
                    onedayCheckData3.day1 = $(a).val();
                    break;
                }
                case 'ondDayDate2-3': {
                    onedayCheckData3.day2 = $(a).val();
                    break;
                }
                case 'ondDayDate3-3': {
                    onedayCheckData3.day3 = $(a).val();
                    break;
                }
            }

        }
    });
}

// 시간 체크
function checkTime(startTime, endTime, id) {
    // 시간 체크
    if (startTime > endTime || startTime == endTime) {
        alert('시간이 올바르지 않습니다 다시 설정해주세요');
        id.val('');
        return false;
    }
}

// 같은 날일시 잘못된 시간 체크
function checkDay(day1, day2, day3, id) {
    alert(day1 + '/' + day2 + '/' + day3);
    alert(onedayCheckData1.t1_end + "/" + onedayCheckData1.t2_start);
    alert(onedayCheckData1.t1_end + "/" + onedayCheckData1.t3_start);
    if (day1 == day2) {
        if (onedayCheckData1.t1_end >= onedayCheckData1.t2_start) {
            alert('이미 설정한 시작 시간입니다.');
            id.val('');
            return false;
        }
    }
    if (day1 == day3 && day3 != '') {
        if (onedayCheckData1.t1_end >= onedayCheckData1.t3_start) {
            alert('이미 설정한 시작 시간입니다.');
            id.val('');
            return false;
        }
    }
    if (day2 == day3 && day3 != '') {
        if (onedayCheckData1.t2_end >= onedayCheckData1.t3_start) {
            alert('이미 설정한 시작 시간입니다.');
            id.val('');
            return false;
        }
    }
    return true;
}


/* 재식 */

// a는 요일 체크박스의 ID b는 요일 Tap 패인의 ID e는 Tap 패인 안의 Content div 의 id
function checkConfirm(a, b, e) {
    var d = '#' + e + 'checkTime';
    var c = '#' + e;
    var f = 'saveTime' + e;
    var g = e + 'time0';
    // 체크 가 되있을시
    if (!$(a).prop("checked")) {
        if ($(d).val() == 1) {
            var con = confirm('저장된 데이터가 있습니다. 취소 하시겠습니까?');
            if (con == true) {
                $(a).prop("checked", false);
                // 저장된 공간 삭제
                var item = document.getElementById(f);
                if (item != null) {
                    item.parentNode.removeChild(item);
                }
                // 데이터 리셋
                for (var i = 1; i <= 6; i++) {
                    var temp = '#' + g + i;
                    if ($(temp).val() != null) {
                        $(temp).val('시간협의').prop("selected", true);
                    }
                }

            } else {
                $(a).prop("checked", true);
                return;
            }

        }
        var item = document.getElementById(f);
        if (item != null) {
            item.parentNode.removeChild(item);
        }
        $(b).attr('href', 'void(0)');
        $(b).attr('onclick', 'alert("선택되지 않은 요일입니다");return false;');

        if ($(c).hasClass("show") == 1) {
            $(c).removeClass("show");
            $(c).removeClass("active");
            $(b).removeClass("show");
            $(b).removeClass("active");
        }
        $(a).removeAttr("checked");

    } else {

        // 체크가 안되있을시
        $(b).attr('href', '#' + e);
        $(b).removeAttr('onclick');

        // 저장될 공간 업데이트
        var html = '';
        html += '<div id="saveTime' + e + '">';
        html += '<input type="hidden" name="' + e + 'Time" value=0 id="' + e + 'Time1">';
        html += '<input type="hidden" name="' + e + 'Time" id="' + e + 'Time2">';
        html += '<input type="hidden" name="' + e + 'Time" id="' + e + 'Time3">';
        html += '<input type="hidden" id="' + e + 'checkTime" value="0">';
        html += '</div>';
        var div = $(html);
        $('#saveTimeData').append(div);

        if ($(b).hasClass("show") == 1) {
            $(b).removeClass("show");
            $(b).removeClass("active");
        }
        $(a).prop("checked", true);
    }
}

// 날짜 타임 지우기
function removeTime(idCount, day) {
    var a = '#' + day + 'checkPlusTime1';
    var b = '#' + day + 'checkPlusTime2';
    var c = '#' + day + 'divTime';
    var checkTime1 = $(a).val();
    var checkTime2 = $(b).val();
    // div
    var div = $(c).val();
    if (idCount == 1) {
        checkTime1 = checkTime1 - 2;
        checkTime2 = checkTime2 - 2;
    }
    if (idCount == 2) {
        checkTime1 = checkTime1 - 2;
        checkTime2 = checkTime2 - 2;
    }
    div--;
    $(a).val(checkTime1);
    $(b).val(checkTime2);
    $(c).val(div);
    var item = document.getElementById(day + "timeDate" + idCount);
    if (item != null) {
        item.parentNode.removeChild(item);
    }
}

// 시간추가 a는 해당 요일일 ex) 월요일이면 mon 화요일이면 tue
function addTime(a) {

    var checkTime1ID1 = '#' + a + 'checkPlusTime1';
    var checkTime1ID2 = '#' + a + 'checkPlusTime2';
    var checkDivTime = '#' + a + 'divTime';

    var checkTime1 = $(checkTime1ID1).val();
    var checkTime2 = $(checkTime1ID2).val();
    // div
    var div = $(checkDivTime).val();

    if (div == 2) {
        alert("시간선택은 3개 까지 추가가 가능합니다.");
        return;
    }
    // 시간체크옵션 값 + ,value 값에 저장
    checkTime1++;
    checkTime1++;
    checkTime2++;
    checkTime2++;
    div++;
    $(checkTime1ID1).val(checkTime1);
    $(checkTime1ID2).val(checkTime2);
    $(checkDivTime).val(div);
    // html 에 추가
    var timeDataDivId = '#' + a + 'timeData';
    var timedata = $(timeDataDivId);
    var html = '';
    html += '<div class="plusTimeClass" id=' + a + 'timeDate' + div + '>';
    /*
	 * html += '<input type="text" name="picker" id="picker' + (div + 1) + '"
	 * class="picker" readonly="readonly" value="날짜선택">';
	 */
    html += '<select name="' + a + 'time0' + checkTime1 + '" ';
    html += 'id="' + a + 'time0' + checkTime1 + '" ';
    html += 'class="btn btn-default">\n' +
        '                                            <option value="시간협의">시간협의</option>\n' +
        '                                            <option value="6:00">6:00</option>\n' +
        '                                            <option value="6:30">6:30</option>\n' +
        '                                            <option value="7:00">7:00</option>\n' +
        '                                            <option value="7:30">7:30</option>\n' +
        '                                            <option value="8:00">8:00</option>\n' +
        '                                            <option value="8:30">8:30</option>\n' +
        '                                            <option value="9:00">9:00</option>\n' +
        '                                            <option value="9:30">9:30</option>\n' +
        '                                            <option value="10:00">10:00</option>\n' +
        '                                            <option value="10:30">10:30</option>\n' +
        '                                            <option value="11:00">11:00</option>\n' +
        '                                            <option value="11:30">11:30</option>\n' +
        '                                            <option value="12:00">12:00</option>\n' +
        '                                            <option value="12:30">12:30</option>\n' +
        '                                            <option value="13:00">13:00</option>\n' +
        '                                            <option value="13:30">13:30</option>\n' +
        '                                            <option value="14:00">14:00</option>\n' +
        '                                            <option value="14:30">14:30</option>\n' +
        '                                            <option value="15:00">15:00</option>\n' +
        '                                            <option value="15:30">15:30</option>\n' +
        '                                            <option value="16:00">16:00</option>\n' +
        '                                            <option value="16:30">16:30</option>\n' +
        '                                            <option value="17:00">17:00</option>\n' +
        '                                            <option value="17:30">17:30</option>\n' +
        '                                            <option value="18:00">18:00</option>\n' +
        '                                            <option value="18:30">18:30</option>\n' +
        '                                            <option value="19:00">19:00</option>\n' +
        '                                            <option value="19:30">19:30</option>\n' +
        '                                            <option value="20:00">20:00</option>\n' +
        '                                            <option value="20:30">20:30</option>\n' +
        '                                            <option value="21:00">21:00</option>\n' +
        '                                            <option value="21:30">21:30</option>\n' +
        '                                            <option value="22:00">22:00</option>\n' +
        '                                            <option value="22:30">22:30</option>\n' +
        '                                            <option value="23:00">23:00</option>\n' +
        '                                            <option value="23:30">23:30</option>\n' +
        '                                        </select>\n' +
        '                                        부터\n' +
        '                                        <select name="' + a + 'time0' + checkTime2 + '" id="' + a + 'time0' + checkTime2 + '" class="btn btn-default" ' +
        ' >\n' +
        '                                            <option value="시간협의">시간협의</option>\n' +
        '                                            <option value="6:00">6:00</option>\n' +
        '                                            <option value="6:30">6:30</option>\n' +
        '                                            <option value="7:00">7:00</option>\n' +
        '                                            <option value="7:30">7:30</option>\n' +
        '                                            <option value="8:00">8:00</option>\n' +
        '                                            <option value="8:30">8:30</option>\n' +
        '                                            <option value="9:00">9:00</option>\n' +
        '                                            <option value="9:30">9:30</option>\n' +
        '                                            <option value="10:00">10:00</option>\n' +
        '                                            <option value="10:30">10:30</option>\n' +
        '                                            <option value="11:00">11:00</option>\n' +
        '                                            <option value="11:30">11:30</option>\n' +
        '                                            <option value="12:00">12:00</option>\n' +
        '                                            <option value="12:30">12:30</option>\n' +
        '                                            <option value="13:00">13:00</option>\n' +
        '                                            <option value="13:30">13:30</option>\n' +
        '                                            <option value="14:00">14:00</option>\n' +
        '                                            <option value="14:30">14:30</option>\n' +
        '                                            <option value="15:00">15:00</option>\n' +
        '                                            <option value="15:30">15:30</option>\n' +
        '                                            <option value="16:00">16:00</option>\n' +
        '                                            <option value="16:30">16:30</option>\n' +
        '                                            <option value="17:00">17:00</option>\n' +
        '                                            <option value="17:30">17:30</option>\n' +
        '                                            <option value="18:00">18:00</option>\n' +
        '                                            <option value="18:30">18:30</option>\n' +
        '                                            <option value="19:00">19:00</option>\n' +
        '                                            <option value="19:30">19:30</option>\n' +
        '                                            <option value="20:00">20:00</option>\n' +
        '                                            <option value="20:30">20:30</option>\n' +
        '                                            <option value="21:00">21:00</option>\n' +
        '                                            <option value="21:30">21:30</option>\n' +
        '                                            <option value="22:00">22:00</option>\n' +
        '                                            <option value="22:30">22:30</option>\n' +
        '                                            <option value="23:00">23:00</option>\n' +
        '                                            <option value="23:30">23:30</option>\n' +
        '                                        </select>\n' +
        '                                        까지\n' +
        '                                        <input type="button" class="btn btn-primary" value="삭제" onclick="removeTime(' + div + ',\'' + a + '\')">';

    // 내용추가
    html += '<br>';
    html += '</div>';

    timedata.append(html);

    var setData = "#" + a + "picker" + (div + 1);

    $(setData).datepicker({
        minDate: 0,
        dateFormat: 'yyyy-mm-dd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        changeMonth: true,
        changeYear: true,
        yearSuffix: '년'
    });

    // change event 걸기
    var eventTime1 = '#' + a + 'time0' + checkTime1;
    var tempEventTime1 = a + 'time0' + checkTime1;
    var eventTime2 = '#' + a + 'time0' + checkTime2;
    var tempEventTime2 = a + 'time0' + checkTime2;
    if (checkTime2 == 4) {
        var saveTime = '#' + a + 'Time' + '2';
    }
    if (checkTime2 == 6) {
        var saveTime = '#' + a + 'Time' + '3';
    }


    alert(eventTime2 + "/" + saveTime);

    $(eventTime2).change(function () {
        if (timeCheck(tempEventTime1, tempEventTime2) == true) {
            alert(saveTime);
            var insertDate = $(eventTime1).val() + "~" + $(eventTime2).val();
            $(saveTime).val(insertDate);
            alert($(saveTime).val());
        }
    });
}

// 시간 체크
function timeCheck(a, b) {

    var s1 = document.getElementById(a);
    var s2 = document.getElementById(b);

    var t1 = s1.options[s1.selectedIndex].value;
    var t2 = s2.options[s2.selectedIndex].value; // 두번째 선택시간

    if (t1 == '시간협의') {
        if (t2 != '시간협의') {
            alert("수업 시간이 잘못되었습니다");
            var fin = "#" + d2 + " option:eq(0)";
            $(fin).prop("selected", true);
            return;
        }
    }
    if (t2 == '시간협의') {
        if (t1 != '시간협의') {
            alert("수업 시간이 잘못되었습니다");
            var fin = "#" + d2 + " option:eq(0)";
            $(fin).prop("selected", true);
            return;
        }
    }

    var t1Hours = parseInt(t1.substr(0, 2));  // 시
    var t1Min = parseInt(t1.substr(3, 2));  // 분

    var t2Hours = parseInt(t2.substr(0, 2)); // 시
    var t2Min = parseInt(t2.substr(3, 2)); // 분
    // 시간분으로 바꾸기
    var t11 = t1Hours * 60 + t1Min;
    var t22 = t2Hours * 60 + t2Min;

    if (t11 >= t22) {
        alert("수업 시간이 잘못되었습니다");
        var fin = "#" + b + " option:eq(0)";
        $(fin).prop("selected", true);
        return false;
    }
    return true;
}

// 각 요일에 대한 정보 저장하기 a 는 각요일의 정보를 저장하는 곳의 id #을 제외한
function dayTabBtn(a) {
    var id1 = '#' + a + "Time1";
    var id2 = '#' + a + "Time2";
    var id3 = '#' + a + "Time3";
    var checkid = '#' + a + 'checkTime';
    if ($(id1).val() != 0) {
        $(checkid).val(1);
        swal("저장 되었습니다.");
        timeDataSave(selectZonedata, a, $(id1).val(), $(id2).val(), $(id3).val());
    } else {
        alert('시간을 올바르게 입력해주세요');
    }
}

// 지역 추가 버튼 클릭시 발생
function addZone() {
    var checkZone = $("#ca_dt1 option:selected").text();

    if (checkZone == null || checkZone == '' || checkZone == '세부지역') {
        alert('정확한 지역을 선택해주세요');
        return;
    }

    // 지역 중복 검사
    if ($("#zonSpan1").text() == checkZone || $("#zonSpan2").text() == checkZone || $("#zonSpan3").text() == checkZone) {
        swal('이미 선택하신 지역입니다.', {
            icon: "warning"
        });
        return;
    }
    // 지역 3개 검사
    if ($("#zonSpan1").text() != '' && $("#zonSpan2").text() != '' && $("#zonSpan3").text() != '') {
        swal('지역은 3개까지 선택 가능합니다.', {
            icon: "warning"
        });
        return;
    }

    // 지역 추가
    if ($("#zonSpan1").text() == '') {
        $("#zonSpan1").text(checkZone);
        $("#zoneA1").css("display", "block");
        $("#oneDayDiv1-1").css("display", "flex");
        return;
    }
    if ($("#zonSpan2").text() == '') {
        $("#zonSpan2").text(checkZone);
        $("#zoneA2").css("display", "block");
        $("#oneDayDiv1-2").css("display", "flex");
        return;
    }
    if ($("#zonSpan3").text() == '') {
        $("#zonSpan3").text(checkZone);
        $("#zoneA3").css("display", "block");
        $("#oneDayDiv1-3").css("display", "flex");
        return;
    }
}

// zone을 몇번을 선택했는지 구별해주는 함수, notoneDay 를 보이게 만들어줌
function selectZoneNumber(a) {
    // 원데이 항목일 경우에 리턴
    if ($("#checkDayType").prop("checked")) {
        return;
    }
    if ($(".notOnedayDiv").css("display") == "none") {
        $(".notOnedayDiv").css("display", "block");
    }
    // 탭 화면을 전환시 내용 초기화
    if (selectZonedata != a) {
        var result = confirm("지역 탭을 이동하기전에 저장하셨습니까?");
        if (result) {
            $("#dayCheckMon").prop("checked", false);
            $("#dayCheckTue").prop("checked", false);
            $("#dayCheckWed").prop("checked", false);
            $("#dayCheckTur").prop("checked", false);
            $("#dayCheckFri").prop("checked", false);
            $("#dayCheckSat").prop("checked", false);
            $("#dayCheckSun").prop("checked", false);
            // time값 리셋
            $("#montime01").val(''); // 월요일
            $("#montime02").val('');
            $("#montime03").val('');
            $("#montime04").val('');
            $("#montime05").val('');
            $("#montime06").val('');
            
            $("#tuetime01").val(''); // 화요일
            $("#tuetime02").val('');
            $("#tuetime03").val('');
            $("#tuetime04").val('');
            $("#tuetime05").val('');
            $("#tuetime06").val('');
                        
            $("#wedtime01").val(''); // 수요일
            $("#wedtime02").val('');
            $("#wedtime03").val('');
            $("#wedtime04").val('');
            $("#wedtime05").val('');
            $("#wedtime06").val('');            
            
            $("#turtime01").val(''); // 목요일
            $("#turtime02").val('');
            $("#turtime03").val('');
            $("#turtime04").val('');
            $("#turtime05").val('');
            $("#turtime06").val('');       
            
            $("#fritime01").val(''); // 금요일
            $("#fritime02").val('');
            $("#fritime03").val('');
            $("#fritime04").val('');
            $("#fritime05").val('');
            $("#fritime06").val('');
            
            $("#sattime01").val(''); // 토요일
            $("#sattime02").val('');
            $("#sattime03").val('');
            $("#sattime04").val('');
            $("#sattime05").val('');
            $("#sattime06").val('');
            
            $("#suntime01").val(''); // 일요일
            $("#suntime02").val('');
            $("#suntime03").val('');
            $("#suntime04").val('');
            $("#suntime05").val('');
            $("#suntime06").val('');
            
            // 자식노드 모두 지우기
            $("#saveTimeData").empty();
        } else {
            swal("꼭 저장해주세요.");
            return;
        }
    }
    // 선택한 지역의 넘버가 들어감.
    selectZonedata = a;

}


// 지역을 클릭한 후 필요한 정보 저장 메서드 a는 실행시키는 input tag
function selectZone(a) {
    var thisValue = a.value; // zone 의 이름
    var thisId = a.id; // 버튼의 이름 저장
    // 해당 버튼이 어디에 위치있는지 구함
    if (databtn1 == thisId) {
        selectZonedata = 1;
        alert(thisValue + " 의 시간설정을 해주세요.");
        $(a).css("background", "blue");
        $(a).css("color", "white");
        alert(data1.zoneId + ' / ' + data1.mon + ' / ' + data1.tue + ' / ' + data1.wed + ' / ' + data1.tur + ' / ' + data1.fri + ' / ' + data1.sat + ' / ' + data1.sun);

        // 나머지 버튼들 css 변환
        if ($("#zoneBtn2").length > 0) {
            $("#zoneBtn2").css("background", "white");
            $("#zoneBtn2").css("color", "#007bff");
        }
        if ($("#zoneBtn3").length > 0) {
            $("#zoneBtn3").css("background", "white");
            $("#zoneBtn3").css("color", "#007bff");
        }
        return;
    }
    if (databtn2 == thisId) {
        alert('bb');
        selectZonedata = 2;
        alert(thisValue + " 의 시간설정을 해주세요.");
        $(a).css("background", "blue");
        $(a).css("color", "white");

        // 나머지 버튼들 css 변환
        if ($("#zoneBtn1").length > 0) {
            $("#zoneBtn1").css("background", "white");
            $("#zoneBtn1").css("color", "#007bff");
        }
        if ($("#zoneBtn3").length > 0) {
            $("#zoneBtn3").css("background", "white");
            $("#zoneBtn3").css("color", "#007bff");
        }
        alert(data2.zoneId + ' / ' + data2.mon + ' / ' + data2.tue + ' / ' + data2.wed + ' / ' + data2.tur + ' / ' + data2.fri + ' / ' + data2.sat + ' / ' + data2.sun);
        return;
    }

    if (databtn3 == thisId) {
        alert('c');
        selectZonedata = 3;
        alert(thisValue + " 의 시간설정을 해주세요.");
        $(a).css("background", "blue");
        $(a).css("color", "white");

        // 나머지 버튼들 css 변환
        if ($("#zoneBtn1").length > 0) {
            $("#zoneBtn1").css("background", "white");
            $("#zoneBtn1").css("color", "#007bff");
        }
        if ($("#zoneBtn2").length > 0) {
            $("#zoneBtn3").css("background", "white");
            $("#zoneBtn3").css("color", "#007bff");
        }
        alert(data3.zoneId + ' / ' + data3.mon + ' / ' + data3.tue + ' / ' + data3.wed + ' / ' + data3.tur + ' / ' + data3.fri + ' / ' + data3.sat + ' / ' + data3.sun);
        return;
    }

}

// a는 저장하는 data 의 번호를 저장하고 있는 값의 value
function timeDataSave(a, name, time1, time2, time3) {
    if (a == 1) {
        // zone id 저장.
        data1.zoneId = $("#zonSpan1").text().trim();
        if (name == 'mon') {
            callbackData.setDataName(data1.mon, monArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'tue') {
            callbackData.setDataName(data1.tue, tueArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'wed') {
            callbackData.setDataName(data1.wed, wedArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'tur') {
            callbackData.setDataName(data1.tur, turArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'fri') {
            callbackData.setDataName(data1.fri, friArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'sat') {
            callbackData.setDataName(data1.sat, satArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'sun') {
            callbackData.setDataName(data1.sun, sunArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        callbackData.setData(data1, name);
    }
    if (a == 2) {
        // zone id 저장.
        data2.zoneId = $("#zonSpan2").text().trim();
        if (name == 'mon') {
            callbackData.setDataName(data2.mon, monArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'tue') {
            callbackData.setDataName(data2.tue, tueArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'wed') {
            callbackData.setDataName(data2.wed, wedArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'tur') {
            callbackData.setDataName(data2.tur, turArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'fri') {
            callbackData.setDataName(data2.fri, friArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'sat') {
            callbackData.setDataName(data2.sat, satArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'sun') {
            callbackData.setDataName(data2.sun, sunArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        callbackData.setData(data2, name);

    }
    if (a == 3) {
        // zone id 저장.
        data3.zoneId = $("#zonSpan3").text().trim();
        if (name == 'mon') {
            callbackData.setDataName(data3.mon, monArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'tue') {
            callbackData.setDataName(data3.tue, tueArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'wed') {
            callbackData.setDataName(data3.wed, wedArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'tur') {
            callbackData.setDataName(data3.tur, turArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'fri') {
            callbackData.setDataName(data3.fri, friArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'sat') {
            callbackData.setDataName(data3.sat, satArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        if (name == 'sun') {
            callbackData.setDataName(data3.sun, sunArray);
            callbackData.setDataTime(time1, time2, time3);
        }
        callbackData.setData(data3, name);
    }
}

// oneday 시간 추가
function addOnedayTime(a, b) {
    if ($(a).css("display") == "none") {
        $(a).show();
    } else {
        $(b).show();
    }
}

// oneday 시간 삭제
function delOnedayTime(a, b) {
    if ($(b).css("display") != "none") {
        $(b).hide();
    }
    else if ($(a).css("display") != "none" && $(b).css("display") == "none") {
        onedayCheckData1.t3_start, onedayCheckData1.t3_end = '';
        $(a).hide();
    }
}

// oneday 내용 저장
function saveOneday(a) {
    var zoneid = '';
    var day1 = '';
    var day1Time = '';
    var day2 = '';
    var day2Time = '';
    var day3 = '';
    var day3Time = '';
    var text = '';
    // 1번 지역에서 실행될 코드
    if (a == 1) {
        if (onedayCheckData1.day1 == '' || onedayCheckData1.t1_start == '' || onedayCheckData1.t1_end == '') {
            swal("입력을 올바르게 해주세요", {
                icon: "warning"
            });
            return;
        }
        zoneid = $("#zoneA1").text().trim();        
        day1 = onedayCheckData1.day1;
        day1Time = onedayCheckData1.t1_start + "~" + onedayCheckData1.t1_end;
        day2 = onedayCheckData1.day2;
        day2Time = onedayCheckData1.t2_start + "~" + onedayCheckData1.t2_end;
        day3 = onedayCheckData1.day3;
        day3Time = onedayCheckData1.t3_start + "~" + onedayCheckData1.t3_end;

        text = zoneid + "\n" + day1 + " (" + day1Time + ")";

        if (day2 != '') {
            text += "\n" + day2 + " (" + day2Time + ")";
        }

        if (day3 != '') {
            text += "\n" + day3 + " (" + day3Time + ")";
        }
        swal({
            title: "저장 내용을 확인 해 주세요",
            text: text,
            icon: "info",
            buttons: true
        }).then(function (value) {
            if (value) {
                // 실제로 저장하기
                onedayData1.zoneid = zoneid;
                onedayData1.day1 = day1;
                onedayData1.day2 = day2;
                onedayData1.day3 = day3;
                onedayData1.t1 = day1Time;
                onedayData1.t2 = day2Time;
                onedayData1.t3 = day3Time;
                swal("성공적으로 저장 되었습니다.", {
                    icon: "success"
                });
            } else {
                swal("수정하신 후에 꼭 저장해주세요");
            }
        });
    }
    if (a == 2) {
        if (onedayCheckData2.day1 == '' || onedayCheckData2.t1_start == '' || onedayCheckData2.t1_end == '') {
            swal("입력을 올바르게 해주세요", {
                icon: "warning"
            });
            return;
        }
        zoneid = $("#zoneA2").text().trim();
        day1 = onedayCheckData2.day1;
        day1Time = onedayCheckData2.t1_start + "~" + onedayCheckData2.t1_end;
        day2 = onedayCheckData2.day2;
        day2Time = onedayCheckData2.t2_start + "~" + onedayCheckData2.t2_end;
        day3 = onedayCheckData2.day3;
        day3Time = onedayCheckData2.t3_start + "~" + onedayCheckData2.t3_end;

        text = zoneid + "\n" + day1 + " (" + day1Time + ")";

        if (day2 != '') {
            text += "\n" + day2 + " (" + day2Time + ")";
        }

        if (day3 != '') {
            text += "\n" + day3 + " (" + day3Time + ")";
        }
        swal({
            title: "저장 내용을 확인 해 주세요",
            text: text,
            icon: "info",
            buttons: true
        }).then(function (value) {
            if (value) {
                // 실제로 저장하기
                onedayData2.zoneid = zoneid;
                onedayData2.day1 = day1;
                onedayData2.day2 = day2;
                onedayData2.day3 = day3;
                onedayData2.t1 = day1Time;
                onedayData2.t2 = day2Time;
                onedayData2.t3 = day3Time;
                swal("성공적으로 저장 되었습니다.", {
                    icon: "success"
                });                
            } else {
                swal("수정하신 후에 꼭 저장해주세요");
            }
        });
    }
    if (a == 3) {
        if (onedayCheckData3.day1 == '' || onedayCheckData3.t1_start == '' || onedayCheckData3.t1_end == '') {
            swal("입력을 올바르게 해주세요", {
                icon: "warning"
            });
            return;
        }
        zoneid = $("#zoneA3").trim();
        day1 = onedayCheckData3.day1;
        day1Time = onedayCheckData3.t1_start + "~" + onedayCheckData3.t1_end;
        day2 = onedayCheckData3.day2;
        day2Time = onedayCheckData3.t2_start + "~" + onedayCheckData3.t2_end;
        day3 = onedayCheckData3.day3;
        day3Time = onedayCheckData3.t3_start + "~" + onedayCheckData3.t3_end;

        text = zoneid + "\n" + day1 + " (" + day1Time + ")";

        if (day2 != '') {
            text += "\n" + day2 + " (" + day2Time + ")";
        }

        if (day3 != '') {
            text += "\n" + day3 + " (" + day3Time + ")";
        }
        swal({
            title: "저장 내용을 확인 해 주세요",
            text: text,
            icon: "info",
            buttons: true
        }).then(function (value) {
            if (value) {
                // 실제로 저장하기
                onedayData3.zoneid = zoneid;
                onedayData3.day1 = day1;
                onedayData3.day2 = day2;
                onedayData3.day3 = day3;
                onedayData3.t1 = day1Time;
                onedayData3.t2 = day2Time;
                onedayData3.t3 = day3Time;
                swal("성공적으로 저장 되었습니다.", {
                    icon: "success"
                });
            } else {
                swal("수정하신 후에 꼭 저장해주세요");
            }
        });
    }
}

function deleteOneday(a) {

    if (a == 1) {
        swal({
            title: "정말 해당 지역을 삭제 하시겠습니까?",
            icon: "warning",
            buttons: true
        }).then(function (value) {
            if (value) {
                onedayData1.day1 = '';
                onedayData1.day2 = '';
                onedayData1.day3 = '';
                onedayData1.t1 = '';
                onedayData1.t2 = '';
                onedayData1.t3 = '';

                onedayReset(a);

                swal("성공적으로 삭제 되었습니다.", {
                    icon: "success"
                });
            } else {
                return;
            }
        });
    }

    if (a == 2) {
        swal({
            title: "정말 해당 지역을 삭제 하시겠습니까?",
            icon: "warning",
            buttons: true
        }).then(function (value) {
            if (value) {
                onedayData2.day1 = '';
                onedayData2.day2 = '';
                onedayData2.day3 = '';
                onedayData2.t1 = '';
                onedayData2.t2 = '';
                onedayData2.t3 = '';

                onedayReset(a);

                swal("성공적으로 삭제 되었습니다.", {
                    icon: "success"
                });
            } else {
                return;
            }
        });
    }

    if (a == 3) {
        swal({
            title: "정말 해당 지역을 삭제 하시겠습니까?",
            icon: "warning",
            buttons: true
        }).then(function (value) {
            if (value) {
                onedayData3.day1 = '';
                onedayData3.day2 = '';
                onedayData3.day3 = '';
                onedayData3.t1 = '';
                onedayData3.t2 = '';
                onedayData3.t3 = '';

                onedayReset(a);

                swal("성공적으로 삭제 되었습니다.", {
                    icon: "success"
                });
            } else {
                return;
            }
        });
    }
}

// oneday 항목 리셋
function onedayReset(a) {
    if (a == 1) {
        $(".oneday1").val('');
        $("#oneDayDiv1-1").hide();
        $("#oneDayDiv2-1").hide();
        $("#oneDayDiv3-1").hide();
        $("#zoneA1").hide();
        $("#zonSpan1").text('');
    }
    if (a == 2) {
        $(".oneday2").val('');
        $("#oneDayDiv1-2").hide();
        $("#oneDayDiv2-2").hide();
        $("#oneDayDiv3-2").hide();
        $("#zoneA2").hide();
        $("#zonSpan2").text('');
    }
    if (a == 3) {
        $(".oneday3").val('');
        $("#oneDayDiv1-3").hide();
        $("#oneDayDiv2-3").hide();
        $("#oneDayDiv3-3").hide();
        $("#zoneA3").hide();
        $("#zonSpan3").text('');
    }
}

// 이미지파일
function viewImg() {
    if ($("#talentImgView").css("display") == "none") {
        $("#talentImgView").css("display", "block");
        $("#viewImgBtn").val('사진 감추기');
        return;
    }
    if ($("#talentImgView").css("display") == "block") {
        $("#talentImgView").css("display", "none");
        $("#viewImgBtn").val('사진 미리보기');
    }
}

function test1() {
    alert($("#note_tutorinfo").val());
}

// 커리큘렴 추가
function addCurri() {
    var count = $("#checkCurriCount").val();
    var html = '';
    count++;
    $("#checkCurriCount").val(count);
    html += '<div id="curri'+count+'">';
    html += '<h4>'+count+'회차</h4>';
    html += '<input type="button" onclick="delCurri(\'curri'+count+'\')" class="btn btn-outline-primary" value="삭제">';
    html += '<textarea id="note_curri'+count+'"name="tc_curriculum" class="summer" required></textarea>';
    html += '</div>';
    $("#curriDiv").append(html);
    $("#note_curri"+count).summernote({
        height: 300,
        minheight: null,
        maxHeight: null
    });
}

// 커리큘럼 삭제
function delCurri(a) {
    var count  = $("#checkCurriCount").val();
    var thisCount = a.substr(5,1);
    // 삭제하려는 커리큘럼이 전체 커리큘럼 텍스트의 숫자 밑일경우 리턴
    if(thisCount != count){
        swal('마지막 커리큘럼의 내용 부터 삭제 해주세요',{
           icon:"warning"
        });
        return;
    }else{
        count --;
        $("#checkCurriCount").val(count);
        // 해당 div 삭제
        $("#"+a).remove();
    }


   /*
	 * var divId = "#"+a; if (a >= count) { $("#curri2").remove(); return; }
	 */
}


// 최종으로 보내기전에 체크 및 체크 완료시 ajax로 data전송
function lastSubmit(){
	alert('시작');
	// 원데이 인지 아닌지 여부 판단
	if(!$("#checkDayType").prop("checked")){// 해당 항목이 체크가 안되있으면 즉 원데이 항목이 아님,
		// 저장된 항목을 보낼 변수 작성
		var sendData ={'zone1':'','zone2':'','zone3':'','count':''};
		// 보낼 내용이 담겨져 있는지 확인
		if(data1.zoneId != ''){
			sendData.zone1 = data1;
			sendData.count = 1;
		}
		if(data2.zoneId != ''){
			sendData.zone2 = data2;
			sendData.count = 2;
		}
		if(data3.zoneId != ''){
			sendData.zone3 = data1;
			sendData.count = 3;
		}
		// 저장된 timeData controller로 내용 보내기
		var myHeaders = new Headers();
		myHeaders.append("Content-Type",
				"application/json;Charset=UTF-8");	
		fetch('/zest/tutorPage/talentPropTime', {
			method : 'POST',
			credentials : 'same-origin',
			headers : myHeaders,
			body : JSON.stringify(sendData)
		}).then(function(response) {
			if (!response.ok) {
				throw Error(response.statusText);
			}
			// 텍스트 기반으로 처리
			return response.text();
		}).then(function(text) {
			alert(text);		
			if(text == "success"){
				return true;
			}else{
				return false;
			}
		});
		
	}else{//원데이 항목 처리 
		var sendData ={'zone1':'','zone2':'','zone3':'','count':''};
		if(onedayData1.zoneid != ''){
			sendData.zone1 = onedayData1;
			sendData.count = 1;
		}
		if(onedayData2.zoneid != ''){
			sendData.zone2 = onedayData2;
			sendData.count = 2;
		}
		if(onedayData3.zoneid != ''){
			sendData.zone3 = onedayData3;
			sendData.count = 3;
		}
		alert(sendData.count);
		var myHeaders = new Headers();
		myHeaders.append("Content-Type",
				"application/json;Charset=UTF-8");	
		fetch('/zest/tutorPage/talentPropTime2', {
			method : 'POST',
			credentials : 'same-origin',
			headers : myHeaders,
			body : JSON.stringify(sendData)
		}).then(function(response) {
			if (!response.ok) {
				throw Error(response.statusText);
			}
			// 텍스트 기반으로 처리
			return response.text();
		}).then(function(text) {
			
			if(text == "success"){		
					return true;				
			}else{
				return false;
			}
		});
	}
}

$(document).ready(function () {

    // 이미지 슬라이드 기능
    $("#talentImg1").change(function () {
        var imgFile = document.querySelector('#talentImg1');
        var maxSize = 2 * 1024 * 1024; // 2M
        var fileSize = 0;

        fileSize = imgFile.files.size;
        // 내용을 빼었을시
            $("#Img1").remove();
     
        // 사이즈 체크
        if (fileSize > maxSize) {
            swal("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
            return;
        }

        var fileList = imgFile.files;
        // 읽기
        var reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            // 해당 이미지 슬라이쇼 추가
            html = '';
            html += '<div class="carousel-item active" id="Img1">';
            html += '<img class="d-block w-100" src="' + reader.result + '">';
            html += '</div>';
            $("#imgInner").append(html);
        }
    });
    $("#talentImg2").change(function () {
        var imgFile = document.querySelector('#talentImg2');
        var maxSize = 2 * 1024 * 1024; // 2M
        var fileSize = 0;
        fileSize = imgFile.files.size;
        if (imgFile.files.length == 0) {
            $("#Img2").remove();
        }
        // 사이즈 체크
        if (fileSize > maxSize) {
            swal("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
            return;
        }

        var fileList = imgFile.files;
        // 읽기
        var reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            // 해당 이미지 슬라이쇼 추가
            html = '';
            html += '<div class="carousel-item" id="Img2">';
            html += '<img class="d-block w-100" src="' + reader.result + '">';
            html += '</div>';
            $("#imgInner").append(html);
        }
    });
    $("#talentImg3").change(function () {
        var imgFile = document.querySelector('#talentImg3');
        var maxSize = 2 * 1024 * 1024; // 2M
        var fileSize = 0;
        fileSize = imgFile.files.size;
        if (imgFile.files.length == 0) {
            $("#Img3").remove();
        }
        // 사이즈 체크
        if (fileSize > maxSize) {
            swal("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
            return;
        }

        var fileList = imgFile.files;
        // 읽기
        var reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            // 해당 이미지 슬라이쇼 추가
            html = '';
            html += '<div class="carousel-item" id="Img3">';
            html += '<img class="d-block w-100" src="' + reader.result + '">';
            html += '</div>';
            $("#imgInner").append(html);
        }
    });
    $("#talentImg4").change(function () {
        var imgFile = document.querySelector('#talentImg4');
        var maxSize = 2 * 1024 * 1024; // 2M
        var fileSize = 0;
        fileSize = imgFile.files.size;
        if (imgFile.files.length == 0) {
            $("#Img4").remove();
        }
        // 사이즈 체크
        if (fileSize > maxSize) {
            swal("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
            return;
        }

        var fileList = imgFile.files;
        // 읽기
        var reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            // 해당 이미지 슬라이쇼 추가
            html = '';
            html += '<div class="carousel-item" id="Img4">';
            html += '<img class="d-block w-100" src="' + reader.result + '">';
            html += '</div>';
            $("#imgInner").append(html);
        }
    });
    $("#talentImg5").change(function () {
        var imgFile = document.querySelector('#talentImg5');
        var maxSize = 2 * 1024 * 1024; // 2M
        var fileSize = 0;
        fileSize = imgFile.files.size;
        if (imgFile.files.length == 0) {
            $("#Img5").remove();
        }
        // 사이즈 체크
        if (fileSize > maxSize) {
            swal("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
            return;
        }

        var fileList = imgFile.files;
        // 읽기
        var reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            // 해당 이미지 슬라이쇼 추가
            html = '';
            html += '<div class="carousel-item" id="Img5">';
            html += '<img class="d-block w-100" src="' + reader.result + '">';
            html += '</div>';
            $("#imgInner").append(html);
        }
    });
    $("#talentImg6").change(function () {
        var imgFile = document.querySelector('#talentImg6');
        var maxSize = 2 * 1024 * 1024; // 2M
        var fileSize = 0;
        fileSize = imgFile.files.size;
        if (imgFile.files.length == 0) {
            $("#Img6").remove();
        }
        // 사이즈 체크
        if (fileSize > maxSize) {
            swal("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
            return;
        }

        var fileList = imgFile.files;
        // 읽기
        var reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            // 해당 이미지 슬라이쇼 추가
            html = '';
            html += '<div class="carousel-item" id="Img6">';
            html += '<img class="d-block w-100" src="' + reader.result + '">';
            html += '</div>';
            $("#imgInner").append(html);
        }
    });
    $("#talentImg7").change(function () {
        var imgFile = document.querySelector('#talentImg7');
        var maxSize = 2 * 1024 * 1024; // 2M
        var fileSize = 0;
        fileSize = imgFile.files.size;
        if (imgFile.files.length == 0) {
            $("#Img7").remove();
        }
        // 사이즈 체크
        if (fileSize > maxSize) {
            swal("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
            return;
        }

        var fileList = imgFile.files;
        // 읽기
        var reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            // 해당 이미지 슬라이쇼 추가
            html = '';
            html += '<div class="carousel-item" id="Img7">';
            html += '<img class="d-block w-100" src="' + reader.result + '">';
            html += '</div>';
            $("#imgInner").append(html);
        }
    });
    $("#talentImg8").change(function () {
        var imgFile = document.querySelector('#talentImg8');
        var maxSize = 2 * 1024 * 1024; // 2M
        var fileSize = 0;
        fileSize = imgFile.files.size;
        if (imgFile.files.length == 0) {
            $("#Img8").remove();
        }
        // 사이즈 체크
        if (fileSize > maxSize) {
            swal("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
            return;
        }

        var fileList = imgFile.files;
        // 읽기
        var reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            // 해당 이미지 슬라이쇼 추가
            html = '';
            html += '<div class="carousel-item" id="Img8">';
            html += '<img class="d-block w-100" src="' + reader.result + '">';
            html += '</div>';
            $("#imgInner").append(html);
        }
    });
    $("#talentImg9").change(function () {
        var imgFile = document.querySelector('#talentImg9');
        var maxSize = 2 * 1024 * 1024; // 2M
        var fileSize = 0;
        fileSize = imgFile.files.size;
        if (imgFile.files.length == 0) {
            $("#Img9").remove();
        }
        // 사이즈 체크
        if (fileSize > maxSize) {
            swal("첨부파일 사이즈는 2MB 이내로 등록 가능합니다.");
            return;
        }

        var fileList = imgFile.files;
        // 읽기
        var reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            // 해당 이미지 슬라이쇼 추가
            html = '';
            html += '<div class="carousel-item" id="Img9">';
            html += '<img class="d-block w-100" src="' + reader.result + '">';
            html += '</div>';
            $("#imgInner").append(html);
        }
    });

    // 시간가격체크
    $("#price").change(function () {
        var regexp = /^[0-9]*$/;
        price = $("#price").val();
        if (!regexp.test(price)) {
            swal('숫자만 입력해주세요', {
                icon: "warning"
            });
            $("#price").focus();
            $("#price").val('');
            return;
        }
    });

    // oneDay 인지 아닌지 체크 항목
    $("#checkDayType").change(function () {
        if ($(this).prop("checked")) {// 체크 되었을시
            $(".oneDayDiv").show();
            $(".notOnedayDiv").hide();
            //alert(onedayData1.zoneid + "/" + onedayData1.day1 + "/" + onedayData1.day2 + "/" + onedayData1.day3 + "/" + onedayData1.t1 + "/" + onedayData1.t2 + "/" + onedayData1.t3);
            //alert(onedayData2.zoneid + "/" + onedayData2.day1 + "/" + onedayData2.day2 + "/" + onedayData2.day3 + "/" + onedayData2.t1 + "/" + onedayData2.t2 + "/" + onedayData2.t3);
            //alert(onedayData3.zoneid + "/" + onedayData3.day1 + "/" + onedayData3.day2 + "/" + onedayData3.day3 + "/" + onedayData3.t1 + "/" + onedayData3.t2 + "/" + onedayData3.t3);
        } else {// 체크가 안되있을시
            $(".notOnedayDiv").show();
            $(".oneDayDiv").hide();
        }
    });
    // 각 요일에대한 값 저장 및 체크
    $("#montime02").change(function () {
        var s1 = 'montime01';
        var s2 = 'montime02';
        if (timeCheck(s1, s2) == false) {
            return;
        }
        var insertDate = $("#montime01").val() + "~" + $("#montime02").val();
        $("#monTime1").val(insertDate);
        alert($("#monTime1").val());
    });
    $("#tuetime02").change(function () {
        var s1 = 'tuetime01';
        var s2 = 'tuetime02';
        if (timeCheck(s1, s2) == false) {
            return;
        }
        var insertDate = $("#tuetime01").val() + "~" + $("#tuetime02").val();
        $("#tueTime1").val(insertDate);
        alert($("#tueTime1").val());
    });
    $("#wedtime02").change(function () {
        var s1 = 'wedtime01';
        var s2 = 'wedtime02';
        if (timeCheck(s1, s2) == false) {
            return;
        }
        var insertDate = $("#wedtime01").val() + "~" + $("#wedtime02").val();
        $("#wedTime1").val(insertDate);
        alert($("#wedTime1").val());
    });
    $("#turtime02").change(function () {
        var s1 = 'turtime01';
        var s2 = 'turtime02';
        if (timeCheck(s1, s2) == false) {
            return;
        }
        var insertDate = $("#turtime01").val() + "~" + $("#turtime02").val();
        $("#turTime1").val(insertDate);
        alert($("#turTime1").val());
    });
    $("#fritime02").change(function () {
        var s1 = 'fritime01';
        var s2 = 'fritime02';
        if (timeCheck(s1, s2) == false) {
            return;
        }
        var insertDate = $("#fritime01").val() + "~" + $("#fritime02").val();
        $("#friTime1").val(insertDate);
        alert($("#friTime1").val());
    });
    $("#sattime02").change(function () {
        var s1 = 'sattime01';
        var s2 = 'sattime02';
        if (timeCheck(s1, s2) == false) {
            return;
        }
        var insertDate = $("#sattime01").val() + "~" + $("#sattime02").val();
        $("#satTime1").val(insertDate);
        alert($("#satTime1").val());
    });
    $("#suntime02").change(function () {
        var s1 = 'suntime01';
        var s2 = 'suntime02';
        if (timeCheck(s1, s2) == false) {
            return;
        }
        var insertDate = $("#suntime01").val() + "~" + $("#suntime02").val();
        $("#sunTime1").val(insertDate);
        alert($("#sunTime1").val());
    });


    // datePicker - zone 1
    createDatePicker($("#ondDayDate1-1"));
    createDatePicker($("#ondDayDate2-1"));
    createDatePicker($("#ondDayDate3-1"));
    // datePicker - zone 2
    createDatePicker($("#ondDayDate1-2"));
    createDatePicker($("#ondDayDate2-2"));
    createDatePicker($("#ondDayDate3-2"));
    // datePicker - zone 3
    createDatePicker($("#ondDayDate1-3"));
    createDatePicker($("#ondDayDate2-3"));
    createDatePicker($("#ondDayDate3-3"));

    // timePicker - zone 1
    $("#oneDayTime1_1-1").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData1.t1_start = time.getHours();
        }

    });
    $("#oneDayTime1_2-1").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData1.t1_end = time.getHours();
            // 시간이 올바르지 않을때 설정항목
            if (!checkTime(onedayCheckData1.t1_start, onedayCheckData1.t1_end, this)) {
            }
        }
    });
    $("#oneDayTime2_1-1").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData1.t2_start = time.getHours();
            if (!checkDay(onedayCheckData1.day1, onedayCheckData1.day2, onedayCheckData1.day3, this)) ;
        }

    });
    $("#oneDayTime2_2-1").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData1.t2_end = time.getHours();
            // 시간이 올바르지 않을때 설정항목
            if (!checkTime(onedayCheckData1.t2_start, onedayCheckData1.t2_end, this)) {
            }
        }
    });
    $("#oneDayTime3_1-1").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData1.t3_start = time.getHours();
            if (!checkDay(onedayCheckData1.day1, onedayCheckData1.day2, onedayCheckData1.day3, this)) ;
        }

    });
    $("#oneDayTime3_2-1").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData1.t3_end = time.getHours();
            // 시간이 올바르지 않을때 설정항목
            if (!checkTime(onedayCheckData1.t3_start, onedayCheckData1.t3_end, this)) {
            }
        }
    });

    // timePicker - zone 2
    $("#oneDayTime1_1-2").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData2.t1_start = time.getHours();
        }

    });
    $("#oneDayTime1_2-2").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData2.t1_end = time.getHours();
            // 시간이 올바르지 않을때 설정항목
            if (!checkTime(onedayCheckData2.t1_start, onedayCheckData2.t1_end, this)) {
            }
        }
    });
    $("#oneDayTime2_1-2").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData2.t2_start = time.getHours();
            if (!checkDay(onedayCheckData2.day1, onedayCheckData2.day2, onedayCheckData2.day3, this)) ;
        }

    });
    $("#oneDayTime2_2-2").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData2.t2_end = time.getHours();
            // 시간이 올바르지 않을때 설정항목
            if (!checkTime(onedayCheckData2.t2_start, onedayCheckData2.t2_end, this)) {
            }
        }
    });
    $("#oneDayTime3_1-2").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData2.t3_start = time.getHours();
            if (!checkDay(onedayCheckData2.day1, onedayCheckData2.day2, onedayCheckData2.day3, this)) ;
        }

    });
    $("#oneDayTime3_2-2").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData2.t3_end = time.getHours();
            // 시간이 올바르지 않을때 설정항목
            if (!checkTime(onedayCheckData2.t3_start, onedayCheckData2.t3_end, this)) {
            }
        }
    });

    // timePicker - zone 3
    $("#oneDayTime1_1-3").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData3.t1_start = time.getHours();
        }

    });
    $("#oneDayTime1_2-3").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData3.t1_end = time.getHours();
            // 시간이 올바르지 않을때 설정항목
            if (!checkTime(onedayCheckData3.t1_start, onedayCheckData3.t1_end, this)) {
            }
        }
    });
    $("#oneDayTime2_1-3").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData3.t2_start = time.getHours();
            if (!checkDay(onedayCheckData3.day1, onedayCheckData3.day2, onedayCheckData3.day3, this)) ;
        }

    });
    $("#oneDayTime2_2-3").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData3.t2_end = time.getHours();
            // 시간이 올바르지 않을때 설정항목
            if (!checkTime(onedayCheckData3.t2_start, onedayCheckData3.t2_end, this)) {
            }
        }
    });
    $("#oneDayTime3_1-3").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData3.t3_start = time.getHours();
            if (!checkDay(onedayCheckData3.day1, onedayCheckData3.day2, onedayCheckData3.day3, this)) ;
        }

    });
    $("#oneDayTime3_2-3").timepicker({
        startTime: new Date(0, 0, 0, 06, 0, 0),
        interval: 60,
        change: function (time) {
            onedayCheckData3.t3_end = time.getHours();
            // 시간이 올바르지 않을때 설정항목
            if (!checkTime(onedayCheckData3.t3_start, onedayCheckData3.t3_end, this)) {
            }
        }
    });

    // 섬머노트
    $(".summer").summernote({
        height: 300,
        minheight: null,
        maxHeight: null
    });

    // 지도
    var mapDiv = document.getElementById('map');
    map = new naver.maps.Map(mapDiv);

});

