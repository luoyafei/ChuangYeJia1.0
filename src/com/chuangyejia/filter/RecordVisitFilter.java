package com.chuangyejia.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.chuangyejia.bean.Record;

/**
 * Servlet Filter implementation class recordVisitFilter
 */
//@WebFilter("/RecordVisitFilter")
public class RecordVisitFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("resource")
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		String ip = request.getRemoteAddr();
		String fromUrl = request.getRequestURI() + "?" + request.getQueryString();
		HibernateTemplate hibernateTemplate = new ClassPathXmlApplicationContext("beans.xml").getBean("hibernateTemplate", HibernateTemplate.class);
		
		Record record = new Record();
		record.setIp(ip);
		record.setFromUrl(fromUrl);
		hibernateTemplate.save(record);
		
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
       

}
