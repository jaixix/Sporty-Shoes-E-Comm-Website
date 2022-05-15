package client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		int productId = Integer.parseInt(request.getParameter("id"));
		System.out.println(productId);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Products product = session.get(Products.class, productId);
		
	}
}
