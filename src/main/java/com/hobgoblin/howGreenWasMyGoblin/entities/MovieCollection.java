package com.hobgoblin.howGreenWasMyGoblin.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class MovieCollection extends Collection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "collections_movies", 
			joinColumns = @JoinColumn(name = "collection_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "movie_id", nullable = false)
	)
	private List<Movie> movies;
	
	public MovieCollection() {}
	public MovieCollection(Category category) {
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
