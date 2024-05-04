package com.ritik.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;// enabling this filter
	}

	@Override
	public Object run() throws ZuulException {
		// getting the current requestcontext object
		RequestContext ctx = RequestContext.getCurrentContext();
		log.info("===============================POST FILTER===============================");
		log.info("RequestContext object class name--> "+ctx.getClass().getName());
		 HttpServletResponse response = ctx.getResponse();
		 log.info("HttpServletResponse object class name--> "+response.getClass().getName());
		log.info("response content type--> " +response.getContentType());
		log.info("REsponse status--> "+response.getStatus());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;//makes the filter as POST filter
	}

	@Override
	public int filterOrder() {
		return 0;// specifying maximum priority
	}

}
