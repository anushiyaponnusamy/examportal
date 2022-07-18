package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long>{

}
