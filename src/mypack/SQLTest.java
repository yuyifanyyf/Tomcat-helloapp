package mypack;

import java.sql.*;

public class SQLTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb?useSSL=false"
				, "root", "2ez4yuan");
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select * from BOOKS");
		while (rs.next())
		{
			System.out.println(rs.getString("ID") + "\t" + rs.getString("TITLE"));
		}
	}
}
