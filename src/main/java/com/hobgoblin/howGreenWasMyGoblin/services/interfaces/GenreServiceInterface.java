package com.hobgoblin.howGreenWasMyGoblin.services.interfaces;

import java.util.List;

import com.hobgoblin.howGreenWasMyGoblin.entities.Genre;

public interface GenreServiceInterface {
	public Genre findById(Long id);
	public List<Genre> findAll();
	public Genre save(Genre genre);
	public void delete(Long id);
}
