package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.MovieByGenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private UserService userService;
	
	public MovieDTO findMovieById(Long id) {
		Optional<Movie> optional =  repository.findById(id);
		Movie movie =  optional.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		return new MovieDTO(movie, movie.getGenre());
	}
	
	public List<MovieReviewDTO> findReviewByMovie(Long id) {
		return reviewService.findReviewByIdMovie(id);
	}
	
	
	public Page<MovieByGenreDTO> findMovieByGenre(Long id, Pageable pageable){
		Long genereId = id == 0 ? null:id; 
		Page<Movie> moviePage = repository.findMovieByGenreId(genereId,pageable );
		
		return moviePage.map(x -> new MovieByGenreDTO(x));
		
	}
	
}
