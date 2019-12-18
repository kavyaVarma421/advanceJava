<html>
<head>
<title>login and registration page</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<script src="login.js" type="text/javascript">
		
	</script>
	<form action="RegistrationServlet" method="post">
		<div class="Registration">
			<div class="Signup">Registration form</div>
			<div class="signup-form" align="center">
				<input type="text" id="fname" name="fName" placeholder="FirstName"
					class="input" required> <input id="lname" name="lName"
					placeholder="LastName" class="input" required>
				<div>
					<input id="uname" name="uName" placeholder="UserName" class="input"
						required>
					<p id="user" style=""></p>
				</div>
				<p id="valid"></p>
				<input type="password" id="passw" name="password"
					placeholder="Password" class="input" required> <input
					type="password" id="cnfrmPasswrd" name="cnformPass"
					placeholder="confirm Password" class="input" required> <input
					id="email" name="emailId" placeholder="EmailId" class="input"
					required> <input id="phnNo" name="phnNum"
					placeholder="MobileNumber" class="input" required>
				<div class="button">
					<button type="submit" id="hh">create account</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>