<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<%@include file="include/category.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link href="${pageContext.request.contextPath}/resources/css/home.css" rel="stylesheet">

<article>
	<div class="wrap-search">
		<input type="text" class="searchBar" placeholder="검색어를 입력하세요."/>
		<input type="button" class="btnSearch" value="검색">
	</div>
	<div class="wrap-goods">
		<ul class="goods">
		<%-- <c:forEach begin="0" end="7" var="carVo" items="${carList}"> --%>
			<c:forEach var="carVo" items="${carList}">
				<li onclick="location.href='/car/carInfo?carNo=${carVo.carNo}'">
					<div class="wrap-img">
						<img alt="${carVo.carName}" src="../../resources/img/${carVo.carName}.png"/>
					</div>
					<div>
						<label class="carName">${carVo.carName}</label>
							<br/><br/>
						<label>${carVo.carComp}</label>
							<br/><br/>
						<label class="carPrice"><fmt:formatNumber value="${carVo.carPrice}" type="currency"/>,000 원</label>
							<br/>
						<label class="sales">${carVo.carsale} 대 구매</label>
					</div>
				</li>
			</c:forEach>
				
		</ul>
	</div>
</article>
<script>
	var message = "${message}";
	
	if(message != null && message != ""){
		alert(message);
	}
</script>


<%@include file="include/footer.jsp"%>