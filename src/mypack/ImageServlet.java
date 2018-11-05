package mypack;

import java.io.*;
import javax.imageio.ImageIO;  
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.*;

public class ImageServlet extends HttpServlet{
	private Font font = new Font("Courier", Font.BOLD, 12);
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String count = request.getParameter("count");
		if (count == null) count="1";
		int len = count.length();
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		BufferedImage image = new BufferedImage(11 * len, 16, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 11 * len, 16);
		g.setColor(Color.white);
		g.setFont(font);
		char c;
		for (int i = 0; i < len; i++)
		{
			c = count.charAt(i);
			g.drawString(c + "", i * 11 + 1, 12);
			g.drawLine((i + 1) * 11 - 1, 0, (i + 1) * 11 - 1, 16);
		}
		ImageIO.write(image, "JPEG", out);
		out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doGet(request, response);
	}
}
