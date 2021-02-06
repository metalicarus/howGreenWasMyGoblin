package com.hobgoblin.howGreenWasMyGoblin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hobgoblin.howGreenWasMyGoblin.entities.Category;
import com.hobgoblin.howGreenWasMyGoblin.repositories.CategoryRepository;
import com.hobgoblin.howGreenWasMyGoblin.service.exceptions.EntityNotFoundException;
import com.hobgoblin.howGreenWasMyGoblin.service.interfaces.CategoryServiceInterface;

@Service
public class CategoryService implements CategoryServiceInterface {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
}
