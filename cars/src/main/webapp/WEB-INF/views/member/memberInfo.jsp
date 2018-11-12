<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/memberInfo.css" rel="stylesheet">

<article>
	<div class="wrap-wrap-profile">
		<form id="modifyInfo" action="/member/modifyInfo" method="post">
			<div class="wrap-profile">
				<div class="profile">
					<h2>나의 정보 수정</h2>
					<input type="hidden" name="mNo" value="${memberVo.mNo}"/>
					<div>						
						<div><label>등급</label></div>
						<div><input type="text" name="mGrade" value="${memberVo.mGrade}" readonly/></div>
					</div>
					<div>
						<div><label>아이디</label></div>
						<div><input type="text" name="mId" value="${memberVo.mId}" readonly/></div>
					</div>
					<div>
						<div><label>비밀번호</label></div>
						<div><input type="password" name="mPass" value="${memberVo.mPass}"/></div>
					</div>
					<div>
						<div><label>이름</label></div>
						<div><input type="text" name="mName" value="${memberVo.mName}"/></div>
					</div>
					<div>
						<div><label>성별</label></div>
						<div>
							<c:choose>
								<c:when test="${memberVo.mGender == 1}">
									<input type="radio" id="male" name="mGender" value="1" checked />
									<label for="male">남자</label>
									<input type="radio" id="female" name="mGender" value="2"/>
									<label for="female">여자</label>
								</c:when>								
								<c:when test="${memberVo.mGender == 2}">
									<input type="radio" id="male" name="mGender" value="1"/>
									<label for="male">남자</label>
									<input type="radio" id="female" name="mGender" value="2" checked/>
									<label for="female">여자</label>
								</c:when> 
							</c:choose>							
						</div>
					</div>
					<div>
						<div><label>나이</label></div>
						<div><input type="text" name="mAge" value="${memberVo.mAge}"/></div>
					</div>					
				</div>
				<div class="wrap-btn">
					<input type="button" class="exit" value="회원 탈퇴"/>
					<input type="button" class="cancel" value="취소" onclick="location.href='/'"/>
					<input type="submit" class="finish" value="수정 완료"/>
				</div>
			</div>
		</form>
	</div>
</article>

<script>
	$(document).ready(function(){
		$(".exit").on("click",function(){
			var conf = confirm('정말 탈퇴하시겠습니까?');
			if(conf == true){
				location.href='/member/exitMember?mNo=${memberVo.mNo}';
			}else{
				return;
			}
		});
	});
</script>

<%@include file="../include/footer.jsp"%>