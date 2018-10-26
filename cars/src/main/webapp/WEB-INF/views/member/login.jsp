<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<title>로그인</title>
<style>

.wrap{
	border:1px solid #333;
}

.loginForm {
	border: 1px solid skyblue;
	width: 350px;
	text-align:center;
	/*margin: 0 auto;*/ padding : 5px;
	box-sizing: border-box;
	padding: 5px
}

.loginFormGroup {
	text-align:center;
	width: 300px;
	margin: 3px auto;
}

.loginFormGroup:nth-child(3) input.inputSubmit {
	float: right;
}

.loginInput input {
	width: 100%;
	margin: 3px;
	padding: 6px;
}

input[type=submit]{
	padding:3px;
	border-radius:3px;
}

.memberJoin {
	text-decoration: none;
	color: skyblue;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="loginForm">
			<p>로그인</p>
			<form action="/member/loginPost" method="post">
				<div class="loginFormGroup loginInput">
					<input type="text" name="uid" placeholder="아이디를 입력하세요">
				</div>
				<div class="loginFormGroup loginInput">
					<input type="password" name="upw" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="loginFormGroup">
					<label> <input type="checkbox" name="mCookie">로그인정보
						기억하기
					</label> <input type="submit" class="inputSubmit" value="로그인">
				</div>

			</form>
			<div class="loginFormGroup">
				<a class="memberJoin" href="/member/join">회원가입</a>
			</div>
		</div>
	</div>

</body>
</html>