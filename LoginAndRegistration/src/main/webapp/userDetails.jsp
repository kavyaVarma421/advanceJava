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
<link rel="stylesheet" type="text/css" href="CSS/userDetails.css">
<style type="text/css">
</style>
</head>

<body class="body">
<h1>
<%out.print("welcome   "+name1+"  check your details below");%>
</h1>
<div class="fort">
<table>
<%
try{	
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc ? user=kavya & password=kavya123");
	st = con.createStatement();
	
	String query ="select Id,FirstName,LastName,UserName,EmailId,MobileNumber from LoginAndRegistration where  UserName  = '"+name1+"'";
	rs = st.executeQuery(query);
	while(rs.next()){
		temp=rs.getInt("Id");
%>
<tr><th>Id       <td><%=rs.getInt("Id")%></td></tr>
<tr><th>firstName  <td><%=rs.getString("FirstName")%></td></tr>
<tr><th>lastName   <td><%=rs.getString("LastName")%></td></tr>
<tr><th>UserName   <td><%=rs.getString("UserName")%></td></tr>
<tr><th>EmailId    <td><%=rs.getString("EmailId")%></td></tr>
<tr><th>MobileNo   <td><%=rs.getString("MobileNumber")%></td>
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
</div>
<div class="clicking">

<a class="button" id = "update" href=<%="Update?id="+temp %>>update</a>&ensp;&ensp;


<a class="button" id = "delete" href="DeleteServlet">delete</a>&ensp;&ensp;


<a class="button" id = "logout" href="LogoutServlet">logout</a>

</div>
</body>

</html>
 


