<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<!-- script -->
<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/js/bootstrap.js"></script>
<!-- <script src="assets/js/main.js"></script> -->
<script src="assets/js/main2.js"></script>

<!-- 구글차트_보영 -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    
    //1번차트
    
     google.charts.load('current', {'packages':['corechart']});
     google.charts.setOnLoadCallback(drawChart1); 
 
      function drawChart1() {
        var data1 = google.visualization.arrayToDataTable([
          ['Year', '국내여행인원수', '숙박여행','당일치기'],
          <c:forEach var="vo" items="${tlist}">
          ['<c:out value="${vo.year}"/>', <c:out value="${vo.total}"/>, <c:out value="${vo.sleep}"/>,<c:out value="${vo.oneday}"/>],
          </c:forEach>
        ]);

        var options1 = {
        		backgroundColor:'none',
          title: '',
          hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 20000}
        };

        var chart1 = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart1.draw(data1, options1);
      
      }
        		
				/* 	//2번차트
					google.charts.load('current', {'packages' : [ 'bar' ]});
					google.charts.setOnLoadCallback(drawChart2);

					function drawChart2() {
						var data2 = google.visualization.arrayToDataTable([
								[ 'Year', 'in', 'out' ],
								<c:forEach var="vo" items="${inoutlist}">[
										'<c:out value="${vo.year}"/>',
										'<c:out value="${vo.sleep}"/>',
										'<c:out value="${vo.total}"/>'],
								</c:forEach> ]);

						var options2 = {
							chart : {
								title : 'Company Performance',
								subtitle : 'Sales, Expenses, and Profit: 2014-2017',
							}
						};

						var chart2 = new google.charts.Bar(document
								.getElementById('columnchart_material'));

						chart2.draw(data2, options2);
					} */
				</script>


<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript">
$(function () {
    // Age categories
    var categories = [
						<c:forEach var="vo" items="${inoutlist}">
                      	<c:out value="${vo.year}"/>,
                      </c:forEach>
                      ];
    $(document).ready(function () {
        $('#container').highcharts({
            chart: {
                type: 'bar'
            },
            title: {
                text: ''
            },
            subtitle: {
                text: ''
            },
            xAxis: [{
                categories: categories,
                reversed: false,
                labels: {
                    step: 1
                }
            }, { // mirror axis on right side
                opposite: true,
                reversed: false,
                categories: categories,
                linkedTo: 0,
                labels: {
                    step: 1
                }
            }],
            yAxis: {
                title: {
                    text: null
                },
                labels: {
                    formatter: function () {
                        return this.value;
                    }
                }
            },

            plotOptions: {
                series: {
                    stacking: 'normal'
                }
            },

            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + ', age ' + this.point.category + '</b><br/>' +
                        'Population: ' + Highcharts.numberFormat(Math.abs(this.point.y), 0);
                }
            },

            series: [{
                name: '입국자',
                data: [
						<c:forEach var="vo" items="${inoutlist}">
							-<c:out value="${vo.sleep}"/>,
						</c:forEach>
                       ]
            }, {
                name: '출국자',
                data: [
						<c:forEach var="vo" items="${inoutlist}">
						<c:out value="${vo.total}"/>,
						</c:forEach>
                       ]
            }]
        });
    });

});

</script>

<!-- D3 : 준비물 -->
<link href="cssR/things.css" rel="stylesheet" />
<script type="text/javascript">
setTimeout(function start (){
	  
	  $('.bar').each(function(i){  
	    var $bar = $(this);
	    $(this).append('<span class="count"></span>')
	    setTimeout(function(){
	      $bar.css('width', $bar.attr('data-percent'));      
	    }, i*100);
	  });

	$('.count').each(function () {
	    $(this).prop('Counter',0).animate({
	        Counter: $(this).parent('.bar').attr('data-percent')
	    }, {
	        duration: 2000,
	        easing: 'swing',
	        step: function (now) {
	            $(this).text(Math.ceil(now) +'%');
	        }
	    });
	});

	}, 500)

</script>

<!-- css -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/main.css" rel="stylesheet" />

</head>
<body>
	<div id="cf-jumbotron" class="text-center">
		<div class="col-md-12">
			<div class="overlay">
				<br>
				<br>
				<h1>
					한국의 산에 대해서<strong><span class="color">&nbsp;얼마나&nbsp;</span></strong>알고계신가요?
				</h1>

				<div id=carousel>
					<figure id=spinner>
						<img src=//demosthenes.info/assets/images/wanaka-tree.jpg alt="">
						<img src=//demosthenes.info/assets/images/still-lake.jpg alt="">
						<img src=//demosthenes.info/assets/images/pink-milford-sound.jpg
							alt="">
						<img src=//demosthenes.info/assets/images/paradise.jpg alt="">
						<img src=//demosthenes.info/assets/images/morekai.jpg alt="">
						<img src=//demosthenes.info/assets/images/milky-blue-lagoon.jpg
							alt="">
						<img src=//demosthenes.info/assets/images/lake-tekapo.jpg alt="">
						<img src=//demosthenes.info/assets/images/milford-sound.jpg alt="">
					</figure>
				</div>

				<span style="float: left" class=ss-icon onclick="galleryspin('-')">&lt;</span>
				<span style="float: right" class=ss-icon onclick="galleryspin('')">&gt;</span>
			</div>
			<div class="overlay">
				<a href="#cf-about" class="fa fa-angle-down page-scroll"></a>
			</div>
		</div>
		<div class="content-wrapper">
			<div class="container">

				<div class="row">
					<div class="col-md-12">
						<div class="page-head-line">Mountain Bigdata</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="page-head-line">
							<div class="panel panel-default">
								<br>

								<div class="col-md-4 col-sm-4">
									<div class="panel panel-default">
										<div class="panel-heading">지역별 데이터</div>
										<div class="panel-body">이미지</div>
									</div>
								</div>

								<div class="col-md-4 col-sm-4">
									<div class="panel panel-primary">
										<div class="panel-heading">계절별 통계</div>
										<div class="panel-body">이미지~</div>
									</div>
								</div>

								<div class="col-md-4 col-sm-4">
									<div class="panel panel-default">
										<div class="panel-heading">감정분석</div>
										<div class="panel-body">이미지 ~</div>
									</div>
								</div>

								<br> <br>
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
										<div class="panel-body">
											<div class="wrap">
												<h3>등산시 준비물</h3>
												<div class="holder">
												<c:forEach var="vo" items="${thingsList}">
													<div class="bar cf" data-percent="${vo.count }">
														<span class="label">${vo.things }</span>
													</div>
  												</c:forEach>
  											</div>
										</div>
									</div>
								</div>

								<div class="panel-body"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="cf-about">
			<div class="container" id="startchange">
				<div class="row">
					<div id="content-hello-img" class="col-md-6">
						<img
							src="http://www.ghostkitten.com/wp-content/uploads/2014/04/foxy-01.jpg"
							class="img-responsive">
					</div>
					<div id="content-hello-about" class="col-lg-4">
						<div class="about-text">
							<div class="section-title">
								<h4>ABOUT ME</h4>
								<a name="whatido"></a>
								<h2>WHAT I DO</h2>
							</div>
						</div>
						<hr>
						<p>Nothing compares to that feeling when you get what you
							want. I am here to make it possible for you.</p>
						<hr>
						<div class="">
							<span class="glyphicon glyphicon-leaf" aria-hidden="true"></span>
							&nbsp;&nbsp; Listen <br /> <span
								class="glyphicon glyphicon-leaf" aria-hidden="true"></span>
							&nbsp;&nbsp; Create <br /> <span
								class="glyphicon glyphicon-leaf" aria-hidden="true"></span>
							&nbsp;&nbsp; Enjoy
						</div>
					</div>
				</div>
			</div>
		</div>


		<div id="cf-personal">
			<div class="overlay">
				<div class="container">
					<div class="personal-title-center">
						<h4 id="personal-greeting" class="text-center">
							<strong>Meet Me</strong>
						</h4>
						<a name="meetme"></a>
						<div class="row">
							<div class="col-md-6">
								<div class="personal-intro">
									<p id="personal-text">My name is Luba May and I'm in love
										with web design. Creating things makes me feel happy and
										useful. Here are my three rules: Never stop dreaming! Never
										stop exploring! Never stop learning!</p>
								</div>
							</div>
							<div class="col-md-6"></div>
							<div id="personal-pic" class="col-md-6">
								<img src="assts/img/main.jsp"
									class="img-responsive img-circle center-block"
									style="width: 15em;">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div id="cf-portfolio">
			<div class="container">
				<h4 id="portfolio-header" class="text-center">Portfolio</h4>
				<a name="portfolio"></a>
				<hr>
				<div class="row">
					<div class="col-xs-6 col-md-3" class="portfolio-img">
						<div class="thumbnail">
							<img src="https://images6.alphacoders.com/308/308238.jpg" alt=""
								class="img-responsive" style="height: 159px; width: 100%;">
							<div class="caption">
								<h3 class="text-center">Tribute Page</h3>
								<br />
								<p></p>
								<p>
									<a href="http://codepen.io/LubaMay/full/dMNedO/"
										class="btn btn-success btn-block" role="button"
										target="_blank">Look closer</a>
								</p>
							</div>
						</div>
					</div>

					<div class="col-xs-6 col-md-3" class="portfolio-img">
						<div class="thumbnail">
							<img
								src="http://magazine.foxnews.com/sites/magazine.foxnews.com/files/CarrotOil_0.jpg"
								class="img-responsive" style="height: 159px; width: 100px;">
							<div class="caption">
								<h3 class="text-center">Coming soon</h3>
								<br />
								<p></p>
								<p>
									<a href="#" class="btn btn-success btn-block" role="button">Look
										closer</a>
								</p>
							</div>
						</div>
					</div>

					<div class="col-xs-6 col-md-3" class="portfolio-img">
						<div class="thumbnail">
							<img
								src="http://magazine.foxnews.com/sites/magazine.foxnews.com/files/CarrotOil_0.jpg"
								class="img-responsive" style="height: 159px; width: 100px;">
							<div class="caption">
								<h3 class="text-center">Coming soon</h3>
								<br />
								<p></p>
								<p>
									<a href="#" class="btn btn-success btn-block" role="button">Look
										closer</a>
								</p>
							</div>
						</div>
					</div>

					<div class="col-xs-6 col-md-3" class="portfolio-img">
						<div class="thumbnail">
							<img
								src="http://magazine.foxnews.com/sites/magazine.foxnews.com/files/CarrotOil_0.jpg"
								class="img-responsive" style="height: 159px; width: 100px;">
							<div class="caption">
								<h3 class="text-center">Coming soon</h3>
								<br />
								<p></p>
								<p>
									<a href="#" class="btn btn-success btn-block" role="button">Look
										closer</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>





		<div id="cf-contact">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title center">
							<h4 class="text-center" id="cf-contact-header">
								Feel free to <strong>contact me</strong>
							</h4>
							<a name="contact"></a>
							<div class="line">
								<hr>
							</div>

							<ul class="list-inline text-center">
								<li><a href="https://www.linkedin.com/in/lubovmayorova"
									class="btn btn-info" target="_blank"><i
										class="fa fa-linkedin"> LinkedIn</i></a></li>
								<li><a href="https://github.com/LubaMay" type="button"
									class="btn btn-info" target="_blank"><i
										class="fa fa-github"> GitHub</i></a></li>
								<li><a href="https://www.freecodecamp.com/lubamay"
									type="button" class="btn btn-info" target="_blank"><i
										class="fa fa-fire"> FreeCodeCamp</i></a></li>
							</ul>

						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>