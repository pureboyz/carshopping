<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp"%>

<style>

#inputTitle{
	width: 432px;
}

tr td:nth-child(3) label{
	margin-left:20px;	
}


tr:nth-child(4) td input{
	float:right;
	margin-left:20px;
}

</style>


<body>
	<div class="wrap">
	<form method="post" action="/board/modifyComplete">
		<input type="hidden" name="bNo" value="${boardVo.bNo}">
		<table>
		<tr>
			<td>구분</td>
			<td><select name="bGrade">
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
			</td>
			<td><label>작성자</label></td>
			<td><input type="text" name="writer" value="${boardVo.writer}" readonly></td>
			<td>글번호 : ${boardVo.bNo}</td>
		</tr>
		<tr>	
			<td colspan="2">제목</td>
			<td colspan="3">
				<input type="text" id="inputTitle" name="title" value="${boardVo.title}">
			</td>			
		</tr>
		<tr>
			<td colspan="5">
			<textarea id="inputContent" name="content" cols="72" rows="25" style="resize:none;">${boardVo.content}</textarea>
			</td>
		</tr>
		<tr>
		<td colspan="5">
			<input type="button" id="cancel" onclick="location.href='/board/boardList'" value="취소">
			<input type="submit" id="sub" value="글 수정">
		</td>
		
		</tr>			
		</table>		
		
				
	</form>
	</div>
</body>

<script>



</script>


<%@include file="../include/footer.jsp"%>