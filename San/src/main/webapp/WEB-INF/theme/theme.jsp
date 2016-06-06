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
								<option value="Busan">�λ�</option>
								<option value="Chungbuk">���</option>			
								<option value="Chungnam">�泲</option>	
								<option value="Daegu">�뱸</option>	
								<option value="Daejeon">����</option>			
								<option value="Gangwon">����</option>		
								<option value="Gyeonbuk">���</option>
								<option value="Gyeongnam">�泲</option>
								<option value="Gyeonggi">���</option>	
								<option value="Incheon">��õ</option>
								<option value="Jeju">����</option>
								<option value="Jeonbuk">����</option>
								<option value="Jeonnam">����</option>
								<option value="Ulsan">���</option>
							</select> 
						</div>
					</div>
					
					<div class="col-md-2">
						<div class="panel panel-default">
							<div class="panel-heading">Top 5 Mountain</div>
							<div class="panel-body">
							
								 <!-- ������ ž5 �� ��� -->
								 <div id="localSanResult"></div>  
							</div>
						</div>
					</div>

					<div class="col-md-5 col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">�׸��� �����м�</div>
							<div class="panel-body">
							
								<!-- ������ ž5 detail ��� -->
							<div id="localSanDetail_season" style="width:500px; height:600px;"></div>
							
							</div>
						</div>
					</div>
					<div class="col-md-5 col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">�׸��� ���������</div>
							<div class="panel-body">
								<p>��������.</p>
							</div>
						</div>
					</div>

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">������</div>
							<div class="panel-body">
							</div>
						</div>
					</div>

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">����?</div>
							<div class="panel-body"></div>
						</div>
					</div>

					<!-- <div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">�ν�Ÿ ���� ������~</div>
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
			tag : '�λ꿩��',
			imageSize : 200,
			clientID : 'c64c6f7b9c374d29967626c71c4e075b',
			imageContainer : '#test',
			includeCaption : true
		});
	</script> -->

</body>
</html>
