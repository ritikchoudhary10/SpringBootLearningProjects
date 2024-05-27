package com.ritik.interceptors;

import java.time.LocalTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getServletPath().equalsIgnoreCase("/"))
			return true;
		System.out.println("TimeHandlerInterceptor.preHandle()");
		int currentHour=LocalTime.now().getHour();
		if(currentHour<9 || currentHour>17) {
			request.getRequestDispatcher("/timeout.jsp").forward(request, response);
			return false;
		}
		return true;
	}
}
