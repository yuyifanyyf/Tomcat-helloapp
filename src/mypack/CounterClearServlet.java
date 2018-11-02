package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class CounterClearServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		ServletContext context = getServletContext();
		context.removeAttribute("counter");
		
		PrintWriter out = response.getWriter();
		out.println("the counter is removed");
		out.close();
	}
}
