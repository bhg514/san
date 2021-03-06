<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link href="assets/css/data.css" rel="stylesheet" />
<link href="assets/css/bootstrap.css" rel="stylesheet" />

<link rel="stylesheet" type="text/css"  media="screen" href="assets/css/things.css">

<script src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<!-- 1,지역 -->
<script src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/themes/none.js"></script>
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


<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<!-- 2,계절 -->
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
</script>

<!-- 3.요일               ---------------------------------------------------------------------->
<script type="text/javascript">
// week
 $(function(){
	  $('#weekGraph').radarChart({
    size: [300, 300],
    step: 1,
    values: <%=request.getAttribute("weekData")%>
   /*   { "월요일": 4.1,
      "화요일": 4.1,
      "수요일": 4.1,
      "목요일": 4.1,
      "금요일": 6.1,
      "토요일": 5.1,
      "일요일": 3.1
     } */
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
        size: [250,250],
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

      var spacing = 7;
      
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

    <script type="text/javascript">
      
      google.charts.setOnLoadCallback(drawFoodChart);
      function drawFoodChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          
          <c:forEach var="vo" items="${food}">    
          ['<c:out value="${vo.food}"/>',<c:out value="${vo.count}"/>],
          </c:forEach>
        ]);

        var options = {
          
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    </script>
<!-- 5.things -->
<script type="text/javascript">
var chart = AmCharts.makeChart("chartdiv", {
    "theme": "none",
    "type": "serial",
	"startDuration": 2,
    "dataProvider": [
                    <c:forEach  var="vo" items="${thingsList}"> 
                     {
        "country": '<c:out value="${vo.things}"/>',
        "visits":<c:out value="${vo.count}"/>,
        "color": "<c:out value="${vo.color}"/>"
    },
    </c:forEach >
    
    
    ],
    "valueAxes": [{
        "position": "left",
        "axisAlpha":0,
        "gridAlpha":0         
    }],
    "graphs": [{
        "balloonText": "[[category]]: <b>[[value]]</b>",
        "colorField": "color",
        "fillAlphas": 0.85,
        "lineAlpha": 0.1,
        "type": "column",
        "topRadius":1,
        "valueField": "visits"
    }],
    "depth3D": 40,
	"angle": 30,
    "chartCursor": {
        "categoryBalloonEnabled": false,
        "cursorAlpha": 0,
        "zoomable": false
    },    
    "categoryField": "country",
    "categoryAxis": {
        "gridPosition": "start",
        "axisAlpha":0,
        "gridAlpha":0
        
    },
	"exportConfig":{
		"menuTop":"20px",
        "menuRight":"20px",
        "menuItems": [{
        "icon": '/lib/3/images/export.png',
        "format": 'png'	  
        }]  
    }
},0);

jQuery('.chart-input').off().on('input change',function() {
	var property	= jQuery(this).data('property');
	var target		= chart;
	chart.startDuration = 0;

	if ( property == 'topRadius') {
		target = chart.graphs[0];
	}

	target[property] = this.value;
	chart.validateNow();
});

</script>

<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="https://rawgit.com/jasondavies/d3-cloud/master/build/d3.layout.cloud.js"></script>
</head>






<body>
	<div class="content-wrapper">
		<div class="container">

			<div class="row">
				<div class="page-head-line">Mountain Bigdata</div>
			</div>


			<section>

				<div id="icon-wrapper">

					<div class="row">

						<div class="col-sm-6">
							<div class="icons">
								<div class="icon-slide-container">
									<a href="map.html"> <img class="slide-icon"
										alt="The Kite Map Logo" height="100" src="assets/img/1.png">
									</a>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="icons2">
								<div class="icon-slide-container">
									<a href="kite-map.php"> <img class="slide-icon"
										alt="The Kite Map Logo" height="100" src="assets/img/2.png">
									</a>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="icons3">
								<div class="icon-slide-container">
									<img class="slide-icon" alt="The Kite Map Logo" height="100"
										src="assets/img/3.png">
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="icons4">
								<div class="icon-slide-container">

									<a href="feedback.html"> <img class="slide-icon"
										alt="The Kite Map Logo" height="100" src="assets/img/4.png">
									</a>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="icons5">
								<div class="icon-slide-container">

									<a href="feedback.html"> <img class="slide-icon"
										alt="The Kite Map Logo" height="100" src="assets/img/5.png">
									</a>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="icons6">
								<div class="icon-slide-container">
									<a href="feedback.html"> <img class="slide-icon"
										alt="The Kite Map Logo" height="100" src="assets/img/6.png">
									</a>
								</div>
							</div>
						</div>

					</div>
				</div>
			</section>



			<div class="row">
				<div class="col-md-12">

					<div class="col-md-4 col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading">지역별 통계</div>
							<div class="panel-body">
								<div id="container" style="width: 100%; height: 400px;"></div>

							</div>
						</div>
					</div>

					<div class="col-md-4 col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading">계절별 통계</div>
							<div class="panel-body">
								<div id="piechart_3d" style="width: 100%; height: 400px;"></div>
							</div>
						</div>
					</div>

					<div class="col-md-4 col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading">감정분석</div>
							<div class="panel-body">
								<div id="feelword" style="width: 100%; height: 400px;"></div>
							</div>
						</div>
					</div>

					<br> <br>

					<div class="col-md-4 col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading">요일분석</div>
							<div class="panel-body">
								<div id="weekGraph" style="width: 100%; height: 100%;"></div>
							</div>
						</div>
					</div>

					<div class="col-md-4 col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading">준비물</div>
							<div class="panel-body"><div id="chartdiv"></div></div>
						</div>
					</div>

				<div class="col-md-4 col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">음식</div>
						<div class="panel-body">
						 <div id="donutchart" style="width: 100%; height: 100%;"></div> 
						</div>
					</div>
				</div>

					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">데이터 확인</div>
							<div class="panel-body">
									
								
										
														
							
							
							
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


<!-- 감정워드클라우드.. 아래있어야 됨... -->
<script>


//Simple animated example of d3-cloud - https://github.com/jasondavies/d3-cloud
//Based on https:F//github.com/jasondavies/d3-cloud/blob/master/examples/simple.html

// Encapsulate the word cloud functionality
function wordCloud() {

  var fill = d3.scale.category20();

  //Construct the word cloud's SVG element
  var svg = d3.select("#feelword").append("svg")
      .attr("class", "word-cloud")
      .attr("width", 300)
      .attr("height", 400)
      .append("g")
      .attr("transform", "translate(150,200)");


  //Draw the word cloud
  function draw(words) {
      var cloud = svg.selectAll("g text")
                      .data(words, function(d) { return d.text; })

      //Entering words
      cloud.enter()
          .append("text")
          .style("font-family", "Impact")
          .style("fill", function(d, i) { return fill(i); })
          .attr("text-anchor", "middle")
          .attr('font-size', 1)
          .text(function(d) { return d.text; });

      //Entering and existing words
      cloud
          .transition()
              .duration(600)
              .style("font-size", function(d) { return d.size + "px"; })
              .attr("transform", function(d) {
                  return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
              })
              .style("fill-opacity", 1);

      //Exiting words
      cloud.exit()
          .transition()
              .duration(200)
              .style('fill-opacity', 1e-6)
              .attr('font-size', 1)
              .remove();
  }


  //Use the module pattern to encapsulate the visualisation code. We'll
  // expose only the parts that need to be public.
  return {

      //Recompute the word cloud for a new set of words. This method will
      // asycnhronously call draw when the layout has been computed.
      //The outside world will need to call this function, so make it part
      // of the wordCloud return value.
      update: function(words) {
          d3.layout.cloud().size([300, 400])
              .words(words)
              .padding(5)
              .rotate(function() { return ~~(Math.random() * 2) * 90; })
              .font("Impact")
              .fontSize(function(d) { return d.size; })
              .on("end", draw)
              .start();
      }
  }

}

//Some sample data - http://en.wikiquote.org/wiki/Opening_lines
var words = [
  /*  "hi nice nice nice hi good oh oh my god god god god god", */
 "<c:out value='${feelAll}'/>"
]

//Prepare one of the sample sentences by removing punctuation,
// creating an array of words and computing a random size attribute.
function getWords(i) {
  return words[i]
          .replace(/[!\.,:;\?]/g, '')
          .split(' ')
          .map(function(d) {
              return {text: d, size: 10 + Math.random() * 30};
          })
}

//This method tells the word cloud to redraw with a new set of words.
//In reality the new words would probably come from a server request,
// user input or some other source.
function showNewWords(vis, i) {
  i = i || 0;

  vis.update(getWords(i ++ % words.length))
  setTimeout(function() { showNewWords(vis, i + 1)}, 2000)
}

//Create a new instance of the word cloud visualisation.
//var myWordCloud = wordCloud(document.getElementById('feelword'));
var myWordCloud = wordCloud();
//Start cycling through the demo data
showNewWords(myWordCloud);

</script>
</body>
</html>