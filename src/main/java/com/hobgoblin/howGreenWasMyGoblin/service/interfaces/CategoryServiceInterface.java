package com.hobgoblin.howGreenWasMyGoblin.service.interfaces;

import java.util.List;

import com.hobgoblin.howGreenWasMyGoblin.entities.Category;

public interface CategoryServiceInterface {
	public Category findById(Long id);
	public List<Category> findAll();
	public void deleteById(Long id);
	public Category save(Category category);
}
