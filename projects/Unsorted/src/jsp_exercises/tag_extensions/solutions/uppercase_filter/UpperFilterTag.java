package jsp_exercises.tag_extensions.solutions.uppercase_filter;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

@SuppressWarnings("serial")
public class UpperFilterTag extends BodyTagSupport {

    public int doEndTag() throws JspException {
        String currentContent = getBodyContent().getString();

        String newContent = currentContent.toUpperCase();
        try {
            getBodyContent().clear();
            getBodyContent().print(newContent);
            getBodyContent().writeOut(pageContext.getOut());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }

}
