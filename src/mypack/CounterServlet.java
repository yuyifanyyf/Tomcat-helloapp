package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		ServletContext context = getServletContext();
		Counter counter = (Counter)context.getAttribute("counter");
		if (counter == null)
		{
			counter = new Counter(1);
			context.setAttribute("counter", counter);
		}
		
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>CounterServlet</title></head>");
		out.println("<body>");
		out.println("<h1>��ӭ���١����ǵ�" + counter.getCount() + "λ�����ߡ�</h1>");
		out.println("</body></html>");
		counter.add(1);
		out.close();
	}
}
