package com.ritik.utility;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component("util")
public class JwtUtility {

	@Value("${jwt.secretkey}")
	private   String secretKey ;

	@Value("${jwt.issuer}")
	private   String issuer;

	public  String generateToken(Integer id,Authentication auth) {
		
		 // Prepare claims for the token
	     String roles = auth.getAuthorities().stream().map(role->role.getAuthority()).collect(Collectors.toSet()).iterator().next();
		
		return Jwts.builder()
				   .id(id.toString())
				   .claim("role",roles)
				   .subject(auth.getName())
				   .issuer(issuer)
				   .issuedAt(new Date(System.currentTimeMillis()))
				   .expiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10)))// no expiry
				   .signWith(getKey())
				   .compact();
	}
	
	private  Key getKey() {
		return Keys.hmacShaKeyFor(Base64.getDecoder().decode(secretKey.getBytes()));
	}
	
	private  Claims getClaims(String token ) {
		return Jwts.parser().verifyWith((SecretKey)getKey())
							.build()
							.parseSignedClaims(token)
							.getPayload();
	}
	
	public  boolean isTokenValid(String token ,UserDetails user ) {
		try {
			Claims claims= getClaims(token);
			return user.getUsername().equals(claims.getSubject()) && claims.getExpiration().after(new Date(System.currentTimeMillis())) ;
			
		}catch(ExpiredJwtException e) {
			System.out.println("JWT token is expired !!");
			return false;
		}catch(MalformedJwtException e) {
			System.out.println("JWT token is Malformed or Invalid !!");
			return false;
		}catch(UnsupportedJwtException e) {
			System.out.println("JWT token structure is invalid !!");
			return false;
		}catch(ClaimJwtException e) {
			System.out.println("JWT token claims is failds due to "+e.getMessage());
			return false;
		}catch(JwtException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String getUsernameFromToken(String token) {
		return getClaims(token).getSubject();
	}
	

}
