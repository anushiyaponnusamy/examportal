package com.exam.service;

import java.util.Set;

import com.exam.models.UserEntity;
import com.exam.models.UserRoleEntity;

public interface UserEntityService {
//creating user
	public UserEntity createUser(UserEntity user,Set<UserRoleEntity> userRoles) throws Exception;
	
//get user by username
	public UserEntity getUser(String username);
	
//delete user by id
	public void deleteUser(Long userId);

//update user by id
//	public UserEntity updateUser(Long userId);
}
