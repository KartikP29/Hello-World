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

/**
 * Servlet implementation class RemoveServlet
 */
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p = request.getParameter("pid");
		int s = Integer.parseInt(p);
		response.sendRedirect("Cart.jsp");
		try {
			CartDAO cart = new CartDAO(Conn.connect());
			// calling the remove cart functionality from CartDao
			cart.removeFromCart(s);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

}
