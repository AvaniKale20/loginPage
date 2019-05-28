<%@ page import="java.sql.*" %>
<%@ page import="com.bridgelabz.dao.DBConnection"%>

<%
String email=request.getParameter("email");
if(email.contains("@")&&email.contains(".")){
try{

Connection con=DBConnection.getDBConnection();
PreparedStatement ps=con.prepareStatement("select * from student where email=?");
ps.setString(1,email);
ResultSet rs=ps.executeQuery();
if(rs.next()){
out.print("Unavailable");
}else{
out.print("Available");
}
}catch(Exception e){out.print(e);}
}else{
 out.print("Invalid email!");
}
%>