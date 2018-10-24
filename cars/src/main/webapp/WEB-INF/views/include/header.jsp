<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CarS.com</title>

<style>
	*{
		margin: 0px auto;
		padding: 0px;
	}
	
	header{
		height:160px;
		padding: 10px;
	}
	
	.wrap-header{
		width: 1300px;
		height: 150px;
		text-align: center;
		border: 1px solid black;
	}
	
	.logo{
		width: 696px;
		height: 148px;
		margin: 0px auto;
		margin-left: 300px;
		float: left;
		text-align: center;
		border: 1px solid blue;
	}
	
	.logo img{
		
	}
	
	.member{
		width: 300px;
		height: 148px;
		float: left;
		/* border: 1px solid red; */
	}
	
	.member-sign{
		height: 73px;
		/* border: 1px solid green; */
	}
	
	.member-info{
		height: 73px;
		/* border: 1px solid green; */
	}
	
	.member-sign a{
		margin: auto 10px auto 0;
		float: right;
		text-decoration: none;
		line-height: 73px;
	}
	
	.member-info a{
		margin: auto 10px auto 0;
		float: right;
		text-decoration: none;
		line-height: 20px;
	}
	
	
</style>

</head>


<body>

<header>
	<div class="wrap-header">
		<div class="logo">
			<img alt="logo" src="../../resources/img/benz.jpg" style="height:140px"/>
		</div>
		<div class="member">
			<div class="member-sign">
				<a href="/member/join" style="color:black">회원가입</a>
				<a href="/member/login" style="color:black">로그인</a>
			</div>
			<div class="member-info">
				<a href="" style="color:black">공지사항</a>
				<a href="" style="color:black">구매내역</a>
				<a href="" style="color:black">정보수정</a>
			</div>
		</div>
	</div>
</header>

