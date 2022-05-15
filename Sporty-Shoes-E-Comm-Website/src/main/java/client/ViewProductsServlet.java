package client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.Users;
import util.HibernateUtil;

//@WebServlet("/viewProductsServlet")
public class ViewProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside Get Method");

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Users> products = session.createQuery("from Products").list();
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("/viewProducts.jsp");
		rd.forward(request, response);
		session.close();
	}
}
