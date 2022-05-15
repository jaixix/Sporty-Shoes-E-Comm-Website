package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.Products;
import util.HibernateUtil;

@WebServlet("/addToCartServlet")

public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Method!");
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		int userId=0;
		
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("userId")) {
//					userId = Integer.parseInt(cookie.getValue());
//				}
//			}	
//		}
		
		Cookie productIdFromCart = new Cookie("productId", String.valueOf(productId));
		productIdFromCart.setMaxAge(60*60);
		response.addCookie(productIdFromCart);
		
		System.out.println(productId);
		System.out.println(userId);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>Product has been added to Cart Successfully!</h2>");
		List<Products> products = new ArrayList<Products>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Products product = session.get(Products.class, productId);
		products.add(product);
		
		out.println("<br><h2>Items in Cart :</h2>");
		out.println("<ul>");
		for(int i=0;i<products.size();i++) {
			out.println("<li> <h3><strong>"+ products.get(i).getName() + "</strong> by <strong>"+ products.get(i).getCompany() +"</strong></h3></li>");
		}
		
		out.println("<br><br><a href='paymentServlet'><button>Proceed to Buy?</button></a>");
		
		session.close();
		out.close();
	}
}
