<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/categoryadmin.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/resources/css/statistic.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/statistic.js"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<article>
<div class="age-comp">
	<h2>연령별 제조사 선호도</h2>
	<div id='dashboard'>
	</div>
</div>
</article>
<script>

$.getJSON("/admin/statisticList",function(list){
	console.log(list);
	dashboard('#dashboard',list);
});

</script>
<%-- <c:choose>
<c:when test="${comp eq 'all'}">
<script>

$.getJSON("/admin/statisticList",function(list){
	console.log(list);
	dashboard('#dashboard',list);
});

</script>
</c:when>
<c:when test="${comp eq 'lamborghini'}">
<script>

$.getJSON("/admin/lamborghini",function(list){
	
	console.log(list);
	dashboard('#dashboard',list);
});

</script>
</c:when>
</c:choose> --%>

<%@include file="../include/footer.jsp"%>