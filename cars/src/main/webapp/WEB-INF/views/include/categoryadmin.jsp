<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="${pageContext.request.contextPath}/resources/css/categoryadmin.css" rel="stylesheet">

<div class="wrapper">
	<div class="wrap-category">
		<div class="category">
			<ul class="company">
				<li onclick="location.href='/admin/memberManagement'"><span>회원관리</span></li>
				<li onclick="location.href='/admin/statistic?comp=all'"><span>연령별 통계</span></li>
				<li onclick="location.href='/admin/topByGenders'"><span>성별 통계</span></li>
				<li onclick="location.href='/admin/fuelAndSize'"><span>연료별 통계</span></li>
				<li onclick="location.href='/admin/statisticBySize'"><span>외형별 통계</span></li>
				<li onclick="location.href='/admin/sales'"><span>매출액</span></li>
				<!-- <li onclick="location.href='/admin/statistic?comp=toyota'"><img alt="toyota" src="../../resources/img/toyota.jpg" style="margin-top:2px"/></li>
				<li onclick="location.href='/admin/statistic?comp=hyundai'"><img alt="hyundai" src="../../resources/img/hyundai.jpg" style="margin-top:14px"/></li>
				<li onclick="location.href='/admin/statistic?comp=all'"><img alt="ALL" src="../../resources/img/all2.png"/></li> -->
			</ul>
		</div>
	</div>
</div>