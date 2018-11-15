<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/writeBoard.js?ver=1"></script>
<style>

.wrap{
	width:700px;
	min-height:780px;
	
	margin: 0 auto;
	margin-top : 30px;
}

.part{
	float:left;
	width:100%;
}

.part1st,.part2nd,.part3rd{
	border-bottom:2px solid #ccc;
}

.part3rd{
	border-left:1px solid #ddd;
	border-right:1px solid #ddd;
}

.part4th{
	border : none;
	padding-bottom:20px;
	
}


.btnGroup{	
	margin-top:10px;
	margin-right:30px;
	
}

.btnGroup input{
	margin: 4px 10px;
	padding: 8px;	
	float: right;
	
	border-style: none;
	border-radius: 4px;	
}

.item{
	margin:5px;
	float:left;	
}

.item input,.item select{
	padding:2px;
}

label{
	font-style: italic;
	font-size: small;
	margin-right: 20px;
}

.writer{
	float:right;
}

.writer input{
	width: 200px;
}

.title input{
	width: 630px;	
}

.contents textarea{
	width: 100%;
	min-height: 600px;
	border-style: none;
	resize: none;
}


</style>


<body>
	<div class="wrap">
	<form id="writeBoard" method="post">
		<div class="part part1st">
			<div class="item bgrade">
				<label>구분</label>&nbsp; 
				<select name="bGrade">
					<option value="1">일반</option>
					<c:choose>
						<c:when test="${memberVo.mGrade>=2}">
							<option value="2">공지</option>
						</c:when>
						<c:otherwise>
							<option value="2" disabled="disabled">공지</option>
						</c:otherwise>
					</c:choose>
				</select>
			</div>
			<div class="item writer">
				<label>작성자</label>
				<input type="text" name="writer" value="${memberVo.mName}" readonly>
			</div>
		</div>
		<div class="part part2nd">
			<div class="item title">
				<label>제목</label>
				<input type="text" id="inputTitle" name="title" placeholder="글 제목을 입력해주세요">
			</div>
		</div>
		<div class="part part3rd">
			<div class="contents">
				<textarea></textarea>
				<!-- <textarea id="inputContent" name="content" cols="72" rows="25" style="resize:none;">
				</textarea> -->
			</div>
		</div>
		<div class="part part4th">
			<div class="btnGroup">
				<input type="hidden" name="mNo" value="${memberVo.mNo}">
				<input type="button" id="sub" value="글 작성">
				<input type="button" id="listBtn" value="목록으로">
			</div>
		</div>				
	</form>
	</div>
</body>



<%@include file="../include/footer.jsp"%>