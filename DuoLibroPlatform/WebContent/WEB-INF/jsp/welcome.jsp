<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pojo.User" %>

<% User user = request.getAttribute("user") != null ? (User)request.getAttribute("user"): new User(); %>

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
    <link href="resources/css/bootstrap-3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/bootstrap-3.3.7/docs/examples/cover/cover.css" rel="stylesheet">
    <link href="resources/css/login/login.css" rel="stylesheet">
    <link href="resources/css/core/global-utility.css" rel="stylesheet">
    <link href="resources/css/core/global.css" rel="stylesheet">
    
    
    

  </head>

  <body>
    <script>
    
    </script>
    <div class="site-wrapper dashboard-background">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">DuoLibro</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li id="homeItem" class="active"><a onclick="showHomeInfo()">Home</a></li>
                  <li id="contactItem"><a  onclick="showContactInfo()">Contact</a></li>
                  <li id="contactItem"><a >Hello <%=user.getFirstname() %></a></li>
                  
                </ul>
              </nav>
            </div>
          </div>
          <div class="row">
          		<div class="col-xs-3 full-height main-container" style="min-height: 600px; background-color: #ffe6e6">
          		Left User Menu
          		</div>
          		<div class="col-xs-5 full-height main-container">
          		<div id = "article"></div>
          		
          		</div>
          		<div class="col-xs-4 full-height main-container">
          		</div>
          </div>
                <script src="<c:url value="/resources/js/core/dist/bundle.js" />"></script>

          <div class="mastfoot">
            <div class="inner">
              <p>Copyright 2018 DuoLibro</p>
            </div>
          </div>

        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="resources/css/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>        

  </body>
</html>