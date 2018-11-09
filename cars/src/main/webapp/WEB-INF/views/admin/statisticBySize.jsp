<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/categoryadmin.jsp"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/fuelAndSize.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/fuelAndSize.js"></script>

<div class="wrap-piechart">
	<h2>크기별 차량 구매 수</h2>
	<h2>외형별 차량 구매 수</h2>
	<div id="piechart_3d3"></div>
	<div id="piechart_3d4"></div>
</div>

<%@include file="../include/footer.jsp"%>