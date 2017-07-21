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
                            		<li><a href="CreateResource.jsp">Create New Resources</a></li>
                            		<li><a href="Resources.jsp">ReserveResources</a></li>
                            		<li><a href="login.jsp">logout</a></li>
                        	</ul>
			</nav>

			
			
			</aside>
			</section>
			
<section id="content" class="column-center">
                		
	    
	<article>
	<h1>WELCOME TO UALBANY</h1>
	
<%
        ResultSet rs= null;
        loginDAO d= new loginDAO();
        d.resource1();
		rs=d.resourcefetch();
  
  
  %>


        <H1>Reservation</H1>
<table border='1' >
        
  
  <%while(rs.next()){ %>
  

<br>
  	<tr>
     <td>Name:<% out.println(rs.getString(1)); %> </td>
     <td>Time:<% out.println(rs.getString(2)); %> </td>
     <td>Date:<% out.println(rs.getString(3)); %> </td>
     <td><a href="CancelReservation?x=<%= rs.getInt(4)%>">Delete</a> </td>
     
     </tr>              
 


        
        
    
    <%} %>
    
    </table>
    
    
    
    

	</article>
</section>	
		<div class="clear"></div>
		
		<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>