<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script src="assets/js/insta.js"></script>


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
									<a href="#">1. ��õ</a>
									<li><a href="#">1. ��õ</a></li>
									<li><a href="#">1. ��õ</a></li>
									<li><a href="#">1. ��õ</a></li>
									<li><a href="#">1. ��õ</a></li>
									<li><a href="#">1. ��õ</a></li>
									<li><a href="#">1. ��õ</a></li>
									<li><a href="#">1. ��õ</a></li>
									<li><a href="#">1. ��õ</a></li>
									<li><a href="#">1. ��õ</a></li>
									
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
							<div class="panel-body"></div>
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
