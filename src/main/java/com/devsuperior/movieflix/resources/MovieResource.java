package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieByGenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		MovieDTO movieDTO = service.findMovieById(id);
		return ResponseEntity.ok(movieDTO);
	}
	
	@GetMapping("/{id}/reviews")
	public ResponseEntity<List<MovieReviewDTO>> findReviewByMovieId(@PathVariable Long id){
		List<MovieReviewDTO>  moviesReview =  service.findReviewByMovie(id);
		return ResponseEntity.ok(moviesReview);
	}
	
	@GetMapping()
	public ResponseEntity<Page<MovieByGenreDTO>> findMovieByGenre(
			@RequestParam(name = "genreId", defaultValue = "0") Long genreId, Pageable pageable){
		
		Page<MovieByGenreDTO> page = service.findMovieByGenre(genreId, pageable);
		
		return ResponseEntity.ok(page);
	}
}
