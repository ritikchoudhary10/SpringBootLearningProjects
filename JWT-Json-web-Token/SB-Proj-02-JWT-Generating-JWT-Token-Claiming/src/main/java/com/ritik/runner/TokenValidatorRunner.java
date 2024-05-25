package com.ritik.runner;

import java.util.Base64;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenValidatorRunner implements CommandLineRunner{

	private String secretKey="NIT-HYD-ONLINE-Secures"; 
	@Override
	public void run(String... args) throws Exception {
		String token ="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJBQjEyMyIsInN1YiI6IlJJVElLIENIT1VEQUhSWSIsImlzcyI6Ik5JVC1PTkxJTkUiLCJpYXQiOjE3MTYzMTQxMzgsImV4cCI6MTcxNjMxNDczOH0.MrG0fjg6DrDqFuA7Y_n8vUpebpnSHy8idCE9ExECfNo";
//		
//		Claims claim= getClaims(token, secretKey);
//		System.out.println(claim.getId());
//		System.out.println(claim.getSubject());
//		System.out.println(claim.getIssuedAt());
//		System.out.println(claim.getIssuer());
//		System.out.println(claim.getExpiration());
		
		boolean status=isTokenValid(token, secretKey);
		System.out.println(status);
	}
	
	private Claims getClaims(String token ,String secretKey) throws JwtException{
		return Jwts.parser()
					.verifyWith(Keys.hmacShaKeyFor(Base64.getEncoder().encode(secretKey.getBytes())))
					.build()
					.parseSignedClaims(token)
					.getPayload();
	}
	
	boolean isTokenValid(String jwtToken ,String secretKey) {
		try {
			getClaims(jwtToken, secretKey);
			return true;
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

}
