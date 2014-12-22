package exercise;

import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class HelloWorldTag extends TagSupport {
	public int doStartTag() {
		try {
			pageContext.getOut().println("Hello world from Tag!");
		} catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
}
