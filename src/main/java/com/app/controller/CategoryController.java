package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.CategoryDTO;
import com.app.pojo.CategoryPojo;
import com.app.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<CategoryDTO> getAllCategories() {
		List<CategoryPojo> categories = categoryService.getAllCategories();
		return categories.stream().map(this::convertToCategoryDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		CategoryPojo category = categoryService.getCategoryById(id);
		return convertToCategoryDTO(category);
	}

	@PostMapping
	public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
		CategoryPojo category = convertToCategory(categoryDTO);
		CategoryPojo createdCategory = categoryService.createCategory(category);
		return convertToCategoryDTO(createdCategory);
	}

	@PutMapping("/{id}")
	public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
		CategoryPojo category = convertToCategory(categoryDTO);
		CategoryPojo updatedCategory = categoryService.updateCategory(id, category);
		return convertToCategoryDTO(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}

	private CategoryDTO convertToCategoryDTO(CategoryPojo category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());

		return categoryDTO;
	}

	private CategoryPojo convertToCategory(CategoryDTO categoryDTO) {
		CategoryPojo category = new CategoryPojo();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());

		return category;
	}
}
