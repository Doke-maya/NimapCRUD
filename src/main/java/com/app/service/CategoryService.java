
package com.app.service;

import java.util.List;

import com.app.pojo.CategoryPojo;

public interface CategoryService {
	List<CategoryPojo> getAllCategories();

	CategoryPojo getCategoryById(Long id);

	CategoryPojo createCategory(CategoryPojo category);

	CategoryPojo updateCategory(Long id, CategoryPojo category);

	void deleteCategory(Long id);
}
