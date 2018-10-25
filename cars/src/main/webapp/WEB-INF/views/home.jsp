<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<%@include file="include/category.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/resources/css/home.css" rel="stylesheet">

<article>
	<div class="wrap-search">
		<input type="text" class="searchBar" placeholder="검색어를 입력하세요."/>
		<input type="button" class="btnSearch" value="검색">
	</div>
	<div class="wrap-goods">
		<ul class="goods">
			 <!-- 여기를 for문으로 -->
		 	<c:forEach begin="0" end="8" items="i">
				<li onclick="location.href='/car/carInfo'">
					<div class="wrap-img">
						<img alt="sonata" src="../../resources/img/sonata.jpg"/>
					</div>
					<div>
						<label class="carName">2018 소나타 뉴 라이즈</label>
							<br/><br/>
						<label>HYUNDAI</label>
							<br/><br/>
						<label class="carPrice">12,000,000 원</label>
							<br/>
						<label class="sales">478 대 구매</label>
					</div>
				</li>
			</c:forEach>
		</ul>
		
	</div>
</article>



<%@include file="include/footer.jsp"%>