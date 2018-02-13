function login(){
	var form = $("#loginForm").serialize();
	$("#loginForm").submit();
}

function register(){
	var valid = true;
	var passwordMatch = true;
	var username = $("#registerUsername").val();

	var firstName = $("#registerFirstName").val();
	var lastName = $("#registerLastName").val();

	var email = $("#registerEmail").val();

	var firstPass = $("#firstPassword").val();
	var secondPass = $("#secondPassword").val();
	if (username == null || username == ""){
		valid = false;
	}
	if (firstName == null || firstName == ""){
		valid = false;
	}
	if (lastName == null || lastName == ""){
		valid = false;
	}
	if (email == null || email == ""){
		valid = false;
	}
	if (firstPass == null || firstPass == ""){
		valid = false;
	}
	if (secondPass == null || secondPass == ""){
		valid = false;
	}
	if (firstPass != secondPass){
		passwordMatch = false
	}
	
	if (valid && passwordMatch){
		$("#registerForm").submit();

	}else if (valid && !passwordMatch){
		$("#passwordMismatch").show();
	}else{
		$("#invalidForm").show();
	}
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