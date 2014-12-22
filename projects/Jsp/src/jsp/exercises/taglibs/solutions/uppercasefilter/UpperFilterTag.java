package jsp.exercises.taglibs.solutions.uppercasefilter;

import java.io.IOException;

import javax.servlet.jsp.tagext.BodyTagSupport;

@SuppressWarnings("serial")
public class UpperFilterTag extends BodyTagSupport {
	public int doEndTag() {
		String currentContent = getBodyContent().getString();
		String newContent = currentContent.toUpperCase();
		try {
			getBodyContent().clear();
			getBodyContent().print(newContent);
			getBodyContent().writeOut(pageContext.getOut());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return EVAL_PAGE;
	}
}
