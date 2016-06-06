<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>	2,계절
<script type="text/javascript">
  google.charts.load("current", {packages:["corechart"]});
  google.charts.setOnLoadCallback(drawChart);
  
  function drawChart() {
    var data = google.visualization.arrayToDataTable([
      ['Task', 'Hours per Day'],
      
      <c:forEach var="vo" items="${slist}">    
      ['<c:out value="${vo.season}"/>',<c:out value="${vo.count}"/>],
      </c:forEach>
      
    ]);
      
    var options = {
      title: 'My Daily Activities',
      is3D: true,
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
    chart.draw(data, options);
  }
</script> -->

<script src="http://www.amcharts.com/lib/3/amcharts.js"></script>	<!-- 1,지역 -->
<script src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript">
var chart;
var graph;

var chartData = [
<c:forEach var="vo" items="${slist}">        
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
valueAxis.maximum = 30;
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

// Germany graph
var graph = new AmCharts.AmGraph();
graph.title = "Botev Plovdiv";
graph.valueField = "Botev Plovdiv";
graph.balloonText = "place taken by Botev Plovdiv in [[category]]: [[value]]";
graph.bullet = "round";
chart.addGraph(graph);

// United Kingdom graph
var graph = new AmCharts.AmGraph();
graph.title = "The Draw";
graph.valueField = "The Draw";
graph.balloonText = "place taken by The Draw in [[category]]: [[value]]";
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
chart.write("container");
});

</script> 



</head>
<body>
<div id="container" style="width:100%; height:400px;"></div> <!-- 1.지역 -->  
	 <!-- <div id="piechart_3d" style="width:300px;height:300px;"></div>   -->
	<%--  <ul>
		<c:forEach var="vo" items="${slist}">  
			<p>${vo.season }</p>
			<P>hi</P>
		</c:forEach>
	</ul>  --%>

</body>
</html>