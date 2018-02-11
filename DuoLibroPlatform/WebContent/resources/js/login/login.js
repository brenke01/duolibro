function login(){
	var form = $("#loginForm").serialize();
	$("#loginForm").submit();
/*	$.ajax({
		type : "POST",
		url : "/DuoLibroPlatform/login ",
		data : form,
		success : function(response) {
			if (typeof response != 'undefined' && response != null){
				var data = JSON.parse(response);
				if (data.valid == false){
					$("#invalidCredentials").show();
				}
			}

		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});*/
}

function register(){
	$("#registerForm").submit();

/*	var form = $("#registerForm").serialize();

	$.ajax({
		type : "POST",
		url : "/DuoLibroPlatform/register",
		data : form,
		success : function(response) {
			console.log(response.data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});*/
}

function toggleRegisterForm(isRegister){
	if (!isRegister){
		$("#registerContainer").show();
		$("#loginContainer").hide();
	}else{
		$("#registerContainer").hide();
		$("#loginContainer").show();
	}
}