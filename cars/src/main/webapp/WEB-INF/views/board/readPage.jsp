<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
    
<%@include file="../include/header.jsp"%>


<body>

	<table>
		<tr>
			<td>글번호</td><td>${boardVo.bNo}</td>
			
				<c:choose>
					<c:when test="${boardVo.bGrade==2}">
						<td>공지</td>
					</c:when>
					<c:when test="${boardVo.bGrade==1}">
						<td>일반</td>
					</c:when>
				</c:choose>			
			
			<td>작성일</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${boardVo.regDate}" /></td>
			<td>조회수</td><td>${boardVo.viewCnt}</td>			
		</tr>
		<tr>
			<td>제목</td><td colspan="2">${boardVo.title}</td>
			<td></td><td>작성자</td><td>${boardVo.writer}</td>
		</tr>		
		<tr>
			<td>
				${boardVo.content}
			</td>
		</tr>
		
	</table>
	

</body>