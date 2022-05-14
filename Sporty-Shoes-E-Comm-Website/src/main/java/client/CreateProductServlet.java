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

@WebServlet("/createProductServlet")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		String productName = request.getParameter("productName");
		String company = request.getParameter("company");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Products product = new Products(productName,company,description, price, category);
		
		session.save(product);
		session.close();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>Product Added Successfully!</h2><br><br>");
		out.println("<a href='createProductForm.html'>Create More Products?</a><br><br>");
		out.println("<a href='indexAdmin.jsp'>Return to homepage?</a>");
		out.close();
	}
}
