package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class HelloServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String name = request.getParameter("username");
		
		if (name != null) name = new String(name.getBytes("ISO-8859-1"), "GB2312");
		else {
			response.sendError(response.SC_FORBIDDEN);
			System.out.println("refuse you!");
			return;
		}
		
		response.setContentType("text/html;charset=GB2312");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>HelloServlet</title></head>");
		out.println("<body>");
		out.println("ÄãºÃ£º" + name);
		out.println("</body></html>");
		System.out.println("before close():" + response.isCommitted());
		out.close();
		System.out.println("after close():" + response.isCommitted());
	}
}
