<!-- 首先导入必要的packages -->
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>

<%@ page contentType="text/html; charset=GB2312" %>
<html>
	<head>
		<title>dbaccess</title>
	</head>
	<body>
		<%
		try{
			Connection conn;
			Statement stmt;
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bookdb?useSSL=false";
			String user = "root";
			String pw = "2ez4yuan";
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into BOOKS (ID, NAME, TITLE, PRICE)" + 
					"values('999', 'Tom', 'Tomcat Bible', 44.5)");
			rs = stmt.executeQuery("select ID, NAME, TITLE, PRICE from BOOKS");
			out.println("<table border=1 width=400>");
			while (rs.next())
			{
				String col1 = rs.getString(1);
				String col2 = rs.getString(2);
				String col3 = rs.getString(3);
				float col4 = rs.getFloat(4);
				out.println("<tr>");
				out.println("<td>"+ col1 + "</td>");
				out.println("<td>"+ col2 + "</td>");
				out.println("<td>"+ col3 + "</td>");
				out.println("<td>"+ col4 + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			stmt.executeUpdate("delete from BOOKS where ID='999'");
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){out.println(e.getMessage());}
		%>
	</body>
</html>