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

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Users user = session.get(Users.class, userId);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>User : " + user.getName() + " has been deleted successfully!</h2><br><br>");
		out.println("<a href='deleteUser.html'>Delete More Users?</a><br>");
		out.println("<a href='indexAdmin.jsp'>Go Back to Home Page?</a>");
		out.close();
	}
}
