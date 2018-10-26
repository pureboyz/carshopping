<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/category.jsp"%>

<link href="${pageContext.request.contextPath}/resources/css/carInfo.css" rel="stylesheet">

<article>
	<div class="img-info">
		<div class="imgbox">
			<img alt="goods" src="${pageContext.request.contextPath}/resources/img/${car.carName}.png">
		</div>
		<div class="info">
			<div class="info-high">
				<label class="carName">${car.carComp}&nbsp;${car.carName}</label>
					<br/><br/><br/>
				<fmt:formatNumber value="${car.carPrice}" type="currency"/>,000
			</div>
			<div class="info-mid">
				<label class="sales">${car.carsale} 대 구매</label>
					<br/>
				<div class="selectbox">
					<select>
						<option>빨강</option>
						<option>파랑</option>
						<option>노랑</option>
					</select>
				</div>
			</div>
			<div class="info-row">
				<input type="submit" value="구매하기"/>
				<input type="button" value="장바구니"/>
			</div>
		</div>
	</div>
	<div class="info-detail">
		<div class="conatiner">
			<h2>상품 정보</h2>
			<div class="tab_container">
				<div id="tab1" class="tab_content">
					<table class="tbl1">
						<tr>
							<th>구매 & 배송</th>
							<th>안내사항</th>
						</tr>
						<tr>
							<td>
								<br/>[구매정보]<br/><br/>
								주문 취소와 배송상태 확인은 불가능합니다.<br/>
								옵션 선택은 색상만 가능합니다.<br/>
								구매완료 후 '구매내역' 페이지에서 구매내역이 확인가능합니다.<br/>
								<br/><br/>
								[배송정보]<br/><br/>
								1인당 구매가능수량은 제한이 없습니다.<br/>
								무료배송, 묶음배송 가능 <br/>
								당일출고(공휴일/주말 제외)<br/>
								배송 중 분실되어도 책임을 지지 않습니다. <br/>
							</td>
							<td>
								<br/>[반품기간]<br/><br/>
								상품수령일로 부터 7일 이내 반품 가능합니다.<br/>
								고객변심의 경우 왕복 택배비 5,000,000원 (1개 기준) 부담 <br/>
								도서 산간 지역 추가 운임 발생 <br/>
								<br/><br/>
								[반품 기준]<br/><br/>
								단, 7일 이내라도 제품 사용, 훼손된 경우 반품이 어렵습니다.<br/><br/><br/><br/>
							</td>
						</tr>
					</table>
				</div>				
			</div>
			<h2>모델 제원</h2>
			<table class="tbl2" cellspacing=0>
				<tr><td>모델명</td><td>${car.carName}</td></tr>
				<tr><td>모델가격</td><td><fmt:formatNumber value="${car.carPrice}" type="currency"/>,000</td></tr>
				<tr><td>제조사</td><td>${car.carComp}</td></tr>
				<tr><td>배기량</td><td>${car.carCC} cc</td></tr>
				<tr><td>연비</td><td>${car.carEff} km/l</td></tr>
				<tr><td>등급</td><td>${car.carSize}</td></tr>
				<tr><td>연료</td><td>${car.carFuel}</td></tr>
			</table>
			<h2>구매 후기</h2>
			<div id="tab2" class="tab_content">
				<script id="reply-template" type="text/x-handlebars-template">
					<div>
						<h1>{{name}}</h1>
						<div>
							{{comment}}
						</div>
					</div>
				</script>
			</div>	
		</div>	
	</div>
</article>

<script>
	$(document).ready(function(){
		var source   = document.getElementById("reply-template").innerHTML;
		var template = Handlebars.compile(source);
		var context = {name: "토르", comment: "This is my first post!"};
		$(".tab_content").html(template(context));
	});

</script>

<%@include file="../include/footer.jsp"%>