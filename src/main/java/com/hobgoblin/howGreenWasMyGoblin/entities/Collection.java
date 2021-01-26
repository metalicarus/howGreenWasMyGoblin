package com.hobgoblin.howGreenWasMyGoblin.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "collections")
@Inheritance(strategy= InheritanceType.JOINED)
public class Collection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = true)
	private Integer volumes;
	@Column(nullable = false)
	private Boolean onGoing;
	@Column(nullable = false)
	private String cover;
	
	public Collection() {}
	
	public Collection(Long id, String name, Integer volumes, Boolean onGoing, String cover) {
		super();
		this.id = id;
		this.name = name;
		this.volumes = volumes;
		this.onGoing = onGoing;
		this.cover = cover;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getVolumes() {
		return volumes;
	}
	public void setVolumes(Integer volumes) {
		this.volumes = volumes;
	}
	public Boolean getOnGoing() {
		return onGoing;
	}
	public void setOnGoing(Boolean onGoing) {
		this.onGoing = onGoing;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	
}
