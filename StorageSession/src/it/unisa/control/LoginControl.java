package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.Cart;
import it.unisa.model.UserBean;
import it.unisa.model.UserDaoImpl;


/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/loginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static UserDaoImpl userDao = new UserDaoImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = (String) req.getParameter("email");
		String password = (String) req.getParameter("password");		
		//String action = (String) req.getSession().getAttribute("action");
		Cart cart = (Cart) req.getSession().getAttribute("cart"); 
		
		
		UserBean user = null;
		
		try {
			user = userDao.findByCred(email,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(user != null){
			HttpSession session = req.getSession(false);
			if(session != null){
				session.invalidate();
			}
		
			HttpSession currentSession = req.getSession();
			currentSession.setAttribute("user", email);
			currentSession.setAttribute("psw", password);
			currentSession.setAttribute("tipo", user.getTipo());
			currentSession.setAttribute("cart", cart);
			
			
//			if(action.equalsIgnoreCase("checkout"))
//				resp.sendRedirect("checkout.jsp");
//			
			if(user.getTipo().equalsIgnoreCase("admin")) {
				resp.sendRedirect("ProductViewAdmin.jsp");
			}
			else if(user.getTipo().equalsIgnoreCase("user")) {
				resp.sendRedirect("ProductView.jsp");
			}

		}
		else{
			resp.sendRedirect("loginForm.jsp");	
		}
	}
}
