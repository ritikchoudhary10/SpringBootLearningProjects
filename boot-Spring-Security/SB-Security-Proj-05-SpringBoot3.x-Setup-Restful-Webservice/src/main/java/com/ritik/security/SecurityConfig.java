package com.ritik.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	

	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((req)->req.requestMatchers("/emp-api/").permitAll()
											 .requestMatchers("/emp-api/report/**").hasAnyAuthority("EMPLOYEE" ,"ADMIN")
											 .requestMatchers("/emp-api/admin/**").hasAuthority("ADMIN")
											 .anyRequest().authenticated())
			.formLogin(Customizer.withDefaults())
			.logout(log->log.logoutRequestMatcher(new AntPathRequestMatcher("/signout")));
		
	
			return http.build();
	
	}
	
	@Bean
	UserDetailsService userDetail(DataSource ds) {
		return new JdbcUserDetailsManager(ds);
	}
	
	
}
