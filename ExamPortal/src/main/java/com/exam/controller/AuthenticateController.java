package com.exam.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.configuration.JwtUtils;
import com.exam.models.JwtRequest;
import com.exam.models.JwtResponse;
import com.exam.models.UserEntity;
import com.exam.service.serviceImpl.UserDetailsServiceImpl;

@CrossOrigin("*")
@RestController
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtils jwtutils;
	
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}
		//authenticate
		UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtutils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	private void authenticate(String username,String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e)
		{
			throw new Exception("USER DISABLED"+e.getMessage());
		}catch(BadCredentialsException e)
		{
			throw new Exception("BAD CREDENTIALS"+e.getMessage());
		}
	}
	//returns details of current user
	@GetMapping("/current-user")
	public UserEntity getCurrentUser(Principal principal) {
	return	((UserEntity)this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
	}
	
}
