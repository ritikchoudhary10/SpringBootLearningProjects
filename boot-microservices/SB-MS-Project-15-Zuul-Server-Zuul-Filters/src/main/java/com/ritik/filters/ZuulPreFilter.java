package com.ritik.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulPreFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;// enabling this filter
	}

	@Override
	public Object run() throws ZuulException {
		// getting the requestcontext object
		RequestContext ctx = RequestContext.getCurrentContext();
		log.info("===============================PRE FILTER===============================");
		log.info("RequestContext object class name--> "+ctx.getClass().getName());
		HttpServletRequest request = ctx.getRequest();
		log.info("HttpServletRequest object class name--> "+request.getClass().getName());
		log.info("Request mode --> " +request.getMethod());
		log.info("Request uri--> "+request.getRequestURI());
		log.info("Request path--> "+request.getPathInfo());
		log.info("Request content type--> "+ request.getContentType());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;//makes the filter as PRE filter
	}

	@Override
	public int filterOrder() {
		return 0;// specifying maximum priority
	}

}
