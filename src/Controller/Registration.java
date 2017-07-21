package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.*;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String url = "jdbc:mysql://localhost:3306/db1";
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String id=request.getParameter("Id");  
		String pass=request.getParameter("userPass");  
		String role=request.getParameter("role");  
		String first=request.getParameter("FirstName");
		String last=request.getParameter("LastName");
		String year=request.getParameter("year");
		String program=request.getParameter("program");
		String major=request.getParameter("major");
		
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn = DriverManager.getConnection(url, "root", "root");  
		  
		PreparedStatement ps = conn.prepareStatement("insert into registration(Id,Password,role,FirstName,LastName,Year,Program,Major) values(?,?,?,?,?,?,?,?)");  
		  
		ps.setString(1,id);  
		ps.setString(2,pass);  
		ps.setString(3,role);  
		ps.setString(4,first);  
		ps.setString(5,last);
		ps.setString(6,year);
		ps.setString(7,program);
		ps.setString(8,major);
		
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		      response.sendRedirect("login.jsp");
		          
		}
		catch (Exception e2) 
		{System.out.println(e2);}  
		          
		//out.close();  
		//doGet(request,response);
	}

}
