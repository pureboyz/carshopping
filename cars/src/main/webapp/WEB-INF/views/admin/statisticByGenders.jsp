<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/categoryadmin.jsp"%>
<script src="//d3js.org/d3.v3.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/statisticByGenders.css?ver=1" rel="stylesheet">

<article>
	<div class="chartByGender">
		<h2>성별 자동차 구매선호도 TOP4</h2>
		<div class="wrap-chart"></div>
		<div class="gender">
			<div class="male">
				<div class="male_bar"></div>
				<div class="genderName">남성</div>
			</div>
			<div class="female">
				<div class="female_bar"></div>
				<div class="genderName">여성</div>
			</div>
		</div>
	</div>
</article>

<script>
var margin = {top: 20, right: 30, bottom: 40, left: 30},
width = 960 - margin.left - margin.right,
height = 500 - margin.top - margin.bottom;

var x = d3.scale.linear()
.range([0, width]);

var y = d3.scale.ordinal()
.rangeRoundBands([0, height], 0.1);

var xAxis = d3.svg.axis()
.scale(x)
.orient("bottom");

var yAxis = d3.svg.axis()
.scale(y)
.orient("left")
.tickSize(0)
.tickPadding(6);

var svg = d3.select(".wrap-chart").append("svg")
.attr("width", width + margin.left + margin.right)
.attr("height", height + margin.top + margin.bottom)
.append("g")
.attr("transform", "translate(" + margin.left + "," + margin.top + ")");

d3.tsv("${pageContext.request.contextPath}/resources/data/topByGenders.tsv", type, function(error, data) {
x.domain(d3.extent(data, function(d) { return d.value; })).nice();
y.domain(data.map(function(d) { return d.name; }));

svg.selectAll(".bar")
  .data(data)
.enter().append("rect")
  .attr("class", function(d) { return "bar bar--" + (d.value < 0 ? "negative" : "positive"); })
  .attr("x", function(d) { return x(Math.min(0, d.value)); })
  .attr("y", function(d) { return y(d.name); })
  .attr("width", function(d) { return Math.abs(x(d.value) - x(0)); })
  .attr("height", y.rangeBand());

svg.append("g")
  .attr("class", "x axis")
  .attr("transform", "translate(0," + height + ")")
  .call(xAxis);

svg.append("g")
  .attr("class", "y axis")
  .attr("transform", "translate(" + x(0) + ",0)")
  .call(yAxis);
});

function type(d) {
d.value = +d.value;
return d;
}
</script>
<%@include file="../include/footer.jsp"%>