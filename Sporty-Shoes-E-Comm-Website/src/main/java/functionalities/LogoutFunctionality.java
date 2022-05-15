package functionalities;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logoutFunctionality")
public class LogoutFunctionality extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside Get Method!");

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("emailId") || cookie.getName().equals("userName") || cookie.getName().equals("userId")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}	
		}
		
		response.sendRedirect("loginForm.html");
	}
}