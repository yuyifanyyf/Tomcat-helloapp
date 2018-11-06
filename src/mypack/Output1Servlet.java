package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

public class Output1Servlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String message = (String)request.getAttribute("msg");
		System.out.println("请求范围内的消息：" + message);
		
		message = request.getParameter("msg");
		System.out.println("请求参数中的消息：" + message);
		PrintWriter out = response.getWriter();
		out.println(message);
		out.close();
	}
}
