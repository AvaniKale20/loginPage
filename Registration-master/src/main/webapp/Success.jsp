
<%
   Object userId = session.getAttribute("uname");
   if(userId == null) {
      response.sendRedirect("log.jsp");
   }
%>
<html>
<body >


<h2 style="color: red;text-align: center"><i>Welcome To Login Application</i></h2>
		Welcome...<label for="male"><%= session.getAttribute("uname")%></label>
<h3 style="color: red;text-align: center"><i>Successfully Logged In.....</i></h3>

<br><br>
<form action="logout" method="post">

<input type="submit" value="Logout ">
</form>

</body>
</html>