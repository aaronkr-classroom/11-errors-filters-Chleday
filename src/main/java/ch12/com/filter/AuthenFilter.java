package ch12.com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
public class AuthenFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter01 �ʱ�ȭ...");
	}
	
	@Override
	public void doFilter(ServletRequest req,	ServletResponse res,
			FilterChain filterChain
			) throws IOException, ServletException {
		System.out.println("Filter01.jsp ����...");
		String name = req.getParameter("name");
		
		if (name == null || name.equals("")) {
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			
			PrintWriter writer = res.getWriter();
			String msg = "�Էµ� name ���� null�Դϴ�.";
			writer.println(msg);
			return;
		}
		filterChain.doFilter(req, res);
	}
	
	@Override
	public void destroy() {
		System.out.println("Filter01 ����...");
	}
	
}
