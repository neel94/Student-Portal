package Controller;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    HttpSession h= request.getSession();   
	    
	    String n=request.getParameter("Id");
	    System.out.println("n here"+n);
	    String p=request.getParameter("userpass");  
	          
	    if(loginDAO.validateFaculty(n, p)){  
	    	//out.println("Success"); 
	    	h.setAttribute("Id",n);
	    	System.out.println("n here222"+n);
	    	String idid= (String)request.getSession().getAttribute("Id");
	    	System.out.println("ididmeet"+idid);
	    	response.sendRedirect("FacultyHomepage.jsp");
	    }  
	    
	    else{  
	    	
	    	if(loginDAO.validateStaff(n, p)){  
		    	//out.println("Success"); 
	    		h.setAttribute("Id",n );
		    	response.sendRedirect("Homepage.jsp");
		    }  
	    	else{
	    		h.setAttribute("Id",n );
		    	response.sendRedirect("StudentHomepage.jsp");
	    	}
	    }  
	          
	    out.close();  
	   }  
}


