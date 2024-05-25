package com.ritik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.entity.UserInfo;
import com.ritik.model.JwtResponse;
import com.ritik.model.UserDTO;
import com.ritik.service.UserService;
import com.ritik.utility.JwtUtility;

@RestController
@RequestMapping("/auth")
public class EmployeeAuthController {

	@Autowired
	private UserService ser;;

	@Autowired
	private JwtUtility jwtUtility;

	@Autowired
	AuthenticationManager manager;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserInfo user) {
		return ResponseEntity.ok(ser.registerUser(user));
	}

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody UserDTO credientials) {
		Authentication authenticate;
		try {
			authenticate = manager.authenticate(
					new UsernamePasswordAuthenticationToken(credientials.getUsername(), credientials.getPassword()));

			if (authenticate != null && authenticate.isAuthenticated()) {
				UserInfo userByUsername = ser.findByUsername(credientials.getUsername()).get();
				return ResponseEntity.ok(
						new JwtResponse(jwtUtility.generateToken(userByUsername.getId(),authenticate),
								"User Login Successfull..!"));
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

}
