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
		System.out.println("����Χ�ڵ���Ϣ��" + message);
		
		message = request.getParameter("msg");
		System.out.println("��������е���Ϣ��" + message);
		PrintWriter out = response.getWriter();
		out.println(message);
		out.close();
	}
}
