package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Products;
import util.HibernateUtil;

@WebServlet("/searchProducts")
public class SearchProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		String findName = request.getParameter("findName");
		List<Products> products = new ArrayList<Products>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Products FETCH ALL PROPERTIES where name=:findName";
		Query<Products> query  = session.createQuery(hql);
		query.setParameter("findName", findName);
		products.addAll(query.list());
		
		request.setAttribute("products", products);
		
		RequestDispatcher rd = request.getRequestDispatcher("/searchedProducts.jsp");
		rd.forward(request,response);
		session.close();
	}
}
