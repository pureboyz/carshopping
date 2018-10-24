<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.wrapper{
		margin: 50px 0px;
		border-top: 1px solid #ccc;
		border-bottom: 1px solid #ccc;
		background-color: pink;
	}
	
	.wrap-category{
		width: 1300px;
	}
	
	.category{
		width: 754px;
		height: 142px;
		text-align: center;
		/* border: 1px solid green; */
	}
	
	.company{
		float: left;
		margin: 20px;
		/* border: 1px solid red; */
	}

	.company li{
		list-style: none;
		float: left;
		margin: 10px;
		height: 80px;
		width: 80px;
		line-height: 100%;
		background-color: white;
		/* border: 1px solid blue; */
	}
	
	.company li:hover{
		cursor: pointer;
	}
	
	img{
		width: 78px;
	}
	
</style>
<div class="wrapper">
	<div class="wrap-category">
		<div class="category">
			<ul class="company">
				<li></li>
				<li><img alt="" src="../../resources/img/lamborghini.jpg" style="margin-top:4px"/></li>
				<li><img alt="" src="../../resources/img/benz.jpg" style="margin-top:18px"/></li>
				<li><img alt="" src="../../resources/img/audi.png" style="margin-top:17px"/></li>
				<li><img alt="" src="../../resources/img/bmw.jpg" style="margin-top:12px"/></li>
				<li><img alt="" src="../../resources/img/toyota.jpg" style="margin-top:2px"/></li>
				<li><img alt="" src="../../resources/img/hyundai.jpg" style="margin-top:14px"/></li>
			</ul>
		</div>
	</div>
</div>