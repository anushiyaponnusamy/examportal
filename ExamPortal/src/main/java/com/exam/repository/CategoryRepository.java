package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.models.exam.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
