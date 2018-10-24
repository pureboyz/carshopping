<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<link href="${pageContext.request.contextPath}/resources/css/memberInfo.css" rel="stylesheet">

<article>
	<div class="wrap-wrap-profile">
		<form>
			<div class="wrap-profile">
				<div class="profile">
					<h2>나의 정보 수정</h2>
					<div>
						<div><label>등급</label></div>
						<div><input type="text" value="일반회원"/></div>
					</div>
					<div>
						<div><label>아이디</label></div>
						<div><input type="text" value="id001"/></div>
					</div>
					<div>
						<div><label>비밀번호</label></div>
						<div><input type="text" value=""/></div>
					</div>
					<div>
						<div><label>이름</label></div>
						<div><input type="text" value="김회원"/></div>
					</div>
					<div>
						<div><label>성별</label></div>
						<div>
							<input type="radio" id="male" name="gender" checked/>
							<label for="male">남자</label>
							<input type="radio" id="female" name="gender"/>
							<label for="female">여자</label>
						</div>
					</div>
					<div>
						<div><label>나이</label></div>
						<div><input type="text" value="20"/></div>
					</div>
					<div>
						<div><label>주소</label></div>
						<div><input type="text" value="부산광역시 동래구 충렬대로 84 영남빌딩 9층 901호"/></div>
					</div>
				</div>
				<div class="wrap-btn">
					<input type="button" class="exit" value="회원 탈퇴"/>
					<input type="button" class="cancel" value="취소"/>
					<input type="submit" class="finish" value="수정 완료"/>
				</div>
			</div>
		</form>
	</div>
</article>

<%@include file="../include/footer.jsp"%>