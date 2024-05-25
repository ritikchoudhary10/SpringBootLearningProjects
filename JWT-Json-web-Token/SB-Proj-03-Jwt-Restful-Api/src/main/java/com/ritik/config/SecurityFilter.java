package com.ritik.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ritik.utility.JwtUtility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtility jwtService;

	@Autowired
	private UserDetailsService ser;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Extracting token from the request header
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String userName = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			// Extracting the token from the Authorization header
			token = authHeader.substring(7);
			// Extracting username from the token
			userName = jwtService.getUsernameFromToken(token);
		}

		// If username is extracted and there is no authentication in the current
		// SecurityContext
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			// Loading UserDetails by username extracted from the token
			UserDetails userDetails = ser.loadUserByUsername(userName);

			// Validating the token with loaded UserDetails
			if (jwtService.isTokenValid(token, userDetails)) {
				// Creating an authentication token using UserDetails
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				// Setting authentication details
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// Setting the authentication token in the SecurityContext
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}

		// Proceeding with the filter chain
		filterChain.doFilter(request, response);
	}

}
