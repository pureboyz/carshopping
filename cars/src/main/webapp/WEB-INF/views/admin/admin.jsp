<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/categoryadmin.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
.menuDiv{
	width: 100px;
	height: 30px;
	border:1px solid black;
	margin:5px auto;
	text-align:center;
}
</style>


<div class="menuDiv" onclick="location.href='/admin/memberManagement'">회원관리</div>
<div class="menuDiv" onclick="location.href='/admin/statistic?comp=all'">통계</div>
<div class="menuDiv" onclick="location.href='/admin/topByGenders'">성별top4</div>
<div class="menuDiv" onclick="location.href='/admin/fuelAndSize'">연료/크기별 통계</div>
<div class="menuDiv" onclick="location.href='/admin/sales'">매출</div>





<%@include file="../include/footer.jsp"%>