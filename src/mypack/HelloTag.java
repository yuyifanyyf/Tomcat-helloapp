package mypack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport{
	/*��JSP����������hello��ǩ�Ľ�����־ʱ�����ô˷���*/
	public int doEndTag() throws JspException{
		try {
			//��ӡ�ַ���hello
			pageContext.getOut().print("Hello");
		}catch (Exception e) {
			// TODO: handle exception
			throw new JspTagException(e.getMessage());
		}
		return EVAL_PAGE;
	} 
}
