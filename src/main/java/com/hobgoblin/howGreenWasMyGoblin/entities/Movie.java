package com.hobgoblin.howGreenWasMyGoblin.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
 
@Table(name = "movies")
//@JsonIgnoreProperties({"categories", "genres"})
public class Movie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "title is mandatory")
	@Column(nullable = false)
	private String title;
	@NotNull(message = "original title is mandatory")
	@Column(nullable = false)
	private String originalTitle;
	@NotNull(message = "cover is mandatory")
	@Column(nullable = false)
	private String cover;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "movies_categories", 
			joinColumns = @JoinColumn(name = "movie_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "category_id", nullable = false)
	)
	private Set<Category> categories;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "movies_genres", 
			joinColumns = @JoinColumn(name = "movie_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "genre_id", nullable = false)
	)
	private Set<Genre> genres;
	
	public Movie() {}
	public Movie(Long id, String title, String originalTitle, String cover, Set<Category> categories, Set<Genre> genres) {
		super();
		this.id = id;
		this.title = title;
		this.originalTitle = originalTitle;
		this.cover = cover;
		this.categories = categories;
		this.genres = genres;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public String getCover() {
		return this.cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Set<Genre> getGenres() {
		return this.genres;
	}
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
