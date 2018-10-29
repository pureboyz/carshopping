$(document).ready(function(){
	
	var id = /^[0-9a-zA-Z]{4,12}$/;
	var pass1 = /^.*(?=.{6,12})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	var name = /^[\uac00-\ud7a3a-zA-Z\s0-9]{2,12}$/;
	
	var boolId = false;
	var boolPass = false;
	var boolPass2 = false;
	var boolName = false;
	
	var formObj = $("#joinPOST");
	
	$("#btnJoin").on("click",function(){
		if(boolId == false){
			alert('올바른 아이디가 아닙니다.');
			$("#mId").focus();
		}else if(boolPass == false){
			alert('올바른 비밀번호가 아닙니다.');
			$("#mPass").focus();
		}else if(boolPass2 == false){
			alert('비밀번호가 일치하지 않습니다.');
			$("#mPass2").focus();
		}else if(boolName == false){
			alert('올바른 이름이 아닙니다.');
			$("#mName").focus();
		}else if($("#mAge").val() == "" || $("#mAge").val() == null || $("#mAge").val() == 0){
			alert('나이를 선택해주세요.');
		}else{
			formObj.attr("action","/member/joinPOST");
			formObj.attr("method","post");
			formObj.submit();
		}
	});
	
	
	function checkReg(divId,tempVal,reg,message){
		if(reg.test(tempVal) === false){
			showErrorMessage(divId,message);
			return false;
		}else{
			showSuccessMessage(divId,"사용가능합니다.");
			return true;
		}
	}
	
	function showErrorMessage(divId,message){
		var html = "<span style='color:red'>";
		html += message;
		html += "</span>";
		$("#"+divId).html(html);
	}
	
	
	function showSuccessMessage(divId,message){
		var html = "<span style='color:green'>";
		html += message;
		html += "</span>";
		$("#"+divId).html(html);
	}
	
	$("#mId").on("input",function(){
		var tempVal = $('#mId').val();
		var divId = "mIdCheck";
		var messageError = "4~12자 이내의 영문 또는 숫자만 가능합니다.";
		boolId = checkReg(divId, tempVal, id, messageError); 
	});
	
	$("#mPass").on("input",function(){
		var tempVal = $('#mPass').val();
		var divId = "mPassCheck";
		var messageError = "영문,숫자를 혼합하여 6~12자 이내만 가능합니다.";
		boolPass = checkReg(divId, tempVal, pass1, messageError); 
	});
	
	$("#mPass2").on("input",function(){
		var tempVal = $('#mPass').val();
		var tempVal2 = $('#mPass2').val();
		var divId = "mPass2Check";
		
		if(tempVal === tempVal2){
			showSuccessMessage(divId,"비밀번호가 일치합니다.");
			boolPass2 = true;
		}else{
			showErrorMessage(divId,"비밀번호가 일치하지 않습니다.");
			boolPass2 = false;
		}
	});
	
	$("#mName").on("input",function(){
		var tempVal = $('#mName').val();
		var divId = "mNameCheck";
		var messageError = "제한없이 2~12자 이내만 가능합니다.";
		boolName = checkReg(divId, tempVal, name, messageError); 
	});
	
	
	
});