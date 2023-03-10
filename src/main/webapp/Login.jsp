<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
          <link rel="stylesheet" href="css/login.css"/>
          <link rel="stylesheet" href="css/bootstrap.min.css"/>
          <script type="text/javascript" src="css/login.css"></script>
        <title>Project_01</title>
    </head>
    
    <body>
       <div class="container">
            <div class="row">
                <div class="offset-md-2 col-lg-5 col-md-7 offset-lg-4 offset-md-3">
                    <div class="panel border bg-white">
                        <div class="panel-heading">
                            <h3 class="pt-3 font-weight-bold">Login</h3>
                        </div>
                        <div class="panel-body p-3">
                            <form action="LoginProcess" method="post">
                                <div class="form-group py-2">
                                    <div class="input-field">
                                        <span class="far fa-user p-2"></span>
                                        <input type="text" placeholder="Username or Email" name = "username">
                                    </div>
                                </div>
                                <div class="form-group py-1 pb-2">
                                    <div class="input-field">
                                        <span class="fas fa-lock px-2"></span>
                                        <input type="password" placeholder="Enter your Password" name = "password">
                                        <button class="btn bg-white text-muted">
                                            <span class="far fa-eye-slash"></span>
                                        </button>
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <input type="checkbox" name="remember" id="remember">
                                    <label for="remember" class="text-muted">Remember me</label>
                                    <a href="#" id="forgot" class="font-weight-bold">Forgot password?</a>
                                </div>
                                <div class="btn btn-primary btn-block mt-3">Login</div>
                                    <div class="text-center pt-4 text-muted">Don't have an account? <a href="Register.jsp">Sign up</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    </body>
</html>