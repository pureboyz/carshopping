$(document).ready(function(){
	
	var id = /^[0-9a-zA-Z]{4,12}$/;
	var pass1 = /^.*(?=.{6,12})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	var name = /^[\uac00-\ud7a3]{2,4}$/;
	
	var boolId = false;
	var boolPass = false;
	var boolPass2 = false;
	var boolName = false;
	var boolAge = false;
	
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
		var messageError = "2~4자 이내의 올바른 한글만 가능합니다.";
		boolName = checkReg(divId, tempVal, name, messageError); 
	});
	
	$("#mAge").on("change",function(){
		var tempVal = $('#mAge').val();
		var divId = "mAgeCheck";
		if(20 <= tempVal && tempVal <= 80){
			showSuccessMessage(divId,"가입이 가능한 나이입니다.");
			boolAge = true;
		}else{
			showErrorMessage(divId,"가입이 불가능한 나이입니다.");
			boolAge = true;
		}
	});
	
});