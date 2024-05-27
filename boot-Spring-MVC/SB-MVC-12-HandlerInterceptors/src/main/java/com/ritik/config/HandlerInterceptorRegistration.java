package com.ritik.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ritik.interceptors.TimeHandlerInterceptor;

@Component
public class HandlerInterceptorRegistration implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TimeHandlerInterceptor());
	}
}
