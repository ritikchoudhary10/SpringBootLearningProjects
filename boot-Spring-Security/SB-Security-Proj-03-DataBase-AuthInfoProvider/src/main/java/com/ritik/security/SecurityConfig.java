package com.ritik.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource ds;
	
	private final  String USERNAME_QUERY ="SELECT username ,password ,status FROM USERS WHERE username=?";
	private final  String ROLES_QUERY ="SELECT username,role FROM USERS_ROLES WHERE username=?";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(ds)
			.usersByUsernameQuery(USERNAME_QUERY)
			.passwordEncoder(new BCryptPasswordEncoder())//we have used BCryptPasswordEncoder for encoding and decoding the password while authentication
			.authoritiesByUsernameQuery(ROLES_QUERY);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/show_balance").hasAnyAuthority("CUSTOMER","MANAGER")
								.antMatchers("/approve_loan").hasAuthority("MANAGER")
								.anyRequest().authenticated()
								.and()
								.formLogin()	//enabling form bases user authentication
								.and()
								.logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))		//enabling predefined logout filter provided by spring security
								.and()
								.exceptionHandling().accessDeniedPage("/access_denied")  //unautherized user will be redirected to this page 
								.and()
								.rememberMe()		//enabling remenberme filter provided by spring security
								.and()
								.sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);  //specifying max session counts with prevent login if session limit is breached
	}
}
