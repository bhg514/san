<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  media="screen" href="assets/css/who.css">
<!-- 누구와 스타일 -->
<style>
      * {
  box-sizing: border-box;
}

/* :root {
  margin: 2rem auto;
  width: 50%;
  text-align: center;
} */

.avatar-container {
  position: relative;
  display: block;
  border-radius: 50%;
  overflow: hidden;
  height: 130px;
  width: 130px;
  padding: 0;
  margin: 1rem auto;
  border: none;
  background: #efefef;
  cursor: pointer;
}
.avatar-container .avatar {
  display: block;
  margin: 15px;
  border-radius: 50%;
  width: 100px;
  height: 100px;
  overflow: hidden;
  z-index: 100;
}
.avatar-container .avatar img {
  width: 100%;
  height: auto;
}
.avatar-container .info {
  display: none;
  font-weight: bold;
  font-size: 2rem;
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 187, 255, 0.2);
  color: white;
  z-index: 1000;
}
.avatar-container .info.js-active {
  display: table;
}
.avatar-container .info .info-inner {
  display: table-cell;
  text-align: center;
  vertical-align: middle;
}

/**
* Function to generate procentual progress classes 
* .p-1 1% -> p-100 100%
**/
.p-1 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(93.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-2 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(97.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-3 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(100.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-4 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(104.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-5 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(108deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-6 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(111.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-7 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(115.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-8 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(118.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-9 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(122.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-10 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(126deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-11 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(129.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-12 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(133.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-13 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(136.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-14 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(140.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-15 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(144deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-16 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(147.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-17 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(151.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-18 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(154.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-19 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(158.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-20 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(162deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-21 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(165.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-22 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(169.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-23 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(172.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-24 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(176.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-25 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(180deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-26 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(183.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-27 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(187.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-28 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(190.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-29 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(194.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-30 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(198deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-31 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(201.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-32 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(205.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-33 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(208.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-34 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(212.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-35 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(216deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-36 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(219.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-37 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(223.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-38 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(226.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-39 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(230.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-40 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(234deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-41 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(237.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-42 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(241.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-43 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(244.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-44 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(248.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-45 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(252deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-46 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(255.6deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-47 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(259.2deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-48 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(262.8deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-49 {
  background-image: linear-gradient(90deg, #efefef 50%, transparent 50%, transparent), linear-gradient(266.4deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-50 {
  background-image: linear-gradient(-90deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-51 {
  background-image: linear-gradient(-86.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-52 {
  background-image: linear-gradient(-82.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-53 {
  background-image: linear-gradient(-79.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-54 {
  background-image: linear-gradient(-75.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-55 {
  background-image: linear-gradient(-72deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-56 {
  background-image: linear-gradient(-68.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-57 {
  background-image: linear-gradient(-64.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-58 {
  background-image: linear-gradient(-61.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-59 {
  background-image: linear-gradient(-57.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-60 {
  background-image: linear-gradient(-54deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-61 {
  background-image: linear-gradient(-50.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-62 {
  background-image: linear-gradient(-46.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-63 {
  background-image: linear-gradient(-43.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-64 {
  background-image: linear-gradient(-39.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-65 {
  background-image: linear-gradient(-36deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-66 {
  background-image: linear-gradient(-32.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-67 {
  background-image: linear-gradient(-28.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-68 {
  background-image: linear-gradient(-25.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-69 {
  background-image: linear-gradient(-21.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-70 {
  background-image: linear-gradient(-18deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-71 {
  background-image: linear-gradient(-14.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-72 {
  background-image: linear-gradient(-10.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-73 {
  background-image: linear-gradient(-7.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-74 {
  background-image: linear-gradient(-3.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-75 {
  background-image: linear-gradient(0deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-76 {
  background-image: linear-gradient(3.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-77 {
  background-image: linear-gradient(7.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-78 {
  background-image: linear-gradient(10.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-79 {
  background-image: linear-gradient(14.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-80 {
  background-image: linear-gradient(18deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-81 {
  background-image: linear-gradient(21.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-82 {
  background-image: linear-gradient(25.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-83 {
  background-image: linear-gradient(28.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-84 {
  background-image: linear-gradient(32.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-85 {
  background-image: linear-gradient(36deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-86 {
  background-image: linear-gradient(39.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-87 {
  background-image: linear-gradient(43.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-88 {
  background-image: linear-gradient(46.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-89 {
  background-image: linear-gradient(50.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-90 {
  background-image: linear-gradient(54deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-91 {
  background-image: linear-gradient(57.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-92 {
  background-image: linear-gradient(61.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-93 {
  background-image: linear-gradient(64.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-94 {
  background-image: linear-gradient(68.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-95 {
  background-image: linear-gradient(72deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-96 {
  background-image: linear-gradient(75.6deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-97 {
  background-image: linear-gradient(79.2deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-98 {
  background-image: linear-gradient(82.8deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-99 {
  background-image: linear-gradient(86.4deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}

.p-100 {
  background-image: linear-gradient(90deg, #0BF 50%, transparent 50%, transparent), linear-gradient(270deg, #0BF 50%, #efefef 50%, #efefef);
}
</style>

<!-- 스타일 -->



<script src="http://www.amcharts.com/lib/3/amcharts.js"></script>

<!-- 1.계절             ---------------------------------------------------------------------->
<script type="text/javascript" src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/themes/none.js"></script>
<script type="text/javascript">
var chart;
var graph;

var chartData = [
<c:forEach var="vo" items="${seasonlist}">        
{
'date': '<c:out value="${vo.season}"/>',
'검색수': <c:out value="${vo.count}"/>,
'Botev Plovdiv': 2.9,
'The Draw': 3.55
},
</c:forEach>
];

AmCharts.ready(function () {
// SERIAL CHART
chart = new AmCharts.AmSerialChart();
chart.dataProvider = chartData;
chart.categoryField = "date";
chart.startDuration = 0.5;
chart.balloon.color = "#000000";

// AXES
// category
var categoryAxis = chart.categoryAxis;
categoryAxis.fillAlpha = 1;
categoryAxis.fillColor = "#FAFAFA";
categoryAxis.gridAlpha = 0;
categoryAxis.axisAlpha = 0;
categoryAxis.gridPosition = "start";

// value
var valueAxis = new AmCharts.ValueAxis();
valueAxis.title = "Average Prices";
valueAxis.dashLength = 5;
valueAxis.axisAlpha = 0;
valueAxis.minimum = 1;
valueAxis.maximum = 40;
valueAxis.gridCount = 10;
chart.addValueAxis(valueAxis);

// GRAPHS
// Italy graph						            		
var graph = new AmCharts.AmGraph();
graph.title = "검색수";
graph.valueField = "검색수";
graph.balloonText = "place taken by Cherno More in [[category]]: [[value]]";
graph.bullet = "round";
chart.addGraph(graph);

// CURSOR
var chartCursor = new AmCharts.ChartCursor();
chartCursor.cursorPosition = "mouse";
chartCursor.zoomable = false;
chartCursor.cursorAlpha = 0;
chart.addChartCursor(chartCursor);                

// LEGEND
var legend = new AmCharts.AmLegend();
legend.useGraphSettings = true;
chart.addLegend(legend);

// WRITE
chart.write("localSanDetail_season");
});

</script> 

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<!-- 2.요일               ---------------------------------------------------------------------->
<script type="text/javascript">
$('.avatar-container').on('click',function(){
	  
	  if ($(this).find('.info').length <= 0) {
	    $(this).append('<div class="info"><div class="info-inner"></div></div>');
	  }
	  
	  var $info = $(this).find('.info'),
	      $inner= $(this).find('.info-inner'),
	      $p    = $(this).attr("class").match(/p-\w+/).toString().substring(2);
	  
	  $inner.text($p+'%');
	  $info.toggleClass('js-active');
	});
</script>
      
</head>

<body>

					<div class="col-md-5 col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">계절분석</div>
							<div class="panel-body">
							
							<!-- 1. 계절 -->
							<div id="localSanDetail_season" style="width:400px; height:400px;"></div>
							
							</div>
						</div>
					</div>
					
					<div class="col-md-5 col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">요일분석</div>
							<div class="panel-body">
							
								<!-- 2.요일 -->
								
								   
							</div>
						</div>
					</div>    
	
					
					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">누구랑</div>
							<div class="panel-body">
							
							<div class="avatar-container p-36" >
								  <img src="https://s3.amazonaws.com/uifaces/faces/twitter/_shahedk/128.jpg" alt="" class="avatar"/>
								</div><!--.avatar-container-->
								
								<div class="avatar-container p-12">
								  <img src="https://s3.amazonaws.com/uifaces/faces/twitter/mattchevy/128.jpg" alt="" class="avatar"/>
								</div><!--.avatar-container-->
								
								<div class="avatar-container p-78">
								  <img src="https://s3.amazonaws.com/uifaces/faces/twitter/soffes/128.jpg" alt="" class="avatar"/>
								</div><!--.avatar-container-->
							</div>
						</div>
					</div>

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">언제?</div>
							<div class="panel-body"></div>
						</div>
					</div>
					
				<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        			<script src="js/index.js"></script>
	
</body>
</html>