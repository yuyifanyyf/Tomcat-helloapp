package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class OutputServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = (String)req.getAttribute("msg");
		PrintWriter out = res.getWriter();
		out.println(message);
		System.out.println(message);
		out.close();
	}

}
