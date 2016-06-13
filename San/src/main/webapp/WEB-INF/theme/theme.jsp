<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript">

	$(function(){
		$('#localType').change(function(){		
			var selectsan=$('#localType').val();	
			var param="type="+selectsan;
			sendMessage("POST", "recommand_select.do",param, localsan);
			
		});
	}); 

	function localsan() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				$('#localSanResult').html(httpRequest.responseText);
			}
		}
	}
	
</script>
</head>
<body>

	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="page-head-line">Mountain Big Data</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="col-md-12">
						<div class="panel panel-default">
							 <select name="text_loc2" id="localType">
								<option value="">- SORT -</option>
								<option value="Busan">부산</option>
								<option value="Chungbuk">충북</option>			
								<option value="Chungnam">충남</option>	
								<option value="Daegu">대구</option>	
								<option value="Daejeon">대전</option>			
								<option value="Gangwon">강원</option>		
								<option value="Gyeongbuk">경북</option>
								<option value="Gyeongnam">경남</option>
								<option value="Gyeonggi">경기</option>	
								<option value="Incheon">인천</option>
								<option value="Jeju">제주</option>
								<option value="Jeonbuk">전북</option>
								<option value="Jeonnam">전남</option>
								<option value="Ulsan">울산</option>
							</select> 
						</div>
					</div>
					
					<div class="col-md-2">
						<div class="panel panel-default">
							<div class="panel-heading">Top 5 Mountain</div>
							<div class="panel-body">								
								 <div id="localSanResult"></div> 			  <!-- 지역의 탑5 산 출력 -->
							</div>
						</div>
					</div>
					
					<div id="sanDetail"></div>								<!-- san detail -->
					
					<!-- <div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">인스타 사진 긁은거~</div>
							<div class="panel-body">
								<div id="test"></div>
							</div>
						</div>
					</div> -->


				</div>
			</div>
		</div>
	</div>
	

	<!-- <script>
		InstagramScroll({
			tag : '부산여행',
			imageSize : 200,
			clientID : 'c64c6f7b9c374d29967626c71c4e075b',
			imageContainer : '#test',
			includeCaption : true
		});
	</script> -->

</body>
</html>
