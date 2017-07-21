<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="Controller.loginDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
function check() {
    if (document.getElementById('s1').checked) {
        document.getElementById('showfield').style.display = 'block';
    }
    else {
        document.getElementById('showfield').style.display = 'none';
    }
}
</script>

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
                            		
                            		
                            		
                            		
                            		<li><a href="login.jsp">login</a></li>
                        	</ul>
			</nav>

			
			
			</aside>
			</section>
			
<section id="content" class="column-center">
                		
	    
	<article>
	
<form action= "Registration" method= "post">
ID: <input type="text" name= "Id"/> <br/> <br/>
Password:<input type="password" name="userPass"/><br/><br/>
Role:  <br>
<INPUT type="radio" name="role" id="s1" value="student" onclick="javascript:check();">
             Student
            <BR>
            <INPUT type="radio" name="role" id="f1" value="faculty" onclick="javascript:check();">
             Faculty
            <BR>
            <INPUT type="radio" name="role" id="s2" value="staff" onclick="javascript:check();">
             staff
          	 <BR>

First Name:<input type="text" name="FirstName"/><br/><br/>
Last Name:<input type="text" name="LastName"/><br/><br/>
 <div id="showfield" style="display:none">
Year Joined:<input type="text" name="year"/><br/><br/>
Program:  
<select name="program">  
<option value="none">none</option>
<option value="bs">BS</option>  
<option value="ba">BA</option>  
<option value="ms">MS</option>
<option value="phd">Phd</option>
</select>
Major:<input type="text" name="major"/><br/><br/>
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