<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/categoryadmin.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<style>
article{
	width: 1580px;
}

#chart_div{
	width: 900px;
	height: 500px;
	margin: 0 auto;
}

h2, h3{
	text-align: center;
}
</style>

<article>
	<h2>날짜별 판매액</h2>
	<div id="chart_div"></div>
	<h3>총 판매액 : <fmt:formatNumber value="${totalSales}" type="currency"/> 만원</h3>
</article>

<script>
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'X');
      data.addColumn('number', '판매액');
      
	$.getJSON("/admin/getSales",function(list){
		console.log(list);
   	    var array = new Array(list.length);
  		for(var i=0; i< list.length; i++){
  			array[i] = new Array(2);
  			for(var j =0; j<=1; j++){
  				if(j == 0){
  					array[i][j] = list[i].name;
  					console.log(array[i][j]);
  				}else{
  					array[i][j] = list[i].count;
  					console.log(array[i][j]);
  				}
  			}
  		}
  		data.addRows(array);
  		console.log(array);
  		
  		var options = {
	        hAxis: {
	          title: '단위 : 만원'
	        },
	        vAxis: {
	          title: ''
	        }
  		};
  		
  		var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
		chart.draw(data, options);
	});
    	
}
</script>

<%@include file="../include/footer.jsp"%>