<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<!-- <script src="assets/js/insta.js"></script> -->


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
													<option value="seoul">서울</option>			
													<option value="incheon">인천</option>	
													<option value="ranking">경기</option>	
													<option value="cost">강원</option>			
													<option value="newest">충북</option>		
													<option value="ranking">대전</option>
													<option value="cost">충남</option>	
												</select>
						</div>
					</div>
					
					<div class="col-md-2">
						<div class="panel panel-default">
							<div class="panel-heading">Top 5 Mountain</div>
							<div class="panel-body">
							
								<!-- 지역의 탑5 산 출력 -->
								<div id="localSanResult"></div>
								
							</div>
						</div>
					</div>

					<div class="col-md-5 col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">테마별 감정분석</div>
							<div class="panel-body">
								<p>내요요요요용.</p>
							</div>
							<div class="panel-footer">Panel Footer</div>
						</div>
					</div>
					<div class="col-md-5 col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">테마별 유명관광지</div>
							<div class="panel-body">
								<p>내요요요요용.</p>
							</div>
							<div class="panel-footer">Panel Footer</div>
						</div>
					</div>

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">누구랑</div>
							<div class="panel-body">
							
							
								
							</div>
						</div>
					</div>

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">언제?</div>
							<div class="panel-body"></div>
						</div>
					</div>

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
