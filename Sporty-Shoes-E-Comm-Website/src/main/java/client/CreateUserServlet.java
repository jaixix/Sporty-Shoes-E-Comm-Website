package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.Users;
import util.HibernateUtil;

@WebServlet("/createUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		String userName = request.getParameter("userName");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		int userType = Integer.parseInt(request.getParameter("userType"));
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Users user = new Users(userName, emailId, password, userType);
		
		session.saveOrUpdate(user);
		
		session.getTransaction().commit();
		session.close();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>User Added Successfully!</h2><br><br>");
		out.println("<a href='createUserForm.html'>Create More Users?</a><br><br>");
		out.println("<a href='indexAdmin.jsp'>Return to homepage?</a>");
		out.close();
	}
}
