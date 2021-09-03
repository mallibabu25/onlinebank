<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  
   <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/css/AdminLTE.min.css" />
  <!-- iCheck -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/iCheck/1.0.2/skins/square/blue.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/sweetalert2/6.0.1/sweetalert2.min.css">
  
  <style>
 .login-card-body{
    background: #fff;
    border-top: 0px ;
    color: #666;
    padding: 20px;
    

}
.card-body {
    -ms-flex: 1 1 auto;
    flex: 1 1 auto;
    padding: 1.25rem;
}
*, ::after, ::before {
    box-sizing: border-box;

}
.login-box{
  background: #fff;
    border:5px auto;

    color: #666;
     padding: 20px;

}
</style>
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- icheck bootstrap -->
  
 
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo" style="margin-bottom:0px">
    <h1><b>Quiz</b></h1>
  </div>
  <!-- /.login-logo -->
   <form name='f' action="/perform_login" method='post'>
  <div class="card">
    <div class="card-body login-card-body">
      <c:if test="${not empty msg}">
	  	<p class="login-box-msg text-red">${msg}</p>
	  </c:if>
<%-- 	  <c:if test="${empty m}"> --%>
<!-- 	  	<p class="login-box-msg">Sign in to start your session</p> -->
<%-- 	  </c:if> --%>

     
      <div class="row">
        <div class="col-md-12">
         <label class="label-control "for="login_id">Login id:</label>
          <input type="text" class="form-control" placeholder="login id" required  name="username">
          <div class="input-group-append">
           
          </div>
        </div>
        </div>
        <div class="row">
        <div class="col-md-12">
          <label for="pwd">Password:</label>
          <input type="password" class="form-control" placeholder="Password" required  name="password">

          <div class="input-group-append">
           
          </div>
        </div>
        </div>
          <!-- /.col -->
          <div class="row" style="margin-top:10px;">
                    <div class="col-md-4">
          </div>
          <div class="col-md-4">
            <input type="submit" class="btn btn-primary btn-flat " value="Sign In">
          </div> 
           <div class="col-md-4">
          </div>
          </div>
        </div>
      </div>
       </form>
      </div>
      

      
     


</body>
<script>
var hostUrl = window.location.host;
console.log(hostUrl)
var href = window.location.href;
console.log(href)
var pathname = window.location.pathname;
console.log(pathname)
var protocol = window.location.protocol;
console.log(protocol)
</script>
</html>
