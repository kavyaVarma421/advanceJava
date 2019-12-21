<%@page import="model.PersonDetails"%>

    <%@page import="java.sql.*" %>
<% 
try{
PersonDetails pd=(PersonDetails)request.getAttribute("detail");
%>
<html>
<head>
<title>updating details</title>
<link rel="stylesheet" type="text/css" href="CSS/update.css">
</head>
<body>
<h1>Update your details</h1>

<form method="post" action="UpdateServlet">
<div class="editing">
<div class = "edit">
<a>First name:</a>
</div>
<div class="texting">
<input type="text" name="firstName" class="input" value=<%=pd.getfName()%>>
</div>
<br>
<div class = "edit"><a>Last name:</a></div>
<div class="texting">
<input type="text" name="lastName" class="input" value=<%=pd.getlName()%>>
</div>
<br>
<div class = "edit"><a>User Name:</a></div>
<div class="texting">
<input type="text" name="UserName"  class="input" readonly="readonly" value=<%=pd.getuName()%>>
</div>
<br>
<div class = "edit"><a>Email Id:</a></div>
<div class="texting">
<input type="email" name="email" class="input" value=<%=pd.getEmailId()%>>
</div>
<br>
<div class = "edit"><a>Mobile Number:</a></div>
<div class="texting">
<input type="text" name="MobileNo" class="input" value=<%=pd.getPhnNum()%>>
</div>
<br><br>

</div>

<div class="click">
<button type="submit" id="button">update</button>
</div>
<%
}catch(Exception e)
{
out.print(e);
}
%>
</form>
</body>
</html>