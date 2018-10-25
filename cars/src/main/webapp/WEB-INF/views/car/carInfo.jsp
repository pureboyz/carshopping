<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/category.jsp"%>

<link href="${pageContext.request.contextPath}/resources/css/carInfo.css" rel="stylesheet">

<article>
	<div class="img-info">
		<div class="imgbox">
			<img alt="goods" src="${pageContext.request.contextPath}/resources/img/${carVo.carName}.jpg">
		</div>
		<div class="info">
			<div class="info-high">
				<label class="carName">2018 소나타 뉴 라이즈</label>
					<br/><br/><br/>
				<label class="carPrice">12,000,000 원</label>
			</div>
			<div class="info-mid">
				<label class="sales">478 대 구매</label>
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
					<table>
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
			<h2>구매 후기</h2>
			<div id="tab2" class="tab_content">
				
			</div>	
		</div>	
	</div>
</article>

<%@include file="../include/footer.jsp"%>