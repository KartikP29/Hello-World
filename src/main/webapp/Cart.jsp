<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@page import="dao.CartDAO"%>
<%@page import="model.Products"%>
<%@page import="model.Cart"%>
<%@ page import="connection.Conn"%>
<%@ page import="java.util.*"%>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

	<%@ include file = "MenuBar.jsp" %>
<link href="css/style.scss" rel="stylesheet" type="text/css"/>
</head>
<body style="background: linear-gradient(to top, #c9c9ff 50%, #9090fa 90%) no-repeat !important; ">
        <section class="pt-5 pb-5">
            <div class="container">
              <div class="row w-100">
                  <div class="col-lg-12 col-md-12 col-12">
                      <h3 class="display-5 mb-2 text-center">Shopping Cart</h3>
                      
                      <table id="shoppingCart" class="table table-condensed table-responsive">
                          <thead>
                              <tr>
                                  <th style="width:60%">Product</th>
                                  <th style="width:12%">Price</th>
                                  <th style="width:10%">Quantity</th>
                                  <th style="width:16%"></th>
                              </tr>
                          </thead>
                          <tbody>

			<%
				CartDAO cartDao = new CartDAO(Conn.connect()); 
				List<Cart> cartData = new ArrayList<Cart>();
				cartData = cartDao.Display();
				Products p=new Products();
				double total=0;
				if(!cartData.isEmpty()){
					for(Cart c : cartData){
						
						total=total+(Double.parseDouble(c.getPprice()));
			%>
			
			 <tr>
                                  <td data-th="Product">
                                      <div class="row">
                                          <div class="col-md-3 text-left">
                                              <img src="<%= c.getPimg() %>" alt="" class="img-fluid d-none d-md-block rounded mb-2 shadow ">
                                          </div>
                                          <div class="col-md-9 text-left mt-sm-2">
                                              <h4><%= c.getPname() %></h4>
                                          </div>
                                      </div>
                                  </td>
                                  <td data-th="Price">INR <%= c.getPprice() %></td>
                                  <td data-th="Quantity"><%= c.getPqty() %></td>
                                  <td class="actions" data-th="">
                                      <div class="text-right">
                                        
										<form method = "post">
											<button class="btn btn-danger" formaction="./RemoveServlet?pid=<%=c.getUid() %>">
												Remove Item
											</button>
										</form>

                                      </div>
                                  </td>
                              </tr>
			
			
			<%
 				}
				}
			%>
	                        </tbody>
                      </table>
                      <div class="float-right text-right">
                          <h4>Total</h4>
                          <h1>INR <%= total %></h1>
                      </div>
                  </div>
              </div>
              <div class="row mt-4 d-flex align-items-center">
                  <div class="col-sm-6 order-md-2 text-right">
                      <a href="#" class="btn btn-primary mb-4 btn-lg pl-5 pr-5">Checkout</a>
                  </div>
                  <div class="col-sm-6 mb-3 mb-m-1 order-md-1 text-md-left">
                      <a href="Home.jsp">
                          <i class="fas fa-arrow-left mr-2"></i> Continue Shopping</a>
                  </div>
              </div>
          </div>
          </section>
	                        
		
		
</body>
</html>