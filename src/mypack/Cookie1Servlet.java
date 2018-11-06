package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Cookie1Servlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		Cookie cookie = null;
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				out.println("Cookie name:" + cookies[i].getName());
				out.println("Cookie value:" + cookies[i].getValue());
				if (cookies[i].getName().equals("username")) cookie = cookies[i];
			}
		}
		else {
			out.println("no cookie.");
		}
		
		if (cookie == null)
		{
			cookie = new Cookie("username", "yyf");
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
		}
		else if (cookie.getValue().equals("yyf"))
		{
			cookie.setValue("Jack");
			response.addCookie(cookie);
		}
		else if (cookie.getValue().equals("Jack")) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
}
