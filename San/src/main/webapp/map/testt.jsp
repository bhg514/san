<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
<style type="text/css">

 html { height : 100% }
 body { height : 100%; margin: 0% 0% 0% 0%; padding: 0 }
  #map_canvas { height : 100% }
</style>

<script type = "text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=true"></script>
<script type="text/javascript" src="../../map/cluster.js"></script>
<script type = "text/javascript">
var map;
var infowindow;
var i = 0;
var markers =[];
var markerCluster = null;

//MarkerClusterer ������Ʈ�� ��� ���� ������ �����մϴ�.
//�� ������ Global ������ �����ؾ� �Ʒ��� �� �Լ����� ��� ����� �� �ս��ϴ�.
//Refresh ��ư�� �����ϱ� ���� �Լ��Դϴ�.
function NewControl(controlDiv, map) {

   // Set CSS styles for the DIV containing the control
   // Setting padding to 5 px will offset the control
   // from the edge of the map
   controlDiv.style.padding = '5px';

   // Set CSS for the control border
   var controlUI = document.createElement('DIV');
   controlUI.style.backgroundColor = 'white';
   controlUI.style.borderStyle = 'solid';
   controlUI.style.borderWidth = '3px';
   controlUI.style.cursor = 'pointer';
   controlUI.style.textAlign = 'center';
   controlUI.title = 'Click to set the map to Home';
   controlDiv.appendChild(controlUI);

   // Set CSS for the control interior
   var controlText = document.createElement('DIV');
   controlText.style.fontFamily = 'Arial,sans-serif';
   controlText.style.fontSize = '14px';
   controlText.style.paddingLeft = '4px';
   controlText.style.paddingRight = '4px';
   controlText.innerHTML = 'Refresh';
   controlUI.appendChild(controlText);

   // 'Refresh' ��Ʈ���� Ŭ���� ��� ������ �ִ� ��Ŀ�� MarkerClustere�� �����մϴ�.
   google.maps.event.addDomListener(controlUI, 'click', function() {
   if(markerCluster){
    	markerCluster.clearMarkers();
  		//MarkerClusterer ������Ʈ�� clearMarkers() �Լ��� ����Ͽ� Clustering�ϴ� ��� ��Ŀ�� �����մϴ�.
   }

   for(var j=0; j<markers.length; j++){ 
       markers[j].setMap(null); 
   } 

   markers.length = 0; 
   markers = [];
   i = 0;
   }); 

}

function initialize(){
	
	 	var latlng = new google.maps.LatLng(37.5640220, 126.9995940);
	 	var myOptions = {
		  	zoom: 13,
		  	center:latlng,
		  	mapTypeId: google.maps.MapTypeId.ROADMAP   
		};
	 	
	 	map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
	 	
		var newControlDiv = document.createElement('DIV');
		var newControl = new NewControl(newControlDiv, map);
		newControlDiv.index = 1;
		map.controls[google.maps.ControlPosition.TOP_RIGHT].push(newControlDiv);
		// refresh ��ư�� ������ newControl �Լ��� �����մϴ�.
		
		
		// ���� ��ĿŬ�����͸��� �Ǿ�� �ϴµ�.........
		alert(22);
		//markerCluster = new MarkerClusterer(map,markers);
		// ������ ������ markerCluster ������ MarkerClusterer ������Ʈ�� �����մϴ�.
		
		//infowindow = new google.maps.InfoWindow();
		google.maps.event.addListener(map, 'click', Setmarker);
		// ������ Ŭ������ �� Ŭ���� ������ ��Ŀ�� �����ϴ� �Լ��� �����մϴ�.
	 	
	
	
};

//Ŭ������ �� ��Ŀ�� �����ϴ� �Լ��Դϴ�.
function Setmarker(event) {
   	markers.push(new google.maps.Marker({
	   position: event.latLng,
	   map: map
   	}));
   	alert(33);
	//markers �迭�� Ŭ���� ������ ��ġ�ϴ� ��Ŀ�� �߰��մϴ�.
  	//infowindow.setContent("The " + i +"th marker is presented here.");
  	//infowindow.open(map,markers[i]);
	//Ŭ���� ������ ��Ŀ�� �����԰� ���ÿ� infowindow�� �����ݴϴ�.
  	markerCluster.addMarker(markers[i],0);
	//markerCluster Ŭ������ addMarker��� ��Ŀ�� �߰������ִ� �Լ��� ���� ������ ��Ŀ�� MarkerClusterer�� �߰��մϴ�.
	i++; 
};

</script>
</head>
<body onload="initialize()">
 <!-- <div id="map_canvas" style="width:100%; height:100%"></div> -->
</body>
</html>