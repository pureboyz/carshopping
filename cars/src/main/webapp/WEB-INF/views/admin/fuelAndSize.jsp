<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<style>
.wrap-poechart{
	width: 902px;
	height: 550px;
}

#piechart_3d1{
	 width: 900px;
	 height: 500px;
	 margin-top: 50px;
	 padding-left: 150px;
}

h2{
	width: 250px;
}
</style>

<script type="text/javascript">
	google.charts.load("current", {packages:["corechart"]});
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {
		var options = {
		  pieHole: 0.5,
		  title: '',
		  is3D: true,
		};
		
		 $.getJSON("/admin/getFuelAndSize",function(list){
			 var array = new Array(list.length+1);
			 array[0] = new Array(2);
			 array[0][0] = "aaa";
			 array[0][1] = "aaa";
			 for(var i=1; i<= list.length; i++){
				 array[i] = new Array(2);
				 for(var j =0; j<=1; j++){
					 if(j == 0){
						 array[i][j] = list[i-1].name;	 
						 console.log(array[i][j]);
					 }else{
						 array[i][j] = list[i-1].count;
						 console.log(array[i][j]);
					 }
				 }
			 }
			 
			 console.log(array);
			 
			var chart = new google.visualization.PieChart(document.getElementById('piechart_3d1'));
			var data1  = google.visualization.arrayToDataTable(array);
			chart.draw(data1, options);
			
		});
		 
	}
</script>
<div class="wrap-poechart">
	<h2>연료별 차량 구매 수</h2>
	<div id="piechart_3d1"></div>
</div>
<div id="piechart_3d2"></div>


<%@include file="../include/footer.jsp"%>