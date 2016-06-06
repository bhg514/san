<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE HTML>
<html>
<head>
<title>SIST BOOK CENTER</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<!-- script -->
<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/main.js"></script>

<!-- css -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- <link href="assets/css/style.css" rel="stylesheet" /> -->
<link href="assets/css/main.css" rel="stylesheet" />
</head>

<body>


	<!-- Header -->
	<tiles:insertAttribute name="header" />


	<!-- Body -->
	<tiles:insertAttribute name="body" />


	<!-- Footer -->
	<tiles:insertAttribute name="footer" />

</body>
</html>