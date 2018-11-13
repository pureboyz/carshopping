<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/categoryadmin.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="${pageContext.request.contextPath}/resources/js/carInfo.js"></script>

<style>
article{
	width: 1580px;
	text-align:center;
}
.menuDiv{
	width: 100px;
	height: 30px;
	border:1px solid black;
	margin:5px auto;
	text-align:center;
}

img{
	margin:0 auto;
}
</style>

<article>
	<!-- <img src="../../resources/img/람보르기니.gif"/> -->
	<!-- <img src="../../resources/img/니드포스피드.gif"/>	 -->
	<img src="../../resources/img/니드포스피드2.gif"/>		
	<!--	
	<div class="menuDiv" onclick="location.href='/admin/memberManagement'">회원관리</div>
	<div class="menuDiv" onclick="location.href='/admin/statisticByAges'">연령별통계</div>
	<div class="menuDiv" onclick="location.href='/admin/statisticByGenders'">성별top4</div>
	<div class="menuDiv" onclick="location.href='/admin/statisticByFuel'">연료별 통계</div>
	<div class="menuDiv" onclick="location.href='/admin/statisticBySize'">크기별 통계</div>
	<div class="menuDiv" onclick="location.href='/admin/statisticBySales'">매출</div>
	-->
</article>




<%@include file="../include/footer.jsp"%>