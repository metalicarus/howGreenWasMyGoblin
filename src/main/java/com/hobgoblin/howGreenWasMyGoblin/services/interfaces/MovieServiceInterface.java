package com.hobgoblin.howGreenWasMyGoblin.services.interfaces;

import java.util.List;

import com.hobgoblin.howGreenWasMyGoblin.entities.Movie;

public interface MovieServiceInterface {
	public Movie findById(Long id);
	public List<Movie> findAll();
	public Movie save(Movie movie);
	public void delete(Long id);
}
