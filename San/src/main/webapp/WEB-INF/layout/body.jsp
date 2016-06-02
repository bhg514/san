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
<script src="assets/js/main.js"></script>

<!-- ������Ʈ_���� -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
    //1����Ʈ
    
      google.charts.load('current', {'packages':['corechart']});
     google.charts.setOnLoadCallback(drawChart1); 
 
      function drawChart1() {
        var data1 = google.visualization.arrayToDataTable([
          ['Year', '���������ο���', '���ڿ���','����ġ��'],
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
        		
				/* 	//2����Ʈ
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
                name: '�Ա���',
                data: [
						<c:forEach var="vo" items="${inoutlist}">
							-<c:out value="${vo.sleep}"/>,
						</c:forEach>
                       ]
            }, {
                name: '�ⱹ��',
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



<!-- css -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/style.css" rel="stylesheet" />

</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="page-head-line">������� ������ ���</div>
			</div>
		</div>

		<div class="row">
			<br>
			<div class="col-md-3 col-sm-3 col-xs-6">
				<div class="dashboard-div-wrapper bk-clr-one">
					<i class="fa fa-venus dashboard-div-icon"></i>
					<h5>���� ���� ����</h5>
					<div id="chart_div" style="width: 400px; height: 400px;"></div>

				</div>
			</div>
			
			
			<div class="col-md-3 col-sm-3 col-xs-6">
				<div class="dashboard-div-wrapper bk-clr-two">
					<i class="fa fa-edit dashboard-div-icon"></i>
					<h5>���ⱹ ����</h5>
					<!-- <div id="columnchart_material" style="width: 400px; height: 400px;"></div> -->
					<div id="container" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
				</div>
			</div>
			<div class="col-md-3 col-sm-3 col-xs-6">
				<div class="dashboard-div-wrapper bk-clr-three">
					<i class="fa fa-cogs dashboard-div-icon"></i>
					<div class="progress progress-striped active">
						<div class="progress-bar progress-bar-success" role="progressbar"
							aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
							style="width: 40%"></div>

					</div>
					<h5>Simple Text Here</h5>
				</div>
			</div>
			<div class="col-md-3 col-sm-3 col-xs-6">
				<div class="dashboard-div-wrapper bk-clr-four">
					<i class="fa fa-bell-o dashboard-div-icon"></i>
					<div class="progress progress-striped active">
						<div class="progress-bar progress-bar-primary" role="progressbar"
							aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"
							style="width: 50%"></div>

					</div>
					<h5>Simple Text Here</h5>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="notice-board">
					<div class="panel panel-default">
						<div class="panel-heading">
							Active Notice Panel
							<div class="pull-right">
								<div class="dropdown">
									<button class="btn btn-success dropdown-toggle btn-xs"
										type="button" id="dropdownMenu1" data-toggle="dropdown"
										aria-expanded="true">
										<span class="glyphicon glyphicon-cog"></span> <span
											class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu"
										aria-labelledby="dropdownMenu1">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="#">Refresh</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="#">Logout</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<ul>
								<li><a href="#"> <span
										class="glyphicon glyphicon-align-left text-success"></span>
										Lorem ipsum dolor sit amet ipsum dolor sit amet <span
										class="label label-warning"> Just now </span>
								</a></li>
								<li><a href="#"> <span
										class="glyphicon glyphicon-info-sign text-danger"></span>
										Lorem ipsum dolor sit amet ipsum dolor sit amet <span
										class="label label-info"> 2 min chat</span>
								</a></li>
								<li><a href="#"> <span
										class="glyphicon glyphicon-comment  text-warning"></span>
										Lorem ipsum dolor sit amet ipsum dolor sit amet <span
										class="label label-success">GO ! </span>
								</a></li>
								<li><a href="#"> <span
										class="glyphicon glyphicon-edit  text-danger"></span> Lorem
										ipsum dolor sit amet ipsum dolor sit amet <span
										class="label label-success">Let's have it </span>
								</a></li>
							</ul>
						</div>
						<div class="panel-footer">
							<a href="#" class="btn btn-default btn-block"> <i
								class="glyphicon glyphicon-repeat"></i> Just A Small Footer
								Button
							</a>
						</div>
					</div>
				</div>
				<hr />
				<div class="text-center alert alert-warning">
					<a href="#" class="btn btn-social btn-facebook"> <i
						class="fa fa-facebook"></i>&nbsp; Facebook
					</a> <a href="#" class="btn btn-social btn-google"> <i
						class="fa fa-google-plus"></i>&nbsp; Google
					</a> <a href="#" class="btn btn-social btn-twitter"> <i
						class="fa fa-twitter"></i>&nbsp; Twitter
					</a> <a href="#" class="btn btn-social btn-linkedin"> <i
						class="fa fa-linkedin"></i>&nbsp; Linkedin
					</a>
				</div>

				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Ref. No.</th>
								<th>Date</th>
								<th>Amount</th>
								<th>Status</th>
								<th>Delivery On</th>
								<th># #</th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td># 2501</td>
								<td>01/22/2015</td>
								<td><label class="label label-info">300 USD </label></td>
								<td><label class="label label-success">Delivered</label></td>
								<td>01/25/2015</td>
								<td><a href="#" class="btn btn-xs btn-danger">View</a></td>
							</tr>
							<tr>
								<td># 15091</td>
								<td>12/12/2014</td>
								<td><label class="label label-danger">7000 USD </label></td>
								<td><label class="label label-warning">Shipped</label></td>
								<td>N/A</td>
								<td><a href="#" class="btn btn-xs btn-success">View</a></td>
							</tr>
							<tr>
								<td># 11291</td>
								<td>12/03/2014</td>
								<td><label class="label label-warning">7000 USD </label></td>
								<td><label class="label label-success">Delivered</label></td>
								<td>01/23/2015</td>
								<td><a href="#" class="btn btn-xs btn-primary">View</a></td>
							</tr>
							<tr>
								<td># 1808</td>
								<td>11/10/2014</td>
								<td><label class="label label-success">2000 USD </label></td>
								<td><label class="label label-info">Returned</label></td>
								<td>N/A</td>
								<td><a href="#" class="btn btn-xs btn-danger">View</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<!-- �������� -->
			<div class="col-md-6">
				<div class="notice-board">
					<div class="panel panel-default">
						<div class="panel-heading">����������� ��õ</div>
						<div class="panel-body">
							<div id="aaaa" style="width: 100%; height: 650px;">����</div>
							<script type="text/javascript"
								src="//apis.daum.net/maps/maps3.js?apikey=cdcb15981eecc6effefb51aa33302b28&libraries=services"></script>

							<script>
		// ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ǥ���� ���������� �Դϴ�
		var infowindow = new daum.maps.InfoWindow({
			zIndex : 1
		});

		var mapContainer = document.getElementById('aaaa'), // ������ ǥ���� div 
		mapOption = {
			center : new daum.maps.LatLng(37.566826, 126.9786567), // ������ �߽���ǥ
			level : 10
		// ������ Ȯ�� ����
		};

		// ������ �����մϴ�    
		var map = new daum.maps.Map(mapContainer, mapOption);

		// ��� �˻� ��ü�� �����մϴ�
		var ps = new daum.maps.services.Places();

		// Ű����� ��Ҹ� �˻��մϴ�
		ps.keywordSearch('������', placesSearchCB);
		/* ps.keywordSearch('���� ������', placesSearchCB);
		ps.keywordSearch('��õ ������', placesSearchCB);
		ps.keywordSearch('��⵵ ������', placesSearchCB);
		ps.keywordSearch('����ϵ� ������', placesSearchCB);
		ps.keywordSearch('���󳲵� ������', placesSearchCB);
		ps.keywordSearch('��󳲵� ������', placesSearchCB);
		ps.keywordSearch('���ϵ� ������', placesSearchCB);
		ps.keywordSearch('��û���� ������', placesSearchCB);
		ps.keywordSearch('��û�ϵ� ������', placesSearchCB);
		ps.keywordSearch('���ֵ� ������', placesSearchCB);
		ps.keywordSearch('�λ� ������', placesSearchCB);
		ps.keywordSearch('�뱸 ������', placesSearchCB);
		ps.keywordSearch('���� ������', placesSearchCB);
		ps.keywordSearch('���� ������', placesSearchCB);
		 */

		// Ű���� �˻� �Ϸ� �� ȣ��Ǵ� �ݹ��Լ� �Դϴ�
		function placesSearchCB(status, data, pagination) {
			if (status === daum.maps.services.Status.OK) {

				// �˻��� ��� ��ġ�� �������� ���� ������ �缳���ϱ�����
				// LatLngBounds ��ü�� ��ǥ�� �߰��մϴ�
				var bounds = new daum.maps.LatLngBounds();

				for (var i = 0; i < data.places.length; i++) {
					displayMarker(data.places[i]);
					bounds.extend(new daum.maps.LatLng(data.places[i].latitude,
							data.places[i].longitude));
				}

				// �˻��� ��� ��ġ�� �������� ���� ������ �缳���մϴ�
				map.setBounds(bounds);
			}
		}

		// ������ ��Ŀ�� ǥ���ϴ� �Լ��Դϴ�
		function displayMarker(place) {

			// ��Ŀ�� �����ϰ� ������ ǥ���մϴ�
			var marker = new daum.maps.Marker(
					{
						map : map,
						position : new daum.maps.LatLng(place.latitude,
								place.longitude)
					});

			// ��Ŀ�� Ŭ���̺�Ʈ�� ����մϴ�
			daum.maps.event.addListener(marker, 'click', function() {
				// ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ���������쿡 ǥ��˴ϴ�
				infowindow
						.setContent('<div style="padding:5px;font-size:12px;">'
								+ place.title + '</div>');
				infowindow.open(map, marker);
			});
		}
	</script>
						</div>
						<div class="panel-footer">Ǫ��</div>
					</div>
				</div>
				<hr />

			</div>
		</div>
		<hr />

	</div>
<%-- 
	<article>
		<jsp:include page="../../map/map.jsp"></jsp:include>
		<jsp:include page="../../map/testt.jsp"></jsp:include>
	</article> --%>
</body>
</html>