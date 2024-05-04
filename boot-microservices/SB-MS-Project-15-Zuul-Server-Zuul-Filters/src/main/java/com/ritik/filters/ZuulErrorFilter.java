package com.ritik.filters;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulErrorFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true; // enable the filter
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		log.info("============================ERROR FILTER======================");
		Throwable err = ctx.getThrowable();
		log.info("error message--> "+err.getMessage());
		log.info("Exception class Name--> "+err.getClass().getName());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;// specifying the type of the filter
	}

	@Override
	public int filterOrder() {
		return 0;// high priority
	}

}
