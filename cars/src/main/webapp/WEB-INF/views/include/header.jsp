<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CarS.com</title>

<link href="${pageContext.request.contextPath}/resources/css/header.css" rel="stylesheet">

</head>

<body>

<header>
	<div class="wrap-header">
		<div class="logo">
			<img alt="logo" src="../../resources/img/logo.png" style="height:140px"  onclick="location.href='/'"/>
		</div>
		<div class="member">
			<c:choose>
				<c:when test = "${!empty loginMember}"> 
					<div class="member-sign">
						<a href="/member/logout" style="color:black">로그아웃</a>
						<a>${loginMember.mName}님</a>
						<c:if test="${loginMember.mGrade == '2'}">
							<a href="/admin/admin" style="color:black">management&nbsp;&nbsp;&nbsp;</a>
						</c:if>
					</div>
				</c:when>
				<c:otherwise>
					<div class="member-sign">
						<a href="/member/join" style="color:black">회원가입</a>
						<a href="/member/login" style="color:black">로그인</a>
					</div>
				</c:otherwise>
			</c:choose>
			<div class="member-info">
				<a href="/board/boardList" style="color:black">게시판</a>
				<a href="/car/buyInfo?basketCurrentPage=1&currentPage=1" style="color:black">구매내역</a>
				<a href="/member/memberInfo" style="color:black">정보수정</a>
			</div>
		</div>
	</div>
</header>

