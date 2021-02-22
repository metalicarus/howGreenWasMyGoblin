package com.hobgoblin.howGreenWasMyGoblin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hobgoblin.howGreenWasMyGoblin.entities.Genre;
import com.hobgoblin.howGreenWasMyGoblin.repositories.interaces.GenreRepository;
import com.hobgoblin.howGreenWasMyGoblin.service.exceptions.DuplicateEntityException;
import com.hobgoblin.howGreenWasMyGoblin.service.exceptions.EntityNotFoundException;
import com.hobgoblin.howGreenWasMyGoblin.services.interfaces.GenreServiceInterface;

@Service
public class GenreService implements GenreServiceInterface{
	
	@Autowired
	GenreRepository genreRepository;
	
	@Override
	public void delete(Long id) {
		genreRepository.deleteById(id);
	}
	@Override
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}
	@Override
	public Genre findById(Long id) {
		return genreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
	}
	@Override
	public Genre save(Genre genre) {
		if(genreRepository.findByName(genre.getName()) != null)
			throw new DuplicateEntityException("Genre name " + genre.getName() + " already exists!");
		return genreRepository.save(genre);
	}
}
