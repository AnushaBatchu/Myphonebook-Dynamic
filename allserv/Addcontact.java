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
 * Servlet implementation class Addcontact
 */
@WebServlet("/Addcontact")
public class Addcontact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String name=request.getParameter("name");
			String phoneNumber=(String) request.getParameter("number");
			String email=request.getParameter("email");
			String Relation=request.getParameter("Relation");
			
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement("insert into phonebook  values(?,?,?,?)");
			
			ps.setString(1,name);
			ps.setString(2, phoneNumber);
			ps.setString(3, email);
			ps.setString(4, Relation);
			ps.execute();
			out.print("Contact saved...");
			RequestDispatcher rd=request.getRequestDispatcher("create.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}



	}


