<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>

table{
	width:600px;
	border : 1px solid skyblue;
	border-collapse: collapse;
}

tr:nth-child(2) td{
	border-bottom: 1px solid skyblue;
}

#contents{
	width:100%;
	height:500px;
	border:1px solid skyblue;
}

#contents textarea{
	padding: 5px 0px;
	height:490px;
	width:100%;
	resize: none;
	border-style: none;
}

.wrap{
	width:760px;
	height:1000px;
}

.part{
	width:100%;
}

</style>

<body>
		<!-- 
		<div class="wrap">
			<div class="part 1stLine">
				<div class="bno"></div>
				<div class="date"></div>
				<div class="readcnt"></div>	
			</div>
			<div class="part 2ndLine">
				<div class="title"></div>
				<div class="writer"></div>
			</div>
			<div class="part 3rdContent">
				
			</div>
			<div class="part 4thBtnLine">
				<form id="readForm">
					<input type="hidden" name="bNo" value="${boardVo.bNo}">
					<input type="hidden" name="mNo" value="${boardVo.mNo}">
					<input type="hidden" name="bGrade" value="${boardVo.bGrade}">
					<input type="button" id="modifyBtn" value="수정하기"> 
					<input type="button" id="deleteBtn" value="글 삭제">
					<input type="button" id="listBtn" value="목록으로">
				</form>
			</div>			
		</div> 
		-->

	
		<table>
			<tr>
				<td>글번호</td>
				<td>${boardVo.bNo}</td>

				<c:choose>
					<c:when test="${boardVo.bGrade==2}">
						<td>공지</td>
					</c:when>
					<c:when test="${boardVo.bGrade==1}">
						<td>일반</td>
					</c:when>
				</c:choose>

				<td>작성/수정일</td>
				<td colspan="2"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
						value="${boardVo.updateDate}" /></td>
				<td>조회수 : ${boardVo.viewCnt}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="4" id="titleTd">${boardVo.title}</td>
				
				<td>작성자</td>
				<td>${boardVo.writer}</td>
			</tr>
			<tr>
				<td colspan="7" id="contents"><textarea>${boardVo.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="7">
				<form id="readForm">
					<input type="hidden" name="bNo" value="${boardVo.bNo}">
					<input type="hidden" name="mNo" value="${boardVo.mNo}">
					<input type="hidden" name="bGrade" value="${boardVo.bGrade}">
					<input type="button" id="modifyBtn" value="수정하기"> 
					<input type="button" id="deleteBtn" value="글 삭제">
					<input type="button" id="listBtn" value="목록으로">
				</form>
				</td>
			</tr>
		</table>
	
<script>

	var message = "${message}";
	
	if(message != null && message != ""){
		alert(message);
	}
	

	var form = $("#readForm");
	
	$("#modifyBtn").click(function(){
		form.attr("action", "/board/modify");
		form.submit();	
	});
	$("#deleteBtn").click(function(){
		var a = confirm("게시물을 삭제하시겠습니까?")
		if(a==true){
			form.attr("action", "/board/delete");
			form.submit();		
		}else{
			return;
		}
		
		
	});
	$("#listBtn").click(function(){
		location.href="/board/boardList";
	});

</script>

</body>