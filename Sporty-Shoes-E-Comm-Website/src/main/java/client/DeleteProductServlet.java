package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.Products;
import util.HibernateUtil;

@WebServlet("/deleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		int productId =Integer.parseInt(request.getParameter("productId"));
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Products product = session.get(Products.class, productId);
		session.delete(product);
		session.close();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>Product : " + product.getName() + " has been deleted successfully!</h2><br><br>");
		out.println("<a href='deleteProduct.html'>Delete More Products?</a><br>");
		out.println("<a href='indexAdmin.jsp'>Go Back to Home Page?</a>");
		out.close();
	}
}
