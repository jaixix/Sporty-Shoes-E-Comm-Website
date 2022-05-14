package client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.Users;
import util.HibernateUtil;

//@WebServlet("/viewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Method");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Users> users = session.createQuery("from Users").list();
		request.setAttribute("users", users);
		RequestDispatcher rd = request.getRequestDispatcher("/viewUsers.jsp");
		rd.forward(request, response);
		session.close();
	}
}
