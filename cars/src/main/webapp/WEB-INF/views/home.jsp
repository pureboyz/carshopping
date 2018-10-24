<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<%@include file="include/category.jsp" %>

<style>
	.wrap-goods{
		width: 1300px;
		text-align: center;
	}

	.goods{
		width: 1140px;
	}

	.goods li{
		list-style: none;
		width: 348px;
		height: 400px;
		margin: 25px 15px;
		float: left;
		border: 1px solid red;
	}
	
	.goods li:hover{
		cursor: pointer;
	}
	
	.wrap-img{
		width: 348px;
		height: 230px;
	}
	
	.goods li img{
		width: 348px;
	}
	
	.carName{
		font-size: 1.3em;
		font-weight: bold;
	}
	
	.carPrice{
		font-size: 1.3em;
		font-weight: bold;
	}
	
	.sales{
		font-size: 0.9em;
	}
	
	
</style>

<article>
	<div class="wrap-goods">
		<ul class="goods">
			<li onclick="location.href='/car/carInfo'">
				<div class="wrap-img">
					<img alt="sonata" src="../../resources/img/sonata.jpg"/>
				</div>
				<div>
					<label class="carName">2018 소나타 뉴 라이즈</label>
						<br/><br/>
					<label>중형</label>
						<br/><br/>
					<label class="carPrice">12,000,000 원</label>
						<br/>
					<label class="sales">478 대 구매</label>
				</div>
			</li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</article>



<%@include file="include/footer.jsp"%>