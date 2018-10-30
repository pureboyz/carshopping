<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/category.jsp"%>
<link href="${pageContext.request.contextPath}/resources/css/buyInfo.css" rel="stylesheet">

<article>
	<h1>구매 내역</h1>
	<div>
		<div class="buyList">
			<div class="imgBox">
				img
			</div>
			<div>
				
			</div>
		</div>
	</div>
</article>

<script>
	var message = "${message}";
	
	if(message != null && message != ""){
		alert(message);
	}
</script>
<%@include file="../include/footer.jsp"%>