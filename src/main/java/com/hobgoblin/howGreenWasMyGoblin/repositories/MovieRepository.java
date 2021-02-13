package com.hobgoblin.howGreenWasMyGoblin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hobgoblin.howGreenWasMyGoblin.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	Movie findByTitle(String title);
	Movie findByOriginalTitle(String originalTitle);
}
