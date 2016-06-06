<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="http://www.amcharts.com/lib/3/amcharts.js"></script>	<!-- 1,지역 -->
<script src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript">
var chart;
var graph;

var chartData = [
<c:forEach var="vo" items="${local}">        
{
'date': '<c:out value="${vo.local}"/>',
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


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>	<!-- 2,계절 -->
<script type="text/javascript">
  google.charts.load("current", {packages:["corechart"]});
  google.charts.setOnLoadCallback(drawChart);
  
  function drawChart() {
    var data = google.visualization.arrayToDataTable([
      ['Task', 'Hours per Day'],
      
      <c:forEach var="vo" items="${season}">    
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
  
  
  
   // feel-js
  $(function(){
  	  $('#feelGraph').radarChart({
      size: [500, 400],
      step: 1,
      values: <%=request.getAttribute("weekData") %>
        /* "월요일": 4.1,
        "화요일": 4.1,
        "수요일": 4.1,
        "목요일": 4.1,
        "금요일": 6.1,
        "토요일": 5.1,
        "일요일": 3.1, */
        
      ,
      showAxisLabels: true
    });
  });

  (function($) {
    
    var Radar = (function() {
      
      function Radar(ele, settings) {
        this.ele = ele;
        this.settings = $.extend({
          showAxisLabels: false,
          step: 1,
          size: [300,300],
          values: {},
          color: [0,128,255]
        },settings);
        this.width = settings.size[0];
        this.height = settings.size[1];
        $(ele).css({
          'position': 'relative',
          'width': this.width,
          'height': this.height
        });
        this.canvases = {};
        this.draw();
      }
      
      Radar.prototype.newCanvas = function(name, delay) {
        var delay = delay || 0;
        var canvas = document.createElement('canvas');
        canvas.width = this.width;
        canvas.height = this.height;
        $(canvas).css({
          'position': 'absolute'
        });
        this.canvases[name] = canvas;
        this.ele.appendChild(canvas);
        this.cxt = canvas.getContext('2d');
        if (delay != 0) {
          $(canvas).css('opacity',0).delay(delay).animate({opacity: 1}, 500);
        }
      }
      
      Radar.prototype.draw = function() {
        this.newCanvas('axis', 100);
        var min = 0;
        var max = 0;
        
        $.each(this.settings.values, function(i,val){
          if (val < min)
            min = val;
          if (val > max)
            max = val;
        });
        
        min = Math.floor(min);
        max = Math.ceil(max);

        var spacing = 20;
        
        for(var i = min; i <= max; i += this.settings.step) {
          this.cxt.beginPath();
          this.cxt.arc(this.width/2,
                       this.height/2,
                       this.settings.step * spacing * i,
                       0, 2 * Math.PI, false);
          this.cxt.strokeStyle = "#666";
          this.cxt.fillStyle = "#444";
          this.cxt.stroke();
          if (this.settings.showAxisLabels)
            this.cxt.fillText(i,this.width/2 + this.settings.step * spacing * i+4, this.height/2-2);
        }
        
        var size = 0;
        for(var key in this.settings.values)
          size += 1;
        
        for(var i = 0; i < size; i += 1) {
          this.cxt.beginPath();
          this.cxt.moveTo(this.width / 2, this.height /2);
          var x = this.width / 2 + Math.cos((Math.PI * 2) * (i / size)) * spacing * max;
          var y = this.height /2 + Math.sin((Math.PI * 2) * (i / size)) * spacing * max;
          this.cxt.lineTo(x, y);
          this.cxt.stroke();
        }
        
        this.newCanvas('part',200);
        
        this.cxt.beginPath();
        var first = true;
        var i = 0;
        var that = this;
        var end = {x: null, y: null};
        $.each(this.settings.values, function(key,val){
          var x = that.width / 2 + Math.cos((Math.PI * 2) * (i / size)) * spacing * val;
          var y = that.height / 2 + Math.sin((Math.PI * 2) * (i / size)) * spacing * val;
          if (first) {
            that.cxt.moveTo(x, y);
            end.x = x;
            end.y = y;
            first = false;
          }
          that.cxt.lineTo(x, y);
          i += 1;
        });
        
        this.cxt.lineTo(end.x, end.y);
        var grad = this.cxt.createLinearGradient(0, 0, 0, this.height);
        grad.addColorStop(0,"rgba("+this.settings.color[0]+","+this.settings.color[1]+","+this.settings.color[2]+",0)");
        grad.addColorStop(1,"rgba("+this.settings.color[0]+","+this.settings.color[1]+","+this.settings.color[2]+",1)");
        this.cxt.fillStyle = grad;
        this.cxt.shadowBlur = 2;
        this.cxt.shadowColor = "rgba(0, 0, 0, .2)";
        this.cxt.stroke();
        this.cxt.fill();
        
        this.newCanvas('labels',1000);
        
        i = 0;
        $.each(this.settings.values, function(key,val){
          that.newCanvas('label-'+i, i * 250);
          that.cxt.fillStyle = "rgba(0,0,0,.8)";
          that.cxt.strokeStyle = "rgba(0,0,0,.5)";
          that.cxt.font = "bold 12px Verdana";
          var dist = Math.min(spacing * val, size * spacing);
          var x = that.width / 2 + Math.cos((Math.PI * 2) * (i / size)) * spacing * val;
          var y = that.height / 2 + Math.sin((Math.PI * 2) * (i / size)) * spacing * val;

          var textX = that.width / 2 + Math.cos((Math.PI * 2) * (i / size)) * spacing * val;
          var textY = that.height / 2 + Math.sin((Math.PI * 2) * (i / size)) * spacing * val * 1.5;
          
          if (textX < that.width/2) {
            textX -= 75
            that.cxt.textAlign="end";
            that.cxt.beginPath();
            var width = that.cxt.measureText(key).width;
            that.cxt.moveTo(textX - width - 5, textY + 4);
            that.cxt.lineTo(textX + 15, textY + 4);
            that.cxt.lineTo(x - 2, y);
            that.cxt.lineWidth = 2;
            that.cxt.stroke();
          } else {
            textX += 75
            that.cxt.textAlign="start";
            that.cxt.beginPath();
            var width = that.cxt.measureText(key).width;
            that.cxt.moveTo(x + 2,y);
            that.cxt.lineTo(textX - 15, textY + 4);
            that.cxt.lineTo(textX + width + 5, textY + 4);
            that.cxt.lineWidth = 2;
            that.cxt.stroke();
          }
          that.cxt.fillText(key, textX, textY);
          //For arrows that aren't done.
          i += 1;
        });
        
        
       /* this.cxt.font = "bold 24px Verdana";
        this.cxt.fillText(this.settings, 10, 30); */
      }
      
      return Radar;
      
    })();
    
    $.fn.radarChart = function(settings){
      this.each(function(i,ele){
        var radar = new Radar(ele, settings);
      });
    }
    
  })(jQuery);

  
  
</script>


</head>
<body>
	<div class="content-wrapper">
		<div class="container">

			<div class="row">
				<div class="col-md-12">
					<div class="page-head-line">Mountain Bigdata</div>
				</div>
			</div>
<!-- test -->
			<div class="row">
				<div class="col-md-12">
					<div class="page-head-line">

						<div class="panel panel-default">
							<br>
								
								<div class="col-md-4 col-sm-4">
									<div class="panel panel-default">
										<div class="panel-heading">지역별 데이터</div>
										<div class="panel-body">

									<div class="tab-content">
									<div class="tab-pane fade in active" id="tab1default">

										<div class="col-md-6 col-sm-6">
											<div class="panel panel-default">
												<div class="panel-heading">지역</div>
												<div class="panel-body">												  
													<div id="container" style="width:100%; height:400px;"></div> <!-- 1.지역 -->  
												</div>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>
										
										<div class="col-md-6 col-sm-6">
											<div class="panel panel-primary">
												<div class="panel-heading">계절</div>			<!-- 2.계절 -->
												<div class="panel-body">
												 <div id="piechart_3d" style="width: 100%; height: 100%;"></div>
  												</div>												
												</div>
											</div>
										</div>
										</div>
									</div>
								</div>

								<div class="col-md-4 col-sm-4">
									<div class="panel panel-primary">
										<div class="panel-heading">계절별 통계</div>
										<div class="panel-body">
											
										</div>
									</div>
								</div>

								<div class="col-md-4 col-sm-4">
									<div class="panel panel-default">
										<div class="panel-heading">감정분석</div>			<!-- 감정 분석 -->
										<div class="panel-body">
											<div id="feelGraph" style="width: 100%; height: 100%;"></div>
										</div>
									</div>
								</div>
								
								<br><br>
								<div class="col-md-4 col-sm-4">
									<div class="panel panel-default">
										<div class="panel-heading">감정분석</div>
										<div class="panel-body">이미지 ~</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-4">
									<div class="panel panel-default">
										<div class="panel-heading">감정분석</div>
										<div class="panel-body">이미지 ~</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-4">
									<div class="panel panel-default">
										<div class="panel-heading">감정분석</div>
										<div class="panel-body">이미지 ~</div>
									</div>
								</div>

								<div class="col-md-12">
									<div class="panel panel-default">
										<div class="panel-body">데이터 뿌려주는곳 ~</div>
									</div>
								</div>
								
							<div class="panel-body">

							</div>
						</div>
					</div>
				</div>
			</div>
</div></div>
</body>
</html>