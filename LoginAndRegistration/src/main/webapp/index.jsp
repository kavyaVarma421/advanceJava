<html>
<head>
<title>login and registration page</title>
<link rel="stylesheet" type="text/css" href="login.css">
<style type="text/css">	
body {
	background-color:black;
	font-family: 'Roboto', sans-serif;
}
</style>
</head>
<body>
<% String s=(String)(request.getAttribute("display")!=null?request.getAttribute("display"):"none") ;
%>
<% String str=(String)(request.getAttribute("editing")!=null?request.getAttribute("editing"):"none") ;
%>
<script src = "login.js" type="text/javascript">

</script>

	<form action = "LoginServlet" method="post">
		<div class="for-login">
			<div class="login">log in</div>
			<div class="login-form" align="center">
			<div class="show" style="display: <%=s%>;">Successfully registered..now you can login here!</div>
			<%-- <div class="displ" style="editing: <%=str%>;">successfully updated..login to show deatails</div> --%>
				<input type="text" name="username" placeholder="UserName" class="input">
                <input type="password" name= "passwrd" placeholder="Password" class="input">            
				<div class="button">
					<button type="submit" id="hh">login</button>
				</div>
				Don't have account?<a href="signup.jsp">&nbsp;Sign Up</a>
			</div>
		</div>
	</form>
</body>
</html>

