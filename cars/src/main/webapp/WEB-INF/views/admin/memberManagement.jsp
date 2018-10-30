<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/categoryadmin.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
.wrap_table {
	border: 1px solid skyblue;
	width: 400px;
}

table {
	text-align: center;
}

th, td {
	padding: 3px;
}
</style>


<!-- 
<div class="wrap">
	<div class="title">
		<div class="titleMenu memberNo"></div>
		<div class="titleMenu memberId"></div>
		<div class="titleMenu memberName"></div>
		<div class="titleMenu memberAge"></div>
		<div class="titleMenu memberGender"></div>
		<div class="titleMenu memberGrade"></div>
	</div>
 -->
<div>
	<div class="wrap_table">
		<form id="modifyMember" method="post">
			<table>
				<tr>
					<th class="titleMenu memberNo">회원번호</th>
					<th class="titleMenu memberId">회원아이디</th>
					<th class="titleMenu memberName">회원명</th>
					<th class="titleMenu memberAge">나이</th>
					<th class="titleMenu memberGender">성별</th>
					<th class="titleMenu memberGrade">회원등급</th>
				</tr>
				<c:forEach var="memberVo" items="${memberList}">
					<tr>
						<td>${memberVo.mNo}</td>
						<td>${memberVo.mId}</td>
						<td>${memberVo.mName}</td>
						<td>${memberVo.mAge}</td>
						<td><c:choose>
								<c:when test="${memberVo.mGender == 1}">
								남
							</c:when>
								<c:otherwise>
								여
							</c:otherwise>
							</c:choose></td>
						<td><select name="mGrade">
								<c:choose>
									<c:when test="${memberVo.mGrade == 2}">
										<option>관리자</option>
									</c:when>
									<c:when test="${memberVo.mGrade == 1}">
										<option>일반회원</option>
									</c:when>
									<c:otherwise>
										<option>불량회원</option>
									</c:otherwise>
								</c:choose>
								<c:if test="${memberVo.mGrade != 2}">
									<option value="2">관리자</option>
								</c:if>
								<c:if test="${memberVo.mGrade != 1}">
									<option value="1">일반회원</option>
								</c:if>
								<c:if test="${memberVo.mGrade != 0}">
									<option value="0">불량회원</option>
								</c:if>
						</select></td>
					</tr>
				</c:forEach>
			</table>
		</form>


	</div>
</div>






<%@include file="../include/footer.jsp"%>