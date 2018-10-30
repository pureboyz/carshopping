<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/category.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/resources/css/buyInfo.css" rel="stylesheet">

<article>
	<h1>구매 내역</h1>
	<div>
		<c:forEach var="vo" items="${cList}">
			<div class="buyList">
				<div class="imgBox">
					<img alt="car" src="${pageContext.request.contextPath}/resources/img/${vo.carName}.png">
				</div>
					<div class="infoBox">
						<h2>${vo.carName}</h2>
						<div class="infoBox-low">
							<label>제조사 : ${vo.carComp}</label>&nbsp;&nbsp;&nbsp;
							<label>배기량 : ${vo.carCC} cc</label>&nbsp;&nbsp;&nbsp;
							<label>연비 : ${vo.carEff} km/l</label>&nbsp;&nbsp;&nbsp;
							<label>등급 : ${vo.carSize} 형</label>&nbsp;&nbsp;&nbsp;
							<label>연료 : ${vo.carFuel}</label>
						</div>
					</div>
				<div class="btnBox">
					<input id="btnDelete" type="button" value="구매내역삭제"/>
					<input id="btnInfo" type="button" value="상품정보보기"/>
				</div>
			</div>
		</c:forEach>
	</div>
</article>

<script>
	var message = "${message}";
	
	if(message != null && message != ""){
		alert(message);
	}
</script>
<%@include file="../include/footer.jsp"%>