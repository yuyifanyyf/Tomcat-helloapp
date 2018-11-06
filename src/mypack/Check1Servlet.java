package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

public class Check1Servlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String message = null;
		if (username == null) message = "please input username.";
		else message = "hello," + username;
		
		request.setAttribute("msg", message);
		
		out.println("Output from Check1Servlet before redirecting.");
		System.out.println("Output from Check1Servlet before redirecting.");
		response.sendRedirect("/helloapp/output1?msg=" + message);
		
		out.println("Output from Check1Servlet afer redirecting.");
		System.out.println("Output from Check1Servlet afer redirecting.");
	}
}
