package com.hobgoblin.howGreenWasMyGoblin.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
