package project_kartik;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import connection.Conn;
import dao.UserDAO;
import model.User;

//@WebServlet("/LoginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginProcess() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=response.getWriter()){
        	
            String email=request.getParameter("username");
            String password=request.getParameter("password");
            UserDAO udao = new UserDAO(Conn.connect());
            User user = udao.userLogin(email, password);
            
            if(user != null) {
                request.getSession().setAttribute("auth", user);
                response.sendRedirect("Home.jsp");
            }else {
                out.println("there is no user");
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (GeneralSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 }
	
	
	
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		
//		String uname = req.getParameter("username");
//		String pass = req.getParameter("password");
//		
//		if(uname.equals("kartik") && pass.equals("123")) {
//			HttpSession session = req.getSession();
//			session.setAttribute("Name: ", uname);
//			res.sendRedirect("success.jsp");
//		}
//		else  {
//			System.out.println("Invalid Username or Password");
//			PrintWriter out = res.getWriter();
//			out.println("<script type=\"text/javascript\">");
//			out.println("alert('Invalid Username or Password');");
//			out.println("location='Login.jsp';");
//			out.println("</script>");
//		}
//		
//	}


