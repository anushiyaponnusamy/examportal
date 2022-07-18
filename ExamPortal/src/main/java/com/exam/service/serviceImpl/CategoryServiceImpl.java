package com.exam.service.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.models.exam.Category;
import com.exam.repository.CategoryRepository;
import com.exam.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category categaory) {
		
		return this.categoryRepository.save(categaory);
	}

	@Override
	public Category updateCategory(Category categaory) {
		
		return this.categoryRepository.save(categaory);
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<>( this.categoryRepository.findAll());
	}

	@Override
	public Category getCategoryById(Long categoryId) {
	
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category=new Category();
		category.setCid(categoryId);
	this.categoryRepository.delete(category);
		
	}

}
