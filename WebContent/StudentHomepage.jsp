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
                            		
                            		
                            		
                            		<li><a href="StudentViewCourse.jsp">COURSES</a></li>
                            		<li><a href="Email.jsp">EMAIL PROFESSOR/TA</a></li>
                           		 	<li><a href="StudentApplyJob.jsp">APPLY FOR JOB</a></li>
                           		 	<li><a href="StudentProfile.jsp">PROFILE</a></li>
                           		 	<li><a href="StudentViewAlumni.jsp">ALUMNI</a></li>
                           		 	<li><a href="StudentCourseSuggestion.jsp">SUGGESTEDCOURSES</a></li>
                           		 	<li><a href="StudentCourseInfo.jsp">COURSES INFO</a></li>
                           		 	<li><a href="StudentDiscussion.jsp">DISCUSSION</a></li>
                           		 	<li><a href="StudentResource.jsp">RESERVE RESOURCES</a></li>
                           		 	<li><a href="StudentProgramRequirement.jsp">REQUIREMENTS</a></li>
                           		 	<li><a href="Exam.jsp">Exam</a></li>
                           		 	<li><a href="login.jsp">LOGOUT</a></li>
                            		
                        	</ul>
			</nav>

			
			
			</aside>
			</section>
			
<section id="content" class="column-center">
                		
	    
	<article>
	<h1>WELCOME TO UALBANY</h1>
	<br>

	</article>
</section>	
		<div class="clear"></div>
		
		<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>