<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    
<%

String name1 = (String)session.getAttribute("name");
Connection con = null;
Statement st = null;
ResultSet rs = null;
int temp=0;
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
<link rel="stylesheet" type="text/css" href="userDetails.css">
</head>
<body>
<table border="1">
<%
try{	
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc ? user=kavya & password=kavya123");
	st = con.createStatement();
	out.print("hello.."+name1);
	String query ="select Id,FirstName,LastName,UserName,EmailId,MobileNumber from LoginAndRegistration where  UserName  = '"+name1+"'";
	rs = st.executeQuery(query);
	while(rs.next()){
		temp=rs.getInt("Id");
%>
<tr><th>Id<td><%=rs.getInt("Id")%></td></tr>
<tr><th>firstName<td><%=rs.getString("FirstName")%></td></tr>
<tr><th>lastName<td><%=rs.getString("LastName")%></td></tr>
<tr><th>UserName<td><%=rs.getString("UserName")%></td></tr>
<tr><th>EmailId<td><%=rs.getString("EmailId")%></td></tr>
<tr><th>MobileNo<td><%=rs.getString("MobileNumber")%></td>
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
<a class="button" id = "upd" href=<%="Update?id="+temp %>>update</a>

<a class="button" id = "delete" href="DeleteServlet">delete</a>
<a class="button" id = "logout" href="LogoutServlet">logout</a>

</body>
</html>



