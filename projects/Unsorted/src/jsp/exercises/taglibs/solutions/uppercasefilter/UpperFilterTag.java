package jsp.exercises.taglibs.solutions.uppercasefilter;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import java.io.*;

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
