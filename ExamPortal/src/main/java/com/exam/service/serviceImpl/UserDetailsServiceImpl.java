package com.exam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.models.UserEntity;
import com.exam.repository.UserEntityRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
@Autowired
UserEntityRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user=this.userRepository.findByUsername(username);
		System.out.println(user);
		if(user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("No user found");
		}
		return user;
	}

}
