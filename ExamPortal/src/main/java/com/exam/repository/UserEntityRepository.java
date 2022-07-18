package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.UserEntity;

public interface UserEntityRepository  extends JpaRepository<UserEntity, Long>{

	

	UserEntity findByUsername(String username);

}
