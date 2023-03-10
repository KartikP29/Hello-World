<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Site Metas -->
    <link rel="icon" href="images/favicon.png" type="image/gif" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />

  <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <!-- font awesome style -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <!-- responsive style -->
    <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
  
</head>
<body>
      <header class="header_section">
        <div class="container-fluid">
			          <nav class="navbar navbar-expand-lg custom_nav-container ">
            <a class="navbar-brand" href="Home.jsp">
              <span>
                <img alt="Books" src="images/reading.png" width="50" height="60">
                Pick - A - Book 
              </span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class=""> </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link pl-lg-0" href = "Home.jsp" >Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="Cart.jsp" > Cart</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href = "#" > About</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href = "#" > Contact Us </a>
                </li>
                <li>
                  <form action='LogoutProcess' method='post'>
                  <button class="logout_buttton_design" role="button">Logout</button>
                  </form>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </header>
</body>
</html>