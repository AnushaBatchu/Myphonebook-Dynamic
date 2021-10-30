package allserv;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calldatabase.GetData;

/**
 * Servlet implementation Delete Contact
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String name=request.getParameter("number");
			
			
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement(" delete from phonebook where phonenumber=?");
			
			ps.setString(1,name);
			
			ps.execute();
			out.print("Contact Deleted...");
			RequestDispatcher rd=request.getRequestDispatcher("Delete Contact.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}



	

	}


