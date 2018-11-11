<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/carInfo.js"></script>
<%@include file="../include/header.jsp"%>
<%@include file="../include/category.jsp"%>

<link href="${pageContext.request.contextPath}/resources/css/carInfo.css" rel="stylesheet">
<script type="text/javascript">
function loginToBuy(){
	alert("로그인이 필요합니다.");
	location.href="/member/login";
}
</script>
<article>
	<div class="img-info">
		<div class="imgbox">
			<img alt="goods" src="${pageContext.request.contextPath}/resources/img/${car.carName}.png">
		</div>
		<div class="info">
			<div class="info-high">
				<label class="carName">${car.carComp}&nbsp;${car.carName}</label>
					<br/><br/><br/>
				<fmt:formatNumber value="${car.carPrice}" type="currency"/>,000
			</div>
			<div class="info-mid">
				<label class="sales">${car.carsale} 대 구매</label><br/>
			</div>
			<div class="info-row">
				<c:choose>
					<c:when test="${!empty loginMember.mNo}">
						<input onclick="location.href='/car/buyCar?carNo=${car.carNo}&mNo=${loginMember.mNo}'" type="submit" value="구매하기"/>
						<input onclick="location.href='/car/basketCar?carNo=${car.carNo}&mNo=${loginMember.mNo}'" type="button" value="장바구니"/>
					</c:when>
					<c:otherwise>
						<input onclick="loginToBuy()" id="btnBuy" type="button" value="구매하기"/>
						<input onclick="loginToBuy()" type="button" value="장바구니"/>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div class="info-detail">
		<div class="conatiner">
			<h2>상품 정보</h2>
			<div class="tab_container">
				<div id="tab1">
					<table class="tbl1">
						<tr>
							<th>구매 &amp; 배송</th>
							<th>안내사항</th>
						</tr>
						<tr>
							<td>
								<br/>[구매정보]<br/><br/>
								주문 취소와 배송상태 확인은 불가능합니다.<br/>
								옵션 선택은 색상만 가능합니다.<br/>
								구매완료 후 '구매내역' 페이지에서 구매내역이 확인가능합니다.<br/>
								<br/><br/>
								[배송정보]<br/><br/>
								1인당 구매가능수량은 제한이 없습니다.<br/>
								무료배송, 묶음배송 가능 <br/>
								당일출고(공휴일/주말 제외)<br/>
								배송 중 분실되어도 책임을 지지 않습니다. <br/>
							</td>
							<td>
								<br/>[반품기간]<br/><br/>
								상품수령일로 부터 7일 이내 반품 가능합니다.<br/>
								고객변심의 경우 왕복 택배비 5,000,000원 (1개 기준) 부담 <br/>
								도서 산간 지역 추가 운임 발생 <br/>
								<br/><br/>
								[반품 기준]<br/><br/>
								단, 7일 이내라도 제품 사용, 훼손된 경우 반품이 어렵습니다.<br/><br/><br/><br/>
							</td>
						</tr>
					</table>
				</div>				
			</div>
			<h2>모델 제원</h2>
			<table class="tbl2" cellspacing=0>
				<tr><td>모델명</td><td>${car.carName}</td></tr>
				<tr><td>모델가격</td><td><fmt:formatNumber value="${car.carPrice}" type="currency"/>,000</td></tr>
				<tr><td>제조사</td><td>${car.carComp}</td></tr>
				<tr><td>배기량</td><td>${car.carCC} cc</td></tr>
				<tr><td>연비</td><td>${car.carEff} km/l</td></tr>
				<tr><td>등급</td><td>${car.carSize} 형</td></tr>
				<tr><td>연료</td><td>${car.carFuel}</td></tr>
			</table>
			<h2>구매 후기</h2>
			<div class="replyBox">
				<c:if test="${!empty loginMember}">
					<form method="post">
						<input type="hidden" name=carNo value="${car.carNo}"/>
						<div class="replyRegist">
							<h3 class="replyAuth">${loginMember.mName}</h3>
							<input class="replyComments" name="comment" type="text" />
							<input class="btnReply" type="button" value="댓글작성"/>
						</div>
					</form>
				</c:if>
				<div class="temp"></div>
				<div id="pagination">
					<ul class="pageUl">
						<c:if test="${replyPageMaker.prev}">
							<li class="pageLi" onclick="location.href='/car/carInfo?carNo=${car.carNo}&currentPage=${replyPageMaker.currentPage-1}'">이전</li>
						</c:if>
						<c:forEach var="i" begin="${replyPageMaker.startPage}" end="${replyPageMaker.endPage}">
							<li onclick="location.href='/car/carInfo?carNo=${car.carNo}&currentPage=${i}'" class="pageLi">${i}</li>
						</c:forEach>
						<c:if test="${replyPageMaker.next}">
							<li class="pageLi" onclick="location.href='/car/carInfo?carNo=${car.carNo}&currentPage=${replyPageMaker.currentPage+1}'">다음</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>	
	</div>
</article>

<script id="template" type="text/x-hanlebars-template">
	{{#each.}}
		<div class="templateBox">
			<h3 class="auth">{{auth}}</h3>
			<div class="comments">
				{{comment}}
			</div>
			<label class="modify" onclick="modifyReply('{{mno}}','{{rno}}','{{comment}}');">수정</label>
			<label class="delete" onclick="deleteReply('{{mno}}','{{rno}}');">삭제</label>
		</div>
	{{/each}}
</script>
<script>
	$(document).ready(function(){
		var template = Handlebars.compile($("#template").html());
		var cno = ${car.carNo};
		
		$.getJSON("/reply/getReply/"+cno,function(list){
			$(this).each(function(){
				var html = template(list);
				$(".temp").append(html);
			});
		});
	});
	
	function modifyReply(mno, rno, comment){
		var membermno = "${loginMember.mNo}";
		
		if(mno == membermno){
			var input = prompt('수정 할 내용을 입력하세요.',comment);
			
			if(input != null){
				$.ajax({
					type: 'put',
					url : '/reply/modifyReply/'+rno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override": "PUT"
					},
					dataType : "text",
					data : JSON.stringify({comment:input}),
					success : function(result){
						if(result == "SUCCESS"){
							alert("수정 완료");
							location.href="/car/carInfo?currentPage="+${replyPageMaker.currentPage}+"&carNo="+${car.carNo};
						}				
					}
				});
			}else{
				alert('취소되었습니다.');
			}
		}else{
			alert('후기 작성자가 아닙니다.');
		}
	}
	
	function deleteReply(mno, rno){
		var membermno = "${loginMember.mNo}";
		
		if(mno == membermno){
			var conf = confirm('후기를 삭제하시겠습니까?');
			
			if(conf == true){
				$.ajax({
					type: 'delete',
					url : '/reply/deleteReply/'+rno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override": "DELETE"
					},
					dataType : "text",
					success : function(result){
						if(result == "SUCCESS"){
							alert("삭제 완료");
							location.href="/car/carInfo?currentPage="+${replyPageMaker.currentPage}+"&carNo="+${car.carNo};
						}				
					}
				});
			}else{
				return;
			}
		}else{
			alert('후기 작성자가 아닙니다.');
		}
	}
	
	$(".btnReply").on("click",function(){
		var auth = "${loginMember.mName}";
		var comment = $(".replyComments").val();
		var cno = "${car.carNo}";
		var mno = "${loginMember.mNo}";
		
		if(comment == null || comment == ""){
			alert('내용을 작성해주세요.');
			$(".replyComments").focus();
		}else{
			$.ajax({
				type: 'post',
				url : '/reply/register',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override": "POST"
				},
				dataType : "text",
				data : JSON.stringify({cno:cno,comment:comment,auth:auth,mno:mno}),
				success : function(result){
					if(result == "SUCCESS"){
						alert("후기 등록 완료");
						location.href="/car/carInfo?currentPage="+${replyPageMaker.currentPage}+"&carNo="+${car.carNo};
					}				
				}
			});
		}
	});
	
</script>

<%@include file="../include/footer.jsp"%>