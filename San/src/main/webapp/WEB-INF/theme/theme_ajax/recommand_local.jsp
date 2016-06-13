<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript">

	$(function(){
		$('li').click(function(){	
			var san=$(this).attr("value");
			alert("선택"+san)
			var param="san="+san;
			sendMessage("POST", "recommand_detail.do",param, localSanDetail);
			
		});
	}); 

	function localSanDetail() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
			alert(httpRequest.responseText);
				$('#sanDetail').html(httpRequest.responseText);
			}
		}
	} 

</script>
</head>


<body>
	<ul>
		<c:forEach var="vo" items="${recommandlist }">
			<li value="${vo.local }"><a href="#">${vo.local }</a></li>
		</c:forEach>
	</ul>
</body>


</html>