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

import com.hobgoblin.howGreenWasMyGoblin.entities.CollectionMovie;
import com.hobgoblin.howGreenWasMyGoblin.repositories.interaces.CollectionMovieRepository;

@RestController
@RequestMapping(value = "/api/collectionsMovies")
public class CollectionMovieResource {
	@Autowired
	private CollectionMovieRepository collectionMovieRepository;
	
	@GetMapping
	public ResponseEntity<List<CollectionMovie>>findAll() {
		return ResponseEntity.ok(collectionMovieRepository.findAll());
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<CollectionMovie> getCategory(@PathVariable long id) {
		return collectionMovieRepository.findById(id);
	}
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CollectionMovie store(@RequestBody CollectionMovie collectionMovie) {
  		return collectionMovieRepository.save(collectionMovie);
	}
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable long id) {
		collectionMovieRepository.deleteById(id);
	}
}
