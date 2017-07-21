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
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditStatus
 */
@WebServlet("/EditStatus")
public class EditStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStatus() {
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
		String status=request.getParameter("Status");  
		
		
		String s= request.getParameter("ID");
		
		System.out.println(s);
		
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn = DriverManager.getConnection(url, "root", "root");  
			  
			PreparedStatement ps = conn.prepareStatement("update registration set Status=? where Id='"+s+"'");
			  
			ps.setString(1,status);  
			
	
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		     response.sendRedirect("PhdStatus.jsp"); 
		          
		}
		catch(Exception e2) 
		{System.out.println(e2);}  
	}

}
