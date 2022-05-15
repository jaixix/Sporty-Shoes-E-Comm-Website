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

import entity.Products;
import util.HibernateUtil;

@WebServlet("/viewProductsServletUser")
public class ViewProductsServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Products> products = session.createQuery("from Products").list();
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("/viewProductsUser.jsp");
		rd.forward(request, response);
		session.close();
	}
}
