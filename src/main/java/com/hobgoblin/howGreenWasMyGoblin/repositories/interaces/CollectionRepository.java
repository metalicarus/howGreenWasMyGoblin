package com.hobgoblin.howGreenWasMyGoblin.repositories.interaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hobgoblin.howGreenWasMyGoblin.entities.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long>{}
