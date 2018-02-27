<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% boolean error = request.getParameter("loginError") != null ? Boolean.parseBoolean((String)request.getParameter("loginError")) : false; %>
<!DOCTYPE html>
<html lang="en">


  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DuoLibro Platform | Login</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap-3.3.7/dist/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/bootstrap-3.3.7/docs/examples/cover/cover.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/login/login.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/core/global-utility.css" />" rel="stylesheet">
    
    

  </head>

  <body>
  	
    <script>
    

    function showContactInfo(){
                $("#contactItem").addClass("active")
          $("#homeItem").removeClass("active");
      $("#leadHome").hide();
      $(".cover-heading").hide();
      $("#leadContact").show();
      $(".cover-heading-contact").show();
    }
        function showHomeInfo(){
          $("#contactItem").removeClass("active")
          $("#homeItem").addClass("active");
      $("#leadHome").show();
      $(".cover-heading").show();
      $("#leadContact").hide();
      $(".cover-heading-contact").hide();
    }
    </script>
    <div class="site-wrapper bgImg ">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">DuoLibro</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li id="homeItem" class="active"><a onclick="showHomeInfo()">Home</a></li>
                  <li id="contactItem"><a  onclick="showContactInfo()">Contact</a></li>
                </ul>
              </nav>
            </div>
          </div>

		  <h3>
			<hello-world></hello-world>
		  </h3>

          <div class="inner cover ">
            
            <h1 class="cover-heading-contact">Contact</h1>
            
            <p class="lead" id="leadHome"></p>
            <p class="lead" id="leadContact">Contact me at kevin.bren@outlook.com</p>
			<div class="log-in-container" id="loginContainer">
				<h3 class="cover-heading border-bottom padding-bottom-10">Log In</h3>
				<form name="loginForm" id="loginForm" action="/DuoLibroPlatform/login" method="POST">
				<div class="margin-top-10">
					<input class="form-input" placeholder=" Username" name="username" type="text">
				</div>
				<div class="margin-top-10">
					<input class="form-input" placeholder=" Password" name="password" type="password">
				</div>
				</form>
				<%if (error) {%>
					<div class="margin-top-10" id="invalidCredentials">Sorry. Your Username or Password is incorrect.</div>

				<%}%>
				<div class="margin-top-10">Don't have an account? <a class="clickable" onclick="toggleRegisterForm(false)">Sign Up</a>.</div>
				<button class="primary-button margin-top-10" onclick="login()">Log In</button>
			</div>

          </div>
          
          	<div class="log-in-container" id="registerContainer">
          		<h3 class="cover-heading border-bottom padding-bottom-10">Sign up for a free account!</h3>
          		<div class="required"> * <span>required</span></div>
          	
				<form action="/DuoLibroPlatform/register" method="POST" name="registerForm" id="registerForm">
				<div class="margin-top-10">
					<span class="required">*</span>				
					<input class="form-input" placeholder=" Enter a username" name="username" type="text" id="registerUsername">
				</div>
				<div class="margin-top-10">	
					<span class="required">*</span>							
					<input class="form-input" placeholder=" Enter your first name" name="firstName" type="text" id="registerFirstName">
				</div>
				<div class="margin-top-10">
					<span class="required">*</span>								
					<input class="form-input" placeholder=" Enter your last name" name="lastName" type="text" id="registerLastName">
				</div>
				<div class="margin-top-10">	
					<span class="required">*</span>				
					<input class="form-input" placeholder=" Enter your email" name="email" type="text" id="registerEmail">
				</div>
				<div class="margin-top-10">	
					<span class="required">*</span>				
					<input class="form-input" placeholder=" Enter a password" name="password" type="password" id="firstPassword">
				</div>
				<div class="margin-top-10">	
					<span class="required">*</span>				
					<input class="form-input" placeholder=" Type your password again" type="password" id="secondPassword">
				</div>
				</form>
				<div class="margin-top-10" id="passwordMismatch">Your typed password does not match</div>
				<div class="margin-top-10" id="invalidForm">Please fill out all required fields</div>
				
				<div class="margin-top-10">
					<button class="secondary-button" onclick="toggleRegisterForm(true)">Cancel</button>
				</div>
				<div class="margin-top-10">
					<button class="primary-button" onclick="register()">Register</button>
				</div>
			</div>

          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>Copyright 2018 DuoLibro</p>
            </div>
          </div>

        </div>

      </div>
    </div>
    
    <script src="resources/js/core/angularresources/dist/inline.bundle.js"></script>
	<script src="resources/js/core/angularresources/dist/polyfills.bundle.js"></script>
	<script src="resources/js/core/angularresources/dist/styles.bundle.js"></script>
	<script src="resources/js/core/angularresources/dist/vendor.bundle.js"></script>
	<script src="resources/js/core/angularresources/dist/main.bundle.js"></script>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="<c:url value="/resources/css/bootstrap-3.3.7/dist/js/bootstrap.min.js" />"></script>
                <script src="<c:url value="/resources/js/login/login.js" />"></script>
        

  </body>
</html>
