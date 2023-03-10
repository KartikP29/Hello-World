<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "connection.Conn" %>
<%@ page import = "dao.ProductDAO" %>
<%@ page import = "model.Products" %>
<%@ page import="java.util.*"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script src="js/bootstrap.bundle.min.js"></script>

</head>
<body>
    <section style="background: linear-gradient(to top, #c9c9ff 50%, #9090fa 90%) no-repeat;">
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
                  <img src="data:img/png;base64,<%=p.getPimg() %>"  
                    class="w-100" />
                  <a href="#!">
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
                  <h6 class="mb-3"><%= p.getPprice() %></h6>
                  
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