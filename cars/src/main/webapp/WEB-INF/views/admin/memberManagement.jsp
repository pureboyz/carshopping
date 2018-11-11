<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/categoryadmin.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>


<style>
article{
	width: 1580px;
}

.wrap_table {
	border: 1px solid skyblue;
	width: 650px;
}

table {
	text-align: center;
}

th, td {
	padding: 3px;
}

input[type="text"] {
	width: 30px;
}

.memberNo {
	width: 80px;
}

.memberId {
	width: 160px;
}

.memberName {
	width: 160px;
}

.memberAge, .memberGender {
	width: 50px;
}

.memberGrade {
	width: 100px;
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
<article>
	<div class="wrap_table">
		<form id="modifyMember" action="/admin/modifyMemberPOST" method="post">
			<!-- <form id="modifyMember" action="/admin/modifyMember" method="get"> -->
			<input type="hidden" id="mNo" name="mNo">
			<input type="hidden" id="mGrade" name="mGrade">
		</form>			
			<table>
				<tr>
					<th class="titleMenu memberNo">회원번호</th>
					<th class="titleMenu memberId">회원아이디</th>
					<th class="titleMenu memberName">회원명</th>
					<th class="titleMenu memberAge">나이</th>
					<th class="titleMenu memberGender">성별</th>
					<th class="titleMenu memberGrade">회원등급</th>
					<th></th>
				</tr>
				<c:forEach var="memberVo" items="${memberList}">
					<tr>
						<td><input type="text" id="mNo${memberVo.mNo}" name="mNo"
							value="${memberVo.mNo}" style="border-style: none" readonly></td>
						<td>${memberVo.mId}</td>
						<td>${memberVo.mName}</td>
						<td>${memberVo.mAge}</td>
						<td><c:choose>
								<c:when test="${memberVo.mGender == 1}">
									남
								</c:when>
								<c:when test="${memberVo.mGender == 2}">
									여
								</c:when>
								<c:otherwise>
									괴물
								</c:otherwise>
							</c:choose></td>
						<td><c:if test="${loginMember.mNo == memberVo.mNo}">
								<select id="memberGrade${memberVo.mNo}" name="mGrade" disabled="disabled">
									<c:choose>
										<c:when test="${memberVo.mGrade == 2}">
											<option value="2" selected="selected">관리자</option>
											<option value="1">일반회원</option>
											<option value="0">불량회원</option>
										</c:when>
										<c:when test="${memberVo.mGrade == 1}">
											<option value="2">관리자</option>
											<option value="1" selected="selected">일반회원</option>
											<option value="0">불량회원</option>
										</c:when>
										<c:when test="${memberVo.mGrade == 0}">
											<option value="2">관리자</option>
											<option value="1">일반회원</option>
											<option value="0" selected="selected">불량회원</option>
										</c:when>
									</c:choose>
								</select>
							</c:if> <c:if test="${loginMember.mNo != memberVo.mNo}">
								<select id="memberGrade${memberVo.mNo}" name="mGrade">
									<c:choose>
										<c:when test="${memberVo.mGrade == 2}">
											<option value="2" selected="selected">관리자</option>
											<option value="1">일반회원</option>
											<option value="0">불량회원</option>
										</c:when>
										<c:when test="${memberVo.mGrade == 1}">
											<option value="2">관리자</option>
											<option value="1" selected="selected">일반회원</option>
											<option value="0">불량회원</option>
										</c:when>
										<c:when test="${memberVo.mGrade == 0}">
											<option value="2">관리자</option>
											<option value="1">일반회원</option>
											<option value="0" selected="selected">불량회원</option>
										</c:when>
									</c:choose>
								</select>
							</c:if> </select></td>
						<%-- <td><input type="button" id="btnModify" value="수정" 
						onclick="location.href='/admin/modifyMember?mNo='+${memberVo.mNo}+'&mGrade='+${memberVo.mGrade}">
						</td> --%>
						<td><input type="button" onclick="javascript:formSubmit('${memberVo.mNo}');" id="btnModify${memberVo.mNo}" value="수정" /></td>
					</tr>
				</c:forEach>
				
			</table>
		
	</div>
</article>

<script>
	function formSubmit(mNo){		
		//alert($("#mNo"+mNo).val());
		var mno = $("#mNo"+mNo).val();
		var mgrade = $("#memberGrade"+mNo).val();		
		//alert("mno : "+mno+" mGrade : "+mgrade);
		$("#mNo").val(mno);
		$("#mGrade").val(mgrade);		
		$("#modifyMember").submit();		
	}	
	
	var message = "${message}";
	
	if(message != null && message != ""){
		alert(message);
	}
</script>
<script>
	/* $("#btnModify").on("click",function(){
		//location.href="/admin/modifyMember?mNo="+mno+"mGrade="+mGrade;
	});*/
</script>


<%@include file="../include/footer.jsp"%>
