package functionalities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Users;
import util.HibernateUtil;

//@WebServlet("/loginFuntionality")
public class LoginFuntionality extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside Post Method!");

		String emailId = request.getParameter("emailId").trim();
		String password = request.getParameter("password").trim();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Users where emailId=:emailId and password=:password");
		try {
			Users user = (Users) query.setParameter("emailId", emailId).setParameter("password", password)
					.getSingleResult();
			Cookie userId = new Cookie("userId", String.valueOf(user.getId()));
			Cookie userName = new Cookie("userName", user.getName());
			Cookie userEmailId = new Cookie("emailId", user.getEmailId());
			userId.setMaxAge(60*60);
			userName.setMaxAge(60*60);
			userEmailId.setMaxAge(60*60);
			response.addCookie(userId);
			response.addCookie(userName);
			response.addCookie(userEmailId);
			
			if(user.getUserType() == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("/indexUser.jsp");
				rd.forward(request, response);
			}
			
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/indexAdmin.jsp");
				rd.forward(request, response);
			}
			
		} catch (NoResultException e) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>No record Found!</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("/loginForm.html");
			rd.include(request, response);
			session.close();
		}
	}
}
