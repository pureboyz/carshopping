<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<title>회원가입</title>

<style>
.wrap{
	border:1px solid #333;
}

.joinForm {
	border: 1px solid skyblue;
	width: 350px;
	text-align:center;
	/*margin: 0 auto;*/ padding : 5px;
	box-sizing: border-box;
	padding: 5px
}

.joinFormGroup {
	text-align:center;
	padding:3px;
	width: 300px;
	margin: 3px auto;
}

.loginFormGroup:last-child input.inputSubmit {
	float: right;
}

input[type=submit]{
	padding:3px;
	border-radius:3px;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="joinForm">
			<p>회원가입</p>
			<form action="" method="post">
				<div class="joinFormGroup ">
					<input type="text" name="mId" placeholder="아이디를 입력하세요">
				</div>
				<div class="joinFormGroup ">
					<input type="password" name="mPass" placeholder="비밀번호를 입력하세요">
				</div>				
				<div class="joinFormGroup ">
					<input type="password" name="mPass2" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="joinFormGroup ">
					<input type="text" name="mName" placeholder="이름을 입력하세요">
				</div>
				<div class="joinFormGroup ">
					나이 &nbsp;<input type="number" name="mAge" min="20" max="80">
				</div>
				<div class="joinFormGroup ">
					<label>성별</label>
					<select name="mGender">
						성별을 선택해주세요
						<option value=1>남</option>
						<option value=2>여</option>
					</select>
				</div>
				<div class="joinFormGroup ">
					<input type="submit" value="완료">
				</div>
				
								
			</form>	
		</div>
	</div>
	
	<script>
		var message = "${message}";
		
		if(message != null && message != ""){
			alert(message);
		}
		
	</script>
</body>
</html>