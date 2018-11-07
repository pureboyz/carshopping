<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load("current", {packages:["corechart"]});
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {
		var data = google.visualization.arrayToDataTable([
		  ['Task', 'Hours per Day'],
		  ['Work',     11],
		  ['Eat',      2],
		  ['Commute',  2],
		  ['Watch TV', 2],
		  ['Sleep',    7],
		  ['Game',    9]
		]);
		/* $.getJSON("/admin/getFuelAndSize",function(list){
			var chart = new google.visualization.PieChart(document.getElementById('piechart_3d1'));
			chart.draw(list, options);
		}); */
		
		var options = {
		  title: 'My Daily Activities',
		  is3D: true,
		};
		var chart = new google.visualization.PieChart(document.getElementById('piechart_3d1'));
		chart.draw(data, options);
		/* var chart = new google.visualization.PieChart(document.getElementById('piechart_3d2'));
		chart.draw(data, options); */
	}
</script>

<div id="piechart_3d1" style="width: 900px; height: 500px;"></div>
<div id="piechart_3d2" style="width: 900px; height: 500px;"></div>
<div>
	<input type="button" value="다음페이지로" onclick="testApplication"/>
</div>