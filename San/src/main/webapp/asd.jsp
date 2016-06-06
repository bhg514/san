<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
$primColor: #0d0d0d;
$secColor: #fff;

body {
	overflow: hidden;
	font-size: 16px;
}
.chart-wrapper {
	width: 100%;
	height: 100%;
	background-color: $primColor;
	position: absolute;
}

path {
	stroke: $primColor;
	/* stroke-width: 5px; */
	cursor: pointer;
	transition: fill 250ms;
	&:hover {
		/* stroke-width: 10px; */
		fill: $secColor;
	}
}

text {
	font-size: .8em;
	text-transform: uppercase;
	letter-spacing: .5px;
}

polyline {
	fill: none;
	stroke: $secColor;
	stroke-width: 2px;
	stroke-dasharray: 5px;
}
button {
  position: absolute;
  top: 20px;
  left: 20px;
  text-transform: uppercase;
  padding: 5px 10px;
  outline: none;
  font-size: .6em;
  background-color: transparent;
  color: $secColor;
  border: 1px solid $secColor;
	letter-spacing: 1px;
	transition: all 250ms;
	&:hover {
		background-color: $secColor;
		color: $primColor;
		box-shadow: 0 0 2px $secColor;
	}
	&:active {
		opacity: 0.5;
	}
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<!-- <script type="text/javascript" src="js/mountain.js"></script> -->

<script type="text/javascript">
let dataset = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1];

//let colors = ['#8dd3c7', '#ffffb3', '#bebada', '#fb8072', '#80b1d3', '#fdb462', '#b3de69', '#fccde5', '#d9d9d9', '#bc80bd'];
//let colors = ['#67001f', '#b2182b', '#d6604d', '#f4a582', '#fddbc7', '#e0e0e0', '#bababa', '#878787', '#4d4d4d', '#1a1a1a'];
let colors = ['#9e0142', '#d53e4f', '#f46d43', '#fdae61', '#fee08b', '#e6f598', '#abdda4', '#66c2a5', '#3288bd', '#5e4fa2'];

let width = document.querySelector('.chart-wrapper').offsetWidth,
height = document.querySelector('.chart-wrapper').offsetHeight,
minOfWH = Math.min(width, height) / 2,
initialAnimDelay = 300,
arcAnimDelay = 150,
arcAnimDur = 3000,
secDur = 1000,
secIndividualdelay = 150,
radius

//calculate minimum of width and height to set chart radius
if (minOfWH > 200) {
radius = 200
} else {
radius = minOfWH
}

//append svg
let svg = d3.select('.chart-wrapper').append('svg')
.attr({
 'width': width,
 'height': height,
 'class': 'pieChart'
})
.append('g');

svg.attr({
'transform': `translate(${width / 2}, ${height / 2})`
});

//for drawing slices
let arc = d3.svg.arc()
.outerRadius(radius * 0.6)
.innerRadius(radius * 0.45);

//for labels and polylines
let outerArc = d3.svg.arc()
.innerRadius(radius * 0.85)
.outerRadius(radius * 0.85);

//d3 color generator
//let c10 = d3.scale.category10();

let pie = d3.layout.pie()
.value(d => d);

let draw = function() {

svg.append("g").attr("class", "lines");
svg.append("g").attr("class", "slices");
svg.append("g").attr("class", "labels");

// define slice
let slice = svg.select('.slices')
 .datum(dataset)
 .selectAll('path')
 .data(pie);
slice
 .enter().append('path')
 .attr({
   'fill': (d, i) => colors[i],
   'd': arc,
   'stroke-width': '25px'
 })
 .attr('transform', (d, i) => 'rotate(-180, 0, 0)')
 .style('opacity', 0)
 .transition()
 .delay((d, i) => (i * arcAnimDelay) + initialAnimDelay)
 .duration(arcAnimDur)
 .ease('elastic')
 .style('opacity', 1)
 .attr('transform', 'rotate(0,0,0)')

slice.transition()
 .delay((d, i) => arcAnimDur + (i * secIndividualdelay))
 .duration(secDur)
 .attr('stroke-width', '5px')

let midAngle = d => d.startAngle + (d.endAngle - d.startAngle) / 2

let text = svg.select(".labels").selectAll("text")
 .data(pie(dataset))

text.enter()
 .append('text')
 .attr('dy', '0.35em')
 .style("opacity", 0)
 .style('fill', (d, i) => colors[i])
 .text((d, i) => colors[i])
 .attr('transform', d => {
   // calculate outerArc centroid for 'this' slice
   let pos = outerArc.centroid(d)
   // define left and right alignment of text labels 							
   pos[0] = radius * (midAngle(d) < Math.PI ? 1 : -1)
   return `translate(${pos})`
 })
 .style('text-anchor', d => midAngle(d) < Math.PI ? "start" : "end")
 .transition()
 .delay((d, i) => arcAnimDur + (i * secIndividualdelay))
 .duration(secDur)
 .style('opacity', 1)

let polyline = svg.select(".lines").selectAll("polyline")
 .data(pie(dataset))

polyline.enter()
 .append("polyline")
 .style("opacity", 0.5)
 .attr('points', d => {
   let pos = outerArc.centroid(d)
   pos[0] = radius * 0.95 * (midAngle(d) < Math.PI ? 1 : -1)
   return [arc.centroid(d), arc.centroid(d), arc.centroid(d)]
 })
 .transition()
 .duration(secDur)
 .delay((d, i) => arcAnimDur + (i * secIndividualdelay))
 .attr('points', d => {
   let pos = outerArc.centroid(d)
   pos[0] = radius * 0.95 * (midAngle(d) < Math.PI ? 1 : -1)
   return [arc.centroid(d), outerArc.centroid(d), pos]
 })
}

draw()

let button = document.querySelector('button');

let replay = () => {

d3.selectAll('.slices').transition().ease('back').duration(500).delay(0).style('opacity', 0).attr('transform', 'translate(0, 250)').remove()
d3.selectAll('.lines').transition().ease('back').duration(500).delay(100).style('opacity', 0).attr('transform', 'translate(0, 250)').remove()
d3.selectAll('.labels').transition().ease('back').duration(500).delay(200).style('opacity', 0).attr('transform', 'translate(0, 250)').remove()

setTimeout(draw, 800)

}
</script>
</head>
<body>
		<div class="chart-wrapper"></div>
		<button onclick='replay()'>Replay</button>
</body>
</html>