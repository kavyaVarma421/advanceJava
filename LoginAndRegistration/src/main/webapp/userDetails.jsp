<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    
<%
String name = (String) request.getAttribute("User");
String name1 = (String)session.getAttribute("name");
Connection con = null;
Statement st = null;
ResultSet rs = null;
try{
	Class.forName("com.mysql.jdbc.Driver");
}catch(Exception e){
	e.printStackTrace();
}

%>
<!DOCTYPE html>
<html>
<head>
<title>user details</title>
</head>
<body>
<form action="">
<table border="1">
<tr>
<td>Id</td>
<td>firstName</td>
<td>lastName</td>
<td>UserName</td>
<td>EmailId</td>
<td>MobileNo</td>
</tr>
<%
try{	
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc ? user=kavya & password=kavya123");
	st = con.createStatement();
	out.print(name);
	String query ="select Id,FirstName,LastName,UserName,EmailId,MobileNumber from LoginAndRegistration where  UserName  = '"+name1+"'";
	rs = st.executeQuery(query);
	while(rs.next()){
%>
<tr>
<td><%=rs.getInt("Id") %></td>
<td><%=rs.getString("FirstName")%></td>
<td><%=rs.getString("LastName")%></td>
<td><%=rs.getString("UserName")%></td>
<td><%=rs.getString("EmailId")%></td>
<td><%=rs.getString("MobileNumber")%></td>
</tr>
<%
	}
con.close();
st.close();
}catch(Exception e){
	e.printStackTrace();
}
%>
</table>
<button type="submit" id="hh">logout</button>
</form>
</body>
</html>