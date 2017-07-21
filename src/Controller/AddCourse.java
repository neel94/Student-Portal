package Controller;

//import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
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
		String id=request.getParameter("id");  
		String cname=request.getParameter("name");
		HttpSession h= request.getSession();
		String d = (String) h.getAttribute("Id");
		System.out.println(d);
		System.out.println(id);
		System.out.println(cname);
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn = DriverManager.getConnection(url, "root", "root");  
			java.sql.Statement s=conn.createStatement(); 
			ResultSet rs=((java.sql.Statement) s).executeQuery("select * from addcourse where id='"+id+"'");
			if(rs.next()){
			out.println("Already Taken");
			
			}
			else{
				PreparedStatement ps = conn.prepareStatement("insert into addcourse(Id,cname,loginID) values(?,?,?)");  
				  
				ps.setString(1,id);  
				ps.setString(2,cname);  
				ps.setString(3,d);  
				
				
				int i=ps.executeUpdate(); 
				response.sendRedirect("ViewCourse.jsp");
			}
		
		}
		
		catch (Exception e2) 
		{System.out.println(e2);}  
		}

}
