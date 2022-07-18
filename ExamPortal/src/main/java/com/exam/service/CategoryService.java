package com.exam.service;

import java.util.Set;

import com.exam.models.exam.Category;

public interface CategoryService {

	public Category addCategory(Category categaory);
	
	public Category updateCategory(Category categaory);
	
	public Set<Category> getCategories();
	
	public Category getCategoryById(Long categoryId);
	
	public void deleteCategory(Long categoryId);
	
}
