<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="${pageContext.request.contextPath}/resources/css/categoryadmin.css" rel="stylesheet">

<div class="wrapper">
	<div class="wrap-category">
		<div class="category">
			<ul class="company">
				<li onclick="location.href='/admin/memberManagement'"><span>회원관리</span></li>
				<li onclick="location.href='/admin/statisticByAges'"><span>연령별 통계</span></li>
				<li onclick="location.href='/admin/statisticByGenders'"><span>성별 통계</span></li>
				<li onclick="location.href='/admin/statisticByFuel'"><span>연료별 통계</span></li>
				<li onclick="location.href='/admin/statisticBySize'"><span>외형별 통계</span></li>
				<li onclick="location.href='/admin/statisticBySales'"><span>매출액</span></li>
			</ul>
		</div>
	</div>
</div>