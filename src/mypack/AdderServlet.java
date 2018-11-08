package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AdderServlet extends GenericServlet{
	private int sum = 100;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int increase = Integer.parseInt(req.getParameter("increase"));
		res.setContentType("text/html;charest=GB2312");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>AdderServlet</title></head>");
		out.println("<body>");
		synchronized (this) {
			out.println(sum + "+" + increase + "=");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			sum += increase;
			out.println(sum);
		}
		out.println("</body></html>");
		out.close();
	}
	
}
