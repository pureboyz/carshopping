<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../include/header.jsp"%>

<style>

body{
	text-align:center;
}

h1{
	text-align:center;
	margin:50px 0;
}

table{
	text-align : center;
	border: 1px solid skyblue;
	width:760px;
	border-collapse: collapse;
}

tr:nth-child(1) th,tr:nth-child(1) td{
	border-bottom: 1px solid skyblue;
}

th, td{
	padding:10px 5px;	
}

tr td:nth-child(3){
	width:200px;
}
tr td:nth-child(4){
	width:140px;
}

td a{
	text-decoration: none;
	color: black;	
}

.btn_set{
	text-align : center;
	width:760px;
}

.btn_set input{
	float: right;
	padding: 4px;
	border-radius:4px;	
	margin: 10px 30px;
}

img{
	margin:0 auto;
}

.pagination{
	clear: both;
	width: 1580px;
	height: 30px;
	text-align: center;
	margin: 0 auto;
	padding-top: 10px;
}

.pageUl{
	width: 500px;
	height: 40px;
	text-align: center;
	margin: 0 auto;
}

.pageLi{
	position: relative;
	float: left;
	padding: 6px 12px;
	margin-left: -1px;
	line-height: 1.4;
	color: #337ab7;
	text-decoration: none;
	border: 1px solid #ddd;
	list-style: none;
	cursor: pointer;
}

</style>
<title>게시판입니다.</title>

<body>
	<h1>게시판</h1>
	<!-- <img src="../../resources/img/람보르기니.gif" /> -->

	<table>
		<tr>
			<th>글종류</th>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="boardVo" items="${boardList}">

			<c:choose>
				<c:when test="${boardVo.bGrade==2}">
					<tr style="font-weight: bold;">
						<td>공지</td>
						<td><a href="/board/readPage?bno=${boardVo.bNo}">${boardVo.bNo}</a></td>
						<td><a href="/board/readPage?bno=${boardVo.bNo}">${boardVo.title}</a></td>
						<td>${boardVo.writer}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${boardVo.updateDate}" /></td>
						<td>${boardVo.viewCnt}</td>
					</tr>
				</c:when>
				<c:when test="${boardVo.bGrade==1}">
					<tr>
						<td>일반</td>
						<td><a href="/board/readPage?bno=${boardVo.bNo}">${boardVo.bNo}</a></td>
						<td><a href="/board/readPage?bno=${boardVo.bNo}">${boardVo.title}</a></td>
						<td>${boardVo.writer}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${boardVo.updateDate}" /></td>
						<td>${boardVo.viewCnt}</td>
					</tr>
				</c:when>
			</c:choose>
		</c:forEach>


	</table>
	
	<div class="btn_set">
		<input type="button" onclick="location.href='/board/write'" value="글쓰기">
	</div>
	<br/>
	<div id="pagination">
		<ul class="pageUl">
			<c:if test="${boardPageMaker.prev}">
				<li class="pageLi"onclick="location.href='/board/boardList?currentPage=${boardPageMaker.currentPage-1}'">이전</li>
			</c:if>
			<c:forEach var="i" begin="${boardPageMaker.startPage}" end="${boardPageMaker.endPage}">
				<li onclick="location.href='/board/boardList?currentPage=${i}'" class="pageLi">${i}</li>
			</c:forEach>
			<c:if test="${boardPageMaker.next}">
				<li class="pageLi" onclick="location.href='/board/boardList?currentPage=${boardPageMaker.currentPage+1}'">다음</li>
			</c:if>
		</ul>
	</div>
</body>

<script>
	var message = "${message}";
	
	if(message != null && message != ""){
		alert(message);
	}
</script>


<%@include file="../include/footer.jsp"%>