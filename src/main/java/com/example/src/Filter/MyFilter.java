package com.example.src.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) srequest;
		System.out.println("this is MyFilter,url :"+request.getRequestURI());
		String path=request.getRequestURI();
		if(path.contains("xxx")) {
			request.getRequestDispatcher(path.replace("xxx", "")).forward(request, sresponse);
		}else {
			filterChain.doFilter(srequest, sresponse);
		}
	}

}
