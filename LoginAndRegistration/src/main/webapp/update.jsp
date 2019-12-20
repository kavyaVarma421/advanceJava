<%@page import="model.PersonDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<% 
try{
PersonDetails pd=(PersonDetails)request.getAttribute("detail");
%>
<html>
<body>
<h1>Update your details</h1>

<form method="post" action="UpdateServlet">
<div>

First name:
<input type="text" name="firstName" value=<%=pd.getfName()%>>
<br>
Last name:
<input type="text" name="lastName" value=<%=pd.getlName()%>>
<br>
User Name:
<input type="text" name="UserName" readonly="readonly" value=<%=pd.getuName()%>>
<br>
Email Id:
<input type="email" name="email" value=<%=pd.getEmailId()%>>
<br>
Mobile Number:
<input type="text" name="MobileNo" value=<%=pd.getPhnNum()%>>
<br><br>

</div>

<button type="submit" id="button">update</button>

<%}catch(Exception e){
out.print(e);
}
	%>

</form>
</body>
</html>