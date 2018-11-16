<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=GB2312" %>
<html>
	<head>
		<title>dbaccess2.jsp</title>
	</head>
	<body>
		<%
		try{
			Connection con;
			Statement stmt;
			ResultSet rs;
			
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/BookDB";
			String user = "root";
			String password = "2ez4yuan";
			con = DriverManager.getConnection(dbUrl, user, password);
			stmt = con.createStatement();
		%>
		<%@ include file="pages.jsp" %>
		<%
		stmt.close();
		con.close();
		} catch(Exception e)
		{
			out.println(e.getMessage());
		}
		%>
	</body>
</html>