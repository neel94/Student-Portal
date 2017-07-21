package Controller;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReserveResources
 */
@WebServlet("/ReserveResources")
public class ReserveResources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveResources() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String url = "jdbc:mysql://localhost:3306/db1";
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		String time=request.getParameter("time");
		String date=request.getParameter("cal");
		String resource=request.getParameter("resource");
		System.out.println(time);
		System.out.println(date);
		
		loginDAO l= new loginDAO();
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn = DriverManager.getConnection(url, "root", "root");  
			if(l.checkres(resource,time,date)){  
				out.print("Sorry!! Already reserved..."); 
			
			//out.print("You are successfully reserved...");  
			      
			
			}
			else{
				
				PreparedStatement ps = conn.prepareStatement("insert into reserveresources(name,Time,Date) values(?,?,?)");  
				ps.setString(1,resource);  
				ps.setString(2,time);  
				ps.setString(3,date);
				
				ps.execute();  
				response.sendRedirect("StudentViewResources.jsp");
				
			}
			}
			catch (Exception e2) 
			{System.out.println(e2);}  
			          
			//out.close();  
			//doGet(request,response);
		
	}

}
