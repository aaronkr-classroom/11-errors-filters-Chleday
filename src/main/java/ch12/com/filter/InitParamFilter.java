package ch12.com.filter;

import jakarta.servlet.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class InitParamFilter implements Filter {
	
	PrintWriter writer;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter02 �ʱ�ȭ...");
		
		String filename = filterConfig.getInitParameter("filename");
		if (filename == null) throw new ServletException(
				"�α� ������ �̸��� ã�� �� �����ϴ�.");
		
		try {
			writer = new PrintWriter(
					new FileWriter(filename, true), true);
		} catch (IOException e) {
			throw new ServletException("�α� ������ �� �� �����ϴ�.");
		}
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain
			) throws IOException, ServletException {
		System.out.println("Filter01.jsp ����...");
		
		writer.printf("�����Ͻ�: %s %n", getCurrentTime());
		String clientAddr = req.getRemoteAddr();
		writer.printf("Ŭ���̾�Ʈ �ּ�: %s %n", clientAddr);
		
		String contentType = res.getContentType();
		writer.printf("������ ������ ����: %s %n", contentType);
		writer.println("----------------------------------");
		
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Filter02 ����...");
		writer.close();
	}
	
	private String getCurrentTime() {
		DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
	
}
