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
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
