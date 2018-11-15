$(document).ready(function(){
	var boolTitle = false;
	var boolContent = false;
	
	var formObj = $("#writeBoard");
	
	$("#sub").on("click",function(){
		var title = $("#inputTitle").val();
		var content = $("#inputContent").val();
		
		if(title == null || title == ""){
			alert('제목을 작성해주세요.');
			$("#inputTitle").focus();
		}else{
			boolTitle = true;
			
			if(content == null || content == ""){
				alert('내용을 작성해주세요.');
				$("#inputContent").focus();
			}else{
				boolContent = true;
			}
		}
		
		if(boolTitle == true && boolContent == true){
			formObj.attr("action","/board/writeBoard");
			formObj.attr("method","post");
			formObj.submit();
		}
		
	});
	
	$("#listBtn").on("click",function(){
		/*formObj.attr("action","/board/boardList?currentPage=1");
		formObj.attr("method","get");*/
		location.href="/board/boardList?currentPage=1";
	});

		
});