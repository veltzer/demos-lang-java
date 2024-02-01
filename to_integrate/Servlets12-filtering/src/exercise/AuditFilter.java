package exercise;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AuditFilter implements Filter {
	public void init(FilterConfig cfg) {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) {
		HttpServletRequest httpReq = (HttpServletRequest) req;
		System.out.println(new Date() + " URL:" + httpReq.getRequestURI()
				+ " Remote addr:" + httpReq.getRemoteAddr());
		try {
			chain.doFilter(req, res);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}

	public void destroy() {
	}
}
