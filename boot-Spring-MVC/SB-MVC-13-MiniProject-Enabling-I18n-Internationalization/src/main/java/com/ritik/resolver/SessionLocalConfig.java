package com.ritik.resolver;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class SessionLocalConfig {

	@Bean("localeResolver") //fixed bean id we cannot change the default name taken by spring boot app
	SessionLocaleResolver resolver() {
		SessionLocaleResolver resolver =new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.ENGLISH);
		return resolver;
	}
	
	@Bean
	LocaleChangeInterceptor getLCInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	
}
