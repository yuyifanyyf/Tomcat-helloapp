package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ShoppingServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String[] ItemNames = {"�ǹ�", "������", "��ϰ��"};
		HttpSession session = request.getSession(true);
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if (cart == null)
		{
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		String[] itemsSelected;
		String itemIndex;
		String itemName;
		itemsSelected = request.getParameterValues("item");
		
		if (itemsSelected != null)
		{
			for (int i = 0; i < itemsSelected.length; i++)
			{
				itemIndex = itemsSelected[i];
				itemName = ItemNames[Integer.parseInt(itemIndex)];
				cart.add(itemName);
			}
		}
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>���ﳵ������</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Session ID:" + session.getId() + "<br>");
		out.println("<center><h1>��Ĺ��ﳵ��" + cart.getNumberOfItems() + "����Ʒ��" + "</h1></center>");
		Map<String, Integer> items = cart.getItems();
		Iterator<Map.Entry<String, Integer>> iterator = items.entrySet().iterator();
		while (iterator.hasNext())
		{
			Map.Entry<String, Integer> entry = iterator.next();
			out.println(entry.getKey() + ": " + entry.getValue() + "<br>");
		}
		out.println("<a href='shopping.htm'>��������</a><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doGet(request, response);
	}
}
