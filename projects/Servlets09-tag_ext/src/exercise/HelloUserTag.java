package exercise;

import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class HelloUserTag extends TagSupport {
	private String user;
	private int loops = 1;

	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}

	public int getLoops() {
		return loops;
	}

	public void setLoops(int iloops) {
		loops = iloops;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String iuser) {
		user = iuser;
	}
}
