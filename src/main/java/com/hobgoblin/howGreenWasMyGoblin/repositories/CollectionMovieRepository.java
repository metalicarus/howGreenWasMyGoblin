package com.hobgoblin.howGreenWasMyGoblin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hobgoblin.howGreenWasMyGoblin.entities.CollectionMovie;

public interface CollectionMovieRepository extends JpaRepository<CollectionMovie, Long>{}
