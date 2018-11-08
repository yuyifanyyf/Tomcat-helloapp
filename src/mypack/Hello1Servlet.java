package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Hello1Servlet extends GenericServlet{
	private String username = null;
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		username = request.getParameter("username");
		if (username != null)
			username = new String(username.getBytes("ISO-8859-1"), "GB2312");
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>HelloServlet</title></head>");
		out.println("<body>");
		out.println("hello," + username);
		out.println("</body></html>");
		out.close();
	}
	
}
