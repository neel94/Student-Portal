<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="Controller.loginDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />


<title>UAlbany website</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />

<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>

<body>
<style type="text/css">               
        body {background-image:url('image/img4.jpg');}      
    </style>

		<section id="body" class="width">
			<aside id="sidebar" class="column-center">

			<header>
				<h1><a href="#"></a>OPTIONS</h1>

				<h2></h2>
				
			</header>

			<nav id="mainnav">
  				<ul>
                            		
                            		
                            		<li><a href="login.jsp">LOGOUT</a></li>
                            		<li><a href="StudentHomepage.jsp">HOME</a></li>
                            		
                        	</ul>
			</nav>

			
			
			</aside>
			</section>
			
<section id="content" class="column-center">
                		
	    
	<article>
	<h1>WELCOME TO UALBANY</h1>
	<br>
<%
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select *  from studentcourseinfo ");
  
  
  %>

<fieldset style="width: 300px">
        <H1>Course Info</H1>

        
  <%while(rs.next()){ %>
  

<table border='1' >
<tr>  
     <td>ID:<% out.println(rs.getString(1)); %> </td>
     <td>Name: <% out.println(rs.getString(2)); %> </td>
     <td>officehrs: <% out.println(rs.getString(3)); %> </td>
     <td>TA office hrs: <% out.println(rs.getString(4)); %> </td>
     <td>Faculty Location: <% out.println(rs.getString(5)); %> </td>
     <td>TA location: <% out.println(rs.getString(6)); %> </td>
                 
</tr>  

        </table>
    
    <br>
    
    
      
    <%} %>
    
	</article>
</section>	
		<div class="clear"></div>
		
		

</body>
</html>