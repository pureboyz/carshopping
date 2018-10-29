<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="${pageContext.request.contextPath}/resources/css/category.css" rel="stylesheet">

<div class="wrapper">
	<div class="wrap-category">
		<div class="category">
			<ul class="company">
				<li onclick="location.href='/'" ><img alt="BEST" src="../../resources/img/best.jpg" style="margin-top:3px"/></li>
				<li onclick="location.href='/car/searchComp?carComp=lamborghini'" ><img alt="lamborghini" src="../../resources/img/lamborghini.jpg" style="margin-top:4px"/></li>
				<li onclick="location.href='/car/searchComp?carComp=benz'"><img alt="benz" src="../../resources/img/benz.jpg" style="margin-top:18px"/></li>
				<li onclick="location.href='/car/searchComp?carComp=audi'"><img alt="audi" src="../../resources/img/audi.png" style="margin-top:17px"/></li>
				<li onclick="location.href='/car/searchComp?carComp=bmw'"><img alt="bmw" src="../../resources/img/bmw.jpg" style="margin-top:12px"/></li>
				<li onclick="location.href='/car/searchComp?carComp=toyota'"><img alt="toyota" src="../../resources/img/toyota.jpg" style="margin-top:2px"/></li>
				<li onclick="location.href='/car/searchComp?carComp=hyundai'"><img alt="hyundai" src="../../resources/img/hyundai.jpg" style="margin-top:14px"/></li>
				<li onclick="location.href='/car/allCar'"><img alt="ALL" src="../../resources/img/all2.png"/></li>
			</ul>
		</div>
	</div>
</div>