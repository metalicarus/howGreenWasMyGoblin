package com.hobgoblin.howGreenWasMyGoblin.resources;

import java.util.List;
import java.util.Optional;

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

import com.hobgoblin.howGreenWasMyGoblin.entities.Collection;
import com.hobgoblin.howGreenWasMyGoblin.repositories.interaces.CollectionRepository;

@RestController
@RequestMapping(value = "/api/collections")
public class CollectionResource {

	@Autowired
	private CollectionRepository collectionRepository;
	
	@GetMapping
	public ResponseEntity<List<Collection>>findAll() {
		return ResponseEntity.ok(collectionRepository.findAll());
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Collection> getCategory(@PathVariable long id) {
		return collectionRepository.findById(id);
	}
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Collection store(@RequestBody Collection collection) {
  		return collectionRepository.save(collection);
	}
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable long id) {
		collectionRepository.deleteById(id);
	}
}
