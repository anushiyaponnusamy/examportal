package com.exam.service.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exam.helper.UserFoundException;
import com.exam.models.UserEntity;
import com.exam.models.UserRoleEntity;
import com.exam.repository.RoleEntityRepository;
import com.exam.repository.UserEntityRepository;
import com.exam.service.UserEntityService;
@Service
public class UserEntityServiceImpl implements UserEntityService{

	@Autowired
	private UserEntityRepository userRepository;
	
	@Autowired
	private RoleEntityRepository roleRepository;
	//creating user
	@Override
	public UserEntity createUser(UserEntity user, Set<UserRoleEntity> userRoles) throws Exception {
     UserEntity local=   this.userRepository.findByUsername(user.getUsername());
     if(local!=null) {
    	 System.out.println("User is already there!!");
    	 throw new UserFoundException();
     } else {
    	for(UserRoleEntity ur:userRoles) {
    		roleRepository.save(ur.getRole());
    		
    	}
    	user.getUserRoles().addAll(userRoles);
    	local=this.userRepository.save(user);
     }
		return local;
	}
	//getting user by username
	@Override
	public UserEntity getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}
	@Override
	public void deleteUser(Long userId) {
		 this.userRepository.deleteById(userId);
		
	}
@ExceptionHandler(UserFoundException.class)
public ResponseEntity<?> exceptionHandler(UserFoundException exception){
	return ResponseEntity.status(HttpStatus.FOUND)
			.body(exception.getMessage());
	
}
}
