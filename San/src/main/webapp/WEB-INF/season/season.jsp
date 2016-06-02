<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript">
	$(function() {

		google.charts.load('current', {
			'packages' : [ 'corechart', 'bar' ]
		});
		google.charts.setOnLoadCallback(drawChartPie);
		function drawChartPie() {
			var data = google.visualization.arrayToDataTable([
					[ 'Task', 'Hours per Day' ], [ 'Work', 11 ], [ 'Eat', 2 ],
					[ 'Commute', 2 ], [ 'Watch TV', 2 ], [ 'Sleep', 7 ] ]);
			var options = {
				title : 'My Daily Activities'
			};
			var chart = new google.visualization.PieChart(document
					.getElementById('piechart'));
			chart.draw(data, options);
		}

		//google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawChartBar);
		function drawChartBar() {
			var data = google.visualization.arrayToDataTable([
					[ 'Year', 'Sales', 'Expenses', 'Profit' ],
					[ '2014', 1000, 400, 200 ], [ '2015', 1170, 460, 250 ],
					[ '2016', 660, 1120, 300 ], [ '2017', 1030, 540, 350 ] ]);
			var options = {
				chart : {
					title : 'Company Performance',
					subtitle : 'Sales, Expenses, and Profit: 2014-2017',
				},
				bars : 'horizontal' // Required for Material Bar Charts.
			};
			var chart = new google.charts.Bar(document
					.getElementById('barchart_material'));
			chart.draw(data, options);
		}

		google.charts.setOnLoadCallback(drawChartDonut);
		function drawChartDonut() {
			var data = google.visualization.arrayToDataTable([
					[ 'Task', 'Hours per Day' ], [ 'Work', 11 ], [ 'Eat', 2 ],
					[ 'Commute', 2 ], [ 'Watch TV', 2 ], [ 'Sleep', 7 ] ]);
			var options = {
				title : 'My Daily Activities',
				pieHole : 0.4,
			};
			var chart = new google.visualization.PieChart(document
					.getElementById('donutchart'));
			chart.draw(data, options);
		}

		$('#container')
				.highcharts(
						{
							title : {
								text : 'Combination chart'
							},
							xAxis : {
								categories : [ 'Apples', 'Oranges', 'Pears',
										'Bananas', 'Plums' ]
							},
							labels : {
								items : [ {
									html : 'Total fruit consumption',
									style : {
										left : '50px',
										top : '18px',
										color : (Highcharts.theme && Highcharts.theme.textColor)
												|| 'black'
									}
								} ]
							},
							series : [
									{
										type : 'column',
										name : 'Jane',
										data : [ 3, 2, 1, 3, 4 ]
									},
									{
										type : 'column',
										name : 'John',
										data : [ 2, 3, 5, 7, 6 ]
									},
									{
										type : 'column',
										name : 'Joe',
										data : [ 4, 3, 3, 9, 0 ]
									},
									{
										type : 'spline',
										name : 'Average',
										data : [ 3, 2.67, 3, 6.33, 3.33 ],
										marker : {
											lineWidth : 2,
											lineColor : Highcharts.getOptions().colors[3],
											fillColor : 'white'
										}
									},
									{
										type : 'pie',
										name : 'Total consumption',
										data : [
												{
													name : 'Jane',
													y : 13,
													color : Highcharts
															.getOptions().colors[0]
												// Jane's color
												},
												{
													name : 'John',
													y : 23,
													color : Highcharts
															.getOptions().colors[1]
												// John's color
												},
												{
													name : 'Joe',
													y : 19,
													color : Highcharts
															.getOptions().colors[2]
												// Joe's color
												} ],
										center : [ 100, 80 ],
										size : 100,
										showInLegend : false,
										dataLabels : {
											enabled : false
										}
									} ]
						});

		$('#container1')
				.highcharts(
						{
							chart : {
								polar : true,
								type : 'line'
							},
							title : {
								text : 'Budget vs spending',
								x : -80
							},
							pane : {
								size : '80%'
							},
							xAxis : {
								categories : [ 'Sales', 'Marketing',
										'Development', 'Customer Support',
										'Information Technology',
										'Administration' ],
								tickmarkPlacement : 'on',
								lineWidth : 0
							},
							yAxis : {
								gridLineInterpolation : 'polygon',
								lineWidth : 0,
								min : 0
							},
							tooltip : {
								shared : true,
								pointFormat : '<span style="color:{series.color}">{series.name}: <b></b><br/>'
							},
							legend : {
								align : 'right',
								verticalAlign : 'top',
								y : 70,
								layout : 'vertical'
							},
							series : [
									{
										name : 'Allocated Budget',
										data : [ 43000, 19000, 60000, 35000,
												17000, 10000 ],
										pointPlacement : 'on'
									},
									{
										name : 'Actual Spending',
										data : [ 50000, 39000, 42000, 31000,
												26000, 14000 ],
										pointPlacement : 'on'
									} ]
						});

	});
</script>
</head>
<body>
	<div class="content-wrapper">
		<div class="container">

			<div class="row">
				<div class="col-md-12">
					<div class="page-head-line">계절별 추천 여행지</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="page-head-line">
						<div class="panel with-nav-tabs panel-default">
							<div class="panel-heading">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab1default"
										data-toggle="tab">봄</a></li>
									<li><a href="#tab2default" data-toggle="tab">여름</a></li>
									<li><a href="#tab3default" data-toggle="tab">가을</a></li>
									<li><a href="#tab4default" data-toggle="tab">겨울</a></li>
								</ul>
							</div>

							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="tab1default">

										<div class="col-md-6 col-sm-6">
											<div class="panel panel-default">
												<div class="panel-heading">많이찾는명소</div>
												<div class="panel-body">
													<div id="piechart" style="width: 500px; height: 210px;"></div>
													<div>

											
													  <img src="R/naver.png" width="500px" height="210px">													  
													  
													</div>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>
										<div class="col-md-6 col-sm-6">
											<div class="panel panel-primary">
												<div class="panel-heading">유명 음식점?</div>
												<div class="panel-body">
													<div id="barchart_material"
														style="width: 500px; height: 210px;"></div>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<!-- <div class="col-md-4 col-sm-4">
											<div class="panel panel-success">
												<div class="panel-heading">Success Panel</div>
												<div class="panel-body">
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing
														elit. Vestibulum tincidunt est vitae ultrices accumsan.
														Aliquam ornare lacus adipiscing, posuere lectus et,
														fringilla augue.</p>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div> -->

										<div class="col-md-4 col-sm-4">
											<div class="panel panel-info">
												<div class="panel-heading">워드클라우드</div>
												<div class="panel-body">
													<p>워드클라우드</p>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-4 col-sm-4">
											<div class="panel panel-warning">
												<div class="panel-heading">누구랑?</div>
												<div class="panel-body">
													<div id="donutchart" style="width: 300px; height: 210px;"></div>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-4 col-sm-4">
											<div class="panel panel-danger">
												<div class="panel-heading">날씨?</div>
												<div class="panel-body">
													<div id="container1" style="width: 300px; height: 210px;"></div>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-12 col-sm-12">
											<div class="panel panel-danger">
												<div class="panel-heading">여행 관련 뉴스</div>
												<div class="panel-body">
													<p>뉴스</p>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>
									</div>


									<div class="tab-pane fade" id="tab2default">여름</div>
									<div class="tab-pane fade" id="tab3default">가을</div>
									<div class="tab-pane fade" id="tab4default">겨울</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>