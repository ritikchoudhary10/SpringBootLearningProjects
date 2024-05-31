package com.ritik.security;

import javax.sql.DataSource;

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
public class SecurityConfig { // spring security config file
	
	//passwordEncoder for encoding the password and store in database
	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((req)->req
											 // these url are accessed by anyone
											 .requestMatchers("/emp-api/","/error").permitAll()
											 // these url are accessed with authenticated user having role USER or ADMIN or OAUTH_USER
											 .requestMatchers("/emp-api/report/**").hasAnyAuthority("OAUTH2_USER","OIDC_USER","USER" ,"ADMIN")
											 // these url are accessed with authenticated user having role ADMIN only
											 .requestMatchers("/emp-api/admin/**").hasAuthority("ADMIN")
											 // any request to server except permitAll urls will be authenticated 
											 .anyRequest().authenticated())
			// enabling form login
			.formLogin(Customizer.withDefaults())
			// enable oauth login
			.oauth2Login(Customizer.withDefaults()) 
			// logout url configuration
			.logout(log->log.logoutRequestMatcher(new AntPathRequestMatcher("/signout")));
		
		//returning the SecurityFilterChain type object
		//							in this case DefaultSecurityFilterChain class obj 
			return http.build();
	
	}
	
	// for jdbc based user authenticaton
	@Bean
	UserDetailsService userDetail(DataSource ds) {
		return new JdbcUserDetailsManager(ds);
	}
	
	
}
