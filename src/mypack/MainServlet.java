package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class MainServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>MainServlet</title></head>");
		out.println("<body>");
		
		ServletContext context = getServletContext();
		RequestDispatcher headDispatcher = context.getRequestDispatcher("/header.htm");
		RequestDispatcher greetDispatcher = context.getRequestDispatcher("/greet");
		RequestDispatcher footDispathcer = context.getRequestDispatcher("/footer.htm");
		
		headDispatcher.include(request, response);
		greetDispatcher.include(request, response);
		footDispathcer.include(request, response);
		out.println("</body></html>");
		
		out.close();
	}
}
