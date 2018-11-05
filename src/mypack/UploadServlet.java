package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;

public class UploadServlet extends HttpServlet{
	private String filePath;
	private String tempFilePath;
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		filePath = config.getInitParameter("filePath");
		tempFilePath = config.getInitParameter("tempFilePath");
		filePath = getServletContext().getRealPath(filePath);
		tempFilePath = getServletContext().getRealPath(tempFilePath);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/plain");
		PrintWriter outNet = response.getWriter();
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4 * 1024 * 1024);
			factory.setRepository(new File(tempFilePath));
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(4 * 1024 * 1024);
			List items = upload.parseRequest(request);
			Iterator iterator = items.iterator();
			while (iterator.hasNext())
			{
				FileItem item = (FileItem)iterator.next();
				if (item.isFormField())
				{
					processFormField(item, outNet);
				}
				else
				{
					processUploadedFile(item, outNet);
				}
			}
			outNet.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
	
	private void processFormField(FileItem item, PrintWriter outNet)
	{
		String name = item.getFieldName();
		String value = item.getString();
		outNet.println(name + ":" + value + "\r\n");
	}
	
	private void processUploadedFile(FileItem item, PrintWriter outNet) throws Exception
	{
		String filename = item.getName();
		int index = filename.lastIndexOf("\\");
		filename = filename.substring(index + 1, filename.length());
		long fileSize = item.getSize();
		if (filename.equals("") && fileSize == 0) return;
		
		File uploadedFile = new File(filePath + "/" + filename);
		item.write(uploadedFile);
		outNet.println(filename + " is saved.");
		outNet.println("the size of " + filename + " is " + fileSize + "\r\n");
	}
}
