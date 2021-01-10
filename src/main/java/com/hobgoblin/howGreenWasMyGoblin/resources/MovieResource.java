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

import com.hobgoblin.howGreenWasMyGoblin.entities.Movie;
import com.hobgoblin.howGreenWasMyGoblin.repositories.MovieRepository;

@RestController
@RequestMapping(value = "/movies")
 public class MovieResource {
	
	@Autowired
	private MovieRepository movieRepository;
	
 	@GetMapping
	public ResponseEntity<List<Movie>>findAll() {
		return ResponseEntity.ok(movieRepository.findAll());
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Movie> getMovie(@PathVariable long id) {
		return movieRepository.findById(id);
	}
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movie store(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable long id) {
		movieRepository.deleteById(id);
	}
}
