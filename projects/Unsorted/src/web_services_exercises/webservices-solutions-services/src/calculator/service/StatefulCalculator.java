package calculator.service;

//import javax.annotation.*;
//import javax.jws.*;
//import javax.servlet.http.*;
//import javax.xml.ws.*;
//import javax.xml.ws.handler.*;

@WebService
public class StatefulCalculator {

	public enum Operation {
		ADD,
		SUB,
		MUL,
		DIV
	};

	@Resource
	private WebServiceContext wsContext;

	@WebMethod
	public void startCalc(float num) {
		getSession().setAttribute("num", num);
	}

	@WebMethod
	public float invokeOperation(Operation op, float num) {
		float curNum = (Float) getSession().getAttribute("num");

		System.out.println("Current num: " + curNum);

		switch (op) {
			case ADD:
				curNum += num;
				break;
			case SUB:
				curNum -= num;
				break;
			case MUL:
				curNum *= num;
				break;
			case DIV:
				curNum /= num;
				break;
			default:
				break;
		}
		System.out.println("After op " + op + " " + num + ": " + curNum);

		getSession().setAttribute("num", curNum);

		return curNum;
	}

	private HttpSession getSession() {
		MessageContext mc = wsContext.getMessageContext();
		HttpSession session = ((HttpServletRequest) mc.get(MessageContext.SERVLET_REQUEST)).getSession();
		return session;
	}
}
