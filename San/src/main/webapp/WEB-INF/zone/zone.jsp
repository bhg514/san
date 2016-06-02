<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="assets/js/insta.js"></script>
<script src="assets/js/jquery.instagram-tag.js"></script>


<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>
	var directionsDisplay;
	var directionsService = new google.maps.DirectionsService();
	var map;

	function initialize() {
		directionsDisplay = new google.maps.DirectionsRenderer();
		var chicago = new google.maps.LatLng(41.850033, -87.6500523);
		var mapOptions = {
			zoom : 7,
			center : chicago
		}
		map = new google.maps.Map(document.getElementById("map"), mapOptions);
		directionsDisplay.setMap(map);
		directionsDisplay.setPanel(document.getElementById("directionsPanel"));
	}

	function calcRoute() {
		var start = document.getElementById('start').value;
		var end = document.getElementById('end').value;
		var mode = document.getElementById('mode').value;

		var request = {
			origin : start,
			destination : end,
			travelMode : eval("google.maps.DirectionsTravelMode." + mode)
		};
		directionsService.route(request, function(response, status) {
			alert(status); // Ȯ�ο� Alert..�̻��� ����
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(response);
			}
		});
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>

</head>
<body>
	<div class="content-wrapper">
		<div class="container">

			<div class="row">
				<div class="col-md-12">
					<div class="page-head-line">������ ��õ ������ ���</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="page-head-line">
						<div class="panel with-nav-tabs panel-default">
							<div class="panel-heading">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab1default"
										data-toggle="tab">�����</a></li>
									<li><a href="#tab2default" data-toggle="tab">��õ��</a></li>
									<li><a href="#tab3default" data-toggle="tab">��⵵</a></li>
									<li><a href="#tab4default" data-toggle="tab">������</a></li>
									<li><a href="#tab5default" data-toggle="tab">��û��</a></li>
									<li><a href="#tab6default" data-toggle="tab">����</a></li>
									<li><a href="#tab7default" data-toggle="tab">���</a></li>
									<li><a href="#tab8default" data-toggle="tab">���ֵ�</a></li>
								</ul>
							</div>

							<div class="panel-body">
								<div class="tab-content">

									<!-- ���� -->
									<div class="tab-pane fade in active" id="tab1default">

										<div class="col-md-6 col-sm-6">
											<div class="panel panel-default">
												<div class="panel-heading">����ã�¸��</div>
												<div class="panel-body">
													<div id="donutchart" style="width: 100%; height: 350px;"></div>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-6 col-sm-6">
											<div class="panel panel-primary">
												<div class="panel-heading">���� ����</div>
												<div class="panel-body">
													<div id="aaaa" style="width: 100%; height: 350px;">����</div>
													<script type="text/javascript"
														src="//apis.daum.net/maps/maps3.js?apikey=cdcb15981eecc6effefb51aa33302b28&libraries=services"></script>


												</div>

												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-4 col-sm-4">
											<div class="panel panel-info">
												<div class="panel-heading">����Ŭ����</div>
												<div class="panel-body">
													<p>����Ŭ����</p>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-4 col-sm-4">
											<div class="panel panel-warning">
												<div class="panel-heading">������?</div>
												<div class="panel-body">
													<p>������</p>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-4 col-sm-4">
											<div class="panel panel-danger">
												<div class="panel-heading">����?</div>
												<div class="panel-body">
													<p>��������?</p>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-12 col-sm-12">
											<div class="panel panel-danger">
												<div class="panel-heading">#�������</div>
												<div class="panel-body">
													<div class="col-md-12">
														<div class="col-md-3">
															<div id="seoul"></div>
														</div>
													</div>
												</div>
												<div class="panel-footer">Ǫ��Ǫ��</div>
											</div>
										</div>
									</div>

									<!-- ��õ -->
									<div class="tab-pane fade" id="tab2default">

										<div class="col-md-6 col-sm-6">
											<div class="panel panel-default">
												<div class="panel-heading">����ã�¸��</div>
												<div class="panel-body">
													<div id="donutchart" style="width: 100%; height: 350px;"></div>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-6 col-sm-6">
											<div class="panel panel-primary">
												<div class="panel-heading">���� ����</div>
												<div class="panel-body">
													<div id="aaaa" style="width: 100%; height: 350px;">����</div>
													<script type="text/javascript"
														src="//apis.daum.net/maps/maps3.js?apikey=cdcb15981eecc6effefb51aa33302b28&libraries=services"></script>
												</div>

												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-4 col-sm-4">
											<div class="panel panel-info">
												<div class="panel-heading">����Ŭ����</div>
												<div class="panel-body">
													<p>����Ŭ����</p>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-4 col-sm-4">
											<div class="panel panel-warning">
												<div class="panel-heading">������?</div>
												<div class="panel-body">
													<p>������</p>
												</div>
												<div class="panel-footer">Panel Footer</div>
											</div>
										</div>

										<div class="col-md-4 col-sm-4">
											<div class="panel panel-danger">
												<div class="panel-heading">����?</div>
												<div class="panel-body">
													<p>����</p>
												</div>
												<div class="panel-footer">Ǫ��Ǫ��</div>
											</div>
										</div>

										<div>
											<div class="col-md-12 col-sm-12">
												<div class="panel panel-danger">
													<div class="panel-heading">#��õ����</div>
													<div class="panel-body">
														<div class="col-md-12">
															<div class="col-md-3">
																<div id="incheon"></div>
															</div>
														</div>
													</div>
													<div class="panel-footer">Ǫ��Ǫ��</div>
												</div>
											</div>
										</div>
									</div>

									<div class="tab-pane fade" id="tab3default">
										<div class="panel panel-danger">
											<div class="panel-heading">#�������˻�</div>
											<div class="panel-body">
												<div id="panel">
													<b>Start: </b> <input type="text" id="start" /> <b>End:
													</b> <input type="text" id="end" />
													<div>
														<strong>Mode of Travel: </strong> <select id="mode">
														</select> <input type="button" value="��ã��"
															onclick="Javascript:calcRoute();" />
													</div>
												</div>
												<div class="panel-footer">
													<div id="map" style="float: left; width: 600px; height: 600px;"></div>
													<div id="directionsPanel" style="float: right; width: 30%;"></div>
												</div>

											</div>

										</div>

									</div>
									<div class="tab-pane fade" id="tab4default">Default 4</div>
									<div class="tab-pane fade" id="tab5default">Default 5</div>
									<div class="tab-pane fade" id="tab6default">Default 6</div>
									<div class="tab-pane fade" id="tabdefault">Default 7</div>
									<div class="tab-pane fade" id="tab8default">Default 8</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		InstagramScroll({
			tag : '�������',
			imageSize : 200,
			clientID : 'c64c6f7b9c374d29967626c71c4e075b',
			imageContainer : '#seoul',
			includeCaption : true
		});
	</script>

	<script>
		InstagramScroll({

			tag : '��õ����',
			imageSize : 200,
			clientID : 'c64c6f7b9c374d29967626c71c4e075b',
			imageContainer : '#incheon',
			includeCaption : true

		});
	</script>

	<script>
		// ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ǥ���� ���������� �Դϴ�
		var infowindow = new daum.maps.InfoWindow({
			zIndex : 1
		});

		var mapContainer = document.getElementById('aaaa'), // ������ ǥ���� div 
		mapOption = {
			center : new daum.maps.LatLng(37.566826, 126.9786567), // ������ �߽���ǥ
			level : 3
		// ������ Ȯ�� ����
		};

		// ������ �����մϴ�    
		var map = new daum.maps.Map(mapContainer, mapOption);

		// ��� �˻� ��ü�� �����մϴ�
		var ps = new daum.maps.services.Places();

		// Ű����� ��Ҹ� �˻��մϴ�
		ps.keywordSearch('���¿� ����', placesSearchCB);

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

	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>

	<script type="text/javascript">
		google.charts.load("current", {
			packages : [ "corechart" ]
		});
		google.charts.setOnLoadCallback(drawChart);
		function drawChart() {
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
	</script>


</body>
</html>