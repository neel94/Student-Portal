package Controller;



import java.sql.*;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


/**
 * Servlet implementation class loginDAO
 */
@SuppressWarnings("serial")
@WebServlet("/loginDAO")
public class loginDAO extends HttpServlet {
	
	static Statement s =null;
	static ResultSet rs=null;
	
	public static boolean validateStaff(String id,String pass){  
		boolean status=false;  
		String url = "jdbc:mysql://localhost:3306/db1";
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn = DriverManager.getConnection(url, "root", "root");  
		      
		PreparedStatement ps=conn.prepareStatement("select * from registration where Id=? and Password=? role='staff' ");  
		ps.setString(1,id);  
		ps.setString(2,pass); 
		//`ps.setString(3,'student');
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}
		catch(Exception e){System.out.println(e);}  
		return status;  
		}  
	
		public static boolean validateFaculty(String id,String pass){  
		
		boolean status=false;  
		String url = "jdbc:mysql://localhost:3306/db1";
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn = DriverManager.getConnection(url, "root", "root");  
		      
		PreparedStatement ps=conn.prepareStatement("select * from registration where Id=? and Password=? and role='faculty' ");  
		ps.setString(1,id);  
		ps.setString(2,pass); 
		//`ps.setString(3,'student');
		      
		rs=ps.executeQuery();  
		status=rs.next();  
		          
		}
		catch(Exception e){System.out.println(e);}  
		return status;  
		}  
		
		public void resource1() throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
			s=con.createStatement();


		}
		public ResultSet resource2() throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select *  from resources");
			return rs;
		}
		public ResultSet profile(String id) throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select *  from registration where id='"+id+"'");
			return rs;
		}
		public ResultSet resourcefetch() throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select * from reserveresources");
			return rs;
		}
		public ResultSet resourcecancel(int id) throws ClassNotFoundException, SQLException{
			
			s.executeUpdate("delete from reserveresources where id='"+ id +"'");
			System.out.println("IIIDDD IN LOGINDAO:"+id);
			return rs;
		}
		public ResultSet job() throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select *  from job");
			return rs;
		}
		public ResultSet exam() throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select *  from exam");
			return rs;
		}
		public ResultSet result() throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select Id  from result");
			return rs;
		}
		public ResultSet info() throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select * from courseinfo");
			return rs;
		}
		public ResultSet viewcourse() throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select * from addcourse");
			return rs;
		}
		public ResultSet viewresult() throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select * from result");
			return rs;
		}
		public ResultSet progreq() throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select * from progreq");
			return rs;
		}
		public ResultSet studentexam(String id) throws ClassNotFoundException, SQLException{
			
			rs=s.executeQuery("select * from studentexam where id='"+id +"'");
			return rs;
		}
		
		public static boolean checkres(String resource,String time,String date ) {
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
			} catch (ClassNotFoundException  e) {
				e.printStackTrace();
			}
			String sql = "select * from reserveresources";
			
			
			Connection conn=null;
			
			

			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/termproject", "root", "root");
				Statement s = conn.createStatement();

				ResultSet r=s.executeQuery(sql);
				String namedb=null;
				String datedb=null;
				String timedb=null;
				//String netiddb=null;
				while(r.next())
				{
					namedb=r.getString("name");
					datedb=r.getString("Date");
					timedb=r.getString("Time");
					
				}
				if(resource.equals(namedb) && date.equals(datedb) && time.equals(timedb))
				{
					return false;
				}
				else{
					return true;
				}
				

			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;

			}
		public static boolean validateStudent(String id,String pass){  
			boolean status=false;  
			String url = "jdbc:mysql://localhost:3306/db1";
			try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn = DriverManager.getConnection(url, "root", "root");  
			      
			PreparedStatement ps=conn.prepareStatement("select * from registration where Id=? and Password=? role='student' ");  
			ps.setString(1,id);  
			ps.setString(2,pass); 
			//`ps.setString(3,'student');
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
			          
			}
			catch(Exception e){System.out.println(e);}  
			return status;  
			}  
		
		//rs=s.executeQuery("select *  from resources");
		
}
