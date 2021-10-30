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
import javax.servlet.http.HttpSession;

import calldatabase.GetData;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			HttpSession s=request.getSession(false);
			
			String name=request.getParameter("name");
			String Email=request.getParameter("Email");
			
			String relation=request.getParameter("relation");
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement("update phonebook set name=?,Email=?,relation=? where name=?");
			ps.setString(1, name);
			ps.setString(2, Email);
			ps.setString(3, relation);
			
			ps.execute();
			out.print("contact updated...");
			RequestDispatcher rd=request.getRequestDispatcher("adminhome.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}


	}


