<!DOCTYPE html>
<%@ page import = "connection.Conn" %>
<%@ page import = "dao.ProductDAO" %>
<%@ page import = "model.Products" %>
<%@ page import="java.util.*"%>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Site Metas -->
    <link rel="icon" href="images/favicon.png" type="image/gif" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Book Store</title>
	  <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <!-- font awesome style -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <!-- responsive style -->
    <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.scss" rel="stylesheet" type="text/css"/>

	<%@ include file = "MenuBar.jsp" %>
	
  </head>
  
  <body>
    <section style="background: linear-gradient(to top, #c9c9ff 50%, #9090fa 90%) no-repeat !important; ">
        <div class="text-center container py-5">
      
          <div class="row">

	       <%
				ProductDAO prodDao = new ProductDAO(Conn.connect()); 
				List<Products> products = new ArrayList<Products>();
				products = prodDao.getAllProducts();
				//Product p=new Product();
				if(!products.isEmpty()){
					for(Products p : products){
		    %>

            <div class="col-lg-3 col-md-12 mb-3">
              <div class="card">
                <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                  data-mdb-ripple-color="light">
                  <img src="<%=p.getPimg() %>"  
                    class="w-100" />
                  <a href="Home.jsp">
                    <div class="hover-overlay">
                      <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </div>
                  </a>
                </div>
                <div class="card-body">
                <form method="post">
                  <a href="" class="text-reset">
                    <h5 class="card-title mb-3"><%=p.getPname() %></h5>
                  </a>
                  <h6 class="mb-3">INR <%= p.getPprice() %></h6>
                  
              <button type="submit" formaction="./CartServlet?ProductID=<%=p.getPid()%>" class="btn btn-primary" >Add to Cart</button>
              </form>
                </div>
              </div>
            </div>
<%
								}
							}
						%>
          </div>
  
        </div>
      </section>

  </body>
  
</html>