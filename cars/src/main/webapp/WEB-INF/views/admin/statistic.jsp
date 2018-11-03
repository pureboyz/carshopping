<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
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
/* var list=[
{State:'LAMBORGHINI',freq:{twenties:4786, thirties:1319, forties:249, fifties:4786, overSixty:1319}}
,{State:'BENZ',freq:{twenties:1101, thirties:412, forties:674, fifties:279, overSixty:1578}}
,{State:'AUDI',freq:{twenties:932, thirties:2149, forties:418, fifties:777, overSixty:1736}}
,{State:'BMW',freq:{twenties:832, thirties:1152, forties:1862, fifties:1919, overSixty:1542}}
,{State:'TOYOTA',freq:{twenties:4481, thirties:3304, forties:948, fifties:2000, overSixty:2797}}
,{State:'HYUNDAI',freq:{twenties:1619, thirties:167, forties:1063, fifties:1537, overSixty:444}}
];
dashboard('#dashboard',list); */

$.getJSON("/admin/statisticList",function(list){
	dashboard('#dashboard',list);
});


</script>

<%@include file="../include/footer.jsp"%>