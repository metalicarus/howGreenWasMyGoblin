package com.hobgoblin.howGreenWasMyGoblin.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hobgoblin.howGreenWasMyGoblin.entities.Category;
import com.hobgoblin.howGreenWasMyGoblin.service.interfaces.CategoryServiceInterface;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryResource {

	@Autowired
	private CategoryServiceInterface categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>>findAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Category getCategory(@PathVariable long id) {
		return categoryService.findById(id);
	}
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category store(@Valid @RequestBody Category category) {
  		return categoryService.save(category);
	}
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable long id) {
		categoryService.deleteById(id);
	}
}
