package com.ritik.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// No user of password encoder so we use {noop} no operation for telling that the password is not encoded 
		/*auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").authorities("CUSTOMER");
		auth.inMemoryAuthentication().withUser("ritik").password("{noop}ritik").authorities("CUSTOMER","MANAGER");
		auth.inMemoryAuthentication().withUser("ram").password("{noop}sita").authorities("VISITOR");
		auth.inMemoryAuthentication().withUser("rrr").password("{noop}hyd").authorities("CUSTOMER");*/
		
		// using password encoder{BcryptPasswordEncoder}
		
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$TdljKvqhcgvpb6HfiyQpe.8FiA7CaBjGlIRwKLv7Gx/VDi9k8Ol22").authorities("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("ritik").password("$2a$10$NOy4tnkgIWF/pLrNbHziiOQJIzntgFgoEgqiYkNFEF7X63GYJxo7S").authorities("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("sita").password("$2a$10$Uac2c/bhRY4/SZRrvsyT3.oPSpDNk.siEWx1xF6rLoP9/qMsqgcd2").authorities("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("hyd").password("$2a$10$xTn5oBJZoXqolYTvOfOBkuoJ7xUer9KGOsC9JFZLiY4Xg1I0wua2e").authorities("CUSTOMER");
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/show_balance").hasAnyAuthority("CUSTOMER","MANAGER")
								.antMatchers("/approve_loan").hasAuthority("MANAGER")
								.anyRequest().authenticated()
								.and()
								.rememberMe()
								.and()
								.formLogin()
								.and()
								.logout()
								.and()
								.exceptionHandling().accessDeniedPage("/access_denied")
								.and()
								.sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}
