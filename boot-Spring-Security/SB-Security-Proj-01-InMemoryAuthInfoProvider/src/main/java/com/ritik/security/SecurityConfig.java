package com.ritik.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// this is for authenticaton info provider
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("ritik").password("{noop}ritik").authorities("CUSTOMER");
		auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").authorities("MANAGER");
		auth.inMemoryAuthentication().withUser("ram").password("{noop}sita").authorities("VISITER");
		auth.inMemoryAuthentication().withUser("ramu").password("{noop}hyd").authorities("CUSTOMER","MANAGER");
	}

	// this is for authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/home").permitAll()
								.antMatchers("/show_balance").hasAnyAuthority("CUSTOMER","MANAGER")
								.antMatchers("/approve_loan").hasAuthority("MANAGER")
								.anyRequest().authenticated()
								.and()
								.httpBasic()
								.and()
								.exceptionHandling().accessDeniedPage("/access_denied");
	}
	
	
}
