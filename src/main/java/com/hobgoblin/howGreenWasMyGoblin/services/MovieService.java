package com.hobgoblin.howGreenWasMyGoblin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hobgoblin.howGreenWasMyGoblin.entities.Movie;
import com.hobgoblin.howGreenWasMyGoblin.repositories.MovieRepository;
import com.hobgoblin.howGreenWasMyGoblin.service.exceptions.DuplicateEntityException;
import com.hobgoblin.howGreenWasMyGoblin.service.exceptions.EntityNotFoundException;
import com.hobgoblin.howGreenWasMyGoblin.services.interfaces.MovieServiceInterface;

@Service
public class MovieService implements MovieServiceInterface{
	
	@Autowired
	MovieRepository repository;
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}
	@Override
	public Movie findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
	}
	@Override
	public Movie save(Movie movie) {
		if(repository.findByTitle(movie.getTitle()) != null || repository.findByOriginalTitle(movie.getOriginalTitle()) != null) 
			throw new DuplicateEntityException("Movie " + movie.getTitle() + " already exists!");
		return repository.save(movie);
	}
}
