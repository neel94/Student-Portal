package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditAlumni
 */
@WebServlet("/EditAlumni")
public class EditAlumni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAlumni() {
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
		String name=request.getParameter("name");  
		String al=request.getParameter("alname");  
		String member=request.getParameter("member");
		String founded=request.getParameter("year");
		System.out.println(name);
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn = DriverManager.getConnection(url, "root", "root");  
			  
			PreparedStatement ps = conn.prepareStatement("update alumni set name=?, members=?, founded=? where name='"+name+"'");
			  
			ps.setString(1,al);  
			ps.setString(2,member);  
			ps.setString(3,founded);
	
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		     response.sendRedirect("ViewAlumni.jsp"); 
		          
		}
		catch(Exception e2) 
		{System.out.println(e2);}  
	}

}
