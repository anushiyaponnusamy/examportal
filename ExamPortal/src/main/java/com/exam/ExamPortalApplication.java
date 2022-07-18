package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.helper.UserFoundException;
import com.exam.models.RoleEntity;
import com.exam.models.UserEntity;
import com.exam.models.UserRoleEntity;
import com.exam.service.UserEntityService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {
	@Autowired
   private UserEntityService userservice;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		try {
//		System.out.println("starting code");
//		UserEntity user=new UserEntity();
//		user.setFirstname("Anu");
//		user.setEmail("anu@gmail.com");
//		user.setLastname("p");
//		user.setPassword(this.bCryptPasswordEncoder.encode("anushi"));
//		user.setProfile("default.png");
//	    user.setUsername("Anushiya");
//	    RoleEntity role=new RoleEntity();
//	    role.setRoleId(44L);
//	    role.setRolename("ADMIN");
//	    Set<UserRoleEntity> userroleSet=new HashSet<>();
//	    UserRoleEntity userrole=new UserRoleEntity();
//	    userrole.setRole(role);
//	    userrole.setUser(user);
//	    userroleSet.add(userrole);
//	    UserEntity user1=this.userservice.createUser(user, userroleSet);
//	    System.out.println(user1.getUsername());
//		}catch (UserFoundException e) {
//			e.printStackTrace();
//		}
	    
	}

}
