<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>


<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=88cd0292e24e787284b453c36c772445=services"></script>
<script>
	// ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ǥ���� ���������� �Դϴ�
	var infowindow = new daum.maps.InfoWindow({
		zIndex : 1
	});

	var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
	mapOption = {
		center : new daum.maps.LatLng(37.566826, 126.9786567), // ������ �߽���ǥ
		level : 5
	// ������ Ȯ�� ����
	};

	// ������ �����մϴ�    
	var map = new daum.maps.Map(mapContainer, mapOption);
	
	// ��� �˻� ��ü�� �����մϴ�
	var ps = new daum.maps.services.Places();

	// Ű����� ��Ҹ� �˻��մϴ�
	ps.keywordSearch('���� ���', placesSearchCB);

	// Ű���� �˻� �Ϸ� �� ȣ��Ǵ� �ݹ��Լ� �Դϴ�
	function placesSearchCB(status, data, pagination) {
		if (status === daum.maps.services.Status.OK) {

			// �˻��� ��� ��ġ�� �������� ���� ������ �缳���ϱ�����
			// LatLngBounds ��ü�� ��ǥ�� �߰��մϴ�
			var bounds = new daum.maps.LatLngBounds();

			for (var i = 0; i < data.places.length; i++) {
				displayMarker(data.places[i]);
				bounds.extend(new daum.maps.LatLng(
						data.places[i].latitude,
						data.places[i].longitude));
			}

			// �˻��� ��� ��ġ�� �������� ���� ������ �缳���մϴ�
			map.setBounds(bounds);
		}
	}
	
	
	
	// ������ ��Ŀ�� ǥ���ϴ� �Լ��Դϴ�
	function displayMarker(place) {

		// ��Ŀ�� �����ϰ� ������ ǥ���մϴ�
		var marker = new daum.maps.Marker({
			map : map,
			position : new daum.maps.LatLng(place.latitude,
					place.longitude)
		});
		
		
		
		// ��Ŀ�� Ŭ���̺�Ʈ�� ����մϴ�
		daum.maps.event
				.addListener(
						marker,
						'click',
						function() {
							// ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ���������쿡 ǥ��˴ϴ�
							infowindow
									.setContent('<div style="padding:5px;font-size:12px;">'
											+ place.title
											+ '</div>');
							infowindow.open(map, marker);
						});        

	}
</script>

<!-- <script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=cdcb15981eecc6effefb51aa33302b28&libraries=services"></script>
<script>
// ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ǥ���� ���������� �Դϴ�
var infowindow = new daum.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
    mapOption = {
        center: new daum.maps.LatLng(37.566826, 126.9786567), // ������ �߽���ǥ
        level: 13 // ������ Ȯ�� ����
    };  

// ������ �����մϴ�    
var map = new daum.maps.Map(mapContainer, mapOption); 

// ��� �˻� ��ü�� �����մϴ�
var ps = new daum.maps.services.Places(map); 

// ī�װ��� ������ �˻��մϴ�
ps.categorySearch('AT4', placesSearchCB, {useMapBounds:true}); 

// Ű���� �˻� �Ϸ� �� ȣ��Ǵ� �ݹ��Լ� �Դϴ�
function placesSearchCB (status, data, pagination) {
    if (status === daum.maps.services.Status.OK) {
        for (var i=0; i<data.places.length; i++) {
            displayMarker(data.places[i]);    
        }       
    }
}

// ������ ��Ŀ�� ǥ���ϴ� �Լ��Դϴ�
function displayMarker(place) {
    // ��Ŀ�� �����ϰ� ������ ǥ���մϴ�
    var marker = new daum.maps.Marker({
        map: map,
        position: new daum.maps.LatLng(place.latitude, place.longitude) 
    });

    // ��Ŀ�� Ŭ���̺�Ʈ�� ����մϴ�
    daum.maps.event.addListener(marker, 'click', function() {
        // ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ���������쿡 ǥ��˴ϴ�
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.title + '</div>');
        infowindow.open(map, marker);
    });
}
</script> -->
</head>
<body>

	<!-- <div id="map" style="width: 100%; height: 700px;"></div> -->

</body>
</html>