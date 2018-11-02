package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LifeServlet extends GenericServlet{
	private int initVar = 0;
	private int serviceVar = 0;
	private int destroyVar = 0;
	private String name;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		name = config.getServletName();
		initVar++;
		System.out.println(name + ">init(): Servlet被初始化了" + initVar + "次");
	}
	
	@Override
	public void destroy() {
		destroyVar++;
		System.out.println(name + ">destriy(): Servlet被销毁了" + destroyVar + "次");
	}
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		serviceVar++;
		System.out.println(name + ">service(): Servlet共响应了" + serviceVar + "次");
		
		String content1 = "初始化次数：" + initVar;
		String content2 = "响应客户端请求次数" + serviceVar;
		String content3 = "销毁次数：" + destroyVar;
		
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>LifeServlet</title></head>");
		out.println("<body>");
		out.println("<h1>" + content1 + "</h1>");
		out.println("<h1>" + content2 + "</h1>");
		out.println("<h1>" + content3 + "</h1>");
		out.println("</body></html>");
		out.close();
	}

}
