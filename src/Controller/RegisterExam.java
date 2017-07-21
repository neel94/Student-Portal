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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterExam
 */
@WebServlet("/RegisterExam")
public class RegisterExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterExam() {
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
		//doGet(request, response);
		String url = "jdbc:mysql://localhost:3306/db1";
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		
		String id=(String)request.getSession().getAttribute("Id");
		String name=request.getParameter("name");
		String date=request.getParameter("date");
		String topic=request.getParameter("topic");
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn = DriverManager.getConnection(url, "root", "root");  
			  
			PreparedStatement ps = conn.prepareStatement("insert into studentexam(id,name,date,topic) values(?,?,?,?)");  
			  
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,date);
			ps.setString(4,topic);
			
			
			int i=ps.executeUpdate();  
			if(i>0)  
			out.print("You posted...");  
			      
			response.sendRedirect("StudentExam.jsp");          
			}
			catch (Exception e2) 
			{System.out.println(e2);}  
		
		
	}

}
