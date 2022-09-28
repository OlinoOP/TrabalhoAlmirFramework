package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.Genre;

public class GenreDTO implements Serializable {
	

	private static final long serialVersionUID = 2276211030461881992L;
	
	private Long id;
	private String name;
	
	
	public GenreDTO() {
		
	}
	
	public GenreDTO(Genre entity ) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
	public GenreDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}
