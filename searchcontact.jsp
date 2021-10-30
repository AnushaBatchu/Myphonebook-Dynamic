<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
	margin-left: auto;
	margin-right: auto;
}
ul{
list-style-type: none;
margin: 0;
padding: 0;
overflow:hidden;
background-color: #333;
}

li{
float: left;
}

li a{
display: block;
color: white;
text-align: center;
padding: 14px 16px;
text-decoration: none;
}
li a:hover {
	background-color: #111;
}

</style>

</head>
<body>
<%@page import="java.sql.*,calldatabase.*" %>
<table class="center">
<tr>
<td>
<ul>
<li><a class="active" href="adminhome.html">Home</a></li>
<li><a href="adminlogin.html">Admin Login</a></li>
<li><a href="create.html">Add contact</a></li>
<li><a href="searchcontact.html">Search contact</a></li>
<li><a href="Delete Contact.html">Delete contact</a></li>
<li><a href="Emargencycontacts.html">Emargency contacts</a></li>
<li><a href="adminlogin.html">Logout</a></li>
</ul>
</td>
</tr>
</table>
<table border="2">
<tr><th colspan="5">phonebook</th></tr>
<tr><td>name</td><td>phonenumber</td><td>email</td><td>Relation</td>
<%
try{
	Connection cn=GetData.getCn();
	PreparedStatement ps=cn.prepareStatement("select * from phonebook");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>

</body>
</html>