package com.microservices.zuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ZuulLoggingFilter.class);

	@Override
	public Object run() throws ZuulException {
	
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		LOGGER.info("ZuulLoggingFilter-> request -> {} request uri -> {}",request,request.getRequestURI());
		
		//LOGGER.info("request -> "+request+"request uri -> {}"+request.getRequestURI());
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
