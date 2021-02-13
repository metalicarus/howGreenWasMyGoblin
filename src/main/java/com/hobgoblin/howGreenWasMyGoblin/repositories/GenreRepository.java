package com.hobgoblin.howGreenWasMyGoblin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hobgoblin.howGreenWasMyGoblin.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
	Genre findByName(String name);
}
