package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.models.RoleEntity;
import com.exam.models.UserEntity;
import com.exam.models.UserRoleEntity;
import com.exam.service.UserEntityService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserEntityController {
	@Autowired
	private UserEntityService userService;
	@Autowired
     private BCryptPasswordEncoder bcrptPasswordEncoder;
	//creating user
	@PostMapping("/")
	public UserEntity createUser(@RequestBody UserEntity user) throws Exception {
		user.setProfile("default.png");
		//encoding password with bcrypt password encoder
		user.setPassword(this.bcrptPasswordEncoder.encode(user.getPassword()));
		Set<UserRoleEntity> roles =new HashSet();
		 RoleEntity role=new RoleEntity();
		 role.setRoleId(45L);
		 role.setRolename("NORMAL");
		 UserRoleEntity userRole= new UserRoleEntity();
		 userRole.setRole(role);
		 userRole.setUser(user);
		 roles.add(userRole);
		return this.userService.createUser(user, roles);
		
	}
	
	@GetMapping("/{username}")
	public UserEntity getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
		
	}
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		 this.userService.deleteUser(userId);
	}
//	@PutMapping("/{userId}")
//	public UserEntity getUser(@PathVariable("userId") Long userId) {
//		return this.userService.updateUser(userId);
//		
//	}
}
