package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.Purchases;
import util.HibernateUtil;

@WebServlet("/paymentServlet")

public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside Get Method!");
		
		int userId = 0;
		int productId = 0;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userId")) {
					userId = Integer.parseInt(cookie.getValue());
				}
				
				if (cookie.getName().equals("productId")) {
					productId = Integer.parseInt(cookie.getValue());
				}
			}
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Purchases purchase = new Purchases(userId, productId);

		session.save(purchase);
		session.getTransaction().commit();
		session.close();

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>Payment Successful!</h2><br>");
		out.println("<h3>Please check Orders Tab for details.</h3><br>");
		out.println("<br><br><a href='indexUser.jsp'>Go Back to Home Page?</a>");
		out.close();
	}
}
