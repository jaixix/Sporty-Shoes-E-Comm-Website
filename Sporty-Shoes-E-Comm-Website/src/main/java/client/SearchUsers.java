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

import entity.Users;
import util.HibernateUtil;

@WebServlet("/searchUsers")
public class SearchUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		String findName = request.getParameter("findName");
		List<Users> users = new ArrayList<Users>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Users FETCH ALL PROPERTIES where name=:findName";
		Query<Users> query  = session.createQuery(hql);
		query.setParameter("findName", findName);
		users.addAll(query.list());
		
		request.setAttribute("users", users);
		
		RequestDispatcher rd = request.getRequestDispatcher("/searchedUsers.jsp");
		rd.forward(request,response);
		session.close();
	}
}