package com.ritik.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
	    http.csrf(csrf->csrf.disable())
	    	.cors(cors->cors.disable())
	    
	    .authorizeHttpRequests(req -> req
	            .requestMatchers("/","/home" ,"/WEB-INF/pages/home.jsp").permitAll()    // By default the security filter chain will secure all the files and folder of webapp so we must also permit those pages to access 
	            .requestMatchers("/show_balance", "/approve_loan", "/offers").authenticated()
 	            .anyRequest().authenticated())
	        .formLogin(form -> form // Ensure you have a login page configured
	        						.defaultSuccessUrl("/home", true)
	        						.permitAll())
	        .logout(logout -> logout
	            .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
	            .permitAll())
	        .exceptionHandling(exception -> exception
	            .accessDeniedPage("/access_denied"));
	    return http.build();
	}
	
	
	
		
		@Bean
		InMemoryUserDetailsManager userDetailService() {
			
			// withDefaultEncoder() method is deprecated so not recommended
			/*UserDetails user1 = User.withDefaultPasswordEncoder()
									.username("ritik")
									.password("ritik")
									.authorities("MANAGER","CUSTOMER")
									.build();*/
			UserDetails user1 = User.withUsername("ritik")
									.password(encoder().encode("ritik"))
									.authorities("ROLE_MANAGER","ROLE_CUSTOMER")
									.build();
			
			UserDetails user2 = User.withUsername("raja")
									.password(encoder().encode("rani"))
									.authorities("ROLE_CUSTOMER")
									.build();
			
			UserDetails user3 = User.withUsername("vv")
									.password(encoder().encode("vv"))
									.authorities("Visitor")
									.build();
			
			return new InMemoryUserDetailsManager(user1,user2,user3);
		}
		
		
		@Bean
		BCryptPasswordEncoder encoder() {
			return new BCryptPasswordEncoder();
		}
		
		

}
