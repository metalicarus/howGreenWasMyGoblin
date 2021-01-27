package com.hobgoblin.howGreenWasMyGoblin.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name= "movies_collections")
public class CollectionMovie extends Collection {

	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "collection_movies", 
			joinColumns = @JoinColumn(name = "collection_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "movie_id", nullable = false)
	)
	private List<Movie> movies;
	
	public CollectionMovie() {}	
	public CollectionMovie(Category category) {
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
}
