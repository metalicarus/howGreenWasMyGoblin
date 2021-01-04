package com.hobgoblin.howGreenWasMyGoblin.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hobgoblin.howGreenWasMyGoblin.entities.Category;
import com.hobgoblin.howGreenWasMyGoblin.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Category>>findAll() {
		return ResponseEntity.ok(categoryRepository.findAll());
	}
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category store(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
}
