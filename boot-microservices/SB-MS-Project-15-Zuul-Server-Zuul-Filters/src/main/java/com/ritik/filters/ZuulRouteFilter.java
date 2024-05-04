package com.ritik.filters;

import java.net.URL;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class ZuulRouteFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;// enabling this filter
	}

	@Override
	public Object run() throws ZuulException {
		log.info("===============================ROUTE FILTER===============================");
		
		RequestContext ctx = RequestContext.getCurrentContext();
		URL routeHost = ctx.getRouteHost();
		log.info("Route Host--> "+routeHost);
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.ROUTE_TYPE;// making this as Route Filter
	}

	@Override
	public int filterOrder() {
		return 0;// giving maximum priority
	}

}
