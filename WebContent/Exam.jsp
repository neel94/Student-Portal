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
                            		
                            		
                            		<li><a href="login.jsp">logout</a></li>
                            		<li><a href="StudentViewResult.jsp">View Result</a></li>
                        	</ul>
			</nav>

			
			
			</aside>
			</section>
			
<section id="content" class="column-center">
                		
	    
	<article>
	<h1>WELCOME TO UALBANY</h1>
	<br>
<% 
loginDAO l= new loginDAO();
l.resource1();
ResultSet rs=l.exam();
%>

<H1>Exams</H1>
        
  <%while(rs.next()){ %>
  
<form action= "RegisterExam?name=<%=rs.getString(1)%>&amp;date=<%=rs.getString(2)%>&amp;topic=<%=rs.getString(3)%>" method= "post">
<fieldset style="width: 300px">
       <table border='1' > 

<tr>  
     <td>Name:<% out.println(rs.getString(1)); %> </td>
     <td>Date: <% out.println(rs.getString(2)); %> </td>
     <td>Topic: <% out.println(rs.getString(3)); %> </td>
     <td><input type="submit" value="Register" /></td>              
</tr>  

        </table>
         </form>
    <%} %>
    <br>
    
   
    
    
	</article>
</section>	
		<div class="clear"></div>
		
		<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>