package mypack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport{
	/*当JSP解析器遇到hello标签的结束标志时，调用此方法*/
	public int doEndTag() throws JspException{
		try {
			//打印字符串hello
			pageContext.getOut().print("Hello");
		}catch (Exception e) {
			// TODO: handle exception
			throw new JspTagException(e.getMessage());
		}
		return EVAL_PAGE;
	} 
}
