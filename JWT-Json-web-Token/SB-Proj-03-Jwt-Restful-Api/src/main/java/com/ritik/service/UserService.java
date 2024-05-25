package com.ritik.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ritik.entity.UserInfo;
import com.ritik.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public String registerUser(UserInfo user) {
		//encoding the password
		user.setPassword(
				encoder.encode(
						user.getPassword())
				);
		
		String username = repo.save(user).getUsername();
		return username+" saved Successfully..!";
	}
	
	public Optional<UserInfo> findByUsername(String username){
		return repo.findByUsername(username);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> opt = findByUsername(username);
		if(opt.isEmpty())
			throw new UsernameNotFoundException("Username doest not exist");
		UserInfo user = opt.get();
		return user;
	}
	
}
