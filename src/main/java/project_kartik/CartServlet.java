package project_kartik;

import java.io.IOException;
import java.sql.SQLException;

import connection.Conn;
import dao.CartDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Products;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// fetching the pid
		String p = request.getParameter("ProductID");
		System.out.println(p);

		// to check the datatype of pid
		//System.out.println(p.getClass().getName());

		// converting into int
		int r = Integer.parseInt(p);
		response.sendRedirect("Home.jsp");
		try {
			
			// creating cart instance
			CartDAO cartdao = new CartDAO(Conn.connect());

			// creating product instance
			Products product = new Products();

			// to fetch the corresponding data from product table
			product = cartdao.addProduct(r);

			// to add the data into cart table
			cartdao.addToCart(product);
		
		}
           catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}
