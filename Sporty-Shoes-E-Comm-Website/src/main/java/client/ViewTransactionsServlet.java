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
import org.hibernate.query.Query;

import entity.Purchases;
import util.HibernateUtil;

@WebServlet("/viewTransactionsServlet")
public class ViewTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Method!");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Purchases> purchases = session.createQuery("from Purchases").list();
		request.setAttribute("purchases", purchases);
		RequestDispatcher rd = request.getRequestDispatcher("/viewPurchases.jsp");
		rd.forward(request, response);
		session.close();
	}
}
