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
                        	</ul>
			</nav>

			
			
			</aside>
			</section>
			
<section id="content" class="column-center">
                		
	    
	<article>
	<h1>WELCOME TO UALBANY</h1>
<%loginDAO l= new loginDAO();
l.resource1();
ResultSet s=null;
s=l.resource2();
%>

        <H1>RESOURCES</H1>
<form action="ReserveResources" method="post" >
Resurces: <select name="resource">
	 
	 
        <%
  
  while(s.next())
  { %>
  <option>
  
     <%
      
     out.println( s.getString("name"));
      %>
     
  
  </option>
	 
  


<%
  }
 %>
 
	 
	</select>
 <br/><br/>
 <div id="showfield" >
Time:<select name="time">
	 <option>8-9</option>
	 <option>9-10</option>  
	 <option>10-11</option>  
	 <option>11-12</option>
	</select>
 <br/><br/>
Date:  
<input type="date" id="2" name=cal> </input>
</div>
 <br>
<input type="submit" value="Submit" />
        </form>
    
	</article>
</section>	
		<div class="clear"></div>
		
		<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>