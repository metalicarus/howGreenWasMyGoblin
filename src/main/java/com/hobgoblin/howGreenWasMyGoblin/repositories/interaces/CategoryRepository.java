package com.hobgoblin.howGreenWasMyGoblin.repositories.interaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hobgoblin.howGreenWasMyGoblin.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	Category findByName(String name);
}
