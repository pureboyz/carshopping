<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>

.wrap{
	width:700px;
	min-height:780px;
		
	margin:0 auto;
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

#modifyBtn{
	background-color: #D6FFFF;
}

#deleteBtn{
	background-color: #B2EBF4;
}

#listBtn{
	background-color: #8EC7D0;
}

.contents{
	min-height: 600px;
	width:760px;	
	margin:20px 20px;
}

pre{
	font-size:large;
}

.item{
	margin: 5px;
	float:left;
}

label{
	font-style: italic;
	font-size: small;
}

.writer{
	margin-left: 20px;
}

.item span{
	font-weight: bold;
	margin-left:15px;
}

.title span{
	font-size:large;	
}

.dateandcnt{
	float:right;
}

.date{
	margin-right: 20px;
}


</style>

<body>
		
		<div class="wrap">
			<div class="part part1st">
				<div class="bgrade item">
					<c:choose>
						<c:when test="${boardVo.bGrade==2}">
							공지
						</c:when>
						<c:when test="${boardVo.bGrade==1}">
							일반
						</c:when>
					</c:choose>
				</div>
				<div class="bno item">
					<label>No</label>&nbsp;${boardVo.bNo}</div>
				<div class="writer item">
					<label>Writer</label><span>${boardVo.writer}</span>
				</div>
				<div class="dateandcnt">				
					<div class="date item">
						<label>Date</label>&nbsp;
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${boardVo.updateDate}" />
					</div>
					<div class="readcnt item"><label>view</label>&nbsp;${boardVo.viewCnt}</div>
				</div>					
			</div>
			<!--part1 종료-->
			
			<div class="part part2nd">
				<div class="title item">
					<label>Title</label><span>${boardVo.title}</span>
				</div>
				
			</div>
			<!--part2 종료-->
			
			<div class="part part3rd">
				<div class="contents">
					<pre>${boardVo.content}</pre>
				</div>
			</div>
			<!--part3 종료-->
			
			<div class="part part4th">
				<div class="btnGroup">
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
			<!--part4 종료-->	
					
		</div> <!--wrap 종료-->
	
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



<%-- 
/* table{
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
} */

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
		</table> --%>