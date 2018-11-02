package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class ExceptionTesterServlet extends GenericServlet{
	public void service(ServletRequest request, ServletResponse response)
		throws ServletException, IOException{
		String condidion = request.getParameter("condition");
		if (condidion == null) condidion = "ok";
		
		if (condidion.equals("1"))
		{
			throw new ServletException("condition1");
		}
		else if (condidion.equals("2"))
		{
			throw new UnavailableException("condition2", 2);
		}
		else if (condidion.equals("3"))
		{
			throw new UnavailableException("condition3");
		}
		PrintWriter out = response.getWriter();
		out.println("it's ok.");
		out.close();
	}
}
