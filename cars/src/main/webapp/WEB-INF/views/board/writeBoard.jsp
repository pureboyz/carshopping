<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/writeBoard.js"></script>
<style>

#inputTitle{
	width: 432px;
}

tr td:nth-child(3) label{
	margin-left:20px;	
}


#sub{
	float:right;

}

</style>


<body>
	<div class="wrap">
	<form id="writeBoard" method="post">
		<input type="hidden" name="mNo" value="${memberVo.mNo}">		
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
			<td colspan="2"><input type="text" name="writer" value="${memberVo.mName}" readonly></td>
			
		</tr>
		<tr>	
			<td colspan="2">제목</td>
			<td colspan="3">
				<input type="text" id="inputTitle" name="title" placeholder="글 제목을 입력해주세요">
			</td>			
		</tr>
		<tr>
			<td colspan="4">
			<textarea id="inputContent" name="content" cols="72" rows="25" style="resize:none;"></textarea>
			</td>
		</tr>
		<tr>
		<td colspan="4"><input type="button" id="sub" value="글 작성"></td>
		</tr>			
		</table>		
		
				
	</form>
	</div>
</body>



<%@include file="../include/footer.jsp"%>