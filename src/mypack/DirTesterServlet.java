package mypack;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.jasper.tagplugins.jstl.core.Out;

import java.io.*;
import java.util.*;

public class DirTesterServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		ServletContext context = getServletContext();
		
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		Enumeration eu = context.getAttributeNames();
		while (eu.hasMoreElements())
		{
			String attributeName = (String)eu.nextElement();
			out.println("<br>" + attributeName + ": " + context.getAttribute(attributeName));
		}
		out.close();
		
		File wordDir = (File)context.getAttribute("javax.servlet.context.tempdir");
		FileOutputStream fileOut = new FileOutputStream(wordDir + "/temp.txt");
		fileOut.write("Hello world!".getBytes());
	}
}
