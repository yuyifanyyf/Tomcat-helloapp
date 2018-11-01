package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class FontServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String word = request.getParameter("word");
		if (word == null) word = "Hello";
		
		//读取初始化参数
		String color = getInitParameter("color");
		String size = getInitParameter("size");
		System.out.println("servletName:" + getServletName());
		//设置HTTP响应的正文的MIME类型及字符编码
		response.setContentType("text/html;charset=GB2312");
		
		/*输出HTML文档*/
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>FontServlet</title></head>");
		out.println("<body>");
		out.println("<font size='" + size + "' color='" + color + "'>" + word + "</font>");
		out.println("</body></html>");
		
		out.close();
	}
}
