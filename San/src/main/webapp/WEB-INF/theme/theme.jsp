<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script src="assets/js/insta.js"></script>


<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript">

	$(function(){
		//2.����
		$('#sortType').change(function(){		
			var sortType=$('#sortType').val();	//ex_���ݳ�����
			
			var param="type="+sortType;
			sendMessage("POST", "guide_sort.do",param, localsan);
			
		});
	}); 

	//������. �����͸���Ʈ �ҷ�����
	function guideList() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				$('#localsan').html(httpRequest.responseText);
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
					<div class="page-head-line">�׸��� ���� ���� ���</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="col-md-12">
						<div class="panel panel-default">
							�׸�����?
						</div>
					</div>
					
					<div class="col-md-2">
						<div class="panel panel-default">
							<div class="panel-heading">�ְ� ����</div>
							<div class="panel-body">
								<ul>
									<!-- 3. ���� -->
										<div class="inner">
											<br><br>
											<div class="9u 12u$(xsmall) tourFit">
												<h4>I FIND GUIDE!</h4>
											</div>
											
											<div class="select-wrapper tourist_select 3u$ 12u$(xsmall) tourFit">
												<select name="text_loc2" id="sortType">
													<option value="">- SORT -</option>
													<option value="cost">����</option>			
													<option value="newest">��õ</option>	
													<option value="ranking">���</option>	
													<option value="cost">����</option>			
													<option value="newest">���</option>		
													<option value="ranking">����</option>
													<option value="cost">�泲</option>	
												</select>
											</div>
										</div>	
									
								</ul>
							</div>
						</div>
					</div>

					<div class="col-md-5 col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">�׸��� �����м�</div>
							<div class="panel-body">
								<p>��������.</p>
							</div>
							<div class="panel-footer">Panel Footer</div>
						</div>
					</div>
					<div class="col-md-5 col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">�׸��� ���������</div>
							<div class="panel-body">
								<p>��������.</p>
							</div>
							<div class="panel-footer">Panel Footer</div>
						</div>
					</div>

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">������</div>
							<div class="panel-body">
							
							<!-- ������ ž5 �� ��� -->
							<div id="localSan"></div>
								
							</div>
						</div>
					</div>

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">����?</div>
							<div class="panel-body"></div>
						</div>
					</div>

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">�ν�Ÿ ���� ������~</div>
							<div class="panel-body">
								<div id="test"></div>
							</div>
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>


	<script>
		InstagramScroll({
			tag : '�λ꿩��',
			imageSize : 200,
			clientID : 'c64c6f7b9c374d29967626c71c4e075b',
			imageContainer : '#test',
			includeCaption : true
		});
	</script>

</body>
</html>
