package project_kartik;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

import connection.Conn;
import dao.RegisterDAO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try
		    {
		    	String name = request.getParameter("name");
		    	String username = request.getParameter("username");
		    	String password = request.getParameter("password");
		    	RegisterDAO rdao = new RegisterDAO(Conn.connect());
		    	User u=new User();
		    	u.setName(name);
		    	u.setEmail(username);
		    	u.setPassword(password);
		    	rdao.registerUser(u);
		    }

     catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        response.sendRedirect("Login.jsp");

	}

}
