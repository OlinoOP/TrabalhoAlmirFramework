package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository repository;
	
	public List<GenreDTO> findAllGenre(){
		
		List<Genre> listGenres = repository.findAll();
		
		return listGenres.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
	}
}
