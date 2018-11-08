google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
	var options = {
	  pieHole: 0.5,
	  title: '',
	  is3D: true,
	};
	
	$.getJSON("/admin/getCountByFuel",function(list){
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
		var data  = google.visualization.arrayToDataTable(array);
		chart.draw(data, options);
	});
	
	$.getJSON("/admin/getCountByEff",function(list){
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
		 
		var chart = new google.visualization.PieChart(document.getElementById('piechart_3d2'));
		var data  = google.visualization.arrayToDataTable(array);
		chart.draw(data, options);
	});
	 
	$.getJSON("/admin/getCountBySize",function(list){
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
		 
		var chart = new google.visualization.PieChart(document.getElementById('piechart_3d3'));
		var data  = google.visualization.arrayToDataTable(array);
		chart.draw(data, options);
	});
	
	$.getJSON("/admin/getCountByLook",function(list){
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
		 
		var chart = new google.visualization.PieChart(document.getElementById('piechart_3d4'));
		var data  = google.visualization.arrayToDataTable(array);
		chart.draw(data, options);
	});
	 
}