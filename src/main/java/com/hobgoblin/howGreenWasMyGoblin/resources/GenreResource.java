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

import com.hobgoblin.howGreenWasMyGoblin.entities.Genre;
import com.hobgoblin.howGreenWasMyGoblin.services.interfaces.GenreServiceInterface;

@RestController
@RequestMapping(value = "/api/genres")
public class GenreResource {
	
	@Autowired
	private GenreServiceInterface genreService;
	
	@GetMapping
	public ResponseEntity<List<Genre>>findAll() {
		return ResponseEntity.ok(genreService.findAll());
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Genre getGenre(@PathVariable long id) {
		return genreService.findById(id);
	}
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Genre store(@Valid @RequestBody Genre genre) {
		return genreService.save(genre);
	}
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable long id) {
		genreService.delete(id);
	}
}
