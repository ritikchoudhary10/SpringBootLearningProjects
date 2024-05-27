package com.ritik.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Component
public class InterceptorRegistry implements WebMvcConfigurer{
	
	@Autowired
	private LocaleChangeInterceptor LCInterceptor;
	
	@Override
	public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
		registry.addInterceptor(LCInterceptor);
	}
}
