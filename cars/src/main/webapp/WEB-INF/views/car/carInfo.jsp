<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/category.jsp"%>

<link href="${pageContext.request.contextPath}/resources/css/carInfo.css" rel="stylesheet">

<article>
	<div class="img-info">
		<div class="imgbox">
			<img alt="goods" src="${pageContext.request.contextPath}/resources/img/sonata.jpg">
		</div>
		<div class="info">
			<div class="info-high">
				<label class="carName">2018 소나타 뉴 라이즈</label>
					<br/><br/>
				<label class="carPrice">12,000,000 원</label>
			</div>
			<div class="info-mid">
				<label class="sales">478 대 구매</label>
					<br/>
				<select>
					<option>빨강</option>
					<option>파랑</option>
					<option>노랑</option>
				</select>
			</div>
			<div class="info-row">
				<input type="submit" value="구매하기"/>
				<input type="button" value="장바구니 담기"/>
			</div>
		</div>
	</div>
	<div id="notinews">
		<div class="conatiner">
			<ul class="tabs">
				<li>
					<a href="#tab1">상품정보</a>
				</li>
				<li>
					<a href="#tab2">구매후기</a>
				</li>
			</ul>
			
			<div class="tab_container">
				<div id="tab1" class="tab_content">
											
				</div>
				<div id="tab2" class="tab_content">
					
				</div>					
			</div>
		</div>	
	</div>
</article>

<%@include file="../include/footer.jsp"%>