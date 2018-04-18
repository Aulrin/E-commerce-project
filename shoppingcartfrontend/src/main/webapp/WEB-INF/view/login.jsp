<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Login</title>
</head>
<body>
<div class="container">
	<div class="row">
	
        <div class="col-md-6 col-md-offset-3">
  <h4 style="border-bottom: 1px solid #c5c5c5;">
    <i class="glyphicon glyphicon-user">
    </i>
    Account Access
  </h4>
  <p align="right"><b><i>${errorMessage}</i></b></p>
  <div style="padding: 20px;" id="form-olvidado">
  <form accept-charset="UTF-8" role="form" action = "validate" id="login-form" method="post">
      <fieldset>
        <div class="form-group input-group">
          <span class="input-group-addon">
            @
          </span>
          <input class="form-control" placeholder="Email" name="uname" id="txtEmail" type="email" required="" autofocus="">
        </div>
        <div class="form-group input-group">
          <span class="input-group-addon">
            <i class="glyphicon glyphicon-lock">
            </i>
          </span>
          <input class="form-control" placeholder="Password" name="psw" type="password" value="" required="">
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-primary btn-block" id="btnValidate">
            Login
          </button>
         </div>
         </fieldset>
         </form>
        
  </div>

</body>
</html>
