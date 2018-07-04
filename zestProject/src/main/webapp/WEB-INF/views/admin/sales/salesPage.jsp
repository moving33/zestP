<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta name="viewport" content="width=device-width, initial-scale = 1.0" />
<html>
<head>
<title>$Title$</title>


<link href="/zest/css/admin/zest_admin.css" rel="stylesheet">
<link href="/zest/css/bootstrap.css" rel="stylesheet">

<!-- 차트 -->
<link rel="stylesheet" href="/zest/css/style.css" type="text/css">
<script src="/zest/js/chart/amcharts.js" type="text/javascript"></script>
<script src="/zest/js/chart/pie.js" type="text/javascript"></script>


<!-- 차트 끝 -->

</head>
<body class="fix-header fix-sidebar" style="font-size: 18px;">
	<%--전체--%>
	<div id="main-wrapper">
		<%--Header header--%>
		<div class="header">
			<div class="header is_J"
				style="position: fixed; top: 0px; width: 1500px;">
				<nav class="navbar top-navbar navbar-expend-md navbar-light">
					<%--Logo--%>
					<div class="navbar-header">
						<%--헤더로고 넣기--%>
						<a></a>
					</div>
					<%--로그 오른쪽부분 --%>
					<div class="navbar-collapse" style="font-size: 18px;">
						관리자 <b style="color: #ff7200;">${admin.name}</b>님
						환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/zest/admin/logout"
							style="float: right;">로그아웃</a>
					</div>
				</nav>
			</div>
		</div>
		<div
			style="position: relative; width: 1663px; height: 60px; display: block; vertical-align: baseline; float: none;"></div>

		<%--leftsidebar navigation--%>
		<jsp:include page="../leftSideBar.jsp"></jsp:include>
		<%--end left sidebar--%>
		<div class="page-wrapper" style="min-height: 824px;">
			<%--low title--%>
			<div class="row page-titles" style="margin: 0">
				<div class="col-md-5 align-self-center">
					<%--타이틀이 들어가는 영역--%>
					<h3 class="text-primary" style="color: #000000 !important;">매출현황</h3>
				</div>
			</div>
			<br>

			<div>
				<h5>카테고리별 매출 금액</h5>
				<br>
				<!-- 차트 -->
				<div id="chartdiv" style="width: 800px; height: 500px; float: left;"></div>
				<!-- 차트 끝 -->
				<div style="float: left; width: 300px;">
					<table class="table">
						<tr>
							<td>카테고리</td>
							<td style="color:red;">매출</td>
						</tr>
						<tr>
							<td>뷰티</td>
							<td>
								<p id="td0">${model.count0}</p>
							</td>
						</tr>
						<tr>
							<td>실무</td>
							<td>
								<p id="td1">${model.count1}</p>
							</td>
						</tr>
						<tr>
							<td>디자인</td>
							<td>
								<p id="td2">${model.count2}</p>
							</td>
						</tr>
						<tr>
							<td>요리/음식</td>
							<td>
								<p id="td3">${model.count3}</p>
							</td>
						</tr>
						<tr>
							<td>외국어</td>
							<td>
								<p id="td4">${model.count4}</p>
							</td>
						</tr>
						<tr>
							<td>라이프스타일</td>
							<td>
								<p id="td5">${model.count5}</p>
							</td>
						</tr>
						<tr>
							<td>뮤직</td>
							<td>
								<p id="td6">${model.count6}</p>
							</td>
						</tr>
						<tr>
							<td>프로그래밍</td>
							<td>
								<p id="td7">${model.count7}</p>
							</td>
						</tr>
						<tr>
							<td>스포츠</td>
							<td>
								<p id="td8">${model.count8}</p>
							</td>
						</tr>
						<tr>
							<td>총</td>
							<td>${model.sum }원</td>
						</tr>
					</table>
				</div>
			</div>

		</div>
	</div>


	<script src="/zest/js/jquery.min.js"></script>
	<script src="/zest/js/bootstrap.bundle.min.js"></script>
	<script src="/zest/js/popper.js"></script>
	<script src="/zest/js/admin/tutorPropPage.js"></script>

	<script>
	var chart;

    var chartData = [{
        "category": "뷰티",
        "litres": $("#td0").html(),
        "pattern": {
            "url": "patterns/black/pattern1.png",
            "width": 4,
            "height": 4,
            "color": "#FF0F00"
        }
    }, {
        "category": "실무",
        "litres": $("#td1").html(),
        "pattern": {
            "url": "patterns/black/pattern2.png",
            "width": 4,
            "height": 4,
            "color": "#FF6600"
        }
    }, {
        "category": "디자인",
        "litres": $("#td2").html(),
        "pattern": {
            "url": "patterns/black/pattern3.png",
            "width": 4,
            "height": 4,
            "color": "#FF9E01"
        }
    }, {
        "category": "요리/음식",
        "litres": $("#td3").html(),
        "pattern": {
            "url": "patterns/black/pattern4.png",
            "width": 4,
            "height": 4,
            "color": "#FCD202"
        }
    }, {
        "category": "외국어",
        "litres": $("#td4").html(),
        "pattern": {
            "url": "patterns/black/pattern5.png",
            "width": 4,
            "height": 4,
            "color": "#F8FF01"
        }
    }, {
        "category": "라이프스타일",
        "litres": $("#td5").html(),
        "pattern": {
            "url": "patterns/black/pattern6.png",
            "width": 4,
            "height": 4,
            "color": "#B0DE09"
        }
    }, {
        "category": "뮤직",
        "litres": $("#td6").html(),
        "pattern": {
            "url": "patterns/black/pattern7.png",
            "width": 4,
            "height": 4,
            "color": "#04D215"
        }
    }, {
        "category": "프로그래밍",
        "litres": $("#td7").html(),
        "pattern": {
            "url": "patterns/black/pattern7.png",
            "width": 4,
            "height": 4,
            "color": "#0D8ECF"
        }
    }, {
        "category": "스포츠",
        "litres": $("#td8").html(),
        "pattern": {
            "url": "patterns/black/pattern7.png",
            "width": 4,
            "height": 4,
            "color": "#0D52D1"
        }
    }];

    AmCharts.ready(function() {
        // PIE CHART
        chart = new AmCharts.AmPieChart();
		
     	// title of the chart
		chart.addTitle("카테고리별 매출 현황", 19);
        chart.dataProvider = chartData;
        chart.titleField = "category";
        chart.valueField = "litres";
        chart.patternField = "pattern";
        chart.outlineColor = "#000000";
        chart.outlineAlpha = 0.6;
        chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
		
     	 var legend = new AmCharts.AmLegend();
        legend.markerBorderColor = "#000000";
        legend.switchType = undefined;
        legend.align = "center";
        chart.addLegend(legend);

        // WRITE
        chart.write("chartdiv");
    });
         
</script>
</body>
</html>
