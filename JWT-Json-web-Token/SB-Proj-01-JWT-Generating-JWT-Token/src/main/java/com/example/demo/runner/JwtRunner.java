package com.example.demo.runner;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(generateJwtToken());
	}
	
	private String generateJwtToken() {
		
		System.out.println("NIT-HYD-ONLINE-Secures".getBytes().length);
		
		// NOT RECOMMANDD ALL THE METHODS ARE DEPRICATED
		/*return Jwts.builder()
					.setId("AB123")
					.setSubject("RITIK CHOUDHARY")
					.setIssuer("NIT-ONLINE")
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10)))
					.compact();*/
		
		//hardcoded value must take it from application.properties  
		String secretKey="NIT-HYD-ONLINE-Secures";   // At least 22 characters must long the secret key should be else it will keepon throwing WeakKeyExcep[tion
		
		
		return Jwts.builder().id("AB123")
							 .subject("RITIK CHOUDAHRY")
							 .issuer("NIT-ONLINE")
							 .issuedAt(new Date(System.currentTimeMillis()))
							 .expiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10)))
							 .signWith(Keys.hmacShaKeyFor(Base64.getEncoder().encode(secretKey.getBytes())))
							 .compact();
	}
	
	

}
