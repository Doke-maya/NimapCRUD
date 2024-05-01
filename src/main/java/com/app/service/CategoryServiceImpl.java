package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.CategoryPojo;
import com.app.repo.CategoryRepo;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepository;

	@Override
	public List<CategoryPojo> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public CategoryPojo getCategoryById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public CategoryPojo createCategory(CategoryPojo category) {
		return categoryRepository.save(category);
	}

	@Override
	public CategoryPojo updateCategory(Long id, CategoryPojo category) {
		if (categoryRepository.existsById(id)) {
			category.setId(id);
			return categoryRepository.save(category);
		} else {
			return null;
		}
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
