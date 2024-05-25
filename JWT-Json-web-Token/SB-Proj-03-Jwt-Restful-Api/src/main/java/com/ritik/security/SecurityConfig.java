
package com.ritik.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ritik.config.InvalidAuthenticationUser;
import com.ritik.config.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService uds;
	
	@Autowired
	private InvalidAuthenticationUser iau;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SecurityFilter filter;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf->csrf.disable())
			.cors(cors->cors.disable())
				.authorizeHttpRequests((req) -> 
										 req.requestMatchers("/auth/register","/auth/login","/error").permitAll()
											.requestMatchers("/emp-api/report/user/**").hasAnyAuthority("USER","ADMIN")
											.requestMatchers("/emp-api/report/admin/**").hasAuthority("ADMIN")
											.anyRequest().authenticated())
											//.logout(log -> log.logoutRequestMatcher(new AntPathRequestMatcher("/signout")))
											.exceptionHandling(ex->
																	ex.authenticationEntryPoint(iau))
											.sessionManagement(ses->
																	ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
											.authenticationProvider(authenticationProvider())
											.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
											;

		return http.build();

	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(uds);
		authenticationProvider.setPasswordEncoder(encoder);
		return authenticationProvider;
	}
	
	@Bean 
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
