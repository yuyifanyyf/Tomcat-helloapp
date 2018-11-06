package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

public class CheckServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String message = null;
		if (username == null)
		{
			message = "please input username.";
		}
		else
		{
			message = "hello," + username;
		}
		req.setAttribute("msg", message);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/output");
		PrintWriter out = res.getWriter();
		
		out.println("output from CheckServlet before forwarding request.");
		System.out.println("output from CheckServlet before forwarding request.");
		
		dispatcher.forward(req, res);
		out.println("output from CheckServlet after forwarding request.");
		System.out.println("output from CheckServlet after forwarding request.");
		
	}
	
}
