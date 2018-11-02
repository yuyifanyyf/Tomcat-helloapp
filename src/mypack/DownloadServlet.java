package mypack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.*;
import javax.servlet.http.*;

public class DownloadServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		OutputStream out;
		InputStream in;
		
		String filename = request.getParameter("filename");
		
		if (filename == null) {
			out = response.getOutputStream();
			out.write("please input filename.".getBytes());
			out.close();
			return;
		}
		in = getServletContext().getResourceAsStream("/store/" + filename);
		int length = in.available();
		response.setContentType("application/force-download");
		response.setHeader("Content-Length", String.valueOf(length));
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\" ");
		
		out = response.getOutputStream();
		int bytesRead = 0;
		byte[] buffer = new byte[512];
		while ((bytesRead = in.read(buffer)) != -1)
		{
			out.write(buffer, 0, bytesRead);
		}
		in.close();
		out.close();
	}
}
